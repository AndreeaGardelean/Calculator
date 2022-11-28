package uk.ac.rhul.cs2800;

/**
 * Class for executing the project. This class is a subclass of Application, which starts the JavaFx
 * runtime and constructs an instance of the class.
 *
 * @author zjac013
 */
public class MainView {

  /**
   * Main method of the class, launches the application.
   *
   * @param args command line arguments passed to the main method
   * @throws InvalidExpressionException e
   */
  public static void main(String[] args) throws InvalidExpressionException {
    GuiView view = new GuiView();
    CalcModel model = new CalcModel();
    System.out.println("hello, inside main");

    if (System.console() == null) {
      System.out.println("hello, got the gui view instance");
      view = GuiView.getInstance();
    }
    new CalcController(model, view);
    view.menu();
  }

}
