package com.pepper.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pepper.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.pepper.mappers.member";
	
	// 회원가입
	@Override
	public void join(MemberVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne(namespace + ".login", vo);
	}

	// 비밀번호 수정
	@Override
	public void modifyPW(MemberVO vo) throws Exception {
		
		sql.insert(namespace + ".modifyPW", vo);

	}

	// 정보 수정
	@Override
	public void modifyInfo(MemberVO vo) throws Exception {
		
		sql.insert(namespace + ".modifyInfo", vo);

	}

	// 회원 탈퇴
	@Override
	public void delete(MemberVO vo) throws Exception {
		sql.delete(namespace + ".delete", vo);

	}

	// 아이디 중복 확인
	@Override
	public String idCheck(String userID) throws Exception {
		
		return sql.selectOne(namespace + ".idCheck", userID);
	}
	
	// 닉네임 중복 확인
	@Override
	public String nameCheck(String userName) throws Exception {
		
		return sql.selectOne(namespace + ".nameCheck", userName);
	}

	// 비밀번호 일치 확인
	@Override
	public String pwCheck(String userID) throws Exception {
		
		return sql.selectOne(namespace + ".pwCheck", userID);
	}
}
