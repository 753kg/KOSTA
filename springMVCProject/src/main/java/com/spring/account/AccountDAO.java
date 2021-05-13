package com.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 1함수 1SQL
	// 출금
	public void updateBalance1() throws DataAccessException {	// RuntimeException : 에러가 나면 던진다.
		sqlSession.update("com.kosta.account.update1");
	}
	
	// 입금
	public void updateBalance2() throws DataAccessException {
		sqlSession.update("com.kosta.account.update2");
	}
	

}
