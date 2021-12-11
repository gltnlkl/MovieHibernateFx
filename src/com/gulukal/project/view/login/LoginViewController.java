package com.gulukal.project.view.login;

import com.gulukal.project.entity.LoginEntity;
import com.gulukal.project.view.util.UtilsForGui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginViewController {

	UtilsForGui util = new UtilsForGui();

	@FXML
	private TextField     fldMail;
	@FXML
	private PasswordField fldPassword;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnCommit;

	@FXML
	private Button btnNewUser;

	@FXML
	void cancelAction(MouseEvent event) {

		util.cancelAction();
	}

	@FXML
	void newUserAction(MouseEvent event) {

		String rootFxml     = "view/newUser/NewUserView";
		String rootFxmlLong = "../../view/newUser/NewUserView.fxml";
		String rootCss      = "../../view/main/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);
	}

	@FXML
	void commitAction(MouseEvent event) {

		String rootFxml     = "view/main/MainView";
		String rootFxmlLong = "../../view/main/MainView.fxml";
		String rootCss      = "../../view/main/application.css";

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

			util.switchPage(rootFxml, rootFxmlLong, rootCss);
		}
	}
}