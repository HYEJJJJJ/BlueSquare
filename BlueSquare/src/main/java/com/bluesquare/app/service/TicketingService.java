package com.bluesquare.app.service;

import java.util.List;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.PerformImgDto;
import com.bluesquare.app.domain.ScheduleDto;
import com.bluesquare.app.domain.TicketDto;
import com.bluesquare.app.domain.TicketingJoinDto;

public interface TicketingService {

	int ticketing(TicketDto dto);
	
	public List<PerformDto> performList();
	
	List<PerformImgDto> performImgList();

	List<ScheduleDto> scheduleList(int pno);

	PerformDto performDetail(int pno);

	List<TicketingJoinDto> ticketingList(String id);

	List<Integer> reserved(int sno);

	TicketingJoinDto ticketingInfo(int tno);

	int TicketCancle(int tno);

}