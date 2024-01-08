public class BigNumberMath {
  
    public static long sumUnderModulo(long a, long b){
        long mod = (long) Math.pow(10, 9) + 7;
        return (a % mod + b % mod) % mod;
    }   

    static long multiplicationUnderModulo(long a, long b)
    {
        long mod = (long) Math.pow(10, 9) + 7;
        return ((a % mod) * (b % mod)) % mod;
    }
}
