package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solved using dynamic programming.
 */
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

    HashMap<Integer, Long> timerSpawns = new HashMap<>();
    long sum = 0;

    for (int timer : fishes) {
      if (!timerSpawns.containsKey(timer)) {
        long spawns = getSpawns(timer, 256);
        timerSpawns.put(timer, spawns);
        sum += spawns;
      } else {
        sum += timerSpawns.get(timer);
      }
    }

    System.out.println(sum);
  }

  private static long getSpawns(int timer, int days) {
    long[] spawns = new long[days];
    
    // base cases
    for (int i = 0; i < timer; i++) {
      spawns[i] = 1;
    }

    for (int i = timer; i < timer + 7; i++) {
      spawns[i] = 2;
    }

    for (int i = timer + 7; i < 9; i++) {
      spawns[i] = 3;
    }

    // step cases
    for (int i = 9; i < spawns.length; i++) {
      spawns[i] = spawns[i - 7] + spawns[i - 9];
    }

    return spawns[spawns.length - 1];
  }
}
