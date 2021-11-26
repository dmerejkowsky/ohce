package info.dmerej.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OhceTest {
  private Ohce ohce;
  private FakeInteractor interactor;
  private FakeCurrentTimeIndicator currentTimeIndicator;

  @BeforeEach
  void setUp() {
    interactor = new FakeInteractor();
    currentTimeIndicator = new FakeCurrentTimeIndicator();
    ohce = new Ohce("Dimitri", interactor, currentTimeIndicator);
  }

  @Test
  void greetingWhenDuringNightTime() {
    assertGreetingWith("¡Buenas noches Dimitri!", CurrentTime.NIGHT);
  }

  @Test
  void greetingInTheMorning() {
    assertGreetingWith("¡Buenos dias Dimitri!", CurrentTime.MORNING);
  }

  @Test
  void greetingInTheAfternoon() {
    assertGreetingWith("¡Buenas tardes Dimitri!", CurrentTime.AFTERNOON);
  }

  @Test
  void echoInReverse() {
    interactor.add("Hello");

    ohce.processInput();

    assertLastMessageIs("olleH");
  }

  @Test
  void likesPalindromes() {
    interactor.add("oto");

    ohce.processInput();

    assertLastMessagesAre(new String[]{
        "oto",
        "¡Bonita palabra!"
      }
    );
  }

  @Test
  void sayAdiosWhenAskedToStop() {
    interactor.add("Stop!");

    ohce.processInput();

    assertLastMessageIs("Adios Dimitri");
  }

  @Test
  void shouldNotContinueWhenAskedToStop() {
    interactor.add("Stop!");

    ohce.processInput();

    assertFalse(ohce.shouldContinue());
  }

  private void assertGreetingWith(String expected, CurrentTime when) {
    currentTimeIndicator.setCurrentTime(when);

    ohce.greet();

    assertLastMessageIs(expected);
  }

  private void assertLastMessageIs(String expected) {
    List<String> recordedMessages = interactor.getRecordedMessages();
    String lastMessage = recordedMessages.get(recordedMessages.size() - 1);
    assertEquals(expected, lastMessage);
  }

  private void assertLastMessagesAre(String[] expected) {
    List<String> recordedMessages = interactor.getRecordedMessages();
    assertEquals(Arrays.stream(expected).toList(), recordedMessages);
  }
}

