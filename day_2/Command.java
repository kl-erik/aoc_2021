package day_2;

class Command {
  private Direction dir;
  private int units;

  public Command(Direction dir, int units) {
    this.dir = dir;
    this.units = units;
  }

  public Direction getDir() {
    return dir;
  }

  public int getUnits() {
    return units;
  }
}