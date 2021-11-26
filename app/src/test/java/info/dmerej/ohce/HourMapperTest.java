package info.dmerej.ohce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourMapperTest {
  @Test
  void test15HoursIsAfternoon() {
    assertEquals(CurrentTime.AFTERNOON, HourMapper.map(15));
  }

  @Test
  void test21HoursIsNightTime() {
    assertEquals(CurrentTime.NIGHT, HourMapper.map(21));
  }

  @Test
  void test5HoursIsNightTime() {
    assertEquals(CurrentTime.NIGHT, HourMapper.map(21));
  }

  @Test
  void test6hoursIsMorning() {
    assertEquals(CurrentTime.MORNING, HourMapper.map(6));
  }
}
