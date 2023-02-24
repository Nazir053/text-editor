package nazir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{
	
	JFrame window;
	JTextArea textArea;
	boolean wordWrapOn = false;
	JScrollPane scrollPane;
	
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	
	JMenuItem iUndo, iRedo;
	
	JMenuItem iWrap,iFontArial,iFontCSMS,ifontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24;
	JMenu menuFont,menuFontSize;
	
	JMenuItem iColor1,iColor2,iColor3,iColor4;
	
	JMenu menuCode;
	JMenuItem iCompile,iRun;
	
	
	Function_File file = new Function_File(this); 
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this);
	Function_Edit edit = new Function_Edit(this); 
	
	UndoManager um = new UndoManager();

	public static void main(String[] args) {
		new GUI();
		
	}
	
	public GUI() {
		creatWindow();
		creatTextArea();
		creatMenuBar();
		creatFileMenu();
		creatEditMenu();
		creatFormatMenu();
		creatColorMenu();
		creatCodeMenu();
		
		format.selectedFont = "Arial";
		format.creatFont(16);
		format.wordWrap();
		
		color.changeColor("White");
		
		
		window.setVisible(true);
	}
	
	public void creatWindow() {
		window = new JFrame("Notepad");
		window.setSize(800 , 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void creatTextArea() {
		textArea = new JTextArea();
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					
					@Override
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
						
					}
				});
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		//window.add(textArea); // now i add textarea with scrolbar
		
	}
	
	public void creatMenuBar() {
		menuBar =new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Background Color");
		menuBar.add(menuColor);
		
		menuCode = new JMenu("Code");
		menuBar.add(menuCode);
	}
	
	public void creatFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
	}
	
	public void creatEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	
	public void creatFormatMenu() {
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("World Wrap");
		menuFormat.add(iWrap);
		
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("CSMS");
		menuFont.add(iFontCSMS);
		
		ifontTNR = new JMenuItem("Times New Roman");
		ifontTNR.addActionListener(this);
		ifontTNR.setActionCommand("TNR");
		menuFont.add(ifontTNR);
		
		
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("24");
		menuFontSize.add(iFontSize24);
		
	}
	
	public void creatColorMenu() {
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
		
		iColor4 = new JMenuItem("Ash");
		iColor4.addActionListener(this);
		iColor4.setActionCommand("Ash");
		menuColor.add(iColor4);
	}
	
	public void creatCodeMenu()
	{
		iCompile = new JMenuItem("Compile");
		iCompile.addActionListener(this);
		iCompile.setActionCommand("compile");
		menuCode.add(iCompile);
		
		iRun = new JMenuItem("Run");
		iRun.addActionListener(this);
		iRun.setActionCommand("run");
		menuCode.add(iRun);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		switch (command) {
		case "New": file.newFile(); break;
		case  "Open": file.open(); break;
		case "Save" : file.save(); break;
		case "SaveAs":file.saveAs(); break;
		case "Exit" : file.exit();break;
		case "Undo" : edit.undo();break;
		case "Redo" : edit.redo();break;
		case "World Wrap" : format.wordWrap();break;
		case "Arial" : format.setFont("Arial");break;
		case "CSMS" : format.setFont("Comics Sans MS");break;
		case "TNR" : format.setFont("Times New Roman");break;
		case "8" : format.creatFont(8);;break;
		case "12" : format.creatFont(12);;break;
		case "16" : format.creatFont(16);;break;
		case "20" : format.creatFont(20);;break;
		case "24" : format.creatFont(24);;break;
		case "White" : color.changeColor(command);break;
		case "Black" : color.changeColor(command);break;
		case "Blue" : color.changeColor(command);break;
		case "Ash" : color.changeColor(command);break;
		}
		
	}
		
	
	
	
	

}
