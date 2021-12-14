package day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day_7 {
  public static void main(String[] args) {
    File file = new File("day_7/input.txt");
    ArrayList<Integer> list = new ArrayList<>();

    try (Scanner sc = new Scanner(file)) {
      String[] line = sc.nextLine().split(",");

      for (String p : line) {
        list.add(Integer.parseInt(p));
      }
    } catch (NumberFormatException | FileNotFoundException e) {
      e.printStackTrace();
    }

    int[] positions = toArray(list);
    int median = getMedian(positions);
    int fuel = getFuel(positions, median);
    System.out.println(fuel);
  }

  private static int getFuel(int[] positions, int mostCommon) {
    int fuel = 0;

    for (int position : positions) {
      fuel += mostCommon >= position ? mostCommon - position : position - mostCommon;
    }

    return fuel;
  }

  private static int getMedian(int[] positions) {
    Arrays.sort(positions);
    int n = positions.length;

    return n % 2 == 0 ? positions[n / 2] : positions[(n + 1) / 2];
  }

  private static int[] toArray(ArrayList<Integer> list) {
    int[] positions = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      positions[i] = list.get(i);
    }

    return positions;
  }
}
