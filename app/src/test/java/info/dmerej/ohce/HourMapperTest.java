package info.dmerej.ohce;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HourMapperTest {
  @Test
  void test15HoursIsAfternoon() {
    assertEquals(Time.AFTERNOON, HourMapper.map(15));
  }

  @Test
  void test21HoursIsNightTime() {
    assertEquals(Time.NIGHT, HourMapper.map(21));
  }

  @Test
  void test5HoursIsNightTime() {
    assertEquals(Time.NIGHT, HourMapper.map(5));
  }

  @Test
  void test6hoursIsMorning() {
    assertEquals(Time.MORNING, HourMapper.map(6));
  }

  @Test
  void rejectNegativeHours() {
    assertThrows(InvalidParameterException.class, () -> {
      HourMapper.map(-1);
    });
  }

  @Test
  void reject25tHour() {
    assertThrows(InvalidParameterException.class, () -> {
      HourMapper.map(25);
    });
  }
}
