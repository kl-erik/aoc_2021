package day_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.pow;

public class Part_2 {
  final private static HashMap<Integer, Set<Segment>> digits = new HashMap<>() {{
    put(0, new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.C, Segment.E, Segment.F, Segment.G)));
    put(1, new HashSet<>(Arrays.asList(Segment.C, Segment.F)));
    put(2, new HashSet<>(Arrays.asList(Segment.A, Segment.C, Segment.D, Segment.E, Segment.G)));
    put(3, new HashSet<>(Arrays.asList(Segment.A, Segment.C, Segment.D, Segment.F, Segment.G)));
    put(4, new HashSet<>(Arrays.asList(Segment.B, Segment.C, Segment.D, Segment.F)));
    put(5, new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.D, Segment.F, Segment.G)));
    put(6, new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.G)));
    put(7, new HashSet<>(Arrays.asList(Segment.A, Segment.C, Segment.F)));
    put(8, new HashSet<>(Arrays.asList(Segment.values())));
    put(9, new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.C, Segment.D, Segment.F, Segment.G)));
  }};

  public static int solve_2(ArrayList<Entry> entries) {
    int sum = 0;

    for (Entry entry : entries) {
      HashMap<Segment, Set<Segment>> segmentsMap = segmentsMap();
      filter(segmentsMap, entry.getSignals());
      filter(segmentsMap, entry.getDigits());
      sum += getResult(entry.getDigits(), segmentsMap, new HashMap<>(), 0);
    }

    return sum;
  }

  private static HashMap<Segment, Set<Segment>> segmentsMap() {
    HashMap<Segment, Set<Segment>> segmentsMap = new HashMap<>();

    for (Segment segment: Segment.values()) {
      segmentsMap.put(segment, new HashSet<>(Arrays.asList(Segment.values())));
    }

    return segmentsMap;
  }

  private static void filter(HashMap<Segment, Set<Segment>> segmentsMap, Segment[][] segments) {
    for (Segment[] segment : segments) {
      if (segment.length == 2) {
        updateSegments(segmentsMap, new HashSet<>(Arrays.asList(segment)), digits.get(1));
      } else if (segment.length == 4) {
        updateSegments(segmentsMap, new HashSet<>(Arrays.asList(segment)), digits.get(4));
      } else if (segment.length == 3) {
        updateSegments(segmentsMap, new HashSet<>(Arrays.asList(segment)), digits.get(7));
      }
    }
  }

  private static void updateSegments(HashMap<Segment, Set<Segment>> segmentsMap, Set<Segment> segmentSeq,
      Set<Segment> digit) {
    for (Segment segment : Segment.values()) {
      Set<Segment> segments = segmentsMap.get(segment);

      if (digit.contains(segment)) {
        segments.retainAll(segmentSeq);
      } else {
        segments.removeAll(segmentSeq);
      }

      segmentsMap.put(segment, segments);
    }
  }

  private static int getResult(Segment[][] outputDigits, HashMap<Segment, Set<Segment>> segmentsMap, HashMap<Segment, Segment> combination, int i) {
    for (Segment segment : segmentsMap.get(Segment.values()[i])) {
      if (!combination.containsKey(segment)) {
        combination.put(segment, Segment.values()[i]);
        int result = i == Segment.values().length - 1 ? tryDecode(outputDigits, combination) : getResult(outputDigits, segmentsMap, combination, i + 1);

        if (result >= 0) {
          return result;
        } else {
          combination.remove(segment);
        }
      }
    }

    return -1;
  }

  private static int tryDecode(Segment[][] outputDigits, HashMap<Segment, Segment> combination) {
    int result = 0;

    for (int i = 0; i < outputDigits.length; i++) {
      Set<Segment> digit = new HashSet<>();

      for (Segment segments : outputDigits[i]) {
        digit.add(combination.get(segments));
      }

      boolean digitFound = false;

      for (java.util.Map.Entry<Integer, Set<Segment>> entry : digits.entrySet()) {
        if (entry.getValue().equals(digit)) {
          result += entry.getKey() * pow(10, outputDigits.length - 1 - i);
          digitFound = true;
          break;
        }
      }

      if (!digitFound) {
        return -1;
      }
    }

    return result;
  }
}
