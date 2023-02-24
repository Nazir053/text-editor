package nazir;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Function_File {

	GUI gui;
	String filename;
	String fileAddress;
	
	public Function_File(GUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New File");
		filename = null;
		fileAddress = null;
	}
	
	public void open(){
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		if (fd.getFile()!= null) {
			filename = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(filename);
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + filename));
			gui.textArea.setText("");
			String line = null;
			
			while ((line = br.readLine()) != null ) {
				gui.textArea.append( line + "\n");
				
			}
			br.close();
		} catch (Exception e) {
			System.out.println("File Not Open");
		}
	}
	
	public void save() {
		
		if(filename == null) {
			saveAs();
		}
		else {
			try {
				FileWriter fw = new FileWriter(fileAddress + filename);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(filename);
				fw.close();
			} catch (Exception e) {
				System.out.println("Wrong Someting");
			}
		}
		
		
	}
	
	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window,"Save As",FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			filename = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.window.setTitle(filename);
		}
		
		try {
			FileWriter fw = new FileWriter(fileAddress + filename);
			fw.write(gui.textArea.getText());
			fw.close();
		} catch (Exception e) {
			System.out.println("Wrong Someting");
		}
	}
	
	public void exit() {
		System.exit(0);
		
	}
}
