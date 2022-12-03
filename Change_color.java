/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that 
    changes the color of the sub
*/

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Change_color extends JButton implements ActionListener {
    Model model;
    public Change_color (String label, Model m) {
	    setText (label);
        model = m;
        addActionListener (this);
    }
    public void actionPerformed (ActionEvent e) {
        System.out.println ("color changed");
        model.color_choice(2);

    }
}