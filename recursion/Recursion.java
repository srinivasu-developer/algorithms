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
    public void positivePattern(int current, int input, int increment, List<Integer> output) {
        output.add(current);
        if(current >= input) {
            return;
        }
        positivePattern(current + increment, input, output);
    }

    /* Adds negative pattern to the output list */
    public int negativePattern(int n, int increment, List<Integer> output) {
        output.add(n);
        if(n <= 0) {
            return n;
        }
        return negativePattern(n - increment, output);
    }

    /* Uses the above 2 methonds to print a pattern of number from N till 0 and again till N with an increment */
    public List<Integer> pattern(int N, int increment){
        List<Integer> ouput = new ArrayList<>();
        if(N < (-1 * increment)) {
            ouput.add(N);
        } else {
           int lastNumber = negativePattern(N, increment, ouput);
            if(N > 0) {
                positivePattern(lastNumber + increment, N, increment, ouput);
            } 
        }
        return ouput;
    }
}
