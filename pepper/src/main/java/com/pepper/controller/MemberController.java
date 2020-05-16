package com.pepper.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pepper.domain.MemberVO;
import com.pepper.controller.MemberController;
import com.pepper.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	
	
	// ========================= 로그인 ========================= 
	// 로그인 get (로그인 페이지로 이동)
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void getLogin(HttpServletRequest req) throws Exception {
		
		logger.info("get Login");
		
		HttpSession session = req.getSession();
		
		String referer = req.getHeader("Referer").substring(25);
		
		if (referer.contains("join")) {
			session.setAttribute("referer", "/");
		} else if (referer.contains("login")) {
			
		} else if (referer.contains("analysis")) {
			session.setAttribute("referer", "/pepper/analysis");
		} else if (referer.contains("statistics")) {
			session.setAttribute("referer", "/pepper/statistics");
		} else {
			session.setAttribute("referer", referer);
		}
		
	}
	
	// 로그인 post
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String postLogin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		logger.info("post login");
		
		String result = service.login(vo, req, rttr);		
		
		return result;		
		
	}
	
	// ========================= 로그아웃 ========================= 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String getLogout(HttpSession session, HttpServletRequest req) throws Exception {
		
		logger.info("get logout");
		session.invalidate();
		
		return "redirect:/";
	}

	// ========================= 회원가입 =========================
	// 회원가입 get (회원가입 페이지로 이동)
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public void getJoin() throws Exception {
		
		logger.info("get join");
	}
	
	// 회원가입 post
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String postJoin(MemberVO vo) throws Exception {
		logger.info("post join");
		
		service.join(vo);
		
		return "redirect:/member/login";
	}
	
	// 회원가입 시 아이디 중복 확인
	@ResponseBody
	@RequestMapping(value = "/idCheck", method=RequestMethod.POST)
	public int postIDCheck(HttpServletRequest req) throws Exception {
		
		logger.info("post idCheck");
		
		String userID = req.getParameter("userID");
		String idCheck = service.idCheck(userID);
				
		int result = 0;
		
		if(idCheck != null) {
			result = 1;
		}
		
		return result;
	}
	
	// 회원가입 시 닉네임 중복 확인
	@ResponseBody
	@RequestMapping(value = "/nameCheck", method=RequestMethod.POST)
	public int postNameCheck(HttpServletRequest req) throws Exception {
		
		logger.info("post nameCheck");
		
		String userName = req.getParameter("userName");
		String nameCheck = service.nameCheck(userName);
		
		int result = 0;
		
		if(nameCheck != null) {
			result = 1;
		}
		
		return result;
	}
	
	
	// ========================= settings =========================
		// settings get (settings 페이지로 이동)
		@RequestMapping(value="/settings", method=RequestMethod.GET)
		public void getSettings() throws Exception {
			
			logger.info("get settings");		
		}
	
	
	
	
	// ========================= 비밀번호 수정 =========================
	// 비밀번호 수정 get (비밀번호 수정 페이지로 이동)
	@RequestMapping(value="/modifyPW", method=RequestMethod.GET)
	public void getModifyPW() throws Exception {
		
		logger.info("get modifyPW");		
	}
	
	// 비밀번호 수정 post
	@RequestMapping(value="/modifyPW", method=RequestMethod.POST)
	public String postModify(MemberVO vo, HttpServletRequest req) throws Exception {
		
		logger.info("post modifyPW");
		service.modifyPW(vo, req);
		return "redirect:/";
	}
		
	// 비밀번호 수정 시 기존 비밀번호 확인
	@ResponseBody
	@RequestMapping(value = "/pwCheck", method=RequestMethod.POST)
	public int postPWCheck(HttpServletRequest req) throws Exception {
		
		logger.info("post pwCheck");
		
		String userPW = req.getParameter("userPW");
		String pwCheck = service.pwCheck(req);
		
		int result = 0;
		
		if(userPW.equals(pwCheck)) {
			result = 1;
		}
	
		return result;
	}
	
	// ========================= 정보 수정 =========================
	// 정보 수정 get (정보 수정 페이지로 이동)
	@RequestMapping(value="/modifyInfo", method=RequestMethod.GET)
	public void getModifyInfo() throws Exception {
		
		logger.info("get modifyInfo");		
	}
	
	// 정보 수정 post
	@RequestMapping(value="/modifyInfo", method=RequestMethod.POST)
	public String postModifyInfo(MemberVO vo, HttpServletRequest req) throws Exception {
		
		logger.info("post modifyInfo");
		service.modifyInfo(vo, req);
		return "redirect:/";
	}
	
	
	// ========================= 회원탈퇴 =========================
	// 회원탈퇴 get (회원탈퇴 페이지로 이동)
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public void getDelete() throws Exception {
		
		logger.info("get delete");		
	}
	
	// 회원탈퇴 post
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String postDelete(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		logger.info("post delete");	
		
		return service.delete(vo, req, rttr);
	}
	
}