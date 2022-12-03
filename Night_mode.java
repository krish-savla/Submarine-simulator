/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a check box, which changes
    night mode on and off
*/


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Night_mode extends JCheckBox implements ItemListener {
	Model model;
	private String text;
	public Night_mode(String s, Model m) {
		addItemListener(this);
		model = m;
		setText(s);
		text = s;
	}
	public void itemStateChanged (ItemEvent e) {
		if (e.getStateChange() == 1) {
                System.out.println(text + " was selected.");
                setText("Night-mode On");
                model.change_mode_dark();
        }
        else {
                System.out.println(text + " was unselected.");
    			setText("Night-mode Off");
    			model.change_mode_light();
    	}
	}

}
