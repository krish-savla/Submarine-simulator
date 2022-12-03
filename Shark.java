/*
	Name: Krish Savla
 	Email: krish.savla@tufts.edu
 	Description: subclass of the obstacles class,
 	represents shark objects
*/
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Color;

public class Shark extends Obstacles {
	private int x, y;
	private Ellipse2D oval;
	private int size1, size2;
	private Color color;
	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
		size1 = 45;
		size2 = 27;
		color = Color.gray;
	}
	public void draw_obstacle(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		oval = new Ellipse2D.Float(x, y, size1, size2);
		g2.fill(oval);
		g2.setColor(Color.gray);

	}
	public void update_size(int x, int y) {
		size1 = x / 2;
		size2 = y / 2;
		color = Color.pink;
	}
	public Ellipse2D get_oval() {
		return oval;
	}
	public void set_x(int s) {
		x = x - s;
	}
	public void set_y() {
		y = y + 1;
	}
	public int get_x() {
		return x;
	}
	public int get_y() {
		return y;
	}
	public int get_w() {
		return size1;
	}
	public int get_h() {
		return size2;
	}
	public void set_color(Color color) {
		this.color = color;
	}
	public void change_x(int x) {
		this.x = x;
	}
	public void change_y(int y) {
		this.y = y;
	}
	

}