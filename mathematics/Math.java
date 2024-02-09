public class Math {
  
  	public static int countDigit(long n) {
		if (n/10 == 0)
			return 1;
		return 1 + countDigit(n / 10);
	}

	public static boolean checkPalindrome(int n) {
		int reverse = 0;
		int temp = n;
		while (temp != 0) {
			reverse = (reverse * 10) + (temp % 10);
			temp = temp / 10;
		}
		return (reverse == n); // if it is true then it will return 1 else if false it will return 0;
	}

	public static int findTrailingZeros(int n)
	{
		if (n < 0) // Negative Number Edge Case
			return -1;
		int count = 0;
		// Keep dividing n by powers of 5 and update count
		for (int i = 5; n / i >= 1; i *= 5)
			count += n / i;
		return count;
	}
  
}
