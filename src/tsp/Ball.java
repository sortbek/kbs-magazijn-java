package tsp;

import java.awt.*;

public class Ball {

	private double xmin, xmax; 
	private double ymin, ymax;

	private double x, y; 

	private double dx, dy; 

	private Color color; 

	private double radius; 


	public Ball(double left, double right, double top, double bottom) {
		xmin = left;
		xmax = right;
		ymin = top;
		ymax = bottom;
		x = (xmin + xmax) / 2;
		y = (ymin + ymax) / 2;
		radius = 5;
		color = Color.red;
		double angle = 2 * Math.PI * Math.random(); // Random direction.
		double speed = 4 + 8 * Math.random(); // Random speed.
		dx = Math.cos(angle) * speed;
		dy = Math.sin(angle) * speed;
	}


	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius),
				(int) (2 * radius));
	}

	public void travel() {
		travel(1.0);
	}


	public void travel(double time) {

		if (xmax - xmin < 2 * radius || ymax - ymin < 2 * radius)
			return;


		if (x - radius < xmin)
			x = xmin + radius;
		else if (x + radius > xmax)
			x = xmax - radius;
		if (y - radius < ymin)
			y = ymin + radius;
		else if (y + radius > ymax)
			y = ymax - radius;

		double newx = x + dx * time;
		double newy = y + dy * time;


		if (newy < ymin + radius) {
			newy = 2 * (ymin + radius) - newy;
			dy = Math.abs(dy);
		} else if (newy > ymax - radius) {
			newy = 2 * (ymax - radius) - newy;
			dy = -Math.abs(dy);
		}
		if (newx < xmin + radius) {
			newx = 2 * (xmin + radius) - newx;
			dx = Math.abs(dx);
		} else if (newx > xmax - radius) {
			newx = 2 * (xmax - radius) - newx;
			dx = -Math.abs(dx);
		}

		/* We have the new values for x and y. */

		x = newx;
		y = newy;

	} 


	public void setColor(Color c) {
		if (c != null)
			color = c;
	}


	public void setRadius(int r) {
		radius = r;
		if (radius < 0.5)
			radius = 0.5;
	}
	public void setLimits(double left, double right, double top, double bottom) {
		xmin = left;
		xmax = right;
		ymin = top;
		ymax = bottom;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setSpeed(double speed) {
		if (speed > 0) {
			double currentSpeed = Math.sqrt(dx * dx + dy * dy);
			dx = dx * speed / currentSpeed;
			dy = dy * speed / currentSpeed;
		}
	}


	public void headTowards(int a, int b) {
		double vx = a - x;
		double vy = b - y;
		double dist = Math.sqrt(vx * vx + vy * vy);
		if (dist > 0) {
			double speed = Math.sqrt(dx * dx + dy * dy);
			dx = vx / dist * speed;
			dy = vy / dist * speed;
		}
	}


	public void setV(double dx, double dy) {
		if (dx != 0 || dy != 0) {
			this.dx = dx;
			this.dy = dy;
		}
	}

} 
