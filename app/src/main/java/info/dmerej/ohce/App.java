package info.dmerej.ohce;

public class App {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Expecting exactly one argument");
      System.exit(1);
    }

    String user = args[0];
    Interactor interactor = new ConsoleInteractor();
    TimeIndicator timeIndicator = new DateTimeIndicator();
    Ohce ohce = new Ohce(user, interactor, timeIndicator);

    ohce.greet();
    while (ohce.shouldContinue()) {
      ohce.processInput();
    }
  }
}
