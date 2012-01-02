package com.sbrian.simplegraphics;

import java.awt.Dimension;
import java.awt.Point;

public class RealPositions {

    public static int DEFAULT_MAX_X = 100;
    public static int DEFAULT_MAX_Y = 100;
    public static int DEFAULT_MIN_X = -100;
    public static int DEFAULT_MIN_Y = -100;
    public static int DEFAULT_PX_PER_UNIT = 3;

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private int pixelsPerUnit;

    public RealPositions() {
	this(DEFAULT_MIN_X, DEFAULT_MAX_X, DEFAULT_MIN_Y, DEFAULT_MAX_Y,
		DEFAULT_PX_PER_UNIT);
    }

    public RealPositions(int minX, int maxX, int minY, int maxY, int pixelsPerUnit) {
	this.minX = minX;
	this.maxX = maxX;
	this.minY = minY;
	this.maxY = maxY;
	this.pixelsPerUnit = pixelsPerUnit;
    }

    public Dimension getDimension() {
	return new Dimension(getRealWidth(), getRealHeight());
    }

    public int getRealWidth() {
	return (maxX - minX + 1) * pixelsPerUnit;
    }

    public int getRealHeight() {
	return (maxY - minY + 1) * pixelsPerUnit;
    }

    public int getRealXFromPoint(Point p) {
	return ((int) p.getX() - minX) * pixelsPerUnit;
    }

    public int getRealYFromPoint(Point p) {
	return ((int) p.getY() - minY) * pixelsPerUnit;
    }

    public int getPixelsPerUnit() {
	return pixelsPerUnit;
    }
}
