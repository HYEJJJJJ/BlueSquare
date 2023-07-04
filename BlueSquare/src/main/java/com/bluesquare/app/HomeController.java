package com.bluesquare.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluesquare.app.domain.MainPerformDto;
import com.bluesquare.app.notice.dto.NoticeBoardDto;
import com.bluesquare.app.notice.service.NoticeBoardService;
import com.bluesquare.app.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	MainService service;
	
	@Autowired
	NoticeBoardService boardService;
	
	//인덱스 화면 처리
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//현재 공연-MainPerformDto 목록들 받아오기
		List<MainPerformDto> mainPerformDtoList = service.mainPerformList();
		model.addAttribute("perform", mainPerformDtoList);
		
		//공지사항 게시판-NoticeBoardDto 글 목록들 받아오기
		List<NoticeBoardDto> boardList;
		try {
			boardList = boardService.getList();
			model.addAttribute("list", boardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}

	
}
