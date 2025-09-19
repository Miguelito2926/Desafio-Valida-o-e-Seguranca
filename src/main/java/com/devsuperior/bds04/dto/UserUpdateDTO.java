package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.service.validation.UserUpdateValid;

import java.io.Serial;
import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO  extends UserDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
}
