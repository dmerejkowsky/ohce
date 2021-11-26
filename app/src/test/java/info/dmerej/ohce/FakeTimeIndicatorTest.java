package info.dmerej.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeTimeIndicatorTest {
  private FakeTimeIndicator currentTimeIndicator;

  @BeforeEach
  void setUp() {
    currentTimeIndicator = new FakeTimeIndicator();
  }

  @Test
  void canReturnPredefinedTime() {
    currentTimeIndicator.setCurrentTime(Time.MORNING);
    assertEquals(Time.MORNING, currentTimeIndicator.getCurrentTime());
  }
}
