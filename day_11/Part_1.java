package day_11;

public class Part_1 {
  public static int solve_p1(int[][] octopuses) {
    int flashes = 0;

    for (int i = 0; i < 100; i++) {
      step(octopuses);
      flashes += countFlashes(octopuses);
    }

    return flashes;
  }

  private static void step(int[][] octopuses) {
    for (int i = 0; i < octopuses.length; i++) {
      for (int j = 0; j < octopuses[i].length; j++) {
        update(octopuses, i, j);
      }
    }

    for (int i = 0; i < octopuses.length; i++) {
      for (int j = 0; j < octopuses[i].length; j++) {
        if (octopuses[i][j] > 9) {
          octopuses[i][j] = 0;
        }
      }
    }
  }

  private static void update(int[][] octopuses, int i, int j) {
    octopuses[i][j]++;

    if (octopuses[i][j] == 10) {
      boolean up = i > 0;
      boolean down = i < octopuses.length - 1;
      boolean left = j > 0;
      boolean right = j < octopuses[i].length - 1;

      if (up) {
        update(octopuses, i - 1, j);
      }

      if (down) {
        update(octopuses, i + 1, j);
      }

      if (left) {
        update(octopuses, i, j - 1);
      }

      if (right) {
        update(octopuses, i, j + 1);
      }

      if (up && left) {
        update(octopuses, i - 1, j - 1);
      }

      if (up && right) {
        update(octopuses, i - 1, j + 1);
      }

      if (down && left) {
        update(octopuses, i + 1, j - 1);
      }

      if (down && right) {
        update(octopuses, i + 1, j + 1);
      }
    }
  }

  private static int countFlashes(int[][] octopuses) {
    int flashes = 0;

    for (int i = 0; i < octopuses.length; i++) {
      for (int j = 0; j < octopuses[i].length; j++) {
        if (octopuses[i][j] == 0) {
          flashes++;
        }
      }
    }

    return flashes;
  }
}
