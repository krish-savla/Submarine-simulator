/*
    Name: Krish Savla
    Email: krish.savla@tufts.edu
    Description: class that implements a button that exits from the game
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Color;

public class Left_panel extends JPanel {
    public Left_panel (Move move, Change_color change_color, 
                      Add_obstacle obs) {
        setLayout(new GridLayout(3, 1));
        add(move);
        setBackground(Color.gray.darker().darker());
        add(change_color);
        add(obs);
    }
}
