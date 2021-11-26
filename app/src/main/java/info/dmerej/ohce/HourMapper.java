package info.dmerej.ohce;

public class HourMapper {
  public static CurrentTime map(int hours) {
    if (hours >= 6 && hours <= 12) {
      return CurrentTime.MORNING;
    }
    if (hours >= 20 || hours <= 6) {
      return CurrentTime.NIGHT;
    }
    if (hours > 12 && hours < 20) {
      return CurrentTime.AFTERNOON;
    }

    throw new RuntimeException("Unreachable code");
  }
}
