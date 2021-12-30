package day_10;

import java.util.Stack;

public class Part_1 {
  public static int solve_p1(char[][] lines) {
    int points = 0;

    for (char[] chunks : lines) {
      Stack<Character> stack = new Stack<>();

      for (char chunk : chunks) {
        if (chunk == ')') {
          if (stack.pop() != '(') {
            points += 3;
            break;
          }
        } else if (chunk == ']') {
          if (stack.pop() != '[') {
            points += 57;
            break;
          }
        } else if (chunk == '}') {
          if (stack.pop() != '{') {
            points += 1197;
            break;
          }
        } else if (chunk == '>') {
          if (stack.pop() != '<') {
            points += 25137;
            break;
          }
        } else {
          stack.push(chunk);
        }
      }
    }

    return points;
  }
}
