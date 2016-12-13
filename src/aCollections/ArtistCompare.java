package aCollections;

import java.util.Comparator;

public class ArtistCompare implements Comparator<Song> {

	@Override
	public int compare(Song o1, Song o2) {

		return o1.getArtist().compareTo(o2.getArtist());
	}

}
