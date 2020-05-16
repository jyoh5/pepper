package com.pepper.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pepper.domain.MemberVO;
import com.pepper.domain.PepperCntResultVO;
import com.pepper.domain.PepperCntVO;
import com.pepper.service.PepperService;

@Controller
@RequestMapping("/pepper/*")
public class PepperController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	PepperService service;
	
	// 분석 메뉴로 이동
	@RequestMapping(value="/analysis", method=RequestMethod.GET)
	public String getAnalysis(HttpServletRequest req) throws Exception {
		
		logger.info("get analysis");
		
		
		
		MemberVO login = (MemberVO)req.getSession().getAttribute("login");
		if (login != null) {
			return "pepper/analysis";
		} else {
			return "redirect:/pepper/alert?page=analysis";
		}

	}
	
	// 통계 메뉴로 이동
	@RequestMapping(value="/statistics", method=RequestMethod.GET)
	public String getStatistics(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get statistics");
		
		MemberVO login = (MemberVO)req.getSession().getAttribute("login");
		if (login != null) {
			return "pepper/statistics";
		} else {			
			return "redirect:/pepper/alert?page=statistics";
		}
		
		
	}
	
	// alert 페이지로 이동
	@RequestMapping(value="/alert", method=RequestMethod.GET)
	public void getAlert(Model model, @RequestParam("page") String page) throws Exception {
		
		logger.info("get alert");
		
		model.addAttribute("page", page);
		

	}
	
	// 전체 수확량
	@ResponseBody
	@RequestMapping(value="/pepperStat", method=RequestMethod.POST)
	public PepperCntResultVO getCnt(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get cnt");
		
		List<PepperCntVO> today = service.todayCnt(req);
		List<PepperCntVO> total = service.totalCnt(req);
		List<PepperCntVO> year = service.yearCnt(req);
		List<PepperCntVO> week = service.weekCnt(req);
		String[] price = service.price();
		
		PepperCntResultVO result = new PepperCntResultVO();
		
		result.setToday(today);
		result.setTotal(total);
		result.setYear(year);
		result.setWeek(week);
		result.setPrice(price);
		
		
		return result;
	}

	// 오늘 수확량
	@ResponseBody
	@RequestMapping(value="/today", method=RequestMethod.POST)
	public PepperCntResultVO getTodayCnt(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get todayCnt");
		
		List<PepperCntVO> today = service.todayCnt(req);
		
		PepperCntResultVO result = new PepperCntResultVO();
		
		result.setToday(today);		
		
		return result;
	}
	
	// 누적 수확량
	@ResponseBody
	@RequestMapping(value="/total", method=RequestMethod.POST)
	public PepperCntResultVO getTotalCnt(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get totalCnt");
		
		List<PepperCntVO> total = service.totalCnt(req);
		
		PepperCntResultVO result = new PepperCntResultVO();
		
		result.setTotal(total);
		
		return result;
	}
	
	// 연간 수확량
	@ResponseBody
	@RequestMapping(value="/year", method=RequestMethod.POST)
	public PepperCntResultVO getYearCnt(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get yearCnt");
		
		List<PepperCntVO> year = service.yearCnt(req);
		
		PepperCntResultVO result = new PepperCntResultVO();
		
		result.setYear(year);
		
		return result;
	}
	
	// 주간 수확량
	@ResponseBody
	@RequestMapping(value="/week", method=RequestMethod.POST)
	public PepperCntResultVO getWeekCnt(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get weekCnt");
		
		List<PepperCntVO> week = service.weekCnt(req);
		
		PepperCntResultVO result = new PepperCntResultVO();
		
		result.setWeek(week);
		
		return result;
	}
	
	// 가격
	@ResponseBody
	@RequestMapping(value="/price", method=RequestMethod.POST)
	public PepperCntResultVO getPrice(HttpServletRequest req, Model model) throws Exception {
		
		logger.info("get price");
		
		String[] price = service.price();
		
		PepperCntResultVO result = new PepperCntResultVO();
		
		result.setPrice(price);
		
		return result;
	}
}
