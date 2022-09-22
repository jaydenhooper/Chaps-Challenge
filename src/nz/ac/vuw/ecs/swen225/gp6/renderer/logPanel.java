package nz.ac.vuw.ecs.swen225.gp6.renderer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class LogPanel extends JPanel{
    
    //textArea
    private JTextArea textArea;

    public LogPanel() {

        this.setLayout(new GridLayout(1,1)); //so it fills the whole panel
        // make the text Area panel and set property's
		textArea = new JTextArea(); 
		textArea.setLineWrap(true); 
		textArea.setWrapStyleWord(true); // pretty line wrap.
		textArea.setBackground(Color.black);
		Font font = new Font("Verdana", Font.BOLD, 12);
		textArea.setFont(font); // set font
		textArea.setForeground(Color.green); // set color
        textArea.setEditable(false); // set editable to false
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane);
    }

    /**
	 * appends String to textArea and adds \n to the string
     * @param text
	 */
	public String printLine(String s) {
		textArea.append(s+"\n");
        return s;
	}
    
    /**
    * appends String to textArea
    * @param text
    */
	public String printLine(int i) {
		String s = Integer.toString(i);
		textArea.append(s+"\n");
        return s;
	}
	public String printLine(double d) {
		String s = Double.toString(d);
		textArea.append(s+"\n");
        return s;
	}
	
    //get the last line of the textArea
    public String getLastLine() {
        String[] lines = textArea.getText().split("\n");
        return lines[lines.length-1];
    }

    //print into the current line
    public String print(String s) {
        textArea.append(s);
        return s;
    }

    //get all the text in the textArea
    public String getText() {
        return textArea.getText();
    }


	/*
	 * Clears all text
	 */
	public void clearText() {
		textArea.setText("");
	}

}
