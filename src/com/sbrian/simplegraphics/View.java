package com.sbrian.simplegraphics;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class View {

    private RealPositions viewSize;

    private JFrame frame;
    private Panel panel;

    public View() {
	this.viewSize = new RealPositions();
    }

    private Frame getFrame() {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((dim.width - viewSize.getRealWidth()) / 2,
		(dim.height - viewSize.getRealHeight()) / 2);
	frame.add(getPanel());
	frame.pack();
	return frame;
    }

    private Panel getPanel() {
	if (panel != null)
	    return panel;
	panel = new Panel(viewSize);
	panel.setPreferredSize(viewSize.getDimension());
	return panel;
    }

    public synchronized void setVisible(boolean visible) {
	getFrame().setVisible(visible);
    }

    public void setPoint(int x, int y) {
	getPanel().setPoint(x, y);
    }

    public void unsetPoint(int x, int y) {
	getPanel().unsetPoint(x, y);
    }
    
    public void clear() {
	getPanel().clear();
    }
}
