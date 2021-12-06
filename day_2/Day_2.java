package day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_2 {
  public static void main(String[] args) {
    Command[] input = getInput(new File("day_2/input.txt"));
    System.out.println(new Part_1().solve(input));
  }

  private static Command[] getInput(File file) {
    ArrayList<Command> arrayList = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String[] split = scanner.nextLine().split(" ");
        String dir = split[0];
        int units = Integer.parseInt(split[1]);

        switch (dir) {
          case "forward":
            arrayList.add(new Command(Direction.FORWARD, units));
            break;
          case "down":
            arrayList.add(new Command(Direction.DOWN, units));
            break;
          case "up":
            arrayList.add(new Command(Direction.UP, units));
          default:
            break;
        }
      }
    } catch (NumberFormatException | FileNotFoundException e) {
      e.printStackTrace();
    }

    Command[] input = new Command[arrayList.size()];

    for (int i = 0; i < input.length; i++) {
      input[i] = arrayList.get(i);
    }

    return input;
  }
}