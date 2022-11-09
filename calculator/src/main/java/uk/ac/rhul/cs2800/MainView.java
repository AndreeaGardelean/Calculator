package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for executing the project. This class is a subclass of Application, which starts the JavaFx
 * runtime and constructs an instance of the class.
 *
 * @author zjac013
 */
public class MainView extends Application {

  /**
   * Main method of the class, launches the application.
   *
   * @param args command line arguments passed to the main method
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("GuiView.fxml"));
    Scene scene = new Scene(parent, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
