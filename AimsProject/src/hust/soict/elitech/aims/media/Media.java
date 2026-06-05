package hust.soict.elitech.aims.media;

import java.util.Comparator;
import hust.soict.elitech.aims.exception.PlayerException;

public abstract class Media implements Comparable<Media> {
	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;

	// Constructors
	public Media(String title) {
		this.title = title;
		this.id = ++nbMedia;
	}

	public Media(String title, String category) {
		this(title);
		this.category = category;
	}

	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	// Methods
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Media media = (Media) obj;
		return Float.compare(media.cost, cost) == 0 &&
				title.equals(media.title);
	}

	@Override
	public int compareTo(Media other) {
		int titleCompare = this.title.compareTo(other.title);
		if (titleCompare != 0) return titleCompare;
		return Float.compare(this.cost, other.cost);
	}

	public boolean isMatch(String title) {
		if (title == null || title.isEmpty()) return false;
		return this.title.toLowerCase().contains(title.toLowerCase());
	}

	public void play() throws PlayerException {
		throw new PlayerException("ERROR: This media cannot be played!");
	}

	@Override
	public String toString() {
		return "Media: " + this.getTitle() +
				" - Category: " + this.getCategory() +
				" - Cost: " + this.getCost() + "$";
	}

	// Comparator implementations
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			Comparator.comparing(Media::getTitle)
					.thenComparing(Media::getCost);

	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			Comparator.comparing(Media::getCost)
					.thenComparing(Media::getTitle);
}