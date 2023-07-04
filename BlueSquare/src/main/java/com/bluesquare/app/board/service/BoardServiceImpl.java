package com.bluesquare.app.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesquare.app.board.dao.BoardDao;
import com.bluesquare.app.board.domain.BoardDto;
import com.bluesquare.app.board.domain.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	//게시글 수
	@Override
	public int getCount() throws Exception {
		return boardDao.count();
	}

	//게시글 등록
	@Override
	public int write(BoardDto dto) throws Exception {
		return boardDao.insert(dto);
		
	}

	//게시글 수정
	@Override
	public int modify(BoardDto dto) throws Exception {
		return boardDao.update(dto);
	}

	//게시글 삭제
	@Override
	public int remove(Integer bno, String writer) throws Exception {
		return boardDao.delete(bno, writer);
	}

	//게시글 전체 삭제
	@Override
	public int removeAll() throws Exception {
		return boardDao.deleteAll();
	}

	//게시글 전체 목록 조회
	@Override
	public List<BoardDto> getList() throws Exception {
		return boardDao.selectAll();
	}

	//게시글 읽기
	@Override
	public BoardDto read(int bno) throws Exception {
		BoardDto boardDto = boardDao.select(bno);
		boardDao.increaseViewCnt(bno);

		return boardDto;

	}

	//게시글 페이지
	@Override
	public List<BoardDto> getpage(Map map) throws Exception {
		return boardDao.selectPage(map);
	}

	@Override
	public List<BoardDto> getSearchSelectPage(SearchCondition sc) throws Exception {
	return boardDao.searchSelectPage(sc);
	}

	@Override
	public int getSearchResultCnt(SearchCondition sc) throws Exception {
	return boardDao.searchResultCnt(sc);
	}

}
