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

    public static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int resultsSize = (2 * min) + max;
        ArrayList<Integer> results = new ArrayList<>(resultsSize);
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
}
