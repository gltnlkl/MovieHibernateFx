package com.gulukal.project.view.newUser;

import com.gulukal.project.view.util.UtilsForGui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewUserController {

	
	UtilsForGui util = new UtilsForGui();
 
	@FXML
	private TextField fldNewMail;

	@FXML
	private PasswordField fldNewPassword;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnNewUserCommit;

	@FXML
	void NewUserCreateAction(MouseEvent event) {

	}

	@FXML
	void cancelAction(MouseEvent event) {
		
		util.cancelAction();
		
	}

}
