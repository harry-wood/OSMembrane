/*
 * This file is part of the OSMembrane project.
 * More informations under www.osmembrane.de
 * 
 * The project is licensed under the GNU GENERAL PUBLIC LICENSE 3.0.
 * for more details about the license see http://www.osmembrane.de/license/
 * 
 * Source: $HeadURL$ ($Revision$)
 * Last changed: $Date$
 */



package de.osmembrane.view;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import de.osmembrane.view.interfaces.IView;

/**
 * An abstract class interface to be used for dialog frame elements.
 * 
 * @author tobias_kuhn
 * 
 */
@SuppressWarnings("serial")
public abstract class AbstractFrame extends JFrame implements IView {

	/**
	 * This is the {@link KeyListener} for all buttons to be added, so they
	 * react on return. (A rather typical behavior not implemented by Swing
	 * natively)
	 */
	protected KeyListener returnButtonListener;

	/**
	 * common constructor for all frame view elements
	 */
	public AbstractFrame() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// ability activate buttons with return
		returnButtonListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Component focusedComponent = getFocusOwner();
					if (focusedComponent instanceof JButton) {
						e.consume();
						((JButton) focusedComponent).doClick();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
	}

	@Override
	public void showWindow() {
		setVisible(true);
	}

	@Override
	public void hideWindow() {
		setVisible(false);
	}

	@Override
	public void setWindowTitle(String title) {
		setTitle(title);
	}

	@Override
	public void centerWindow() {
		Point screenCenter = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getCenterPoint();
		Point edgeLeftTop = new Point(screenCenter.x - (getWidth() / 2),
				screenCenter.y - (getHeight() / 2));
		setLocation(edgeLeftTop.x, edgeLeftTop.y);
	}

	@Override
	public void bringToFront() {
		toFront();
	}

}
