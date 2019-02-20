package lab.threads;

public class maxFinder   {
	public static class maxRow implements Runnable {
		private Double[] row;
		private Double[] storedArray;
		private int position;

		public maxRow(Double[] row, Double[] storedArray, int position) {
			this.row = row;
			this.storedArray = storedArray;
			this.position = position;
		}

		/**
		 * This method will find the maximum value in a 2D-array of random numbers
		 * @param randArray is a 2D array pre-populated with random double
		 * @return the maximum value in the array.
		 */
		public static double findMax2D(Double[][] randArray) {
			Double max = 0.0;
			for (int i = 0; i < randArray.length; i++) {
				for (int j = 0; j < randArray[i].length; j++) {
					if (randArray[i][j] >= max) {
						max = randArray[i][j];
					}
				}
			}
			return max;
		}

		/*
		 * This method will return the maximum value in a 1D array
		 * @param anArray is a 1D array prepopulated with random numbers
		 * @return the maximum value
		 */
		public static double findMax(Double[] anArray) {
			Double max = 0.0;
			for (int i = 0; i < anArray.length; i++) {
				if (anArray[i] >= max) {
					max = anArray[i];
				}
			}
			return max;
		}
		
		/**
		 * First create a 2d array of random double numbers
		 * Call the findMax2D to find the actual max number expected
		 * start a thread, each of which will find the max of a row within the 2d array and stored that in a 1d array at 
		 * separate index
		 * Once a thread is done, join the threads
		 * Create a final thread that will find the max within the 1d array of maxes and stores this in another 1d array of
		 * length 1.
		 * There are no race conditions as threads are storing numbers into individual elements in the 1d array
		 * @param args
		 */

		public static void main(String[] args) {
			int nRows = 100;
			int nCols = 50;
			Double[][] randArray = createArray(nRows, nCols);
			Double max = findMax2D(randArray);
			System.out.println("The max is: " + max);

			Double[] storedArray = new Double[nRows]; //a 1d array as long as the number of rows
			Thread[] threads = new Thread[nRows]; // a thread for each row
			for (int i = 0; i < nRows; i++) {
				threads[i] = new Thread(new maxRow(randArray[i], storedArray, i));
				threads[i].start();
			}
			try {
				for (int i = 0; i<nRows; i++) {
					threads[i].join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Double[] finalValue = new Double[1];
			Thread finalThread = new Thread(new maxRow(storedArray, finalValue, 0));
			finalThread.start();
			try {
				finalThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(finalValue[0]);
		}
		/**
		 * Create a 2D array populated with random numbers.
		 * @param nRows is the number of rows to be in 2d array
		 * @param nCols is the number of columns to be in 2d array
		 * @return a populated 2d array
		 */
		public static Double[][] createArray(int nRows, int nCols) {
			Double[][] randArray = new Double [nRows][nCols];
			for (int r = 0 ; r<nRows; r++) {
				for (int c = 0; c < nCols; c++) {
					randArray[r][c] = Math.random();
				}
			}
			return randArray;
		}

		/**
		 * Each thread will find the max in a row and store it in a new cell within a 1d array
		 */
		@Override
		public void run() {
			storedArray[position] = findMax(row );
		}
	}
}
