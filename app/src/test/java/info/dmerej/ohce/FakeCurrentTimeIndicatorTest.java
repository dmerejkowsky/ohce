package info.dmerej.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeCurrentTimeIndicatorTest {
    private FakeCurrentTimeIndicator currentTimeIndicator;
    
    @BeforeEach
    void setUp() {
        currentTimeIndicator = new FakeCurrentTimeIndicator();
    }

    @Test
    void canReturnPredefinedTime() {
        currentTimeIndicator.setCurrentTime(CurrentTime.MORNING);
        assertEquals(CurrentTime.MORNING, currentTimeIndicator.getCurrentTime());
    }
}
