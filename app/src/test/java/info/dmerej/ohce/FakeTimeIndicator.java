package info.dmerej.ohce;

public class FakeTimeIndicator implements TimeIndicator {
  private Time time;

  @Override
  public Time getCurrentTime() {
    return time;
  }

  public void setCurrentTime(Time time) {
    this.time = time;
  }
}
