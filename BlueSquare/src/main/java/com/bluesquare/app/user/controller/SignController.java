package com.bluesquare.app.user.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluesquare.app.user.domain.UserDTO;
import com.bluesquare.app.user.service.UserService;



@Controller
public class SignController {
	
	@Autowired
	UserService service;
	
	//회원가입 화면 출력
	@GetMapping("/sign/add")
	public String sign() {
		return "sign";
	}
	
	//회원가입 처리
	@PostMapping("/sign/save")
	public String save(UserDTO dto, Model m) throws Exception {
		
		if(!isValid(dto)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/sign/add";
		}
		
		service.sign(dto);
		
		m.addAttribute("msg", "회원가입이 완료되었습니다.");
		m.addAttribute("url", "/app");
		
		return "alertPrint";
	}

	//아이디 중복체크
	@ResponseBody
	@PostMapping("/sign/idOverlap")
	public int idOverlap(UserDTO dto) throws Exception {
		int result = service.idOverlap(dto);
		return result;
	}
	
	private boolean isValid(UserDTO dto) {
		return true;
	}
}