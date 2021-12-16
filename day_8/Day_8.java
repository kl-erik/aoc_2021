package day_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_8 {
  public static void main(String[] args) {
    ArrayList<Entry> entries = parse("input.txt");
    System.out.println(solve_p1(entries));
  }

  private static ArrayList<Entry> parse(String string) {
    File file = new File("day_8/" + string);
    ArrayList<Entry> entries = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) {
        String[] strings = scanner.nextLine().split("\\| ");
        String[] signals = strings[0].split(" ");
        String[] digits = strings[1].split(" ");
        entries.add(new Entry(signals, digits));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return entries;
  }

  private static int solve_p1(ArrayList<Entry> entries) {
    int sDigits = 0;

    for (Entry entry : entries) {
      String[] digits = entry.getDigits();

      for (String digit : digits) {
        int n = digit.length();

        if ((n >= 2 && n <= 4) || n == 7) {
          sDigits++;
        }
      }
    }

    return sDigits;
  }

  static class Entry {
    String[] signals;
    String[] digits;

    public Entry(String[] signals, String[] digits) {
      this.signals = signals;
      this.digits = digits;
    }

    public String[] getSignals() {
      return signals;
    }

    public String[] getDigits() {
      return digits;
    }
  }
}
