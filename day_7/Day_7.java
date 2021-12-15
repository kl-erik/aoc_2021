package day_7;

import static java.lang.Math.*;

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

      for (String string : line) {
        list.add(Integer.parseInt(string));
      }
    } catch (NumberFormatException | FileNotFoundException e) {
      e.printStackTrace();
    }

    int[] positions = toArray(list);
    System.out.println(solve_1(positions));
    System.out.println(solve_2(positions));
  }

  private static int[] toArray(ArrayList<Integer> list) {
    int[] positions = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      positions[i] = list.get(i);
    }

    return positions;
  }

  private static int solve_1(int[] positions) {
    return getFuel_1(positions, median(positions));
  }

  private static int median(int[] positions) {
    Arrays.sort(positions);
    int n = positions.length;

    return n % 2 == 0 ? positions[n / 2] : positions[(n + 1) / 2];
  }

  private static int getFuel_1(int[] positions, int median) {
    int fuel = 0;

    for (int position : positions) {
      fuel += abs(position - median);
    }

    return fuel;
  }

  private static int solve_2(int[] positions) {
    return getFuel_2(positions, average(positions));
  }

  private static int  average(int[] positions) {
    double sum = 0;

    for (int i = 0; i < positions.length; i++) {
      sum += positions[i];
    }

    int avg = (int) round(sum / positions.length);
    return avg;
  }

  private static int getFuel_2(int[] positions, int average) {
    int[] avg = new int[3];
    avg[0] = average;
    avg[1] = average - 1;
    avg[2] = average + 1;
    int[] fuel = new int[3];
    
    for (int i = 0; i < positions.length; i++) {
      int position = positions[i];

      for (int j = 0; j < fuel.length; j++) {
        int n = abs(position - avg[j]);
        fuel[j] += n * (n + 1) / 2;
      }
    }

    return min(fuel[0], min(fuel[1], fuel[2]));
  }
}
