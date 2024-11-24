package songSorter;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song[] songList = {new Song("Cruel Summer", 2019, "Taylor Swift"), 
							new Song("The Black Dog", 2024, "Taylor Swift"),
							new Song("Cargidan", 2020, "Taylor Swift"),
							new Song("Red", 2013, "Taylor Swift")};
		
		Sorter sorter = new Sorter();
		
		
		sorter.sort(songList);

	}

}
