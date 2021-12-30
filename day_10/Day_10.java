package day_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static day_10.Part_1.solve_p1;
import static day_10.Part_2.solve_p2;

public class Day_10 {
  public static void main(String[] args) {
    char[][] lines = parse("input.txt");
    System.out.println(solve_p1(lines));
    System.out.println(solve_p2(lines));
  }

  private static char[][] parse(String input) {
    File file = new File("day_10/" + input);
    ArrayList<char[]> list = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) {
        list.add(scanner.nextLine().toCharArray());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return toArray(list);
  }

  private static char[][] toArray(ArrayList<char[]> list) {
    char[][] lines = new char[list.size()][];

    for (int i = 0; i < lines.length; i++) {
      lines[i] = list.get(i);
    }

    return lines;
  }
}
