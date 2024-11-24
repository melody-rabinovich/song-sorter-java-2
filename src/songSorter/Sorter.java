
package songSorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Sorter {
	
	public Sorter() {}
	
	public Integer[] sort(Song[] songList) {
		Integer[] sorted = fillArr(songList.length);
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < sorted.length; i++) {
			for (int j = i + 1; j < sorted.length; j++) {
				System.out.println("A. " + songList[i].getName() + " B. " + songList[j].getName());
				String choice = scanner.nextLine();
				
				if(choice.equals("A") || choice.equals("a")) {
					sorted[i] ++;
				} else if (choice.equals("B") || choice.equals("b")){
					sorted[j] ++;
				}
				
			}

		}
		
		showRanking(sorted, songList);
		
		
		return sorted;
	}
	
	private Integer[] fillArr(int length) {
		Integer [] filled = new Integer[length];
		for (int i = 0; i < length; i++) {
			filled[i] = 0;
		}
		return filled;
	}
	
	
	private void showRanking (Integer[] pointsArr, Song[] songList) {
		
		//Arrays.sort(pointsArr, Comparator.comparingInt((song -> song.getPoints())));
		/**
		 * con js, podría crearme un array y guardar objetos que tengan el nombre y los puntos, y después ordenarlos con el sort. 
		 * y recién ahí mostrarlos
		 */
		
		Song[] finalList = new Song[songList.length];
		
		
		for (int i = 0; i < finalList.length; i++) {
			finalList[i] = new Song(songList[i].getName(), pointsArr[i]);
			
		}
		
		Arrays.sort(finalList, Comparator.comparingInt((song -> song.getPoints())));
		
		for (int i = finalList.length-1; i >= 0; i--) {
			System.out.println(finalList[i].getName() + ". Points: " + finalList[i].getPoints());
		}
		
	}
	

}