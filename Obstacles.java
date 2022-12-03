/*
	Name: Krish Savla
 	Email: krish.savla@tufts.edu
 	Description: abstract class for all obstacles, 
 	serves as the super class
*/

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Color;

abstract class Obstacles {
	public Obstacles() {
	}
	abstract void draw_obstacle(Graphics g);
	abstract void set_x(int s);
	abstract void set_y();
	abstract void update_size(int x, int y);
	abstract Ellipse2D get_oval();
	abstract int get_x();
	abstract int get_y();
	abstract int get_w();
	abstract int get_h();
	abstract void set_color(Color color);
	abstract void change_x(int x);
	abstract void change_y(int x);

}