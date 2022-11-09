package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Controller for the scene.
 *
 * @author zjac013
 */
public class GuiView {

  private String expression;
  private String answer;
  
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
    answer = expression;
    output.setText(answer);
  }

}
