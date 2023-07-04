package com.bluesquare.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.PerformImgDto;
import com.bluesquare.app.domain.ScheduleDto;
import com.bluesquare.app.domain.TicketDto;
import com.bluesquare.app.domain.TicketingJoinDto;

@Repository
public class TicketingDaoImpl implements TicketingDao {

	@Autowired
	SqlSession session;
	
	String namespace = "com.bluesquare.app.TicketMapper.";
	
	//티켓 예매
	@Override
	public int ticketing(TicketDto dto) {
		return session.insert(namespace + "ticketing", dto);
	}
	
	//공연 목록 확인
	@Override
	public List<PerformDto> performList() {
		return session.selectList(namespace + "performList");
	}
	
	//공연 이미지 목록
	@Override
	public List<PerformImgDto> performImgList() {
		return session.selectList(namespace + "performImgList");
	}
	
	//공연 일정 목록 확인
	@Override
	public List<ScheduleDto> scheduleList(int pno){
		return session.selectList(namespace + "scheduleList", pno);
	}
	
	//이미 예매 된 좌석 표시
	@Override
	public List<Integer> reserved(int sno){
		return session.selectList(namespace + "reserved", sno);
	}
	
	//공연 상세 정보
	@Override
	public PerformDto performDetail(int pno) {
		return session.selectOne(namespace + "performDetail", pno);
	}
	
	//예매 목록
	@Override
	public List<TicketingJoinDto> ticketingList(String id) {
		return session.selectList(namespace + "ticketingList", id);
	}
	
	//예매 상세 정보
	@Override
	public TicketingJoinDto ticketingInfo(int tno) {
		return session.selectOne(namespace + "ticketingInfo", tno);
	}
	
	//예매 취소
	@Override
	public int ticketCancle(int tno) {
		return session.delete(namespace + "ticketCancle", tno);
	}
}
