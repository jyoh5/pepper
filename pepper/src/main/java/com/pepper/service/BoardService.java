package com.pepper.service;

import java.util.List;

import com.pepper.domain.BoardVO;

public interface BoardService {
	
	// 목록 조회
	public List<BoardVO> list(int startPost, int postCnt) throws Exception;
	
	// 게시글 총 개수 구하기
	public int listCnt(String searchType, String keyword) throws Exception;
	
	// 게시물 검색
	public List<BoardVO> listSearch(int startPost, int postCnt, String searchType, String keyword) throws Exception;
	
	// 글쓰기
	public void write(BoardVO vo) throws Exception;
	
	// 글 상세 보기
	public BoardVO view(int bno) throws Exception;
	
	// 조회수 수정하기
	public void viewCnt(int bno) throws Exception;
	
	// 글 수정하기
	public void edit(BoardVO vo) throws Exception;
	
	// 글 삭제하기
	public void delete(int bno) throws Exception;
}
