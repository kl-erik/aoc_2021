package day_9;

public class Part_2 {
  public static int solve_p2(int[][] heightmap) {
    int[] maxBasins = getMaxBasins(heightmap, 3);
    return calcProd(maxBasins);
  }

  private static int[] getMaxBasins(int[][] heightmap, int n) {
    int[] maxBasins = new int[n];
          
    for (int i = 0; i < heightmap.length; i++) {
      for (int j = 0; j < heightmap[i].length; j++) {
        if (heightmap[i][j] < 9) {
          int basins = countBasins(heightmap, i, j);
          addMax(maxBasins, basins);
        }
      }
    }
    return maxBasins;
  }

  private static int countBasins(int[][] heightmap, int i, int j) {
    if (heightmap[i][j] < 9) {
      heightmap[i][j] = 9;
      int basins = 1;
      
      if (i < heightmap.length - 1) {
        basins += countBasins(heightmap, i + 1, j);
      }

      if (i > 0) {
        basins += countBasins(heightmap, i - 1, j);
      }

      if (j < heightmap[i].length - 1) {
        basins += countBasins(heightmap, i, j + 1);
      }

      if (j > 0) {
        basins += countBasins(heightmap, i, j - 1);
      }

      return basins;
    }

    return 0;
  }

  private static void addMax(int[] maxBasins, int basins) {
    for (int i = 0; i < maxBasins.length; i++) {
      if (maxBasins[i] < basins) {
        int tmp = maxBasins[i];
        maxBasins[i] = basins;
        addMax(maxBasins, tmp);
        return;
      }
    }
  }

  private static int calcProd(int[] maxBasins) {
    int prod = 1;

    for (int basins : maxBasins) {
      prod *= basins;
    }

    return prod;
  }
}
