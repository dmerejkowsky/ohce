package info.dmerej.ohce;

public class Ohce {
  private String user;
  private TimeIndicator currentTimeIndicator;
  private Interactor interactor;
  private boolean shouldContinue;

  public Ohce(String user, Interactor interactor, TimeIndicator currentTimeIndicator) {
    this.shouldContinue = true;
    this.user = user;
    this.interactor = interactor;
    this.currentTimeIndicator = currentTimeIndicator;
  }

  public void greet() {

    Time time = currentTimeIndicator.getCurrentTime();
    String greeting = switch (time) {
      case MORNING -> "Buenos dias";
      case AFTERNOON -> "Buenas tardes";
      case NIGHT -> "Buenas noches";
    };
    interactor.printMessage("¡" + greeting + " " + user + "!");
  }

  public void processInput() {
    String input = interactor.readInput();
    if (input.equals("Stop!")) {
      interactor.printMessage("Adios " + user);
      this.shouldContinue = false;
      return;
    }

    String answer = Reverse.reverse(input);
    interactor.printMessage(answer);
    if (answer.equals(input)) {
      interactor.printMessage("¡Bonita palabra!");
    }
  }

  public boolean shouldContinue() {
    return this.shouldContinue;
  }
}
