public class Problems {

    public static int[][] sumMatrix(int a[][], int b[][]) {
        if(a.length != b.length || a[0].length != b[0].length) {
            return new int[0][0];
        }
        for(int i = 0; i < a.length; i++) {
           for(int j = 0; j < a[0].length; j++) {
               a[i][j] = a[i][j] + b[i][j];
           }
        }
        return a;
    }

    public static int[][] multiplyMatrix(int a[][], int b[][]) {
        if(a[0].length != b.length) {
            return new int[0][0];
        }
        int aRows = a.length;
        int bRows = b.length;
        int bCols = b[0].length;
        int[][] results = new int[aRows][bCols];
        int currentRow = 0;
        while(currentRow < aRows) {
            int currentColumn = 0;
            while(currentColumn < bCols) {
                int currentValue = 0;
                for(int j = 0; j < bRows; j++) {
                    currentValue += (a[currentRow][j] * b[j][currentColumn]);
                }
                results[currentRow][currentColumn++] = currentValue;
            } 
            currentRow++;
        }
        return results;
    }

    /* Snake pattern of the mattrix will be returned as a list */
    public static List<Integer> snakePattern(int matrix[][]) {
        List<Integer> results = new ArrayList<>();
        boolean forwardMove = true;
        int rows = matrix.length;
        for(int i = 0; i < rows; i++) {
           for(int j = 0, k = rows - 1; j < rows; j++, k--) {
               results.add(matrix[i][forwardMove ? j : k]);
           }
           forwardMove = !forwardMove;
        }
        return results;
    }

    /* Boundary traversal */
    public static List<Integer> boundaryTraversal(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int resultsSize = (2 * min) + max;
        List<Integer> results = new ArrayList<>(resultsSize);
        if(n == 1) {
            for(int i = 0; i < m; i++) {
                results.add(matrix[0][i]);
            }
        } else if(m == 1) {
            for(int i = 0; i < n; i++) {
                results.add(matrix[i][0]);
            }
        } else {
            for(int j = 0; j < m; j++) {
                results.add(matrix[0][j]);
            }
            for(int j = 1; j < n; j++) {
                results.add(matrix[j][m - 1]);
            }
            for(int j = m - 2; j >= 0; j--) {
                results.add(matrix[n - 1][j]);
            }
            for(int j = n - 2; j > 0; j--) {
                results.add(matrix[j][0]);
            }
        }
        return results;
    }

	/**
	* Finds the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.
	*/
    public void transpose(int a[][]) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                swap(a, i, j);
            }
        }
    }

	/**
	* Given a square matrix of size N x N. Rotates it by 90 degrees in anti-clockwise direction without using any extra space. 
	*/
    public static void rotateby90(int matrix[][]) { 
        transpose(matrix);
        swapRows(matrix);
    }

	/**
	* Given a matrix of size n x m, where every row and column is sorted in increasing order, and a number x.
 	* Searches whether element x is present in the matrix or not.
	*/
    public static boolean search(int matrix[][], int x) {  
        int n = matrix.length;
        int m = matrix[0].length;
	    boolean found = false;
	    int i = 0, j = m - 1;
	    while(i <= n - 1 && j >= 0) {
	        if(matrix[i][j] < x) {
	            i++;
	        } else if(matrix[i][j] > x) {
	            j--;
	        } else {
	            found = true;
	            break;
	        }
	    }
	    return found;
	} 

	/**
 	* Given a square matrix of size N*N, prints the sum of upper and lower triangular elements. 
  	* Upper Triangle consists of elements on the diagonal and above it. 
  	* The lower triangle consists of elements on the diagonal and below it. 
  	*/
	public static List<Integer> sumTriangles(int matrix[][]) {
		int n = matrix.length;
        List<Integer> results = new ArrayList<>();
        int up = 0;
        int down = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i < j) {
                    up += matrix[i][j];
                } else if (i > j) {
                    down += matrix[i][j];
                } else {
                    up += matrix[i][j];
                    down += matrix[i][j];
                }
            }
        }
        results.add(up);
        results.add(down);
        return results;
    }

	/**
 	* Given a matrix of dimensions (n1 x m1). Exchanges its first column with the last column.
  	*/
	public static void exchangeColumns(int matrix[][]) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int temp;
        for(int i = 0; i < rows; i++) {
            temp = matrix[i][0];
            matrix[i][0] = matrix[i][columns - 1];
            matrix[i][columns - 1] = temp;
        }
    }

	public static void reverseCol(int matrix[][]) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns / 2; j++) {
                swap(matrix, i, j, columns - j - 1);
            }
        }
    }

	/** 
 	* Given a matrix of dimensions n1 x m1. Interchange its rows in-place such that the first row will become 
 	* the last row and so on. 
	*/
	public static void interchangeRows(int matrix[][]) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i < rows / 2; i++) {
            for(int j = 0; j < columns; j++) {
                swap(matrix, i, j, rows - i - 1);
            }
        }
    }

	/* Swaps the row and column */
	private static void swap(int[][] arr, int row1, int col1, int col2) {
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row1][col2];
        arr[row1][col2] = temp;
    }

	/**
	* Swaps the matrix i and j positions
	*/
    private static void swap(int[][] arr, int first, int second) {
        int temp = arr[first][second];
        arr[first][second] = arr[second][first];
        arr[second][first] = temp;
    }

	/**
	* Swaps the matrix rows
	*/
    private static void swap(int[][] arr, int row1, int col1, int row2) {
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col1];
        arr[row2][col1] = temp;
    }

     private static void swapRows(int[][] a) {
        int n = a.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                swap(a, i, j, n - i - 1);
            }
        }
    }
}
