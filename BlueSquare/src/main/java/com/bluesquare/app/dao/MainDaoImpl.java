package com.bluesquare.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.domain.MainPerformDto;

@Repository
public class MainDaoImpl implements MainDao{

	@Autowired
	SqlSession session;
	
	String namespace = "com.bluesquare.app.MainMapper.";
	
	//전체 공연 목록 조회
	@Override
	public List<MainPerformDto> mainPerformList(){
		return session.selectList(namespace + "mainPerformList");
	}

	//전체 공연 조회
	@Override
	public MainPerformDto select(int pno) throws Exception {
		return session.selectOne(namespace + "select", pno);
	}
}