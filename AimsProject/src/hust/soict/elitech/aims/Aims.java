package hust.soict.elitech.aims;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.exception.PlayerException;
import hust.soict.elitech.aims.media.*;
import hust.soict.elitech.aims.screen.customer.controller.ViewStoreController;
import hust.soict.elitech.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aims extends Application {

	private static Store store;
	private static Cart cart;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Initialize store and cart
			initializeData();

			// Load the Store screen
			final String STORE_FXML_FILE_PATH = "/hust/soict/elitech/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			ViewStoreController viewStoreController = new ViewStoreController(store, cart);
			fxmlLoader.setController(viewStoreController);
			Parent root = fxmlLoader.load();

			primaryStage.setTitle("AIMS - Store");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initializeData() {
		// Initialize store
		store = new Store();

		// Initialize cart
		cart = new Cart();

		// Add sample media to store
		try {
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
			DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

			CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music", "Queen", 12.5f);
			Track track1 = new Track("Bohemian Rhapsody", 367);
			Track track2 = new Track("We Will Rock You", 122);
			cd1.addTrack(track1);
			cd1.addTrack(track2);

			store.addMedia(dvd1);
			store.addMedia(dvd2);
			store.addMedia(dvd3);
			store.addMedia(cd1);

		} catch (Exception e) {
			System.err.println("Error initializing media: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// Test playing media with exception handling
		try {
			DigitalVideoDisc dvd = new DigitalVideoDisc("Test DVD", "Test", 0, 0f); // Invalid length
			dvd.play();
		} catch (PlayerException e) {
			System.err.println("DVD Error: " + e.getMessage());
		}

		try {
			Track track = new Track("Test Track", 0); // Invalid length
			track.play();
		} catch (PlayerException e) {
			System.err.println("Track Error: " + e.getMessage());
		}

		// Launch JavaFX application
		launch(args);
	}
}