package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();

        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        mediaList.add(new Book("Effective Java", "Programming", 45.0f));
        mediaList.add(new CompactDisc("Hybrid Theory", "Music", "Linkin Park", 29.99f));

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}

