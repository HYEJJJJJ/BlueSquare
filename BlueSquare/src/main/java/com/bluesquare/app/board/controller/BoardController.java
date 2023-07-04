package com.bluesquare.app.board.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluesquare.app.board.domain.BoardDto;
import com.bluesquare.app.board.domain.PageHandler;
import com.bluesquare.app.board.domain.SearchCondition;
import com.bluesquare.app.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	//게시글 수정
	@PostMapping("/modify")
	public String modify(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session) {
		String writer = (String) session.getAttribute("id");
		
		boardDto.setWriter(writer);
		
		try {
			if (service.modify(boardDto) != 1)
				throw new Exception("Modify failed");
			
		rattr.addFlashAttribute("msg", "MOD_OK");
		
		return "redirect:/board/list";//주소를 이용하여 찾아가기
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			m.addAttribute("mode", "new"); //글쓰기 모드로 이동
			m.addAttribute("boardDto", boardDto);
			m.addAttribute("msg", "MOD_ERR");
			
			return "board"; //파일 위치 찾아가기
		}
			
	}
	
	//게시글 작성
	@GetMapping("/write")
	public String write(Model m, HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();
		m.addAttribute("mode", "new");
		return "board";
	}
	
	//게시글 작성
	@PostMapping("/write")
	public String write(BoardDto boardDto, RedirectAttributes rattr, Model m, HttpSession session, HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();
		String writer = (String) session.getAttribute("id");
		
		boardDto.setWriter(writer);
		
		try {
			if (service.write(boardDto) != 1)
				throw new Exception("Write failed");
			
		rattr.addFlashAttribute("msg", "WRT_OK");
		
		return "redirect:/board/list";//주소를 이용하여 찾아가기
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			m.addAttribute("mode", "new"); //글쓰기 모드로 이동
			m.addAttribute("boardDto", boardDto);
			m.addAttribute("msg", "WRT_ERR");
			
			return "board"; //파일 위치 찾아가기
		}
			
	}
	
	//게시글 삭제
	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session) {
		String writer = (String) session.getAttribute("id");
		
		try {
			m.addAttribute("page" , page);
			m.addAttribute("pageSize", pageSize);
			
		int rowCnt = service.remove(bno, writer);
		
		if(rowCnt != 1) {
			throw new Exception("remove error");
		}
			m.addAttribute("msg", "DEL_OK");
		
		} catch (Exception e) {		
			e.printStackTrace();
			m.addAttribute("msg","DEL_ERR");
		}
		return "redirect:/board/list";
	}
	
	//게시글 읽기
	@GetMapping("/read")
	public String read(Integer bno, Integer page, Integer pageSize, Model m) {
		try {
			BoardDto boardDto = service.read(bno);
			
			m.addAttribute(boardDto);
			
			m.addAttribute("page",page);
			m.addAttribute("pageSize", pageSize);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board";
	}

	
	//게시글 목록 불러오기
	@GetMapping("/list")
	public String list(SearchCondition sc, Model m, HttpServletRequest request) {
		
		//로그인 확인
		if(!loginCheck(request)) 
			return "redirect:/login/login?toURL="+request.getRequestURL();
		
		try {
			int totalCnt = service.getCount();
			
			PageHandler pageHandler = new PageHandler(totalCnt, sc);
			List<BoardDto> list = service.getSearchSelectPage(sc);
		
			m.addAttribute("list",list);
			m.addAttribute("ph", pageHandler);

			Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
			m.addAttribute("startOfToday", startOfToday.toEpochMilli());
		
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "List_ERR");
			m.addAttribute("totalCnt", 0);
		}
		return "boardList";
	}
	
	//로그인 여부 확인
	private boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
	
		return session.getAttribute("id") != null;
		
	}

}


	