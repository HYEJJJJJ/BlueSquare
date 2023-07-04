package com.bluesquare.app.notice.service;

import java.util.List;
import java.util.Map;

import com.bluesquare.app.board.domain.SearchCondition;
import com.bluesquare.app.notice.dto.NoticeBoardDto;

public interface NoticeBoardService {

	int getCount() throws Exception;

	int write(NoticeBoardDto dto) throws Exception;

	int modify(NoticeBoardDto dto) throws Exception;

	int remove(Integer bno, String writer) throws Exception;

	int removeAll() throws Exception;

	List<NoticeBoardDto> getList() throws Exception;

	NoticeBoardDto read(int bno) throws Exception;

	List<NoticeBoardDto> getpage(Map map) throws Exception;

	List<NoticeBoardDto> getSearchSelectPage(SearchCondition sc) throws Exception;

	int getSearchResultCnt(SearchCondition sc) throws Exception;

}
