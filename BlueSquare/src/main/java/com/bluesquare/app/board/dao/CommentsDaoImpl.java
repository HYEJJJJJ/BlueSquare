package com.bluesquare.app.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.board.domain.CommentsDto;

@Repository
public class CommentsDaoImpl implements CommentsDao {

	@Autowired
	SqlSession session; 
	
	String namespace = "com.bluesquare.app.board.dao.CommentsMapper.";
	
	//댓글 전체 삭제
	@Override
	public int deleteAll(Integer bno) throws Exception{
		return session.delete(namespace + "deleteAll", bno);
	}
	
	//댓글 수
	@Override
	public int count(Integer bno) throws Exception {
		return session.selectOne(namespace + "count", bno);
	}
	
	//댓글 삭제
	@Override
	public int delete(Integer cno, String commenter) throws Exception {
		Map map = new HashMap();
		map.put("cno", cno);
		map.put("commenter", commenter);
		return session.delete(namespace + "delete", map);
	}
	
	//댓글 등록
	@Override
	public int insert(CommentsDto dto) throws Exception {
		return session.insert(namespace + "insert", dto);
	}
	
	//댓글 전체
	@Override
	public List<CommentsDto> selectAll(Integer bno) throws Exception {
		return session.selectList(namespace + "selectAll", bno);
	}
	
	//댓글 조회
	@Override
	public CommentsDto select(Integer cno) throws Exception {
		return session.selectOne(namespace + "select", cno);
	}
	
	//댓글 수정
	@Override
	public int update(CommentsDto dto) throws Exception {
		return session.update(namespace + "update", dto);
	}
}






