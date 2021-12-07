package day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_3 {
  public static void main(String[] args) {
    int[][] input = getInput(new File("day_3/input.txt"));
    System.out.println(new Part_1().solve(input));
  }

  private static int[][] getInput(File file) {
    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    try (Scanner sc = new Scanner(file)) {
      while (sc.hasNextLine()) {
        ArrayList<Integer> bs = new ArrayList<>();

        for (char c : sc.nextLine().toCharArray()) {
          bs.add(Integer.parseInt(String.valueOf(c)));
        }

        arrayList.add(bs);
      }
    } catch (NumberFormatException | FileNotFoundException e) {
      e.printStackTrace();
    }

    if (arrayList.size() == 0) {
      return new int[][] {{}};
    }

    int[][] input = new int[arrayList.size()][arrayList.get(0).size()];

    for (int i = 0; i < arrayList.size(); i++) {
      for (int j = 0; j < arrayList.get(0).size(); j++) {
        input[i][j] = arrayList.get(i).get(j);
      }
    }

    return input;
  }
}
