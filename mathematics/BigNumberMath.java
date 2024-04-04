public class BigNumberMath {

    /* Finds sum of 2 long numbers with modulus of 10^9 +7 */
    public static long sumUnderModulo(long a, long b){
        long mod = (long) Math.pow(10, 9) + 7;
        return (a % mod + b % mod) % mod;
    }   

    /* Finds multiplication of 2 long numbers with modulus of 10^9 +7 */
    public static long multiplicationUnderModulo(long a, long b)
    {
        long mod = (long) Math.pow(10, 9) + 7;
        return ((a % mod) * (b % mod)) % mod;
    }
}
