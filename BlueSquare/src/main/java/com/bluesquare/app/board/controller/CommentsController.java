package com.bluesquare.app.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluesquare.app.board.domain.CommentsDto;
import com.bluesquare.app.board.service.CommentsService;

//@ResponseBody : view가 아닌 Json형식의 값을 응답할 때 사용하는 어노테이션
//@Controller
@RestController    //@ResponseBody+@Controller
public class CommentsController {
	
	@Autowired
	CommentsService service;
	
	//댓글 수정하는 메서드
	//@ResponseBody
	@PatchMapping("/comments/{cno}") //   /comments/3
	public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody CommentsDto dto, HttpSession session) {
		
		String commenter = (String) session.getAttribute("id");
		
		dto.setCno(cno);
		dto.setCommenter(commenter);
		
		try {
			if (service.modify(dto) != 1) {
				throw new Exception("comment modify Failed.");
			}
			
			return new ResponseEntity("MOD_OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MOD_ERR", HttpStatus.BAD_REQUEST);
			
		}
	}
	
		//댓글 등록하는 메서드
		//@ResponseBody
		@PostMapping("/comments") //post   /comments?bno=811
		public ResponseEntity<String> write(@RequestBody CommentsDto dto, Integer bno, HttpSession session) {
			
			String commenter = (String) session.getAttribute("id");
			
			dto.setCommenter(commenter);
			dto.setBno(bno);
			
			try {
				 if (service.write(dto) != 1) {
					throw new Exception("comment write Failed.");
				}				
				return new ResponseEntity("WRT_OK", HttpStatus.OK);
				
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("WRT_ERR", HttpStatus.BAD_REQUEST);
				
			}
		}
		
		//댓글 삭제하는 메서드
		@DeleteMapping("/comments/{cno}")  //    /comments/1?bno=811
		public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session) {
			
			String commenter= (String) session.getAttribute("id");
			
			try {
				int rowCnt = service.remove(cno, commenter, bno);
				
				if (rowCnt != 1) 
					throw new Exception("Comments Delete Failed");
				
				return new ResponseEntity("DEL_OK", HttpStatus.OK);
				
			} catch (Exception e) {
				e.printStackTrace();		
				return new ResponseEntity("DEL_ERR", HttpStatus.BAD_REQUEST);
				
			}
		}
		
		//comments 목록을 반환하는 메서드
		//@ResponseBody  //뷰(jsp)가 아닌 다른 값으로 리턴하고자 할 때 사용하는 어노테이션
		@GetMapping("/comments")  //   /comments?bno=100
		public ResponseEntity<List<CommentsDto>> list(Integer bno){
			
			List<CommentsDto> list = null;
			
			try {
				list = service.getList(bno);				
				return new ResponseEntity<List<CommentsDto>>(list, HttpStatus.OK);
				
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<List<CommentsDto>>(HttpStatus.BAD_REQUEST);
				
			}
	
		}
}