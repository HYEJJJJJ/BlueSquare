package com.bluesquare.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesquare.app.user.dao.UserDAO;
import com.bluesquare.app.user.domain.UserDTO;

@Service 
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	//회원 가입
	public int sign(UserDTO dto) throws Exception {
		return dao.sign(dto);
	}

	//아이디 중복확인
	@Override
	public int idOverlap(UserDTO dto) throws Exception{
		return dao.idOverlap(dto);
	}

	//로그인
	@Override
	public UserDTO login(String id, String pw) throws Exception {
		return dao.login(id, pw);
	}
	
}
