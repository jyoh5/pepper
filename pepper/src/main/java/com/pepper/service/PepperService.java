package com.pepper.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pepper.domain.PepperCntVO;

public interface PepperService {

	// 오늘 수확량
	public List<PepperCntVO> todayCnt(HttpServletRequest req) throws Exception;
	
	// 누적 수확량
	public List<PepperCntVO> totalCnt(HttpServletRequest req) throws Exception;
	
	// 연간 수확량
	public List<PepperCntVO> yearCnt(HttpServletRequest req) throws Exception;
	
	// 주간 수확량
	public List<PepperCntVO> weekCnt(HttpServletRequest req) throws Exception;
	
	// 고추 가격
	public String[] price() throws Exception;
}
