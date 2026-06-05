package hust.soict.elitech.aims.screen.customer.controller;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.Media;
import hust.soict.elitech.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class ItemController {
    @FXML private Label lblTitle;
    @FXML private Label lblCost;
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked() {
        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked() {
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
}