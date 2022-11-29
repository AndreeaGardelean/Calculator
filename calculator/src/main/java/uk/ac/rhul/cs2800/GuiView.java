package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
  private Label title;

  @FXML
  private ToggleGroup type;

  @FXML
  private Pane view;

  @FXML
  void expressionType(ActionEvent event) {
    isInfix = infix.isSelected();
    System.out.println("infix notation selected:" + infix.isSelected());
  }

  @FXML
  void getExpression(ActionEvent event) {
    expression = input.getText();
    System.out.println("Got the expression from the button");
  }
  
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
    System.out.println("Calc observer");
    calculate.setOnAction(event -> f.notifyObservers());
  }

  @Override
  public void addTypeObserver(Observer l) {
    System.out.println("type observer");
    infix.setOnAction(event -> l.notifyObservers());
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(MainView.class.getClassLoader().getResource("GuiView.fxml"));
    Scene scene = new Scene(root, 600, 400);

    // get the CSS configuration style sheet for design
    // scene.getStylesheets().add(getClass().getResource("GuiView.css").toExternalForm());
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

  /**
   * The user interface will be started only after the controller is ready to run.
   */
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
  public static boolean getExpressionType() {
    return isInfix;
  }
}
