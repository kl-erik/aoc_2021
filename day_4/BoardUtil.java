package day_4;

import java.util.HashMap;

public class BoardUtil {

  private BoardUtil() {
  }
  
  public static HashMap<Integer, HashMap<Integer, Position>> getBoardsMap(int[][][] boards) {
    HashMap<Integer, HashMap<Integer, Position>> boardsMap = new HashMap<>();

    for (int board = 0; board < boards.length; board++) {
      HashMap<Integer, Position> numMap = getNumMap(boards[board]);
      boardsMap.put(board, numMap);
    }

    return boardsMap;
  }

  private static HashMap<Integer, Position> getNumMap(int[][] board) {
    HashMap<Integer, Position> numMap = new HashMap<>();

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        numMap.put(board[row][col], new Position(row, col));
      }
    }

    return numMap;
  }

  public static boolean checkCol(boolean[][] marked, int col) {
    for (int row = 0; row < marked.length; row++) {
      if (!marked[row][col]) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkRow(boolean[][] marked, int row) {
    for (int col = 0; col < marked[row].length; col++) {
      if (!marked[row][col]) {
        return false;
      }
    }

    return true;
  }

  public static int getSum(int[][] board, boolean[][] marked) {
    int sum = 0;

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (!marked[row][col]) {
          sum += board[row][col];
        }
      }
    }
    return sum;
  }
}
