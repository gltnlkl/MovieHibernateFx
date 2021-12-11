package com.gulukal.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	public static Stage primaryStage;

	public static void main(String[] args) {

		// MainMethod mainMethod = new MainMethod();

		// mainMethod.addMovie();

		// mainMethod.findMovieById();

		// mainMethod.findMovieByTitle();

		// mainMethod.loginUser();

		launch(args);
	}

	// javafx bilgileri burada bulunuyor

	@Override

	public void start(Stage primary) throws Exception {

		try {
			Main.primaryStage = primary;
			BorderPane root  = (BorderPane) FXMLLoader.load(getClass().getResource("view/login/LoginView.fxml"));
			Scene      scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("view/main/application.css").toExternalForm());
			primary.setScene(scene);
			primary.alwaysOnTopProperty();
			primary.centerOnScreen();
			primary.initStyle(StageStyle.UNDECORATED);
			primary.setResizable(false);
			primary.show();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Stage getPrimaryStage() {
		return Main.primaryStage;
	}

}