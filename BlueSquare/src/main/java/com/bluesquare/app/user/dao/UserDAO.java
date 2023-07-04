package com.bluesquare.app.user.dao;

import com.bluesquare.app.user.domain.UserDTO;


public interface UserDAO {

	int sign(UserDTO dto) throws Exception;
	
	int idOverlap(UserDTO dto) throws Exception;
	
	UserDTO login(String id, String pw) throws Exception;
}