package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Part_1
 */
public class Part_1 {
  private static Scanner sc;

  public static void main(String[] args) {
    File input = new File("Day_1/input.txt");

    try {
      sc = new Scanner(input);
      int increments = 0;

      if (sc.hasNextLine()) {
        int max = Integer.parseInt(sc.nextLine());

        while (sc.hasNextLine()) {
          int current = Integer.parseInt(sc.nextLine());

          if (current > max) {
            increments++;
          }

          max = current;
        }
      }

      System.out.println(increments);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}