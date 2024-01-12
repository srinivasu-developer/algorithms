public class BitManipulation
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
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
    
}
