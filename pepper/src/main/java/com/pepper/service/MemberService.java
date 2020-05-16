package com.pepper.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pepper.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void join(MemberVO vo) throws Exception;
	
	// 로그인
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception;
	
	// 비밀번호 수정
	public void modifyPW(MemberVO vo, HttpServletRequest req) throws Exception;
	
	// 정보 수정
	public void modifyInfo(MemberVO vo, HttpServletRequest req) throws Exception;

	// 회원 탈퇴
	public String delete(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception;
	
	// 아이디 중복 확인
	public String idCheck(String userID) throws Exception;
	
	// 닉네임 중복 확인
	public String nameCheck(String userName) throws Exception;
	
	// 비밀번호 중복 확인
	public String pwCheck(HttpServletRequest req) throws Exception;
}
