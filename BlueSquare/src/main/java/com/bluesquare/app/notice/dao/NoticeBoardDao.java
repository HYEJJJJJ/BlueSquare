package com.bluesquare.app.notice.dao;

import java.util.List;
import java.util.Map;

import com.bluesquare.app.board.domain.SearchCondition;
import com.bluesquare.app.notice.dto.NoticeBoardDto;

public interface NoticeBoardDao {

	NoticeBoardDto select(int bno) throws Exception;

	int count() throws Exception;

	int insert(NoticeBoardDto dto) throws Exception;

	int update(NoticeBoardDto dto) throws Exception;

	int delete(Integer bno, String writer) throws Exception;

	int deleteForAdmin(Integer bno) throws Exception;

	int deleteAll() throws Exception;

	List<NoticeBoardDto> selectAll() throws Exception;

	int increaseViewCnt(Integer bno) throws Exception;

	List<NoticeBoardDto> selectPage(Map map) throws Exception;

	List<NoticeBoardDto> searchSelectPage(SearchCondition sc) throws Exception;

	int searchResultCnt(SearchCondition sc) throws Exception;

}
