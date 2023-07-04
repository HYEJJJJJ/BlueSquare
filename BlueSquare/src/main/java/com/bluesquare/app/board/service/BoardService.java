package com.bluesquare.app.board.service;

import java.util.List;
import java.util.Map;

import com.bluesquare.app.board.domain.BoardDto;
import com.bluesquare.app.board.domain.SearchCondition;

public interface BoardService {

	int getCount() throws Exception;

	int write(BoardDto dto) throws Exception;

	int modify(BoardDto dto) throws Exception;

	int remove(Integer bno, String writer) throws Exception;

	int removeAll() throws Exception;

	List<BoardDto> getList() throws Exception;

	BoardDto read(int bno) throws Exception;

	List<BoardDto> getpage(Map map) throws Exception;
	
	List<BoardDto> getSearchSelectPage(SearchCondition sc) throws Exception;

	int getSearchResultCnt(SearchCondition sc) throws Exception;

}