package com.pepper.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pepper.domain.PepperCntVO;
import com.pepper.domain.PepperVO;

@Repository
public class PepperDAOImpl implements PepperDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.pepper.mappers.pepper";
	
	// 오늘 수확량
	@Override
	public List<PepperCntVO> todayCnt(PepperVO vo) throws Exception {

		return sql.selectList(namespace + ".today", vo);

	}

	// 누적 수확량
	@Override
	public List<PepperCntVO> totalCnt(PepperVO vo) throws Exception {
		
		return sql.selectList(namespace + ".total", vo);

	}

	// 연간 수확량
	@Override
	public List<PepperCntVO> yearCnt(String userID, String startYear, String endYear) throws Exception {
		
		HashMap<String, Object> info = new HashMap<String, Object>();
		info.put("startYear", startYear);
		info.put("endYear", endYear);
		info.put("userID", userID);		
		
		return sql.selectList(namespace + ".year", info);

	}

	@Override
	public List<PepperCntVO> weekCnt(String userID, String startDate, String endDate) throws Exception {
		
		HashMap<String, Object> info = new HashMap<String, Object>();
		info.put("startDate", startDate);
		info.put("endDate", endDate);
		info.put("userID", userID);
		
		return sql.selectList(namespace + ".week", info);

	}

}
