package com.bluesquare.app.user.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluesquare.app.user.domain.UserDTO;
import com.bluesquare.app.user.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService service;
	
	//로그인
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//로그아웃
	@GetMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//로그인
	@PostMapping("/login")
	public String login(String id, String pw, String toURL, boolean rememberId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		//1. id와 pw를 확인
		System.out.println(id);
		System.out.println(pw);
		if(!loginCheck(id, pw)) {
			//2. 일치하지 않으면 login으로 이동
			String msg = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다.", "UTF-8");	
			return "redirect:/login/login?msg=" + msg;
		}
		//세션 객체를 얻어옴
		HttpSession session = request.getSession();
		session.setAttribute("id", id);		

		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:" + toURL;		
	}

	//로그인 확인
	private boolean loginCheck(String id, String pw) {
		
		try {
			UserDTO check = service.login(id, pw);
			
			if(check == null)
				throw new Exception("login Err");
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
}
