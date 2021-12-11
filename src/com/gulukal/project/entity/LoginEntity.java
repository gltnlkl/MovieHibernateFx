package com.gulukal.project.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gulukal.project.control.LoginEntityController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
   
@Entity
@Table(name = "application_user")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long   id;
	private String mail;
	private String password;
	
	
	public boolean canLogin(LoginEntity loginUser) {
		LoginEntityController       controller = new LoginEntityController();
		Optional<LoginEntity> found      = controller.find(loginUser.getMail(), loginUser.getPassword());
		return found.isPresent();
	}

}
