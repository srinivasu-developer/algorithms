import java.util.*;

public class Math {
  
  	public static int countDigit(long n) {
		if (n/10 == 0)
			return 1;
		return 1 + countDigit(n / 10);
	}

	/* Checks whether the given number is palindrome or not */
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

	/* Check for prime */
	public static boolean isPrime(int n)
	{
		// Check if number is less than equal to 1
		if (n <= 1)
			return false;
		// Check if number is 2
		else if (n == 2)
			return true;
		// Check if n is a multiple of 2
		else if (n % 2 == 0)
			return false;
		// If not, then just check the odds
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/* Finds the prime factors of the given number */
	public static List<Integer> primeFactors(int n) {
		if(n <= 1)
			return Collections.emptyList();
		List<Integer> primeFactors = new ArrayList<>();
		while (n % 2 == 0) {
			primeFactors.add(2);
			n /= 2;
		}
		// n must be odd at this point. So we can skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		}
		if (n > 2)
			primeFactors.add(n);
		return primeFactors;
	}

	/* Returns list of prime factors for the given number */
	public static List<Integer> primeFactorsEff(int n) {
		if(n <= 1)
			return Collections.emptyList();
		List<Integer> primeFactors = new ArrayList<>();
		while(n % 2 == 0) {
			primeFactors.add(2);
			n = n / 2;
		}
		while(n % 3 == 0) {
			primeFactors.add(3);
			n = n / 3;
		}
		for(int i = 5; i * i <= n; i = i+6) {
			while(n % i == 0) {
				primeFactors.add(i);
				n = n / i;
			}
			while(n % (i + 2) == 0) {
				primeFactors.add(i + 2);
				n = n / (i + 2);
			}
		}
		if(n > 3)
			primeFactors.add(n);
		return primeFactors;
	}

	/* Prints all the divisors of the given number */
	public static void printDivisors(int n) {
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				System.out.print(i + " ");
	}

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
