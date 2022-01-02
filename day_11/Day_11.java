package day_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static day_11.Part_1.solve_p1;
import static day_11.Part_2.solve_p2;

public class Day_11 {
  public static void main(String[] args) {
    int[][] octopuses = parse("input.txt");
    System.out.println(solve_p1(clone(octopuses)));
    System.out.println(solve_p2(octopuses));
  }

  private static int[][] parse(String input) {
    File file = new File("day_11/" + input);
    ArrayList<ArrayList<Integer>> octopuses = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) {
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : scanner.nextLine().toCharArray()) {
          list.add(Integer.parseInt(String.valueOf(c)));
        }

        octopuses.add(list);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return toArray_1(octopuses);
  }

  private static int[][] toArray_1(ArrayList<ArrayList<Integer>> arrayList) {
    int[][] octopuses = new int[arrayList.size()][];

    for (int i = 0; i < octopuses.length; i++) {
      octopuses[i] = toArray_2(arrayList.get(i));
    }

    return octopuses;
  }

  private static int[] toArray_2(ArrayList<Integer> arrayList) {
    int[] octopuses = new int[arrayList.size()];

    for (int i = 0; i < octopuses.length; i++) {
      octopuses[i] = arrayList.get(i);
    }

    return octopuses;
  }

  private static int[][] clone(int[][] original) {
    int[][] clone = new int[original.length][];

    for (int i = 0; i < clone.length; i++) {
      clone[i] = original[i].clone();
    }

    return clone;
  }
}
