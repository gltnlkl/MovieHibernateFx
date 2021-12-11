package com.gulukal.project.view.login;

import java.io.IOException;

import com.gulukal.project.Main;
import com.gulukal.project.MovieDatabaseManager;
import com.gulukal.project.entity.LoginEntity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LoginViewController {
	@FXML
	private TextField     fldMail;
	@FXML
	private PasswordField fldPassword;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnCommit;

	@FXML
	void cancelAction(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	void commitAction(MouseEvent event) {
		String mail     = fldMail.getText();
		String password = fldPassword.textProperty().get();

		LoginEntity loginUser = new LoginEntity(0, mail, password);
		if (!loginUser.canLogin(loginUser)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Hata!");
			alert.setHeaderText("Girilen bilgiler yanlis");
//    		alert.setContentText("Girilen bilgiler yanlis");
			alert.show();
			fldMail.clear();
			fldPassword.clear();
		}
		else {
			try {
				MovieDatabaseManager.setRoot("view/main/MainView");
			}
			catch (Exception ex) {
				// TODO: handle exception
			}
			BorderPane root;
			try {

				root = (BorderPane) FXMLLoader.load(getClass().getResource("../../view/main/MainView.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("../../view/main/application.css").toExternalForm());
				Main.getPrimaryStage().setScene(scene);
				Main.getPrimaryStage().show();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}