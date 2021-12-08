package day_3;

public class BinUtil {

  private BinUtil() {
  }

  public static int getVal(int[] bin) {
    int val = 0;
    int j = 0;

    for (int i = bin.length - 1; i >= 0; i--) {
      val += bin[i] * Math.pow(2, j);
      j++;
    }

    return val;
  }

  public static void flip(int[] bin) {
    for (int i = 0; i < bin.length; i++) {
      bin[i] = bin[i] == 1 ? 0 : 1;
    }
  }
  
}
