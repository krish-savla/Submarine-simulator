import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Color;

public class Submarine {
	private int x, y;
    private Ellipse2D oval;
	public Submarine() {
		x = 60; 
		y = 140;

	}
	public void update_coordinates(int new_y) {
		y = new_y;
	}
	public void draw_sub(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.gray);
        g2.fillRect (x - 15, y + 20, 20, 10);
        g2.setColor(Color.gray.brighter());
        oval = new Ellipse2D.Float(x, y, 120, 50);
        g2.fill(oval);
        g2.setColor(Color.gray);
        g2.fillArc(x + 34, y - 8, 45, 24, 0, 180);
        Path2D path = new Path2D.Double();
        path.moveTo(x + 99, y + 9);
        path.curveTo(x + 99, y + 9, x + 92, y + 23, x + 99, y + 44);
        g2.draw(path);
        g2.fillRect (x + 53, y - 20, 8, 15);
        g2.fillRect (x + 53, y - 25, 15, 5);

	}
	public void draw_sub2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red.darker());
        g2.fillRect (x - 15, y + 20, 20, 10);
        g2.setColor(Color.red.brighter());
        oval = new Ellipse2D.Float(x, y, 120, 50);
        g2.fill(oval);
        g2.setColor(Color.red.darker());
        g2.fillArc(x + 34, y - 8, 45, 24, 0, 180);
        Path2D path = new Path2D.Double();
        path.moveTo(x + 99, y + 9);
        path.curveTo(x + 99, y + 9, x + 92, y + 23, x + 99, y + 44);
        g2.draw(path);
        g2.fillRect (x + 53, y - 20, 8, 15);
        g2.fillRect (x + 53, y - 25, 15, 5);
        g2.setColor(Color.gray);
	}
    public Ellipse2D get_sub() {
        return oval;
    }
    public int get_x() {
        return x;
    }
    public int get_y() {
        return y;
    }
    public void set_x(int x) {
        this.x = x;
    }
    public void set_y(int y) {
        this.y = y;
    }

}