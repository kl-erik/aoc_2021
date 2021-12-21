package day_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.pow;

public class Part_2 {
  public static int solve_2(ArrayList<Entry> entries) {
    int sum = 0;

    for (Entry entry : entries) {
      HashMap<Segment, Set<Segment>> segmentsMap = segmentsMap();
      filter(segmentsMap, entry.getSignals());
      filter(segmentsMap, entry.getDigits());
      sum += getOutput(entry.getDigits(), segmentsMap);
      
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
        updateSegments(segmentsMap, new HashSet<>(Arrays.asList(segment)), intToDigit(1));
      } else if (segment.length == 4) {
        updateSegments(segmentsMap, new HashSet<>(Arrays.asList(segment)), intToDigit(4));
      } else if (segment.length == 3) {
        updateSegments(segmentsMap, new HashSet<>(Arrays.asList(segment)), intToDigit(7));
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

  private static int getOutput(Segment[][] outputDigits, HashMap<Segment, Set<Segment>> segmentsMap) {
    HashMap<Segment, Segment> combination = new HashMap<>();

    return getOutput(outputDigits, segmentsMap, combination, 0);
  }

  /*
  * Recursively finds a combination from all segments.
  * Once a combination is found, it "pauses" the recursion and tries to decode the output digits.
  * If it succeeds, the decoded value is returned.
  * Otherwise, it "jumps back" and recursively looks for a different combination.
  */
  private static int getOutput(Segment[][] outputDigits, HashMap<Segment, Set<Segment>> segmentsMap, HashMap<Segment, Segment> combination, int i) {
    if (i < Segment.values().length) {
      for (Segment segment : segmentsMap.get(Segment.values()[i])) {
        if (!combination.containsKey(segment)) {
          combination.put(segment, Segment.values()[i]);
          int output = getOutput(outputDigits, segmentsMap, combination, i + 1);

          if (output >= 0) {
            return output;
          } else {
            combination.remove(segment);
          }
        }
      }
    } else {
      int output = 0;

      for (int j = 0; j < outputDigits.length; j++) {
        Set<Segment> digit = new HashSet<>();

        for (Segment segments : outputDigits[j]) {
          digit.add(combination.get(segments));
        }

        boolean digitFound = false;

        for (int k = 0; k < 10; k++) {
          if (intToDigit(k).equals(digit)) {
            output += k * pow(10, outputDigits.length - (j + 1));
            digitFound = true;
            break;
          }
        }

        if (!digitFound) {
          return -1;
        }
      }

      return output;
    }

    return -1;
  }

  private static Set<Segment> intToDigit(int i) {
    if (i == 0) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.C, Segment.E, Segment.F, Segment.G));
    } else if (i == 1) {
      return new HashSet<>(Arrays.asList(Segment.C, Segment.F));
    } else if (i == 2) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.C, Segment.D, Segment.E, Segment.G));
    } else if (i == 3) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.C, Segment.D, Segment.F, Segment.G));
    } else if (i == 4) {
      return new HashSet<>(Arrays.asList(Segment.B, Segment.C, Segment.D, Segment.F));
    } else if (i == 5) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.D, Segment.F, Segment.G));
    } else if (i == 6) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.G));
    } else if (i == 7) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.C, Segment.F));
    } else if (i == 8) {
      return new HashSet<>(Arrays.asList(Segment.values()));
    } else if (i == 9) {
      return new HashSet<>(Arrays.asList(Segment.A, Segment.B, Segment.C, Segment.D, Segment.F, Segment.G));
    }

    throw new RuntimeException("must be in range 0 <= i <= 9");
  }
}
