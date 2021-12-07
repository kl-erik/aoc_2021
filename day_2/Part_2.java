package day_2;

public class Part_2 {
  public int solve(Command[] input) {
    int x = 0;
    int y = 0;
    int aim = 0;

    for (Command command : input) {
      switch (command.getDir()) {
        case FORWARD:
          x += command.getUnits();
          y += command.getUnits() * aim;
          break;
        case UP:
          aim -= command.getUnits();
          break;
        case DOWN:
          aim += command.getUnits();
        default:
          break;
      }
    }

    return x*y;
  }
}
