package info.dmerej.ohce;

import java.time.LocalDateTime;

public class DateTimeIndicator implements CurrentTimeIndicator {

  @Override
  public CurrentTime getCurrentTime() {
    LocalDateTime now = LocalDateTime.now();
    int hour = now.getHour() + 1; // getHour is between 0 and 23 :(
    return HourMapper.map(hour);
  }
}
