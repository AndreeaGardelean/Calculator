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
 * Graphical user interface View which allows users to interact with the system.
 *
 * @author zjac013
 */
public class GuiView extends Application implements ViewInterface {

  private static String expression;
  public static boolean isInfix = false;

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
  public void setAnswer(String ans) {
    output.setText(ans);
  }

  @Override
  public void addCalcObserver(Observer c) {
    calculate.setOnAction(event -> c.notifyObservers());
  }

  @Override
  public void addTypeObserver(Observer t) {
    infix.setOnAction(event -> t.notifyObservers());
    reverse.setOnAction(event -> t.notifyObservers());
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

  /**
   * The user interface will be started only after the controller is ready to run. If the controller
   * is not ready all buttons are disabled.
   */
  @Override
  public void menu() {
    calculate.setDisable(false);
    infix.setDisable(false);
    reverse.setDisable(false);
  }

  /**
   * Return the type of the expression by getting the boolean value which describes if the infix
   * button has been pressed.
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

  // --------------------------------------------------------
  /*
   * The code between these delimiters has been inspired after the code written by Prof. Dave Cohen.
   * The code can be found at:
   * https://moodle.royalholloway.ac.uk/course/view.php?id=1470&sectionid=141860 file MVCJavaFX
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
}