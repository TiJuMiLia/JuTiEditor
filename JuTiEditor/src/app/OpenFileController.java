package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OpenFileController {
	
	private TextArea textArea;
	private Stage openFileStage;
	private String fileString="";
	@FXML
	TextField pathOfFile;
	
	public void handleBrowse(){
		FileChooser chooser = new FileChooser();
		//configureFileChooser(chooser);

		File file = chooser.showOpenDialog(openFileStage);
		
		if(file != null) {
			fileString = getTextFromFile(file);
			pathOfFile.setText(file.getAbsolutePath());
			
			// last file to be used as initial directory
			//lastFile = file;
		}
	}
	
	public void handleAppend(){
		textArea.appendText(fileString);
		openFileStage.close();		
	}
	
	public void handleReplace(){
		textArea.clear();
		handleAppend();
		
	}
	
	private String getTextFromFile(File file) {
			
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String fileText = "";
			StringBuilder sb = new StringBuilder();
			while((fileText = br.readLine()) != null){
				sb.append(fileText).append("\n");
			}
			br.close();
			return sb.toString();
		} catch (IOException e){
			e.printStackTrace();
		} 
		
		return "";
	}

	public void setTextArea(TextArea textBox) {
		this.textArea = textBox;
	}

	public void setStage(Stage openFileStage) {
		this.openFileStage = openFileStage;
	}


}
