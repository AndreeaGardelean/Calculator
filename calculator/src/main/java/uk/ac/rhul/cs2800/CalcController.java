package uk.ac.rhul.cs2800;

/**
 * Adds itself to an observer to the view so that changes can be observed.
 *
 * @author zjac013
 */

public class CalcController {
  private CalcModel model;
  private GuiView view;
  private boolean isInfix;

  /**
   * Is notified when a change in the expression type is indicated and updates the state of the
   * calculator.
   */
  public void expressionType() {
    isInfix = view.getExpressionType();
    model.setType(isInfix);
  }

  /**
   * When the 'Calculate' button is pressed, a notification is sent to the controller to execute
   * this method. The method evaluates the input expression and sends an error message to the
   * interface if an error occurs or sends the result of the evaluated expression to the view.
   */
  public void calculate() {
    expressionType();
    String expression = view.getExpression();
    float result = 0;
    try {
      view.setErrorMessage("");
      result = model.evaluate(expression);
    } catch (InvalidExpressionException e) {
      String msg = "Invalid mathematical expression." + System.lineSeparator()
          + "Please refer back to the informations section.";
      view.setErrorMessage(msg);
    }
    view.setAnswer(String.valueOf(result));
  }

  /**
   * Constructor adds itself as an observer and calls the appropriate methods when a change occurs
   * in the view.
   *
   * @param model model object to be used in the observer
   * @param view2 graphical user interface objects on which the changes will be observed
   * @throws InvalidExpressionException method is thrown by the model
   */
  CalcController(CalcModel model, GuiView view2) throws InvalidExpressionException {
    this.model = model;
    this.view = view2;

    view.addCalcObserver(this::calculate);
    view.addTypeObserver(this::expressionType);
  }
}
