package com.bluesquare.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	//회원가입 페이지로 이동
	@GetMapping("/sign")
	public String sign() {
		return "sign";
	}
}