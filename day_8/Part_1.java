package day_8;

import java.util.ArrayList;

public class Part_1 {
  public static int solve_1(ArrayList<Entry> entries) {
    int sDigits = 0;

    for (Entry entry : entries) {
      Segment[][] digits = entry.getDigits();

      for (Segment[] digit : digits) {
        int n = digit.length;

        if ((n >= 2 && n <= 4) || n == 7) {
          sDigits++;
        }
      }
    }

    return sDigits;
  }
  
}
