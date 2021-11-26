package info.dmerej.ohce;

import java.security.InvalidParameterException;

public class HourMapper {
  public static Time map(int hours) {
    if (hours < 0) {
      throw new InvalidParameterException("hour cannot be negative");
    }
    if (hours > 24) {
      throw new InvalidParameterException("hour cannot be greater than 24");
    }

    if (hours >= 6 && hours <= 12) {
      return Time.MORNING;
    }

    if (hours > 12 && hours < 20) {
      return Time.AFTERNOON;
    }

    return Time.NIGHT;
  }
}
