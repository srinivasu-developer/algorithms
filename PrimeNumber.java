public class PrimeNumber {

    /* Prime check with effective algorithm */
    public boolean isPrime(int n) {
      boolean isPrime = true;
      if(n == 1) {
          isPrime = false;
      } else if (n == 2 || n == 3) {
          isPrime = true;
      } else if (n % 2 == 0 || n % 3 == 0) {
          isPrime = false;
      } else {
          for(int i = 5; i * i <= n; i = i + 6) {
              if(n % i == 0 || n % (i + 2) == 0) {
                 isPrime = false;
              }
          }
      }
      return isPrime;
    }
}
