package day_3;

import java.util.ArrayList;

import static day_3.BinUtil.*;

public class Part_2 {

  public int solve(int[][] input) {
    int oxygen = getVal(filter(input, true));
    int co2 = getVal(filter(input, false));

    return oxygen * co2;
  }

  private int[] filter(int[][] input, boolean common) {
    ArrayList<Integer> indexes = new ArrayList<>();

    for (int i = 0; i < input.length; i++) {
      indexes.add(i);
    }

    for (int b = 0; b < input[0].length && indexes.size() != 1; b++) {
      ArrayList<Integer> oneIndexes = new ArrayList<>();
      ArrayList<Integer> zeroIndexes = new ArrayList<>();

      for (int i : indexes) {
        if (input[i][b] == 1) {
          oneIndexes.add(i);
        } else {
          zeroIndexes.add(i);
        }
      }

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

    return input[indexes.get(0)];
  }
}