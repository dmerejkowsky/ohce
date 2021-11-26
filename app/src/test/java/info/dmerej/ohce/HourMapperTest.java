package info.dmerej.ohce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    assertEquals(Time.NIGHT, HourMapper.map(21));
  }

  @Test
  void test6hoursIsMorning() {
    assertEquals(Time.MORNING, HourMapper.map(6));
  }
}
