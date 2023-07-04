package com.bluesquare.app.board.service;

import java.util.List;

import com.bluesquare.app.board.domain.CommentsDto;

public interface CommentsService {

	int getCount(Integer bno) throws Exception;

	List<CommentsDto> getList(Integer bno) throws Exception;

	CommentsDto read(Integer cno) throws Exception;

	int modify(CommentsDto commentsDto) throws Exception;

	int write(CommentsDto commentsDto) throws Exception;

	int remove(Integer cno, String commenter, Integer bno) throws Exception;

}