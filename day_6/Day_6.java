package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_6 {
  public static void main(String[] args) {
    // File file = new File("day_6/test.txt");
    File file = new File("day_6/input.txt");

    try (Scanner sc = new Scanner(file)) {
      String[] s = sc.nextLine().split(",");
      ArrayList<Integer> fishes = new ArrayList<>();

      for (int i = 0; i < s.length; i++) {
        fishes.add(Integer.parseInt(s[i]));
      }

      for (int day = 0; day < 80; day++) {
        int n = fishes.size();

        for (int i = 0; i < n; i++) {
          int fish = fishes.get(i);

          if (fish == 0) {
            fishes.add(8);
            fishes.set(i, 6);
          } else {
            fishes.set(i, fish - 1);
          }
        }
      }

      System.out.println(fishes.size());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
