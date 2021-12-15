package day_7;

import static java.lang.Math.min;
import static java.lang.Math.round;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day_7 {
  public static void main(String[] args) {
    // File file = new File("day_7/test.txt");
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
    System.out.println(solve_1(positions));
    System.out.println(solve_2(positions));
  }

  private static int solve_2(int[] positions) {
    int avg1 = getAvg(positions);
    int avg0 = avg1 - 1;
    int avg2 = avg1 + 1;

    int[] fuel = new int[3];
    
    for (int i = 0; i < positions.length; i++) {
      int p = positions[i];
      int n1 = p >= avg1 ? p - avg1 : avg1 - p;
      int n0 = p >= avg0 ? p - avg0 : avg0 - p;
      int n2 = p >= avg2 ? p - avg2 : avg2 - p;
      fuel[1] += n1 * (n1 + 1) / 2;
      fuel[0] += n0 * (n0 + 1) / 2;
      fuel[2] += n2 * (n2 + 1) / 2;
    }

    return min(fuel[0], min(fuel[1], fuel[2]));
  }

  private static int getAvg(int[] positions) {
    double sum = 0;

    for (int i = 0; i < positions.length; i++) {
      sum += positions[i];
    }

    int avg1 = (int) round(sum / positions.length);
    return avg1;
  }

  private static int solve_1(int[] positions) {
    int median = getMedian(positions);
    return getFuel(positions, median);
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
