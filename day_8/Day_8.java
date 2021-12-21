package day_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static day_8.Part_1.solve_1;
import static day_8.Part_2.solve_2;

public class Day_8 {
  public static void main(String[] args) {
    ArrayList<Entry> entries = parse("input.txt");
    System.out.println(solve_1(entries));
    System.out.println(solve_2(entries));
  }

  private static ArrayList<Entry> parse(String string) {
    File file = new File("day_8/" + string);
    ArrayList<Entry> entries = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNext()) {
        String[] strings = scanner.nextLine().split("\\| ");
        Segment[][] signals = toSegmentSeq(strings[0].split(" "));
        Segment[][] digits = toSegmentSeq(strings[1].split(" "));
        entries.add(new Entry(signals, digits));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return entries;
  }

  private static Segment[][] toSegmentSeq(String[] input) {
    Segment[][] segmentSeq = new Segment[input.length][];

    for (int i = 0; i < input.length; i++) {
      Segment[] segments = new Segment[input[i].length()];

      for (int j = 0; j < input[i].length(); j++) {
        switch (input[i].charAt(j)) {
          case 'a':
            segments[j] = Segment.A;
            break;
          case 'b':
            segments[j] = Segment.B;
            break;
          case 'c':
            segments[j] = Segment.C;
            break;
          case 'd':
            segments[j] = Segment.D;
            break;
          case 'e':
            segments[j] = Segment.E;
            break;
          case 'f':
            segments[j] = Segment.F;
            break;
          case 'g':
            segments[j] = Segment.G;
            break;
          default:
            throw new RuntimeException("not a segment: " + input[i].charAt(j));
        }
      }

      segmentSeq[i] = segments;
    }

    return segmentSeq;
  }
}