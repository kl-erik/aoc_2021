package day_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Part_2 {
  public static long solve_p2(char[][] lines) {
    ArrayList<Long> scoreList = new ArrayList<>();

    for (char[] chunks : lines) {
      Stack<Character> stack = new Stack<>();
      boolean corrupted = false;

      for (char chunk : chunks) {
        if (chunk == ')') {
          if (stack.pop() != '(') {
            corrupted = true;
            break;
          }
        } else if (chunk == ']') {
          if (stack.pop() != '[') {
            corrupted = true;
            break;
          }
        } else if (chunk == '}') {
          if (stack.pop() != '{') {
            corrupted = true;
            break;
          }
        } else if (chunk == '>') {
          if (stack.pop() != '<') {
            corrupted = true;
            break;
          }
        } else {
          stack.push(chunk);
        }
      }

      if (!corrupted) {
        long score = 0;

        while (!stack.empty()) {
          char chunk = stack.pop();

          if (chunk == '(') {
            score = score * 5 + 1;
          } else if (chunk == '[') {
            score = score * 5 + 2;
          } else if (chunk == '{') {
            score = score * 5 + 3;
          } else if (chunk == '<') {
            score = score * 5 + 4;
          }
        }

        scoreList.add(score);
      }
    }

    long[] scores = toArray(scoreList);
    Arrays.sort(scores);

    return scores[scores.length / 2];
  }

  private static long[] toArray(ArrayList<Long> scoreList) {
    long[] scores = new long[scoreList.size()];

    for (int i = 0; i < scores.length; i++) {
      scores[i] = scoreList.get(i);
    }

    return scores;
  }
}
