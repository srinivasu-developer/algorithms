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
}
