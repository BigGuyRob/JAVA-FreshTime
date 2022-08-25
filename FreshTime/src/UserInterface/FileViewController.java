package UserInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FileViewController {
	private MainController main;
	@FXML private Button btnchooseRestFile;
	
	public void setMainController(MainController mainController) {
		// TODO Auto-generated method stub
		this.main = mainController;
	}

	@FXML
	public void shutdown() {
		main.reFocus();
		closeScene();
		
	}
	
	/**
	 * Method for closing the FileViewController and view
	 */
	public void closeScene() {
		Stage closestage = (Stage) btnchooseRestFile.getScene().getWindow();
		closestage.close();
	}
	
	@FXML
	private void startOver() {
		shutdown();
	}

}
