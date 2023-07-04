package com.bluesquare.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluesquare.app.domain.MainPerformDto;
import com.bluesquare.app.service.MainService;

@Controller
@RequestMapping("/perform")
public class PerformController {
	
	@Autowired
	MainService service;
	
	//전체 공연 목록
	@GetMapping("/all")
	public String performAll(MainPerformDto dto, Model model) {
	    List<MainPerformDto> list = service.mainPerformList();
	    model.addAttribute("performList", list);  // performList라는 이름으로 List 데이터를 추가
	    return "performAll";
	}
	
	
	//공연 상세정보
	 @GetMapping("/detail")
	 public String read(@RequestParam("pno") Integer pno, Model model) {
	    try {
	    	List<MainPerformDto> list = service.mainPerformList();
	    	model.addAttribute("performList", list); 
	    	    
	    	MainPerformDto mainPerformDto = service.read(pno);
	    	
	    	model.addAttribute("perform", mainPerformDto);
	    	model.addAttribute("pno", pno);
	    } catch (Exception e) {
	    		e.printStackTrace();
	    }
	    	
	    	return "performDetail";
	    }
	
	
}
