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
  
}
