package com.bluesquare.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluesquare.app.board.dao.BoardDao;
import com.bluesquare.app.board.dao.CommentsDao;
import com.bluesquare.app.board.domain.CommentsDto;

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	CommentsDao commentsDao;
	
	@Autowired
	BoardDao boardDao;
	
	//댓글 가져오기
	@Override
	public int getCount(Integer bno) throws Exception {
		return commentsDao.count(bno);
	}
	
	//댓글 전체
	@Override
	public List<CommentsDto> getList(Integer bno) throws Exception {
		return commentsDao.selectAll(bno);
	}
	
	//댓글 조회
	@Override
	public CommentsDto read(Integer cno) throws Exception {
		return commentsDao.select(cno);
	}
	
	//댓글 수정
	@Override
	public int modify(CommentsDto commentsDto) throws Exception {
		return commentsDao.update(commentsDto);
	}
	
	//댓글 쓰기
	@Override
	@Transactional(rollbackFor = {Exception.class})
	  public int write(CommentsDto commentsDto) throws Exception {
	      boardDao.updateCommentsCnt(commentsDto.getBno(), 1);
	      return commentsDao.insert(commentsDto);
	  }
	
	//댓글 삭제
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public int remove(Integer cno, String commenter, Integer bno) throws Exception {
		int rowCnt = boardDao.updateCommentsCnt(bno, -1);
		System.out.println("updateCommentsCnt - rowCnt = " + rowCnt);
		
		rowCnt = commentsDao.delete(cno, commenter);
		System.out.println("rowCnt = " + rowCnt);
		return rowCnt;
	}
}






