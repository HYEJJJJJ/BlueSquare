package com.bluesquare.app.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.user.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.bluesquare.app.user.dao.UserMapper.";
	
	//회원 가입
	@Override
	public int sign(UserDTO dto) throws Exception {
		return session.insert(namespace + "sign", dto);
	}

	//아이디 중복확인
	@Override
	public int idOverlap(UserDTO dto) throws Exception {
		return session.selectOne(namespace + "idOverlap", dto);
	}

	//로그인
	@Override
	public UserDTO login(String id, String pw) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("pw", pw);
		
		return session.selectOne(namespace + "login", map);
	}
}
