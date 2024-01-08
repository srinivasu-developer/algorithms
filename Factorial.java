public class Factorial {

    public long factorial(int n) {
        long fact = 1L;
        for(int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
