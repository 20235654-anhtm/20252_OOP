package hust.soict.elitech.aims.media;

import hust.soict.elitech.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // Constructors
    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    // Methods
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added");
        } else {
            System.out.println("Track already exists");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track: " + track.getTitle() + " has been removed");
        } else {
            System.out.println("Track not found");
        }
    }

    @Override
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        System.out.println("Total length: " + this.getLength());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                System.err.println("Error playing track " + track.getTitle() + ": " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "CD - ID: " + getId() +
                " - Title: " + getTitle() +
                " - Artist: " + artist +
                " - Category: " + getCategory() +
                " - Length: " + getLength() +
                " - Cost: " + getCost() + "$" +
                " - Tracks: " + tracks.size();
    }

    // Getter for tracks
    public List<Track> getTracks() {
        return tracks;
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }
}