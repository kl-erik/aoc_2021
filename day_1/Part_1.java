package day_1;

public class Part_1 {
  public int solve(int[] input) {
    int increments = 0;
    
    if (input.length > 0) {
      int max = input[0];

      for (int i = 1; i < input.length; i++) {
        int current = input[i];

        if (current > max) {
          increments++;
        }

        max = current;
      }
    }

    return increments;
  }
}