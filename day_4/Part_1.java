package day_4;

import java.util.HashMap;

public class Part_1 {

  public int solve(int[] nums, int[][][] boards) {
    HashMap<Integer, HashMap<Integer, Position>> boardsMap = getBoardsMap(boards);
    boolean[][][] marked = new boolean[boards.length][boards[0].length][boards[0][0].length];

    for (int num : nums) {
      for (int board = 0; board < boardsMap.size(); board++) {
        if (boardsMap.get(board).containsKey(num)) {
          Position pos = boardsMap.get(board).get(num);
          marked[board][pos.row][pos.col] = true;

          if (checkCol(marked[board], pos.col) || checkRow(marked[board], pos.row)) {
            int sum = getSum(boards[board], marked[board]);

            return sum * num;
          } 
        }
      }
    }

    throw new RuntimeException("no board with bingo");
  }

  private HashMap<Integer, HashMap<Integer, Position>> getBoardsMap(int[][][] boards) {
    HashMap<Integer, HashMap<Integer, Position>> boardsMap = new HashMap<>();

    for (int board = 0; board < boards.length; board++) {
      HashMap<Integer, Position> numMap = new HashMap<>();

      for (int row = 0; row < boards[board].length; row++) {
        for (int col = 0; col < boards[board][row].length; col++) {
          numMap.put(boards[board][row][col], new Position(row, col));
        }
      }

      boardsMap.put(board, numMap);
    }

    return boardsMap;
  }

  private boolean checkCol(boolean[][] marked, int col) {
    for (int row = 0; row < marked.length; row++) {
      if (!marked[row][col]) {
        return false;
      }
    }

    return true;
  }

  private boolean checkRow(boolean[][] marked, int row) {
    for (int col = 0; col < marked[row].length; col++) {
      if (!marked[row][col]) {
        return false;
      }
    }

    return true;
  }

  private int getSum(int[][] board, boolean[][] marked) {
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

  class Position {
    int row;
    int col;

    public Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
