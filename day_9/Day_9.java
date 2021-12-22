package day_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static day_9.Part_1.solve_p1;
import static day_9.Part_2.solve_p2;

public class Day_9 {
  public static void main(String[] args) {
    int[][] heightmap = parse("input.txt");
    System.out.println(solve_p1(heightmap));
    System.out.println(solve_p2(heightmap));
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
