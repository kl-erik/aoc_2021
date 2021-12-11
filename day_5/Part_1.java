package day_5;

import java.util.HashMap;

public class Part_1 {

  public int solve(Point[][] lineArray) {
    HashMap<Integer, HashMap<Integer, Integer>> xs = new HashMap<>();

    for (int i = 0; i < lineArray.length; i++) {
      for (int j = 0; j < lineArray[i].length; j++) {
        Point p = lineArray[i][j];
        HashMap<Integer, Integer> ys = xs.getOrDefault(p.getX(), new HashMap<>());
        ys.put(p.getY(), ys.getOrDefault(p.getY(), 0) + 1);
        xs.put(p.getX(), ys);
      }
    }

    int overlaps = 0;

    for (HashMap<Integer, Integer> yOccurrences : xs.values()) {
      for (int occurrences : yOccurrences.values()) {
        if (occurrences > 1) overlaps++;
      }
    }

    return overlaps;
  }
}
