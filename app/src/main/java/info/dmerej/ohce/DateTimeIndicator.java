package info.dmerej.ohce;

import java.time.LocalDateTime;

public class DateTimeIndicator implements TimeIndicator {

  @Override
  public Time getCurrentTime() {
    LocalDateTime now = LocalDateTime.now();
    int hour = now.getHour() + 1;
    return HourMapper.map(hour + 1); // getHour() is in range 0..23
  }
}
