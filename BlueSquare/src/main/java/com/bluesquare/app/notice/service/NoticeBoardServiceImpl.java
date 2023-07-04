package com.bluesquare.app.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesquare.app.board.domain.SearchCondition;
import com.bluesquare.app.notice.dao.NoticeBoardDao;
import com.bluesquare.app.notice.dto.NoticeBoardDto;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	@Autowired
	NoticeBoardDao boardDao;

	//게시글 수
	@Override
	public int getCount() throws Exception {
		return boardDao.count();
	}

	//게시글 작성
	@Override
	public int write(NoticeBoardDto dto) throws Exception {
		return boardDao.insert(dto);
		
	}

	//게시글 수정
	@Override
	public int modify(NoticeBoardDto dto) throws Exception {
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

	//게시글 목록 조회
	@Override
	public List<NoticeBoardDto> getList() throws Exception {
		return boardDao.selectAll();
	}

	//게시글 읽기
	@Override
	public NoticeBoardDto read(int bno) throws Exception {
		NoticeBoardDto boardDto = boardDao.select(bno);
		boardDao.increaseViewCnt(bno);

		return boardDto;
	}

	//게시글 페이지 가져오기
	@Override
	public List<NoticeBoardDto> getpage(Map map) throws Exception {
		return boardDao.selectPage(map);
	}

	//게시글 검색 시 페이지 가져오기
	@Override
	public List<NoticeBoardDto> getSearchSelectPage(SearchCondition sc) throws Exception {
	return boardDao.searchSelectPage(sc);
	}

	//게시글 검색 카운트
	@Override
	public int getSearchResultCnt(SearchCondition sc) throws Exception {
	return boardDao.searchResultCnt(sc);
	}

}
