package info.dmerej.ohce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseTest {
  @Test
  void reverseHello() {
    String actual = Reverse.reverse("Hello");
    assertEquals("olleH", actual);
  }
}
