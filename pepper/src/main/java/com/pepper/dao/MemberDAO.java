package com.pepper.dao;

import com.pepper.domain.MemberVO;

public interface MemberDAO {

	// 회원가입
	public void join(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 비밀번호 수정
	public void modifyPW(MemberVO vo) throws Exception;
	
	// 정보 수정
	public void modifyInfo(MemberVO vo) throws Exception;
	
	// 회원 탈퇴
	public void delete(MemberVO vo) throws Exception;
	
	// 아이디 중복 확인
	public String idCheck(String userID) throws Exception;
	
	// 닉네임 중복 확인
	public String nameCheck(String userName) throws Exception;
	
	// 비밀번호 중복 확인
	public String pwCheck(String userID) throws Exception;
}
