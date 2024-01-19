/* Holds some of the recursion relation algorithms */
public class Recursion {

    /* Sum of digits using recursion */
    public static int sumOfDigits(int n)
    {
        if(n <= 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    /* Fibonacci series */
    public static int fibonacci(int n)
    {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
