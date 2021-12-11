package day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_5 {
  public static void main(String[] args) {
    // File file = new File("day_5/test.txt");
    File file = new File("day_5/input.txt");

    try (Scanner sc = new Scanner(file)) {
      ArrayList<ArrayList<Point>> lineList = getLines(sc);
      Point[][] lineArray = toLineArray(lineList);
      System.out.println(new Part_1().solve(lineArray));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static ArrayList<ArrayList<Point>> getLines(Scanner sc) {
    ArrayList<ArrayList<Point>> lineList = new ArrayList<>();
    
    while(sc.hasNext()) {
      ArrayList<Point> line = getLine(sc.nextLine());

      if (!line.isEmpty()) {
        lineList.add(line);
      }
    }

    return lineList;
  }

  private static ArrayList<Point> getLine(String s) {
    String[] p = s.split(" -> ");
    String[] p1 = p[0].split(",");
    String[] p2 = p[1].split(",");
    int x1 = Integer.parseInt(p1[0]);
    int y1 = Integer.parseInt(p1[1]);
    int x2 = Integer.parseInt(p2[0]);
    int y2 = Integer.parseInt(p2[1]);

    ArrayList<Point> line = new ArrayList<>();

    if (x1 == x2) {
      if (y1 <= y2) {
        getVertical(x1, y1, y2, line);
      } else {
        getVertical(x1, y2, y1, line);
      }
    } else if (y1 == y2) {
      if (x1 <= x2) {
        getHorizontal(y1, x1, x2, line);
      } else {
        getHorizontal(y1, x2, x1, line);
      }
    }

    return line;
  }

  private static void getVertical(int x, int y1, int y2, ArrayList<Point> line) {
    for (int y = y1; y <= y2; y++) {
      line.add(new Point(x, y));
    }
  }

  private static void getHorizontal(int y, int x1, int x2, ArrayList<Point> line) {
    for (int x = x1; x <= x2; x++) {
      line.add(new Point(x, y));
    }
  }

  private static Point[][] toLineArray(ArrayList<ArrayList<Point>> lineList) {
    Point[][] lineArray = new Point[lineList.size()][];

    for (int line = 0; line < lineArray.length; line++) {
      lineArray[line] = toArray(lineList.get(line));
    }

    return lineArray;
  }

  private static Point[] toArray(ArrayList<Point> line) {
    Point[] array = new Point[line.size()];

    for (int p = 0; p < array.length; p++) {
      array[p] = line.get(p);
    }

    return array;
  }
}
