package info.dmerej.ohce;

public class Reverse {

  public static String reverse(String input) {
    StringBuilder builder = new StringBuilder();
    for (int i = input.length() - 1; i >= 0; i--) {
      int charValue = input.charAt(i);
      char c = (char) charValue;
      builder.append(c);
    }
    return builder.toString();
  }
}
