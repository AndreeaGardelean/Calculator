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
   * Is notified when a change in the expression type is indicated.
   */
  public void expressionType() {
    isInfix = GuiView.getExpressionType();
  }

  /**
   * Send a notification when a calculation is required.
   */
  public void calculate() {
    expressionType();
    String expression = view.getExpression();
    float result = 0;
    try {
      result = model.evaluate(expression, isInfix);
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    }
    view.setAnswer(String.valueOf(result));
  }


  CalcController(CalcModel model, GuiView view) throws InvalidExpressionException {
    this.model = model;
    this.view = view;

    view.addCalcObserver(this::calculate);
    view.addTypeObserver(this::expressionType);
  }

}
