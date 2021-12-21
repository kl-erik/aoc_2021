package day_8;

public class Entry {
  final private Segment[][] signals;
  final private Segment[][] digits;

  public Entry(Segment[][] signals, Segment[][] digits) {
    this.signals = signals;
    this.digits = digits;
  }

  public Segment[][] getSignals() {
    return signals;
  }

  public Segment[][] getDigits() {
    return digits;
  }
}
