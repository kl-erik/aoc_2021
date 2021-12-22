package day_9;

public class Part_1 {
  public static int solve_p1(int[][] heightmap) {
    int sum = 0;

    for (int i = 0; i < heightmap.length; i++) {
      for (int j = 0; j < heightmap[i].length; j++) {
        if (lowPoint(heightmap, i, j)) {
          sum += heightmap[i][j] + 1;
        }
      }
    }

    return sum;
  }

  private static boolean lowPoint(int[][] heightmap, int i, int j) {
    boolean lowPoint = true;

    if (i < heightmap.length - 1) {
      lowPoint &= heightmap[i][j] < heightmap[i + 1][j];
    }

    if (i > 0) {
      lowPoint &= heightmap[i][j] < heightmap[i - 1][j];
    }

    if (j < heightmap[i].length - 1) {
      lowPoint &= heightmap[i][j] < heightmap[i][j + 1];
    }

    if (j > 0) {
      lowPoint &= heightmap[i][j] < heightmap[i][j - 1];
    }

    return lowPoint;
  }
}
