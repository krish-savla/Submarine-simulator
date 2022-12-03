/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a toggle button that pauses 
    and resumes the game
*/

import javax.swing.JToggleButton;
import java.awt.event.*;
import javax.swing.*;

public class Pause extends JToggleButton implements ItemListener {
    private Model model;
    private Change_color change_color;
    private Shoot shoot;
    private Move move;
    private Timer timer;

    public Pause (String label, Model m, Change_color change_color, 
                  Shoot shoot, Move move, Timer timer) {
        this.change_color = change_color;
        this.shoot = shoot;
        this.move = move;
        model = m;
        this.timer = timer;
	    setText (label);
        addItemListener (this);
    }
    public void itemStateChanged(ItemEvent itemEvent) {
        // event is generated in button
        int state = itemEvent.getStateChange();
        if (state == ItemEvent.SELECTED) {
            System.out.println("pause selected");
            setText ("Resume");
            change_color.setEnabled(false);
            shoot.setEnabled(false);
            move.setEnabled(false);
            timer.stop();
        }
        else {
            System.out.println("resume selected");
            setText ("Pause");
            change_color.setEnabled(true);
            shoot.setEnabled(true);
            move.setEnabled(true);
            timer.start();
        }
    }
}