public class Problems {

    static int[][] sumMatrix(int a[][], int b[][]) {
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

    static int[][] multiplyMatrix(int a[][], int b[][])
    {
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
}
