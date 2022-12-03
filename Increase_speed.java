/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a toggle button that increases
    the speed of the game
*/

import javax.swing.JToggleButton;
import java.awt.event.*;
import javax.swing.*;

public class Increase_speed extends JToggleButton implements ItemListener {
    private Model model;
    private int speed;

    public Increase_speed (String label, Model m) {
        model = m;
	    setText (label);
        addItemListener (this);
        speed = 1;
    }
    public void itemStateChanged(ItemEvent itemEvent) {
        // event is generated in button
        int state = itemEvent.getStateChange();
        if (state == ItemEvent.SELECTED) {
            System.out.println("quick");
            setText ("1X Speed");
            speed = 2;
        }
        else {
            System.out.println("slow");
            setText ("2X Speed");
            speed = 1;
        }
    }
    public int get_speed() {
        return speed;
    }
}