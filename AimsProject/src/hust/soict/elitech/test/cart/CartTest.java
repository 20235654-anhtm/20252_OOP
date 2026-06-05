package hust.soict.elitech.test.cart;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        cart.addMedia(dvd1);

        cart.displayCart();

        System.out.println("\n--- Test searchByID() ---");
        cart.searchByID(dvd2.getId());
        cart.searchByID(999);

        System.out.println("\n--- Test searchByTitle() ---");
        cart.searchByTitle("Star");
        cart.searchByTitle("king");
        cart.searchByTitle("Doraemon");
    }
}

