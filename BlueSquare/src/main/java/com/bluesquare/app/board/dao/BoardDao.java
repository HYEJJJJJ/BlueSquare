package com.bluesquare.app.board.dao;

import java.util.List;
import java.util.Map;

import com.bluesquare.app.board.domain.BoardDto;
import com.bluesquare.app.board.domain.SearchCondition;

public interface BoardDao {

	BoardDto select(int bno) throws Exception;

	int count() throws Exception;

	int insert(BoardDto dto) throws Exception;

	int update(BoardDto dto) throws Exception;

	int delete(Integer bno, String writer) throws Exception;

	int deleteForAdmin(Integer bno) throws Exception;

	int deleteAll() throws Exception;

	List<BoardDto> selectAll() throws Exception;

	int increaseViewCnt(Integer bno) throws Exception;
	
	public List<BoardDto> selectPage(Map map) throws Exception;
	
	public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;
	
	public int searchResultCnt(SearchCondition sc) throws Exception;

	int updateCommentsCnt(Integer bno, int cnt);
}