package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_6 {
  public static void main(String[] args) {
    File file = new File("day_6/input.txt");
    ArrayList<Integer> fishes = new ArrayList<>();

    try (Scanner sc = new Scanner(file)) {
      String[] s = sc.nextLine().split(",");

      for (int i = 0; i < s.length; i++) {
        fishes.add(Integer.parseInt(s[i]));
      }
    } catch (NumberFormatException | FileNotFoundException e) {
      e.printStackTrace();
    }

    long[] timers = getTimers(256);
    long sum = 0;

    for (int timer : fishes) {
      sum += timers[timer];
    }

    System.out.println(sum);
  }

  private static long[] getTimers(int days) {
    long[] spawns = new long[days];
    long[] timers = new long[7];
    
    for (int j = 1; j < timers.length; j++) {
      // base cases
      for (int i = 0; i < j; i++) {
        spawns[i] = 1;
      }

      for (int i = j; i < j + 7; i++) {
        spawns[i] = 2;
      }

      for (int i = j + 7; i < 9; i++) {
        spawns[i] = 3;
      }

      // step cases
      for (int i = 9; i < spawns.length; i++) {
        spawns[i] = spawns[i - 7] + spawns[i - 9];
      }

      timers[j] = spawns[spawns.length - 1];
    }
    return timers;
  }
}
