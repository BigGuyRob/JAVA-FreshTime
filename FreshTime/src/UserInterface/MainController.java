package UserInterface;

import application.DatasetInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * MainController contains logic required for interacting with MainView.xml and its attributes
 * @author Robert Reid
 *
 */
public class MainController {
	private DatasetInterface dbInterface;
	@FXML private TextField txtjavaconnectionstring;
	@FXML private Button btnChooseFiles;
	@FXML private Button btnConnect;
	@FXML private ToggleGroup tgdatatype;
	@FXML private RadioButton rdbMDB;
	@FXML private RadioButton rdbCSV;
	@FXML private TextArea txtNotif;
	
	
	public void setOptions(boolean state) {
		btnConnect.setVisible(state);
		btnChooseFiles.setVisible(state);
		txtjavaconnectionstring.setVisible(state);
		btnConnect.setDisable(!state);
		btnChooseFiles.setDisable(!state);
		txtjavaconnectionstring.setDisable(!state);
		rdbMDB.setDisable(!state);
		rdbCSV.setDisable(!state);
	}
	
	@FXML
	private void chooseRDB(ActionEvent event) {
		if(rdbMDB.isSelected()) {
			setOptions(false);
			rdbMDB.setDisable(false);
			rdbCSV.setDisable(false);
			btnConnect.setVisible(true);
			btnConnect.setDisable(false);
			txtjavaconnectionstring.setVisible(true);
			txtjavaconnectionstring.setDisable(false);
		}else {
			setOptions(false);
			rdbMDB.setDisable(false);
			rdbCSV.setDisable(false);
			btnChooseFiles.setVisible(true);
			btnChooseFiles.setDisable(false);
		}
	}
	
	@FXML
	private void chooseFiles(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FileView.fxml"));	
			BorderPane fileView = (BorderPane) loader.load();
			FileViewController fileviewController = loader.getController();
			fileviewController.setMainController(this);
			Scene FileScene = new Scene(fileView,600,400);
			Stage primaryStage = new Stage();
			primaryStage.setOnHidden(e-> fileviewController.shutdown());
			primaryStage.setTitle("File View");
			setOptions(false);
			primaryStage.setScene(FileScene);
			primaryStage.show(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reFocus() {
		rdbMDB.setDisable(false);
		rdbCSV.setDisable(false);
		rdbMDB.setSelected(true);
		rdbMDB.setSelected(false);
		rdbCSV.setSelected(false);
	}
	
	@FXML
	public void createDBInterface(ActionEvent event) {
		dbInterface = new DatasetInterface(txtjavaconnectionstring.getText());
		Exception ret = dbInterface.pingDB();
		if(ret == null) {
			openDatabaseView();
		}else {
			//do nothing for now
			txtNotif.setText("Unable to connect to database, please check java connection string");
		}
	}
	
	private void openDatabaseView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DatabaseView.fxml"));	
			BorderPane databaseView = (BorderPane) loader.load();
			DatabaseViewController databaseviewController = loader.getController();
			databaseviewController.setMainController(this);
			Scene DatabaseScene = new Scene(databaseView,600,400);
			Stage primaryStage = new Stage();
			primaryStage.setOnHidden(e-> databaseviewController.shutdown());
			primaryStage.setTitle("Database View");
			setOptions(false);
			primaryStage.setScene(DatabaseScene);
			primaryStage.show(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
