package hust.soict.elitech.aims.media;

import hust.soict.elitech.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    // Constructors
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());

        // Simulate playing (optional)
        for (int i = 0; i < this.getLength() / 60; i++) {
            System.out.println("Playing chapter " + (i + 1));
        }
    }

    @Override
    public String toString() {
        return "DVD - ID: " + getId() +
                " - Title: " + getTitle() +
                " - Category: " + getCategory() +
                " - Director: " + getDirector() +
                " - Length: " + getLength() +
                " - Cost: " + getCost() + "$";
    }
}