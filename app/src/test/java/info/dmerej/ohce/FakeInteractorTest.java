package info.dmerej.ohce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FakeInteractorTest {
  private FakeInteractor interactor;

  @BeforeEach
  void setup() {
    interactor = new FakeInteractor();
  }

  @AfterEach
  void tearDown() {
    interactor.reset();
  }

  @Test
  void canStorePredefinedAnswers() {
    interactor.add("Yes");
    interactor.add("No");

    String answer1 = interactor.readInput();
    assertEquals("Yes", answer1);

    String answer2 = interactor.readInput();
    assertEquals("No", answer2);
  }

  @Test
  void storesPrintedMessages() {
    interactor.printMessage("hello");
    interactor.printMessage("good bye");

    List<String> storedMessages = interactor.getRecordedMessages();
    assertEquals(Arrays.asList("hello", "good bye"), storedMessages);
  }
}
