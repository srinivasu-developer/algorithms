public class BitManipulation
{
    // Function to check if Kth bit is set or not.
    public static boolean checkKthBit(int n, int k)
    {
        return (n & (1 << k)) > 0;
    }

    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
        int position = 1;
        while(n > 0) {
            if((n & 1) > 0) {
               return position;
            }
            ++position;
            n >>= 1;
        }
        return 0;
    }

    /* Function to return sum of count of set bits in the integers from 1 to n */
    public static int countSetBits(int n){
        if(n <= 1) {
            return n;
        }
        int largestPower = findLargestPower(n);
        return (largestPower * (int) Math.pow(2, largestPower - 1)) + 
            (n - (int) Math.pow(2, largestPower) + 1) + 
            countSetBits(n - (int) Math.pow(2, largestPower));
        
    }

    /* Find largest power within the number n */
    public static int findLargestPower(int n) {
        int x = 0;
        while(1 << (x + 1) <= n) {
           ++x; 
        }
        return x;
    }

    /* Function to check if given number n is a power of two. */
    public static boolean isPowerofTwo(long n){
        return ((n != 0) && (n & (n - 1)) == 0);
    }
    
}
