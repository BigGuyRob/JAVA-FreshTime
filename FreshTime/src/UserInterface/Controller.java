package UserInterface;
import application.DatasetInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller extends Application {
	private DatasetInterface dbInteface;
	
	/**
	 * Method to start the main menu view on the start of the application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
		//	primaryStage.initStyle(StageStyle.UNDECORATED);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene MainMenuscene = new Scene(root,600,400);
			primaryStage.setTitle("Main Menu");
			primaryStage.setScene(MainMenuscene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method which runs on start launches the application 
	 * @param args - Arguments not used.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
