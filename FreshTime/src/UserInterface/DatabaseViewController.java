package UserInterface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class DatabaseViewController {
	private MainController main;
	
	
	public void setMainController(MainController mainController) {
		// TODO Auto-generated method stub
		this.main = mainController;
	}
	
	@FXML
	public void shutdown() {
		// TODO Auto-generated method stub
	}

	@FXML
	private void gotoGraphView(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GraphView.fxml"));	
			BorderPane graphView = (BorderPane) loader.load();
			GraphViewController graphviewController = loader.getController();
			graphviewController.setMainController(main);
			Scene graphScene = new Scene(graphView,600,400);
			Stage primaryStage = new Stage();
			primaryStage.setOnHidden(e-> graphviewController.shutdown());
			primaryStage.setTitle("graph View");
			primaryStage.setScene(graphScene);
			primaryStage.show(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
