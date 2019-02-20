package lab.threads;

import lab.threads.maxFinder3.maxRow;

public class maxFinder3   {
	public static class maxRow implements Runnable {
		private Double[] row;
		private Double[] storedArray;
		private int position;
		private SharedDouble shared;

		public maxRow(Double[] row, Double[] storedArray, int position) {
			this.row = row;
			this.storedArray = storedArray;
			this.position = position;
		}
		
		public maxRow(Double[] row, SharedDouble shared) {
			this.row = row;
			this.shared = shared;
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
		
		/**
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

		public static void main(String[] args) {
			int nRows = 100;
			int nCols = 50;
			Double[][] randArray = createArray(nRows, nCols);
			Double max = findMax2D(randArray);
			System.out.println("The max is: " + max);
			
			SharedDouble shared = new SharedDouble();
			shared.setD(0.0);
			Double[] storedArray = new Double[nRows]; //a 1d array as long as the number of rows
			Thread[] threads = new Thread[nRows]; // a thread for each row
			for (int i = 0; i < nRows; i++) {
				threads[i] = new Thread(new maxRow(randArray[i], shared));
				threads[i].start();
			}
				try {
					for (int i = 0; i<nRows; i++) {
						threads[i].join();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(shared.getD());
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
		 * Each thread will find the max in a row and stored in a cell within a new row.
		 */
		@Override
		public void run() {
			for (int i = 0; i < row.length; i++) {
				Double globalMax = shared.getD();
				/**
				 * Can also avoid race condition by applying synchronized to shared object before comparison method
				 * is called
				 */
//				synchronized(shared) {
					shared.compare(row[i]);
//				}
			}
		}
	}
}

