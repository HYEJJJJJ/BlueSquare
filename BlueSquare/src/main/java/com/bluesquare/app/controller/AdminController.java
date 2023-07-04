package com.bluesquare.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.ScheduleDto;
import com.bluesquare.app.service.AdminService;
import com.bluesquare.app.service.TicketingService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	HttpSession session;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	TicketingService ticketingService;
	
	//관리자 전용 페이지
	@GetMapping("/home")
	public String home() {
		if("admin".equals(session.getAttribute("id"))) {
			return "/admin/adminHome";			
		}
		return "index";
	}
	
	//공연 등록
	@GetMapping("/performReg")
	public String performReg() {
		if("admin".equals(session.getAttribute("id"))) {
		return "/admin/performReg";
		}
		return "index";
	}
	
	//공연 등록 처리
	@PostMapping("/performReg")
	public String performReg(PerformDto dto, @RequestParam(value="performImg", required = false) MultipartFile performImg) throws IllegalStateException, IOException {
		adminService.performReg(dto);
		adminService.performImgReg(performImg);
		return "redirect:/admin/performManagement";
	}
	

	//공연 수정 페이지
	@PostMapping("/performEditPage")
	public String performEditPage(PerformDto dto, Model m) {
		m.addAttribute("dto", dto);
		return "/admin/performEdit";
	}
	
	//공연 수정 처리
	@PostMapping("/performEdit")
	public String performEdit(PerformDto dto, Model m) {
		adminService.performEdit(dto);
		m.addAttribute("pno", dto.getPno());
		return "redirect:/admin/performManagementDetail";
	}
	
	//공연 삭제 처리
	@PostMapping("performDel")
	public String performDel(Integer pno) {
		adminService.performDel(pno);
		return "redirect:/admin/performManagement";
	}
	
	//공연 일정 등록 처리
	@PostMapping("/performScheReg")
	public String performScheReg(ScheduleDto dto, Model m) {
		adminService.performScheReg(dto);
		m.addAttribute("pno", dto.getPno());
		return "redirect:/admin/performManagementDetail";
	}
	
	//공연 관리 페이지
	@GetMapping("/performManagement")
	public String performManagement(Model m) {
		List<PerformDto> list = ticketingService.performList();
		m.addAttribute("list", list);
		return "/admin/performManagement";
	}
	
	//공연 상세정보 페이지
	@GetMapping("/performManagementDetail")
	public String performManagementDetail(Integer pno, Model m) {
		List<ScheduleDto> list = ticketingService.scheduleList(pno);
		PerformDto dto = ticketingService.performDetail(pno);
		m.addAttribute("list", list);
		m.addAttribute("performDto", dto);
		m.addAttribute("pno", pno);
		return "/admin/performManagementDetail";
	}

}