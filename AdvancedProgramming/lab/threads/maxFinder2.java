package lab.threads;

public class maxFinder2   {
	public static class maxRow implements Runnable {
		private Double[] row;
		private SharedDouble shared;
		
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

		public static void main(String[] args) {
			int nRows = 100;
			int nCols = 50;
			Double[][] randArray = createArray(nRows, nCols);
			Double max = findMax2D(randArray);
			System.out.println("The max is: " + max);
			SharedDouble shared = new SharedDouble();
			shared.setD(0.0);
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
		public void run() {
			for (int i = 0; i < this.row.length; i++) {
				Double globalMax = shared.getD();
				if (this.row[i] >= globalMax) {
					try {
                        Thread.sleep(1);
                        
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
					shared.setD(row[i]);
				}
			}
		}
	}
}
