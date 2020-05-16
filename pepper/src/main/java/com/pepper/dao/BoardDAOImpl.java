package com.pepper.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pepper.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.pepper.mappers.board";
	
	// 게시물 목록 조회
	@Override
	public List<BoardVO> list(int startPost, int postCnt) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("startPost", startPost);
		data.put("postCnt", postCnt);
		
		
		return sql.selectList(namespace + ".list", data);

	}
	
	// 게시물 총 개수 구하기
	@Override
	public int listCnt(String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectOne(namespace + ".listCnt", data);

	}
	
	// 게시물 검색
	@Override
	public List<BoardVO> listSearch(int startPost, int postCnt, String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("startPost", startPost);
		data.put("postCnt", postCnt);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace + ".listSearch", data);

	}
	
	// 글 쓰기
	@Override
	public void write(BoardVO vo) throws Exception {
		
		sql.insert(namespace + ".write", vo);

	}

	// 글 상세 보기
	@Override
	public BoardVO view(int bno) throws Exception {
		
		return sql.selectOne(namespace + ".view", bno);

	}
	
	// 조회수 카운트
	@Override
	public void viewCnt(int bno) throws Exception {
		
		sql.update(namespace + ".viewCnt", bno);

	}
	
	// 글 수정하기
	@Override
	public void edit(BoardVO vo) throws Exception {
		
		sql.update(namespace + ".edit", vo);

	}

	// 글 삭제하기
	@Override
	public void delete(int bno) throws Exception {
		
		sql.delete(namespace + ".delete", bno);

	}

}
