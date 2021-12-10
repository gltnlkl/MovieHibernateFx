package com.gulukal.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		MainMethod mainMethod = new MainMethod();

//		mainMethod.addMovie();
		
		mainMethod.findMovieById();
		
//		mainMethod.findMovieByTitle();

		launch(args);
	}

	// javafx bilgileri burada bulunuyor

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			BorderPane root  = (BorderPane) FXMLLoader.load(getClass().getResource("MovieDB.fxml"));
			Scene      scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}