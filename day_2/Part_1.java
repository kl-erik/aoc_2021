package day_2;

public class Part_1 {
  public int solve(Command[] input) {
    int x = 0;
    int y = 0;

    for (Command command : input) {
      switch (command.getDir()) {
        case FORWARD:
          x += command.getUnits();
          break;
        case UP:
          y -= command.getUnits();
          break;
        case DOWN:
          y += command.getUnits();
        default:
          break;
      }
    }

    return x*y;
  }
}
