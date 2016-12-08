package aSimpleGui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

	// paint Rectangle
	// public void paintComponent(Graphics g){
	//
	// g.setColor(Color.orange);
	// g.fillRect(60, 50, 100, 100);
	// }

	// draw image
	// public void paintComponent(Graphics g){
	//
	// Image image = new ImageIcon("cat.jpg").getImage();
	//
	// g.drawImage(image, 3, 4, this);
	// }

	// paint Gradient colored 2D Circle on rectangle
	public void paintComponent(Graphics g) {
		// paint rectangle over all Panel
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Graphics2D g2d = (Graphics2D) g;

		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color startColor = new Color(red, green, blue);

		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		Color endColor = new Color(red, green, blue);

		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150,
				endColor);

		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}
}
