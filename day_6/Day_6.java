package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day_6 {
  public static void main(String[] args) {
    // File file = new File("day_6/test.txt");
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

    /*int days = 256;
    int[] spawns = new int[days];

    for (int timer : fishes) {
      calcSpawns4(spawns, timer);
    }*/

    /*for (int i = 0; i < spawns.length; i++) {
      System.out.print(i + 1 + ":" + spawns[i] + ", ");
    }*/

    /*int sum = 0;

    for (int i : spawns) {
      sum += i;
    }*/

    //int spawns = 0;
    /*int[] spawns = new int[7];
    for (int i = 1; i < 7; i++) {
      spawns[i] = calcSpawns(18, i);
    }*/

    /*HashMap<Integer, Integer> spawns = new HashMap<>();

    int sum = 0;

    for (int timer : fishes) {
      if (spawns.containsKey(timer)) {
        sum += spawns.get(timer);
      } else {
        spawns.put(timer, calcSpawns(256, timer));
        sum += spawns.get(timer);
      }
    }

    System.out.println(sum * 5);*/

    int days = 256;
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

      for (int i = 9; i < spawns.length; i++) {
        spawns[i] = spawns[i - 7] + spawns[i - 9];
      }

      timers[j] = spawns[spawns.length - 1];
    }

    long sum = 0;

    for (int timer : fishes) {
      sum += timers[timer];
    }

    System.out.println(sum);

    /*
    calcSpawns[days-timer, 7] + calcSpawns[days-timer, 9]
    */
  }

  private static int calcSpawns(int days, int timer) {
    int daysLeft = days - timer;

    if (daysLeft > 0) {
      return calcSpawns(daysLeft, 7) + calcSpawns(daysLeft, 9);
    }

    return 1;
  }

  private static void calcSpawns4(int[] spawns, int timer) {
    for (int i = timer; i < spawns.length; i += 7) {
      spawns[i]++;

      calcSpawns4(spawns, i + 9);
    }
  }

  private static int calcSpawns3(int days, int timer) {
    int daysLeft = days - timer;

    if (daysLeft > 0) {
      int spawns = daysLeft % 7 == 0 ? daysLeft / 7 : daysLeft / 7 + 1;
      int newSpawns = 0;

      for (int s = 0; s < spawns; s++) {
        newSpawns += calcSpawns3(daysLeft - 7 * s, 9);
      }

      return spawns + newSpawns;
    }

    return 0;
  }

  private static int calcSpawns2(int days, int timer) {
    int spawns = 0;
    int daysLeft = days - timer;

    if (daysLeft > 0) {
      spawns = daysLeft % 7 == 0 ? daysLeft / 7 : daysLeft / 7 + 1;
      int newSpawns = 0;

      for (int spawn = 0; spawn < spawns; spawn++) {
        newSpawns += calcSpawns2(daysLeft - 7 * spawn, 9);
      }

      spawns += newSpawns;
    }

    return spawns;
  }
}
