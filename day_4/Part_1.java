package day_4;

import java.util.HashMap;

import static day_4.BoardUtil.*;

public class Part_1 {

  public int solve(int[] nums, int[][][] boards) {
    HashMap<Integer, HashMap<Integer, Position>> boardsMap = getBoardsMap(boards);
    boolean[][][] marked = new boolean[boards.length][boards[0].length][boards[0][0].length];

    for (int num : nums) {
      for (int board = 0; board < boardsMap.size(); board++) {
        if (boardsMap.get(board).containsKey(num)) {
          Position pos = boardsMap.get(board).get(num);
          marked[board][pos.getRow()][pos.getCol()] = true;

          if (checkCol(marked[board], pos.getCol()) || checkRow(marked[board], pos.getRow())) {
            int sum = getSum(boards[board], marked[board]);

            return sum * num;
          } 
        }
      }
    }

    throw new RuntimeException("no board with bingo");
  }
}
