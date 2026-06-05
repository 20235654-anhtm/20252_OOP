package hust.soict.elitech.aims.cart;

import hust.soict.elitech.aims.exception.LimitExceededException;
import hust.soict.elitech.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private int qtyOrdered = 0;

    // Thêm phương thức getter cho itemsOrdered
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Cập nhật phương thức addMedia để throw exception
    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }

        if (itemsOrdered.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
            qtyOrdered += 1;
        }
    }

    // Phương thức removeMedia giữ nguyên nhưng làm việc với ObservableList
    public void removeMedia(Media media) {
        if (itemsOrdered.size() == 0) {
            System.out.println("Cart empty. Cannot remove!");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
                qtyOrdered -= 1;
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    // Phương thức tính tổng chi phí
    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // Phương thức hiển thị giỏ hàng (dùng cho console)
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

    // Phương thức tìm kiếm để xóa
    public Media searchToRemove(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    // Phương thức tìm kiếm theo ID
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

    // Phương thức tìm kiếm theo tiêu đề
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

    // Phương thức filter cho JavaFX
    public void filterMedia(String filter, boolean filterById) {
        if (filter == null || filter.isEmpty()) {
            return;
        }

        if (filterById) {
            try {
                int id = Integer.parseInt(filter);
                itemsOrdered.forEach(media -> {
                    if (media.getId() == id) {
                        System.out.println("Found by ID: " + media);
                    }
                });
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format");
            }
        } else {
            itemsOrdered.forEach(media -> {
                if (media.getTitle().toLowerCase().contains(filter.toLowerCase())) {
                    System.out.println("Found by title: " + media);
                }
            });
        }
    }
}