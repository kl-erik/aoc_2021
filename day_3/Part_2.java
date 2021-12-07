package day_3;

import java.util.ArrayList;
import java.util.HashMap;

public class Part_2 {

  public int solve(int[][] input) {
    int oxygen = getVal(input, true);
    int co2 = getVal(input, false);

    return oxygen * co2;
  }

  private int getVal(int[][] input, boolean common) {
    ArrayList<Integer> indexes = new ArrayList<>();

    for (int i = 0; i < input.length; i++) {
      indexes.add(i);
    }

    for (int b = 0; b < input[0].length; b++) {
      if (indexes.size() == 1) {
        break;
      }

      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

      for (int i : indexes) {
        if (input[i][b] == 1) {
          ArrayList<Integer> oneIndexes = map.getOrDefault(1, new ArrayList<>());
          oneIndexes.add(i);
          map.put(1, oneIndexes);
        } else {
          ArrayList<Integer> zeroIndexes = map.getOrDefault(0, new ArrayList<>());
          zeroIndexes.add(i);
          map.put(0, zeroIndexes);
        }
      }

      ArrayList<Integer> oneIndexes = map.getOrDefault(1, new ArrayList<>());
      ArrayList<Integer> zeroIndexes = map.getOrDefault(0, new ArrayList<>());

      if (common) {
        if (oneIndexes.size() >= zeroIndexes.size()) {
          indexes.removeAll(zeroIndexes);
        } else {
          indexes.removeAll(oneIndexes);
        }
      } else {
        if (oneIndexes.size() < zeroIndexes.size()) {
          indexes.removeAll(zeroIndexes);
        } else {
          indexes.removeAll(oneIndexes);
        }
      }
    }

    int[] bin = input[indexes.get(0)];
    int val = 0;
    int j = 0;

    for (int i = bin.length - 1; i >= 0; i--) {
      if (bin[i] == 1) {
        val += Math.pow(2, j);
      }

      j++;
    }

    return val;
  }
}

