package com.bluesquare.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesquare.app.dao.TicketingDao;
import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.PerformImgDto;
import com.bluesquare.app.domain.ScheduleDto;
import com.bluesquare.app.domain.TicketDto;
import com.bluesquare.app.domain.TicketingJoinDto;

@Service
public class TicketingServiceImpl implements TicketingService {

	@Autowired
	TicketingDao dao;
	
	//티켓 예매
	@Override
	public int ticketing(TicketDto dto) {
		return dao.ticketing(dto);
	}
	
	//공연 목록 확인
	@Override
	public List<PerformDto> performList(){
		return dao.performList();
	}
	
	//공연 이미지 목록
	@Override
	public List<PerformImgDto> performImgList(){
		return dao.performImgList();
	}
	
	//공연 일정 목록 확인
	@Override
	public List<ScheduleDto> scheduleList(int pno){
		return dao.scheduleList(pno);
	}
	
	//이미 예매 된 좌석 표시
	@Override
	public List<Integer> reserved(int sno){
		return dao.reserved(sno);
	}
	
	//공연 상세 정보
	@Override
	public PerformDto performDetail(int pno) {
		return dao.performDetail(pno);
	}
	
	//예매 목록
	@Override
	public List<TicketingJoinDto> ticketingList(String id){
		return dao.ticketingList(id);
	}
	
	//예매 상세 정보
	@Override
	public TicketingJoinDto ticketingInfo(int tno) {
		return dao.ticketingInfo(tno);
	}
	
	//예매 취소
	@Override
	public int TicketCancle(int tno) {
		return dao.ticketCancle(tno);
	}
}
