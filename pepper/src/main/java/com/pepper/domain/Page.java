package com.pepper.domain;

public class Page {
	
	// 현재 페이지 번호
	private int num;
	
	// 게시물 총 개수
	private int listCnt; // = service.listCnt();
	
	// 한 페이지에 출력할 게시물 개수
	private int postCnt = 5;
	
	// 마지막 페이지 번호
	private int lastPageNum; // = (int)Math.ceil((double)listCnt/postCnt);
	
	// 현재 페이지에서 출력할 첫번째 게시물 (매개변수 num = 현재 페이지 번호)
	private int startPost; // = (num - 1) * postCnt;
	
	// 한번에 표시할 페이지 개수
	private int pageNumCnt = 5;

	// 한번에 표시할 페이지 중 마지막 번호
	private int endPageNum; // = (int)(Math.ceil((double)num/pageNumCnt) * pageNumCnt);
	
	// 한번에 표시할 페이지 중 첫 번째 번호
	private int startPageNum; // = endPageNum - (pageNumCnt - 1);
	
	// 이전, 다음페이지
	private boolean prev; // = startPageNum == 1 ? false : true;
	private boolean next; // = endPageNum == lastPageNum ? false : true;
	
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
		dataCal();
	}
	public int getNum() {
		return num;
	}
	public int getListCnt() {
		return listCnt;
	}
	public int getPostCnt() {
		return postCnt;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public int getStartPost() {
		return startPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	
	
	private void dataCal() {
		// 마지막 페이지 번호
		lastPageNum = (int)Math.ceil((double)listCnt/postCnt);
		
		// 현재 페이지에서 출력할 첫번째 게시물 (매개변수 num = 현재 페이지 번호)
		startPost = (num - 1) * postCnt;
		
		// 한번에 표시할 페이지 중 마지막 번호
		endPageNum = (int)(Math.ceil((double)num/pageNumCnt) * pageNumCnt);
		
		// 한번에 표시할 페이지 중 첫 번째 번호
		startPageNum = endPageNum - (pageNumCnt - 1);
		
		// 한번에 표시할 페이지 중 마지막 번호 다시 계산!! (5의 배수가 아닌 경우) 
		if (lastPageNum < endPageNum) {
			endPageNum = lastPageNum;
		}
		// 이전, 다음페이지
		prev = startPageNum == 1 ? false : true;
		next = endPageNum == lastPageNum ? false : true;

	}
	
}
