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

public class Right_panel extends JPanel {
    public Right_panel (Night_mode n, Change_obs_color c, AddObstacleSpec aos) {
        setLayout(new GridLayout(3, 1));
        add(n);
        add(c);
        add(aos);
    }
}
