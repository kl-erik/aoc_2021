package day_1;

public class Part_2 {
  public int solve(int[] input) {
    int increments = 0;

    if (input.length > 3) {
      int win1 = input[0] + input[1] + input[2];
      int win2 = input[1] + input[2];
      int win3 = input[2];

      for (int i = 3; i < input.length; i++) {
        int val = input[i];

        if (i % 3 == 0) {
          win2 += val;
          win3 += val;

          if (win1 < win2) increments++;

          win1 = val;
        } else if (i % 3 == 1) {
          win1 += val;
          win3 += val;

          if (win2 < win3) increments++;

          win2 = val;
        } else {
          win1 += val;
          win2 += val;

          if (win3 < win1) increments++;

          win3 = val;
        }
      }
    }

    return increments;
  }
}
