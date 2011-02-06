package de.osmembrane.view.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import de.osmembrane.view.panels.LibraryFunction;
import de.osmembrane.view.panels.StartPanel;

/**
 * Glass pane that improvises the drawing of the drag & drop
 * 
 * @author tobias_kuhn
 * 
 */
public class MainFrameGlassPane extends JComponent {

	private static final long serialVersionUID = -997512362081326789L;

	/**
	 * the {@link LibraryFunction} that is currently dragged to store
	 */
	private LibraryFunction dragAndDrop;

	/**
	 * Initializer for new {@link MainFrameGlassPane}
	 * 
	 * @param showStartScreen
	 *            whether the start screen shall be displayed upon
	 *            initialization
	 */
	public MainFrameGlassPane(boolean showStartScreen) {
		setLayout(new GridLayout(1, 1));
		
		if (showStartScreen) {
			JPanel startPanel = new StartPanel();			
			add(startPanel);
		}
	}

	/**
	 * Draws a specific {@link LibraryFunction} that is currently dragged & drop
	 * where the cursor is
	 * 
	 * @param libraryFunction
	 *            the view function to be drawn
	 * @param point
	 *            top left position of the view function to be drawn
	 */
	public void dragAndDrop(LibraryFunction libraryFunction, Point point) {
		if (dragAndDrop == null) {
			// add the display function
			dragAndDrop = new LibraryFunction(null,
					libraryFunction.getModelFunctionPrototype(), false);

			dragAndDrop.setSize(dragAndDrop.getPreferredSize());
			dragAndDrop.forceHighlight(true);
			dragAndDrop.setCursor(DragSource.DefaultCopyDrop);

			add(dragAndDrop);
			setVisible(true);
		}
		dragAndDrop.setLocation(point);
	}

	/**
	 * Ends the current drag and drop functionality and restores normal behavior
	 */
	public void endDragAndDrop() {
		if (dragAndDrop != null) {
			remove(dragAndDrop);
			dragAndDrop = null;
		}
		setVisible(false);
	}

}