package hust.soict.elitech.aims.media;

public class Track implements Playable {
	
    private String title;
    private int length;
    
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    public void play() {
    	System.out.println("Playing DVD: " + this.getTitle());
    	System.out.println("DVD length: " + this.getLength());
    	}
    
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
    }
    
}
