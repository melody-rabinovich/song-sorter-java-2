package songSorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Sorter {
	
	public Sorter() {}
	
	
	/**
	 * this function will recieve a song list and 
	 * transform it into a matrix in order to be able to track
	 * the points each song gets from the user.
	 * 
	 *  It will also fill said matrix with 0, each time it compares
	 *  the same song, and with null for each value that needs to be
	 *  tracked by the user.
	 * @param songList 
	 * @return initializedMatrix
	 */
	private Integer[][] initializeMatrix(Song[] songList){
		Integer [][] initializedMatrix = new Integer[songList.length][songList.length];
		
		for (int i = 0; i < initializedMatrix.length; i++) {
			for (int j = 0; j < initializedMatrix[i].length; j++) {
				if(i == j){
					initializedMatrix[i][j] = 0;
					initializedMatrix[j][i] = 0;
					
				} else {
					initializedMatrix[i][j] = null;
				}
			}
		}
		
		
		return initializedMatrix;
	}
	
	
	//the sorting should be private. The user would only need to interact with the final list
	private Integer[][] sort(Song[] songList) {
		
		Integer [][] matrix = initializeMatrix(songList);
		
		/**
		 * for dev purposes, to verify that the matrix is in fact changing
		  System.out.println("------- show matrix:");
		  showMatrix(matrix);
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				// I previously filled the ones that need to be compared with null
				if(matrix[i][j] == null) {
					// asks the user
					System.out.println("A. " + songList[i].getName() + ", B " + songList[j].getName());
					String choice = scanner.next();


					if(choice.equals("A") || choice.equals("a") ){
						//fills both spaces of the matrix, in order to ask only once
						matrix[i][j] = 1;
						matrix[j][i] = 0;

					} else if (choice.equals("B") || choice.equals("b")) {
						//fills both spaces of the matrix, in order to ask only once
						matrix[i][j] = 0;
						matrix[j][i] = 1;

					}
				}
			}
		}
		

		/**
		 * for dev purposes, to show that the matrix changed
			System.out.println("------- show matrix:");
			showMatrix(matrix);
		 */
		return matrix;
		
	}
	
	/**
	 * will
	 * 	- iterate the matrix using the sort(songList) function 
	 * 	- for each song, it'll sum the points, based on the user's previous choices
	 *  - it'll rank them by said points
	 */
	public void showFavoriteToLeast(Song[] songList) {
		Integer[][] sorted = sort(songList);
		String topSongName = null;
		Song[] sorting = new Song[songList.length] ;
		
		for (int i = 0; i < sorted.length; i++) {
			int counter = 0;
			
			for (int j = 0; j < sorted[i].length; j++) {
				counter += sorted[i][j];
			}
			
			sorting[i] = new Song(songList[i].getName(), counter);
			
			
		}
		
		Arrays.sort(sorting, Comparator.comparingInt((song -> song.getPoints())));
		
		for (int i = sorting.length-1; i >= 0; i--) {
			System.out.println(sorting[i].getName() + " "+ sorting[i].getPoints());
		}
		
		
		
	}
	
	
	
	
	/**
	 * its for dev testing only. It's not the final output
	 * @param matrix
	 */
	private void showMatrix(Integer[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "      |");
			}
				System.out.println();
		}
	}

}
