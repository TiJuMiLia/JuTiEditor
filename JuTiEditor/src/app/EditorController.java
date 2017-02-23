package app;

import java.net.URL;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class EditorController {
	
	
	private final static double DEFAULT_SPACING = 55;
	private final static double CONTROL_HEIGHT = 132;
	private final static double SPACE_DIV = 8.5;
	private final static double BUTTON_WIDTH = 160.0;
	private final static double RBOX_THRESHOLD = 520;	 // threshold to change spacing of right VBox
	
	
	// used when showing new stage/scene
	private Main mainApp;
	// used for getting new objects
	//private LaunchClass launch;
	// UI Controls
	private TextArea textBox;
	@FXML
	private VBox leftPane;
	@FXML
	private VBox rightBox;
	@FXML
	private HBox container;
	@FXML
	private Label fLabel;
	@FXML
	private Pane bufferPane;
	@FXML
	private TextField fleschField;
	@FXML
	private CheckBox autocompleteBox;
	@FXML 
	private CheckBox spellingBox;

	
	@FXML
	private void initialize() {
		// make field displaying flesch score read-only
		//fleschField.setEditable(false);
		
		
		//launch = new LaunchClass();
		
		// instantiate and add custom text area
		//spelling.Dictionary dic = launch.getDictionary();
		textBox = new TextArea();
		textBox.setPrefSize(570, 492);
		textBox.setStyle("-fx-font-size: 14px");
		textBox.setWrapText(true);
		
		
		// add text area as first child of left VBox
		ObservableList<Node> nodeList = leftPane.getChildren();
		Node firstChild = nodeList.get(0);
    	nodeList.set(0, textBox);
		nodeList.add(firstChild);
//		
		VBox.setVgrow(textBox, Priority.ALWAYS);
//		
//		
//		
//		// ADD LISTENERS FOR ADJUSTING ON RESIZE
//		
//		container.widthProperty().addListener(li -> {
//			
//			if((container.getWidth() - leftPane.getPrefWidth()) < BUTTON_WIDTH) {
//				rightBox.setVisible(false);
//			}
//			else {
//				rightBox.setVisible(true);
//			}
//		});
//		
//		// function for setting spacing of rightBox
//		Consumer<VBox> adjustSpacing = box ->  {
//			if(container.getHeight() < RBOX_THRESHOLD) {
//				rightBox.setSpacing((container.getHeight() - CONTROL_HEIGHT)/SPACE_DIV);
//			}
//			else {
//				rightBox.setSpacing(DEFAULT_SPACING);
//			}
//		};
//		
//		container.heightProperty().addListener(li -> {
//			adjustSpacing.accept(rightBox);
//		});
//		
//		rightBox.visibleProperty().addListener( li -> {
//			if(rightBox.isVisible()) {
//				 container.getChildren().add(rightBox);
//				 adjustSpacing.accept(rightBox);
//			 }
//			 else {
//				 container.getChildren().remove(rightBox);
//			 }	 
//		});
	}
	
	
	
	public void handleClear(){
		
	}
	
	public void handleLoadText(){
		
		mainApp.showOpenDialog(textBox);
		
	}
	
	public void handleSaveText(){
		mainApp.showSaveDialog(textBox);
	}

	public void handleFleschIndex(){
	
	}

	public void handleEditDistance(){
	
	}

	public void handleMarkovText(){
	
	}

	public void handleSpelling(){
	
	}

	public void handleAutoComplete(){
	
	}

	public void setMainApp(Main mainApp) {
	this.mainApp = mainApp;
	}
	
	public void handleKeyEvent(){
		
	}
	
	

}
