package com.bluesquare.app.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.board.domain.BoardDto;
import com.bluesquare.app.board.domain.SearchCondition;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.bluesquare.app.board.dao.BoardMapper.";
	
	//게시글 조회
	@Override
	public BoardDto select(int bno) throws Exception{
		return session.selectOne(namespace + "select", bno);
	}
	
	//게시글 수
	@Override
	public int count() throws Exception {
		return session.selectOne(namespace + "count");
	}
	
	//게시글 등록
	@Override
	public int insert(BoardDto dto) throws Exception {
		return session.insert(namespace + "insert", dto);
	}
	
	//게시글 수정
	@Override
	public int update(BoardDto dto) throws Exception {
		return session.update(namespace + "update", dto);
	}
	
	//게시글 삭제
	@Override
	public int delete(Integer bno, String writer) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("writer", writer);
		return session.delete(namespace + "delete", map);
	}
	
	@Override
	public int deleteForAdmin(Integer bno) throws Exception {
		return session.delete(namespace + "delete", bno);
	}
	
	//게시글 전체 삭제
	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}
	
	//게시글 전체 목록 조회
	@Override
	public List<BoardDto> selectAll() throws Exception {
		return session.selectList(namespace + "selectAll");
	}
	
	//게시글 조회수 증가
	@Override
	public int increaseViewCnt(Integer bno) throws Exception {
		return session.update(namespace + "increaseViewCnt", bno);
	}
	
	//게시글 페이지
	@Override
	public List<BoardDto> selectPage(Map map) throws Exception {
		return session.selectList(namespace + "selectPage", map);
	}

	@Override
	public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
		return session.selectList(namespace + "searchSelectPage", sc);
	}

	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
		return session.selectOne(namespace + "searchResultCnt", sc);
	}

	//게시글 댓글
	@Override
	public int updateCommentsCnt(Integer bno, int cnt) {
		System.out.println("upcnt 요청");
		Map map = new HashMap();
		map.put("cnt", cnt);
		map.put("bno", bno);
		return session.update(namespace + "updateCommentsCnt", map);
	}
}




