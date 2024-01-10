public class ModInverse {
    
  public int modInverse(int a, int m)
    {
      for(int i = 1; i <= m; i++) {
          if((i * a) % m == 1) {
              return i;
          }
      }
      return -1;
    }

}
