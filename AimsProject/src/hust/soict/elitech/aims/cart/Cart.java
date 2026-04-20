package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.*;

public class Cart {
	
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public int qtyOrdered = 0;

	
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
        } else if (itemsOrdered.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
            qtyOrdered +=1;
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.size() == 0) {
            System.out.println("Cart empty. Can not remove!");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
                qtyOrdered -=1;
            } else {
                System.out.println("Media not found.");
            }
        }
    }
	
    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total items: " + qtyOrdered);
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public Media searchToRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
    }
    
    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Media not found.");
        }
    }

    public void searchByTitle(String keyword) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(keyword)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media not found.");
        }
    }

}
