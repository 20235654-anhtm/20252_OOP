package hust.soict.elitech.aims.test.screen.customer.store;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.screen.customer.controller.ViewStoreController;
import hust.soict.elitech.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Initialize store and add some sample media
        store = new Store();
        cart = new Cart();

        // Add sample media to store (you should replace with your actual media initialization code)
        // Example:
        // DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        // store.addMedia(dvd1);

        launch(args);
    }
}