package com.bluesquare.app.board.dao;

import java.util.List;

import com.bluesquare.app.board.domain.CommentsDto;

public interface CommentsDao {

	int deleteAll(Integer bno) throws Exception;

	int count(Integer bno) throws Exception;

	int delete(Integer cno, String commenter) throws Exception;

	int insert(CommentsDto dto) throws Exception;

	List<CommentsDto> selectAll(Integer bno) throws Exception;

	CommentsDto select(Integer cno) throws Exception;

	int update(CommentsDto dto) throws Exception;

}