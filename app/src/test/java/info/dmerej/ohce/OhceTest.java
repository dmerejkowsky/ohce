package info.dmerej.ohce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OhceTest {
  private Ohce ohce;
  private FakeInteractor interactor;
  private FakeTimeIndicator currentTimeIndicator;

  @BeforeEach
  void setUp() {
    interactor = new FakeInteractor();
    currentTimeIndicator = new FakeTimeIndicator();
    ohce = new Ohce("Dimitri", interactor, currentTimeIndicator);
  }

  @Test
  void greetingWhenDuringNightTime() {
    assertGreetingWith("¡Buenas noches Dimitri!", Time.NIGHT);
  }

  @Test
  void greetingInTheMorning() {
    assertGreetingWith("¡Buenos dias Dimitri!", Time.MORNING);
  }

  @Test
  void greetingInTheAfternoon() {
    assertGreetingWith("¡Buenas tardes Dimitri!", Time.AFTERNOON);
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

    assertLastMessagesAre(new String[] {"oto", "¡Bonita palabra!"});
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

  private void assertGreetingWith(String expected, Time when) {
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
