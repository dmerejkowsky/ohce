package info.dmerej.ohce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInteractor implements Interactor {
  @Override
  public void printMessage(String message) {
    System.out.println(message);
  }

  @Override
  public String readInput() {
    /* Note: the following does not work when
       using ./gradlew run (Console is null)
       I *think* we can make it work when run from the IDE
    ```
    Console console = System.console();
    return console.readLine();
    ```
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException("Could no tread from stdin");
    }
  }

}
