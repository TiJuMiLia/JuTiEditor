package app;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane borderLayout;
	
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("JuKuEditor");
		
		//build main layout from fxml file
		try {
			URL fxmlUrl = Main.class.getResource("view/BorderLayout.fxml");
			FXMLLoader fmxLoader = new FXMLLoader(fxmlUrl);
			borderLayout = (BorderPane) fmxLoader.load();
			primaryStage.setScene(new Scene(borderLayout));
			
			primaryStage.setMinHeight(400);
			primaryStage.setMinWidth(300);
			primaryStage.show();
			
			OpenFileController controller = fmxLoader.getController();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showEditor();
		
	}
	
	private void showEditor() {
        try {
        	URL fxmlTextURL = getClass().getResource("view/EditorLayout.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlTextURL);
            
            VBox textArea = (VBox) loader.load();
            borderLayout.setCenter(textArea);
            
            EditorController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showOpenDialog(TextArea textBox) {
		try {
		URL fxmlUrl = Main.class.getResource("view/OpenFileLayout.fxml");
		FXMLLoader fmxLoader = new FXMLLoader(fxmlUrl);
		HBox openLayout = (HBox) fmxLoader.load();
		Stage openFileStage = new Stage();
		openFileStage.setScene(new Scene(openLayout));
		openFileStage.setResizable(false);
		openFileStage.setTitle("Open File");
		
		OpenFileController openFileController = fmxLoader.getController();
		openFileController.setTextArea(textBox);
		openFileController.setStage(openFileStage);
		
		openFileStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	public void showSaveDialog(TextArea textBox) {
		try{
		URL fxmlUrl = Main.class.getResource("view/SaveFileLayout.fxml");
		FXMLLoader fmxLoader = new FXMLLoader(fxmlUrl);
		VBox saveLayout = (VBox) fmxLoader.load();
		Stage saveFileStage = new Stage();
		saveFileStage.setScene(new Scene(saveLayout));
		saveFileStage.setResizable(false);
		saveFileStage.setTitle("Save File");
		
		SaveFileController saveFileController = fmxLoader.getController();
		saveFileController.setTextArea(textBox);
		saveFileController.setStage(saveFileStage);	
		saveFileStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
