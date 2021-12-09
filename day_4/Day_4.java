package day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_4 {

  public static void main(String[] args) {
    File file = new File("day_4/input.txt");

    try (Scanner sc = new Scanner(file)) {
      int[] nums = numListToArray(getNums(sc.nextLine()));
      sc.nextLine();
      int[][][] boards = boardsListToArray(getBoards(sc));
      System.out.println(new Part_1().solve(nums, boards));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static ArrayList<ArrayList<ArrayList<Integer>>> getBoards(Scanner sc) {
    ArrayList<ArrayList<ArrayList<Integer>>> boards = new ArrayList<>();

    while (sc.hasNext()) {
      boards.add(getBoard(sc));
    }

    return boards;
  }

  private static ArrayList<ArrayList<Integer>> getBoard(Scanner sc) {
    ArrayList<ArrayList<Integer>> board = new ArrayList<>();

    while (sc.hasNext()) {
      String line = sc.nextLine();

      if (line.isEmpty()) {
        break;
      }

      board.add(getNums(line));
    }

    return board;
  }

  private static ArrayList<Integer> getNums(String line) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < line.length(); i++) {
      if (Character.isDigit(line.charAt(i))) {
        for (int j = i + 1; j <= line.length(); j++) {
          if (j == line.length() || !Character.isDigit(line.charAt(j))) {
            list.add(Integer.parseInt(line.substring(i, j)));

            i = j;
            break;
          }
        }
      }
    }

    return list;
  }

  private static int[][][] boardsListToArray(ArrayList<ArrayList<ArrayList<Integer>>> boardsList) {
    int[][][] boardsArray = new int[boardsList.size()][][];

    for (int i = 0; i < boardsArray.length; i++) {
      boardsArray[i] = boardListToArray(boardsList.get(i));
    }

    return boardsArray;
  }

  private static int[][] boardListToArray(ArrayList<ArrayList<Integer>> boardList) {
    int[][] boardArray = new int[boardList.size()][];

    for (int i = 0; i < boardArray.length; i++) {
      boardArray[i] = numListToArray(boardList.get(i));
    }

    return boardArray;
  }

  private static int[] numListToArray(ArrayList<Integer> numList) {
    int[] numArray = new int[numList.size()];

    for (int i = 0; i < numArray.length; i++) {
      numArray[i] = numList.get(i);
    }

    return numArray;
  }
}
