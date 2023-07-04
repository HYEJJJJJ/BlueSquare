package com.bluesquare.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

	@Autowired
	HttpSession session;
	
	//티켓 예매 페이지로 이동
	@GetMapping("/ticketing")
	public String ticketing(Model m) {
		if(session.getAttribute("id") == null) {
			System.out.println("비로그인");
			m.addAttribute("msg", "로그인 후 예매할 수 있습니다.");
			m.addAttribute("url", "/app/login/login");
			
			return "alertPrint";
		}
		return "ticketing";
	}
	
	//소개 페이지
	@GetMapping("/introduce")
	public String introduce() {
		return "/page/1_1_introduce";
	}
	
	//편의시설 페이지
	@GetMapping("/convenience")
	public String convenience() {
		return "/page/1_2_convenience";
	}
	
	//좌석 페이지
	@GetMapping("/seatInfo")
	public String seatInfo() {
		return "/page/1_3_seatInfo";
	}

	//오시는 길 페이지
	@GetMapping("/guideMap")
	public String guideMap() {
		return "/page/1_4_guideMap";
	}
	
	//대관안내 페이지
	@GetMapping("/rental")
	public String rental() {
		return "/page/3_1_rental";
	}
	
	//대관료 페이지
	@GetMapping("/rentalP")
	public String rentalP() {
		return "/page/3_2_rentalP";
	}
	
	//QNA 페이지
	@GetMapping("/qna")
	public String qna() {
		return "/page/4_2_qna";
	}
	

}