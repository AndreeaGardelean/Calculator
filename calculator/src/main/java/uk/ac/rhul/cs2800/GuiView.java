package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller for the scene.
 *
 * @author zjac013
 */
public class GuiView extends Application implements ViewInterface {

  private static String expression;
  static boolean isInfix = false;

  @FXML
  private Button calculate;

  @FXML
  private RadioButton infix;

  @FXML
  private TextField input;

  @FXML
  private TextField output;

  @FXML
  private RadioButton reverse;

  @FXML
  private Label errorMsg;

  @FXML
  private ToggleGroup type;

  @FXML
  private Pane view;

  // --------------------------------------------------------
  @Override
  public String getExpression() {
    expression = input.getText();
    return expression;
  }

  @Override
  public void setAnswer(String str) {
    output.setText(str);
  }

  @Override
  public void addCalcObserver(Observer f) {
    calculate.setOnAction(event -> f.notifyObservers());
  }

  @Override
  public void addTypeObserver(Observer l) {
    infix.setOnAction(event -> l.notifyObservers());
    reverse.setOnAction(event -> l.notifyObservers());
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(MainView.class.getClassLoader().getResource("GuiView.fxml"));
    Scene scene = new Scene(root, 600, 400);

    // get the CSS configuration style sheet for design
    scene.getStylesheets()
        .add(getClass().getClassLoader().getResource("GuiView.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  // --------------------------------------------------------
  /*
   * The code between these delimiters has been written by Prof. David Cohen.
   */

  private static volatile GuiView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Starts a thread to launch the application, the graphical user interface will run on a thread
   * instead of the main thread. The thread initialisation is only done once each run.
   *
   * @return returns the instance variable
   */
  public static synchronized GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
      while (instance == null) {
      }
    }
    return instance;
  }

  // --------------------------------------------------------
  @Override
  public void menu() {
    calculate.setDisable(false);
    infix.setDisable(false);
    reverse.setDisable(false);
  }

  /**
   * Return the type of the expression.
   *
   * @return return boolean value if the expression is infix or not
   */
  public boolean getExpressionType() {
    return isInfix = infix.isSelected();
  }

  /**
   * Set an error message in the Label box.
   */
  public void setErrorMessage(String error) {
    errorMsg.setText(error);
  }
}
