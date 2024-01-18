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
}
