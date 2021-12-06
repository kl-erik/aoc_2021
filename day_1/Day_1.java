package day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_1 {
  private static Scanner sc;

  public static void main(String[] args) {
    int[] input = getInput(new File("day_1/input.txt"));
    System.out.println(new Part_1().solve(input));
    System.out.println(new Part_2().solve(input));
  }

  private static int[] getInput(File file) {
    ArrayList<Integer> arrayList = new ArrayList<>();

    try {
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (sc.hasNextLine()) {
      arrayList.add(Integer.parseInt(sc.nextLine()));
    }

    int[] input = new int[arrayList.size()];

    for (int i = 0; i < input.length; i++) {
      input[i] = arrayList.get(i);
    }

    return input;
  }
}