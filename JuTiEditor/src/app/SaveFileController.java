package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveFileController {

	private Stage saveDialogeStage;
	private TextArea textBox;
	private String name="";
	@FXML
	private TextField nameOfFile;
	
	public void handleSave(){
		name = nameOfFile.getText();
		FileChooser fs = new FileChooser();
		fs.setInitialFileName(name);
		File file = fs.showSaveDialog(saveDialogeStage);
		//name = file.getName();
		//String path = file.getParent();	
		if(file != null){
			saveFile(file);
		}
	}

	private void saveFile(File file) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(textBox.getText());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setTextArea(TextArea textBox) {
		this.textBox = textBox;		
	}

	public void setStage(Stage saveFileStage) {
		this.saveDialogeStage = saveFileStage;
	}
}
