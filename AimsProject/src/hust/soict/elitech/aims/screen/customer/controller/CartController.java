package hust.soict.elitech.aims.screen.customer.controller;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.Media;
import hust.soict.elitech.aims.media.Playable;
import hust.soict.elitech.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Store store;
    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label costLabel;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        // Set up table columns
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Bind cart items to table
        tblMedia.setItems(cart.getItemsOrdered());

        // Initialize buttons
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Add listener for selected item
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue, Media newValue) {
                        updateButtonBar(newValue);
                    }
                });

        // Add listener for filter text field
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Update total cost
        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    private void showFilteredMedia(String filterText) {
        FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered());

        if (filterText == null || filterText.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }

        String lowerCaseFilter = filterText.toLowerCase();

        if (radioBtnFilterId.isSelected()) {
            filteredData.setPredicate(media -> {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            });
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredData.setPredicate(media -> {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            });
        }

        tblMedia.setItems(filteredData);
    }

    private void updateTotalCost() {
        costLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText("Cannot play this media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.placeOrder();
        updateTotalCost();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText("Order has been placed successfully");
        alert.setContentText("Total cost: " + String.format("%.2f $", cart.totalCost()));
        alert.showAndWait();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) throws IOException {
        final String STORE_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Store");
        stage.show();
    }
}