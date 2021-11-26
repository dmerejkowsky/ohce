package info.dmerej.ohce;

import java.util.ArrayList;
import java.util.List;

public class FakeInteractor implements Interactor {
  private final ArrayList<String> recordedMessages;
  private final ArrayList<String> predefinedAnswers;

  public FakeInteractor() {
    recordedMessages = new ArrayList<>();
    predefinedAnswers = new ArrayList<>();
  }

  @Override
  public void printMessage(String message) {
    recordedMessages.add(message);
  }

  @Override
  public String readInput() {
    return this.predefinedAnswers.remove(0);
  }

  void add(String answer) {
    predefinedAnswers.add(answer);
  }

  public void reset() {
    recordedMessages.clear();
    predefinedAnswers.clear();
  }

  public List<String> getRecordedMessages() {
    return this.recordedMessages;
  }
}
