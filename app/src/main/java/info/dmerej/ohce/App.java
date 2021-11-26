package info.dmerej.ohce;

public class App {
  public static void main(String[] args) {
    int argv = args.length;
    if (argv != 1) {
      System.err.println("Expecting exactly one argument");
      System.exit(1);
    }
  }
}