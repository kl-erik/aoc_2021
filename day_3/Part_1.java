package day_3;

public class Part_1 {

  public int solve(int[][] input) {
    if (input.length == 0) {
      return 0;
    }

    int[] bin = process(input);
    int gamma = BinUtil.getVal(bin);
    BinUtil.flip(bin);
    int epsilon = BinUtil.getVal(bin);

    return gamma * epsilon;
  }

  private int[] process(int[][] input) {
    int[] bin = new int[input[0].length];

    for (int i = 0; i < bin.length; i++) {
      int ones = 0; 
      int zeroes = 0;

      for (int[] b : input) {
        if (b[i] == 1) {
          ones++;
        } else {
          zeroes++;
        }
      }

      if (ones >= zeroes) {
        bin[i] = 1;
      } else {
        bin[i] = 0;
      }
    }

    return bin;
  }
}