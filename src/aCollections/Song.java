package aCollections;

public class Song implements Comparable<Song> {
	private String title;
	private String artist;
	private String rating;
	private String bmp;

	public Song(String title, String artist, String rating, String bmp) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.bmp = bmp;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getRating() {
		return rating;
	}

	public String getBmp() {
		return bmp;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", rating="
				+ rating + ", bmp=" + bmp + "]\n";
	}

	@Override
	public int compareTo(Song o) {
		return title.compareTo(o.getTitle());
	}

}
