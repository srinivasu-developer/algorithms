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

    /* Prints number from 1 to n using recursion */
    public void printNos(int n)
    {
        if(n <= 0) {
            return;
        }
        printNos(n - 1);
        System.out.print(n + " ");
    }

    /* Compute power using recursion */
    public static int power(int n, int p)
    {
        if(p <= 0) {
            return 1;
        }
        return n * power(n, p - 1);
    }

    /* Digital Root of a number */
    public static int digitalRoot(int n)
    {
        if(n % 9 == 0) {
            return 9;
        }
        return ((n % 10) + digitalRoot(n / 10)) % 9;
    }

    /* Josephus problem */
    public int josephus(int n, int k)
    {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k-1) % n + 1;
        }
    }

    /* Adds positive pattern to the output list */
    public void positivePattern(int current, int input, List<Integer> output) {
        output.add(current);
        if(current >= input) {
            return;
        }
        positivePattern(current + 5, input, output);
    }
}
