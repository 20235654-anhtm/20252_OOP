package hust.soict.elitech.aims.media;

import hust.soict.elitech.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track> {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.length <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }

    @Override
    public int compareTo(Track other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Track: " + title + " - Length: " + length + "s";
    }
}