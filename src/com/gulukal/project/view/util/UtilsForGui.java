package com.gulukal.project.view.util;

import java.io.IOException;

import com.gulukal.project.Main;
import com.gulukal.project.MovieDatabaseManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class UtilsForGui {
	
	// singleton ??
	
	public void cancelAction() {
		
		System.exit(0);
	}
	
	public void switchPage(String rootFxml, String rootFxmlLong, String rootCss ) {
		
		
				try {
					MovieDatabaseManager.setRoot(rootFxml);
				}
				catch (Exception ex) {
					// TODO: handle exception
				}
				BorderPane root;
				try {

					root = (BorderPane) FXMLLoader.load(getClass().getResource(rootFxmlLong));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource(rootCss).toExternalForm());
					Main.getPrimaryStage().setScene(scene);
					Main.getPrimaryStage().show();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
		
	}

}
