package uk.ac.rhul.cs2800;

import java.util.function.Consumer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller for the scene.
 *
 * @author zjac013
 */
public class GuiView extends Application implements ViewInterface {

  private String expression;
  private String answer;

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
  private Pane view;

  @FXML
  void getExpression(ActionEvent event) {
    expression = input.getText();
    setAnswer(expression);
  }

  // --------------------------------------------------------

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String str) {
    output.setText(answer);
  }

  @Override
  public void addCalcObserver(Runnable f) {
    calculate.setOnAction(event -> f.notify());
  }

  @Override
  public void addTypeObserver(Consumer<String> l) {
    input.setOnAction(event -> l.notify());
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    GridPane parent =
        (GridPane) FXMLLoader.load(GuiView.class.getClassLoader().getResource("GuiView.fxml"));
    Scene scene = new Scene(parent);
    // get the css configuration stylesheet for design
    scene.getStylesheets().add(getClass().getResource("GuiView.css").toExternalForm());
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
   * Starts a thread to launches the application, the graphical user interface will run on a thread
   * instead of the main thread. The thread initialisation is only done once ech run.
   *
   * @return returns the instance variable
   */
  public static synchronized GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
      while (instance == null) {
        // do nothing
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
}
