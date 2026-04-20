package hust.soict.elitech.aims.media;

import java.util.Comparator;

public abstract class Media {

	public Media() {
		
	}		
		private static int nbMedia = 0;
	    private int id;
	    private String title;
	    private String category;
	    private float cost;

	    public Media(String title) {
	        this.title = title;
			this.id = ++nbMedia;
	    }
	    public Media(String title, String category) {
	        this.title = title;
	        this.category = category;
	        this.id = ++nbMedia;
	    }
	    public Media(String title, String category, float cost) {
	        this.title = title;
	        this.category = category;
	        this.cost = cost;
	        this.id = ++nbMedia;
	    }
	    
	    public int getId() {
	        return id;
	    }
	    public String getTitle() {
	        return title;
	    }
	    public String getCategory() {
	        return category;
	    }
	    public float getCost() {
	        return cost;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public String toString() {
	        return "Media: " + this.getTitle() +
	                " - Category: " + this.getCategory() +
	                " - Cost: " + this.getCost() + "$";
	    }
	    
	    public boolean isMatch(String title) {
	        return this.getTitle().toLowerCase().contains(title.toLowerCase());
	    }
	    
	    public boolean equals(Object obj) {
	        if (obj == this) {
	            return true;
	        }
	        if (!(obj instanceof Media)) {
	            return false;
	        }
	        return ((Media)obj).getTitle() == this.getTitle();
	    }
	    
	    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	    
	    public int compareTo(Media other) {
	        int titleComparison = this.getTitle().compareTo(other.getTitle());
	        if (titleComparison != 0) {
	            return titleComparison;
	        } else {
	            return Double.compare(this.getCost(), other.getCost());
	        }
	    }

}
