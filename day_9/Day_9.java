package day_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_9 {
  public static void main(String[] args) {
    int[][] heightmap = parse("input.txt");
    System.out.println(solve_p1(heightmap));
  }

  private static int solve_p1(int[][] heightmap) {
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

  private static int[][] parse(String string) {
    File file = new File("day_9/" + string);
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    try (Scanner sc = new Scanner(file)) {
      while (sc.hasNext()) {
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : sc.nextLine().toCharArray()) {
          list.add(Integer.parseInt(String.valueOf(c)));
        }

        lists.add(list);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return toArray(lists);
  }

  private static int[][] toArray(ArrayList<ArrayList<Integer>> lists) {
    int[][] aLists = new int[lists.size()][];

    int j = 0;
    for (ArrayList<Integer> list : lists) {
      int[] aList = new int[list.size()];

      for (int i = 0; i < aList.length; i++) {
        aList[i] = list.get(i);
      }

      aLists[j] = aList;
      j++;
    }

    return aLists;
  }
}
