package de.osmembrane;

import de.osmembrane.view.IView;
import de.osmembrane.view.ViewRegistry;

public class Application {
	public Main unnamed_Main_;

	public void initiate() {
		throw new UnsupportedOperationException();
		/*
		 * TODO: IMPLEMENT ME!
		 */
	}

	/*
	 * TODO: when is this method called?
	 */
	public void checkPersistence() {
		throw new UnsupportedOperationException();
	}

	public void createModels() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Shows the main window after application startup.
	 * Is guaranteed to be invoked by a different Runnable
	 */
	public void showMainFrame() {		
		IView mainFrame = ViewRegistry.getInstance().getMainFrame();
		mainFrame.showWindow();
	}
}