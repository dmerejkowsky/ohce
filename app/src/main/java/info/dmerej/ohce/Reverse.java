package info.dmerej.ohce;

public class Reverse {
  public static String reverse(String input) {
    StringBuilder builder = new StringBuilder(input);
    builder.reverse();
    return builder.toString();
  }
}
