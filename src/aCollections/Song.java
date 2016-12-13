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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((bmp == null) ? 0 : bmp.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (bmp == null) {
			if (other.bmp != null)
				return false;
		} else if (!bmp.equals(other.bmp))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
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
