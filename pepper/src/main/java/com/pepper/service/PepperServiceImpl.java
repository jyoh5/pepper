package com.pepper.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.pepper.dao.PepperDAO;
import com.pepper.domain.MemberVO;
import com.pepper.domain.PepperCntVO;
import com.pepper.domain.PepperVO;


@Service
public class PepperServiceImpl implements PepperService {

	@Inject
	private PepperDAO dao;
	
	// 오늘 수확량
	@Override
	public List<PepperCntVO> todayCnt(HttpServletRequest req) throws Exception {
		
		MemberVO login = (MemberVO)req.getSession().getAttribute("login");
		
		String userID = login.getUserID();
		String analDate = req.getParameter("today");
		
		PepperVO vo = new PepperVO();
		vo.setUserID(userID);
		vo.setAnalDate(analDate);
		
		return dao.todayCnt(vo);

	}
	
	// 전체 수확량
	@Override
	public List<PepperCntVO> totalCnt(HttpServletRequest req) throws Exception {
		
		MemberVO login = (MemberVO)req.getSession().getAttribute("login");
		String userID = login.getUserID();
		
		String analDate = req.getParameter("year");
		
		PepperVO vo = new PepperVO();
		vo.setUserID(userID);
		vo.setAnalDate(analDate);
				
		return dao.totalCnt(vo);

	}

	// 연간 수확량
	@Override
	public List<PepperCntVO> yearCnt(HttpServletRequest req) throws Exception {
		
		MemberVO login = (MemberVO)req.getSession().getAttribute("login");
		String userID = login.getUserID();
		
		String startYear = req.getParameter("startYear");
		String endYear = req.getParameter("endYear");
		
		return dao.yearCnt(userID, startYear, endYear);

	}

	// 주간 수확량
	@Override
	public List<PepperCntVO> weekCnt(HttpServletRequest req) throws Exception {
		
		MemberVO login = (MemberVO)req.getSession().getAttribute("login");
		String userID = login.getUserID();
		
		String startDate = req.getParameter("startDate");
		
		String endDate = req.getParameter("endDate");
		
		return dao.weekCnt(userID, startDate, endDate);

	}
	
	// 고추 가격
	public String[] price() throws Exception{
		
		String url = "https://aglook.krei.re.kr/jsp/pc/front/trend/priceTrend06.jsp";
		Document doc = Jsoup.connect(url).get();
		Elements elem_date = doc.select("body > section > article.content_right > article > article > article.sub_content > section:nth-child(6) > table > thead > tr > th:nth-child(10)");
		Elements elem_price = doc.select("body > section > article.content_right > article > article > article.sub_content > section:nth-child(6) > table > tbody > tr:nth-child(2) > td:nth-child(10)");
		
		String[] price = {elem_date.text(),elem_price.text()};
		
		return price;
	}

}
