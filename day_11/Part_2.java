package day_11;

import static day_11.Part_1.*;

public class Part_2 {
  public static int solve_p2(int[][] octopuses) {
    int all = 0;

    for (int i = 0; i < octopuses.length; i++) {
      all += octopuses[i].length;
    }

    int steps = 0;

    while (countFlashes(octopuses) != all) {
      step(octopuses);
      steps++;
    }

    return steps;
  }
}
