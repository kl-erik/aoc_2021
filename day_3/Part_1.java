package day_3;

public class Part_1 {

  public int solve(int[][] bs) {
    if (bs.length == 0) {
      return 0;
    }

    int n = bs[0].length;
    int[] gammaBin = new int[n];
    int[] epsilonBin = new int[n];

    for (int i = 0; i < n; i++) {
      int ones = 0; 
      int zeroes = 0;

      for (int[] b : bs) {
        if (b[i] == 1) {
          ones++;
        } else {
          zeroes++;
        }
      }

      if (ones > zeroes) {
        gammaBin[i] = 1;
        epsilonBin[i] = 0;
      } else {
        gammaBin[i] = 0;
        epsilonBin[i] = 1;
      }
    }

    int gamma = 0;
    int epsilon = 0;
    int j = 0;

    for (int i = n - 1; i >= 0; i--) {
      gamma += gammaBin[i] * Math.pow(2, j);
      epsilon += epsilonBin[i] * Math.pow(2, j);
      j++;
    }

    return gamma * epsilon;
  }
}