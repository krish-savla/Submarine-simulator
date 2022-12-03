/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that exits from the game
*/

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exit extends JButton implements ActionListener {
    public Exit (String label) {
	    setText (label);
        addActionListener (this);
    }
    public void actionPerformed (ActionEvent e) {

        System.out.println ("exit");
        System.exit(0);
    }
}