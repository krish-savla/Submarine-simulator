/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that zooms in
*/

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zoom_out extends JButton implements ActionListener {
    private Model model;
    public Zoom_out (String label, Model m) {
        model = m;
	    setText (label);
        addActionListener (this);
    }
    public void actionPerformed (ActionEvent e) {
        System.out.println ("zoomed in");
        model.zoom_out();    
    }
}