package com.bluesquare.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.ScheduleDto;
import com.bluesquare.app.domain.TicketDto;
import com.bluesquare.app.domain.TicketingJoinDto;
import com.bluesquare.app.service.TicketingService;

@Controller
@RequestMapping("/ticket")
public class TicketingController {

	@Autowired
	HttpSession session;
	
	@Autowired
	TicketingService service;
	
	//티켓 예매 처리
	@PostMapping("/ticketing")
	public String ticketing(TicketDto dto, Model m) {
		service.ticketing(dto);
		
		m.addAttribute("msg", "예매가 완료되었습니다!");
		m.addAttribute("url", "/app/ticket/ticketingList");
		
		return "alertPrint";
	}
	
	//공연 목록 Ajax 
	@ResponseBody
	@GetMapping("/performListAjax")
	public List<PerformDto> performListAjax() {

		List<PerformDto> list = service.performList();
		return list;
	}
	
	//공연 스케줄 Ajax
	@ResponseBody
	@GetMapping("/scheduleListAjax")
	public List<ScheduleDto> scheduleListAjax(Integer pno) {
		
		List<ScheduleDto> list = service.scheduleList(pno);
		
		return list;
	}
	
	//공연 목록
	@GetMapping("/performList")
	public String performList(Model m) {
		
		if(session.getAttribute("id") == null) {
			System.out.println("비로그인");
			m.addAttribute("msg", "로그인 후 예매할 수 있습니다.");
			m.addAttribute("url", "/app/login/login");
			
			return "alertPrint";
		}
		List<PerformDto> list = service.performList();
		
		m.addAttribute("list", list);
		
		return "performList";
	}
	
	//공연 일정 목록
	@GetMapping("/scheduleList")
	public String scheduleList(Integer pno, Model m) {
		
		List<ScheduleDto> list = service.scheduleList(pno);
		m.addAttribute("list", list);
		
		return "scheduleList";
	}
	
	//좌석 목록
	@GetMapping("/seatList")
	public String seatList(Integer sno, Model m) {
		List<Integer> list = service.reserved(sno);
		m.addAttribute("reserved", list);
		return "seatList";
	}
	
	//예매 내역
	@GetMapping("/ticketingList")
	public String ticketingList(Model m) {
		
		if(session.getAttribute("id") == null) {
			System.out.println("비로그인");
			m.addAttribute("msg", "로그인 후 확인할 수 있습니다.");
			m.addAttribute("url", "/app/login/login");
			
			return "alertPrint";
		}
		
		String id = (String)session.getAttribute("id");
		List<TicketingJoinDto> list = service.ticketingList(id);
		
		m.addAttribute("list", list);
		
		return "ticketingList";
	}
	
	//티켓팅 안내
	@GetMapping("/ticketingInfo")
	public String ticketingInfo(TicketingJoinDto dto, Integer tno, Model m) {
		dto = service.ticketingInfo(tno);
		m.addAttribute("dto", dto);
		return "ticketingInfo";
	}
	
	//티켓 예매 취소
	@PostMapping("/ticketCancle")
	public String ticketCancle(Integer tno, Model m) {
		
		service.TicketCancle(tno);
		
		String id = (String)session.getAttribute("id");
		List<TicketingJoinDto> list = service.ticketingList(id);
		m.addAttribute("list", list);
		return "redirect:/ticket/ticketingList";
	}
}