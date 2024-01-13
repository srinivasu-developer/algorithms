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

    /* Find largest power within the number n */
    public static int findLargestPower(int n) {
        int x = 0;
        while(1 << (x + 1) <= n) {
           ++x; 
        }
        return x;
    }
    
}
