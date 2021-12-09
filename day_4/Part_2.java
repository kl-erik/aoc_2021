package day_4;

import java.util.ArrayList;
import java.util.HashMap;

import static day_4.BoardUtil.*;

public class Part_2 {

  public int solve(int[] nums, int[][][] boards) {
    HashMap<Integer, HashMap<Integer, Position>> boardsMap = getBoardsMap(boards);
    boolean[][][] marked = new boolean[boards.length][boards[0].length][boards[0][0].length];

    for (int num : nums) {
      ArrayList<Integer> done = new ArrayList<>();

      for (int board : boardsMap.keySet()) {
        if (boardsMap.get(board).containsKey(num)) {
          Position pos = boardsMap.get(board).get(num);
          marked[board][pos.getRow()][pos.getCol()] = true;

          if (checkCol(marked[board], pos.getCol()) || checkRow(marked[board], pos.getRow())) {
            if (boardsMap.size() - done.size() == 1) {
              int sum = getSum(boards[board], marked[board]);

              return sum * num;
            } else {
              done.add(board);
            }
          } 
        }
      }

      boardsMap.keySet().removeAll(done);
    }

    throw new RuntimeException("no board with bingo");
  }
}