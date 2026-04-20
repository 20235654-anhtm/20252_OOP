package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
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
	
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DigitalVideoDisc b = (DigitalVideoDisc) obj;

        boolean titleEquals = (this.getTitle() == null && b.getTitle() == null) ||
                              (this.getTitle() != null && this.getTitle().equals(b.getTitle()));
        boolean categoryEquals = (this.getCategory() == null && b.getCategory() == null) ||
                                 (this.getCategory() != null && this.getCategory().equals(b.getCategory()));
        boolean directorEquals = (this.getDirector() == null && b.getDirector() == null) ||
                                 (this.getDirector() != null && this.getDirector().equals(b.getDirector()));
        boolean lengthEquals = this.getLength() == b.getLength();
        boolean costEquals = this.getCost() == b.getCost();

        return titleEquals && categoryEquals && directorEquals && lengthEquals && costEquals;
    }
    
    public String toString() {
        return this.getId() + " - DVD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Director: " + this.getDirector() +
                " - DVD length: " + this.getLength() +
                " - Cost: " + this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    
    public void play() {
    	System.out.println("Playing DVD: " + this.getTitle());
    	System.out.println("DVD length: " + this.getLength());
    	}
    
}
