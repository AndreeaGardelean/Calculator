package uk.ac.rhul.cs2800;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * mm.
 *
 * @author zjac013
 */
public class AsciiView implements ViewInterface {

  private String expression;

  Runnable calc = null;
  Consumer<String> reset = null;

  /**
   * This is an Ascii menu, is an application menu which does not use user graphical interfacebut it
   * still communicates with the user. Based on what key the user presses the observer will be
   * notified.
   */
  public void menu() {
    Scanner scan = new Scanner(System.in);
    boolean done = false;
    help();

    while (!done && scan.hasNext()) {
      String action = scan.next();

      switch (action.toUpperCase().charAt(0)) {
        case 'C':
          if (calc != null) {
            calc.notify();
          }
          break;
        case 'R':
          if (reset != null) {
            reset.notify();
          }
          break;
        case '?':
          expression = action.substring(1);
          System.out.println("Current expression: " + expression);
          break;

        case 'Q':
          System.out.println("ByeBye!");
          done = true;
          break;
        default:
          help();
      }
    }
    scan.close();
  }

  private void help() {
    System.out.println("Choose one of the following:");
    System.out.println("? - set expression");
    System.out.println("C - calculate expression");
    System.out.println("R - reset calculator");
    System.out.println("Q - exit program");
  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String str) {
    System.out.println("The answer is being calculated");
  }

  @Override
  public void addCalcObserver(Runnable f) {
    calc = f;
  }

  @Override
  public void addTypeObserver(Consumer<String> l) {
    reset = l;
  }
}
