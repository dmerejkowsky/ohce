package info.dmerej.ohce;

public class HourMapper {
  public static Time map(int hours) {
    if (hours >= 6 && hours <= 12) {
      return Time.MORNING;
    }
    if (hours >= 20 || hours <= 6) {
      return Time.NIGHT;
    }
    if (hours > 12 && hours < 20) {
      return Time.AFTERNOON;
    }

    throw new RuntimeException("Unreachable code");
  }
}
