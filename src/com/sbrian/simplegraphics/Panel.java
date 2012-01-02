package com.sbrian.simplegraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JPanel;

public class Panel extends JPanel {

    private static final long serialVersionUID = -4537539284750052513L;
    private RealPositions viewSize = null;

    private Set<Point> points = new LinkedHashSet<Point>();

    public Panel(RealPositions viewSize) {
	super();
	this.viewSize = viewSize;
    }

    private void render(Graphics g) {
	BufferedImage image = new BufferedImage(viewSize.getRealWidth(),
		viewSize.getRealHeight(), BufferedImage.TYPE_INT_ARGB);
	Graphics bg = image.getGraphics();
	bg.setColor(Color.WHITE);
	bg.fillRect(0, 0, viewSize.getRealWidth(), viewSize.getRealHeight());
	bg.setColor(Color.BLACK);
	for (Point point : points) {
	    int x = viewSize.getRealXFromPoint(point);
	    int y = viewSize.getRealYFromPoint(point);
	    int pxPerUnit = viewSize.getPixelsPerUnit();
	    bg.fillArc(x, y, pxPerUnit, pxPerUnit, 0, 360);
	}
	g.drawImage(image, 0, 0, null);
	bg.dispose();
    }

    public void paint(Graphics g) {
	render(g);
    }

    public void setPoint(int x, int y) {
	points.add(new Point(x, y));
	repaint();
    }

    public void unsetPoint(int x, int y) {
	points.remove(new Point(x, y));
	repaint();
    }

    public void clear() {
	points.clear();
	repaint();
    }
}
