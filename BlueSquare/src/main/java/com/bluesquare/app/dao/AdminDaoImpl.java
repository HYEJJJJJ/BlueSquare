package com.bluesquare.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.PerformImgDto;
import com.bluesquare.app.domain.ScheduleDto;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	SqlSession session;
	
	String namespace = "com.bluesquare.app.AdminMapper.";
		
	//공연 등록
	@Override
	public int performReg(PerformDto dto) {
		return session.insert(namespace + "performReg", dto);
	}
	
	//공연 이미지 등록
	@Override
	public int performImgReg(PerformImgDto dto) {
		return session.insert(namespace + "performImgReg", dto);
	}
	
	//공연 정보 수정
	@Override
	public int performEdit(PerformDto dto) {
		return session.update(namespace + "performEdit", dto);
	}
	
	//공연 일정 추가
	@Override
	public int performScheReg(ScheduleDto dto) {
		return session.insert(namespace + "performScheReg", dto);
	}
	
	//공연 삭제
	@Override
	public int performDel(Integer pno) {
		return session.delete(namespace + "performDel", pno);
	}
}