package com.pepper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pepper.dao.BoardDAO;
import com.pepper.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 게시물 목록 조회
	@Override
	public List<BoardVO> list(int startPost, int postCnt) throws Exception {
		
		return dao.list(startPost, postCnt);
	}
	
	// 게시물 총 개수 구하기
	@Override
	public int listCnt(String searchType, String keyword) throws Exception {
		
		return dao.listCnt(searchType, keyword);
	}
	
	// 게시물 검색
	public List<BoardVO> listSearch(int startPost, int postCnt, String searchType, String keyword) throws Exception {
		
		return dao.listSearch(startPost, postCnt, searchType, keyword);
	}
	
	// 글 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);

	}

	// 글 상세 보기
	@Override
	public BoardVO view(int bno) throws Exception {
		
		return dao.view(bno);

	}
	
	// 조회수 카운트
	@Override
	public void viewCnt(int bno) throws Exception {
		
		dao.viewCnt(bno);

	}
	
	// 글 수정하기
	@Override
	public void edit(BoardVO vo) throws Exception {
		
		dao.edit(vo);

	}

	// 글 삭제하기
	@Override
	public void delete(int bno) throws Exception {
		
		dao.delete(bno);

	}

}
