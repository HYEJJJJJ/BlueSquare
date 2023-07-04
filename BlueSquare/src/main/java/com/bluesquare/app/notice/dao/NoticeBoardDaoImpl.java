package com.bluesquare.app.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluesquare.app.board.domain.SearchCondition;
import com.bluesquare.app.notice.dto.NoticeBoardDto;

@Repository
public class NoticeBoardDaoImpl implements NoticeBoardDao{

		@Autowired
		SqlSession session;
		
		String namespace = "com.bluesquare.app.notice.dao.NoticeBoardMapper.";
		
		//게시글 조회
		@Override
		public NoticeBoardDto select(int bno) throws Exception{
			return session.selectOne(namespace + "select", bno);
		}
		
		//게시글 수
		@Override
		public int count() throws Exception {
			return session.selectOne(namespace + "count");
		}
		
		//게시글 등록
		@Override
		public int insert(NoticeBoardDto dto) throws Exception {
			return session.insert(namespace + "insert", dto);
		}
		
		//게시글 수정
		@Override
		public int update(NoticeBoardDto dto) throws Exception {
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
		
		//게시글 목록 조회
		@Override
		public List<NoticeBoardDto> selectAll() throws Exception {
			return session.selectList(namespace + "selectAll");
		}
		
		//게시글 조회수 증가
		@Override
		public int increaseViewCnt(Integer bno) throws Exception {
			return session.update(namespace + "increaseViewCnt", bno);
		}
		
		//게시글 페이지
		@Override
		public List<NoticeBoardDto> selectPage(Map map) throws Exception {
			return session.selectList(namespace + "selectPage", map);
		}

		//게시글 검색시 페이지
		@Override
		public List<NoticeBoardDto> searchSelectPage(SearchCondition sc) throws Exception {
			return session.selectList(namespace + "searchSelectPage", sc);
		}

		//게시글 검색카운트
		@Override
		public int searchResultCnt(SearchCondition sc) throws Exception {
			return session.selectOne(namespace + "searchResultCnt", sc);
		}

	
}
