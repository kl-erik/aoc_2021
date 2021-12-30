package day_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_10 {
  public static void main(String[] args) {
    char[][] chunks = parse("test.txt");
  }

  private static char[][] parse(String input) {
    File file = new File("day_10/" + input);
    ArrayList<char[]> chunks = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) {
        chunks.add(scanner.nextLine().toCharArray());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return toArray(chunks);
  }

  private static char[][] toArray(ArrayList<char[]> chunksList) {
    char[][] chunks = new char[chunksList.size()][];

    for (int i = 0; i < chunks.length; i++) {
      chunks[i] = chunksList.get(i);
    }

    return chunks;
  }
}
