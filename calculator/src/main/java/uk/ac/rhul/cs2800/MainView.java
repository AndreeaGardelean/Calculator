package uk.ac.rhul.cs2800;

/**
 * Class containing the main method for executing the project. This class starts the JavaFx runtime
 * and constructs an instance of the graphical user interface class.
 *
 * @author zjac013
 */
public class MainView {

  /**
   * Main method of the class, launches the application.
   *
   * @param args command line arguments passed to the main method
   * @throws InvalidExpressionException exception thrown by the CalcModel
   */
  public static void main(String[] args) throws InvalidExpressionException {
    ViewInterface view = new AsciiView();
    CalcModel model = new CalcModel();

    if (System.console() == null) {
      view = GuiView.getInstance();
    }
    CalcController.getInstance(model, view);
    view.menu();
  }
}
