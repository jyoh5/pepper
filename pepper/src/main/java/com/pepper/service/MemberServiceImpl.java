package com.pepper.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pepper.dao.MemberDAO;
import com.pepper.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	// 회원가입
	@Override
	public void join(MemberVO vo) throws Exception {
		dao.join(vo);
	}

	// 로그인
	@Override
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		MemberVO login = dao.login(vo);
		
		HttpSession session = req.getSession();
		String referer = (String)session.getAttribute("referer");
				
		if(login == null) {
			session.setAttribute("login", null);
			rttr.addFlashAttribute("login_fail", "fail");			
			return "redirect:/member/login";
			
		} else {
			session.setAttribute("login", login);
			session.removeAttribute("referer");
			return "redirect:" + referer;
		}
		
		
		
	}

	// 비밀번호 수정
	@Override
	public void modifyPW(MemberVO vo, HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		dao.modifyPW(vo);
		
		login.setUserPW(vo.getUserPW());
	}

	// 정보 수정
	@Override
	public void modifyInfo(MemberVO vo, HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		dao.modifyInfo(vo);
		
		login.setUserName(vo.getUserName());
		login.setUserEmail(vo.getUserEmail());
		login.setUserNumber(vo.getUserNumber());

	}
	
	
	// 회원탈퇴
	@Override
	public String delete(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		MemberVO login = dao.login(vo);
		
		if(login == null) {
			rttr.addFlashAttribute("msg",false);
			return "redirect:/member/delete";
		} else {
			
			dao.delete(vo);
			session.invalidate();
			
			return "redirect:/";
		}
	
	}
	
	// 아이디 중복 확인
	@Override
	public String idCheck(String userID) throws Exception {
		
		return dao.idCheck(userID);
	}
	
	// 닉네임 중복 확인
	@Override
	public String nameCheck(String userName) throws Exception {
		
		return dao.nameCheck(userName);
	}

	// 비밀번호 일치 확인
	@Override
	public String pwCheck(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		return dao.pwCheck(login.getUserID());
	}
}
