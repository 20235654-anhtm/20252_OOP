package hust.soict.elitech.aims.store;

import hust.soict.elitech.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media " + media.getTitle() + " is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the store!");
        }
    }

    public void displayStore() {
        if (itemsInStore.size() == 0) {
            System.out.println("Store empty!");
        } else {
            System.out.println("********************STORE INVENTORY********************");
            for (Media media : itemsInStore) {
                System.out.println(media);
            }
            System.out.println("********************************************************");
        }
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media getMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}
