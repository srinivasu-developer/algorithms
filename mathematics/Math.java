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

	public static int gcd(int a, int b)
	{
		// Everything divides 0
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		// base case
		if (a == b)
			return a;
		// a is greater
		if (a > b)
			return gcd(a-b, b);
		return gcd(a, b-a);
	}

	/* GCD with recursion */
	public static int gcdWithRecursion(int a, int b)
	{
		if (a == 0)
			return b;
		return gcdWithRecursion(b % a, a);
	}

	/* LCM of 2 numbers */
	public static int lcm(int a, int b)
	{
		return (a / gcd(a, b)) * b;
	}
  
}
