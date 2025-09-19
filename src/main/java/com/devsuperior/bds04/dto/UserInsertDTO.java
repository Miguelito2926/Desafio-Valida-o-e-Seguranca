package com.devsuperior.bds04.dto;


import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.service.validation.UserInsertValid;

import java.io.Serial;
import java.io.Serializable;

@UserInsertValid
public class UserInsertDTO extends UserDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private String password;

	public UserInsertDTO () {
		super();
	}

	public UserInsertDTO(String password) {
		this.password = password;
	}

	public UserInsertDTO(User entity, String password) {
		super(entity);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
