package com.pepper.dao;

import java.util.List;

import com.pepper.domain.PepperCntVO;
import com.pepper.domain.PepperVO;

public interface PepperDAO {

	// 오늘 수확량
	public List<PepperCntVO> todayCnt(PepperVO vo) throws Exception;
	
	// 누적 수확량
	public List<PepperCntVO> totalCnt(PepperVO vo) throws Exception;
	
	// 연간 수확량
	public List<PepperCntVO> yearCnt(String userID, String startDate, String endDate) throws Exception;
	
	// 주간 수확량
	public List<PepperCntVO> weekCnt(String userID, String startDate, String endDate) throws Exception;
}
