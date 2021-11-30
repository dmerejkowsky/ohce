package info.dmerej.ohce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseTest {
  @Test
  void reverseHello() {
    String actual = Reverse.reverse("Hello");
    assertEquals("olleH", actual);
  }
}
