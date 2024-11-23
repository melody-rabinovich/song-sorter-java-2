package songSorter;

public class Song {
	private String name;
	private int releaseYear;
	private String artist;
	private int points;
	
	public Song(String name, int releaseYear, String artist) {
		super();
		setName(name);
		setReleaseYear(releaseYear);
		setArtist(artist);
	}
	
	public Song(String name, int points) {
		setName(name);
		setPoints(points);
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	private void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Song [name=" + name + ", releaseYear=" + releaseYear + ", artist=" + artist + ", points=" + points
				+ "]";
	}
	
	
	
	
}


