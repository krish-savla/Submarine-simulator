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

public class Top_panel extends JPanel {
    public Top_panel (Score score) {
        setLayout(new GridLayout(3, 1));
        // add(score);
        setBackground(Color.gray.darker().darker());
    }
}
