package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.HealthFoodDTO;

@Component
public class HealthFoodDAO {

	private SqlSession session = null; // DML쿼리문 다 갖는 SqlSession 인터페이스

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리함수 가짐

	public HealthFoodDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory(); // openSession() 가능
	}

	
	
	/*************** 헬스식품 ***************/

	// healthFoodList (헬스식품 전체 조회)
	public List<HealthFoodDTO> healthFoodList() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할
			return sqlSession.selectList("healthfoodMapper.healthFoodList"); 

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// selectFood (헬스식품 - 카테고리 '음식' 조회)
	public List<HealthFoodDTO> selectFood() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthfoodMapper.selectFood");

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// selectCafe (헬스식품 - 카테고리 '음료' 조회)
	public List<HealthFoodDTO> selectCafe() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthfoodMapper.selectCafe");

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// healthFoodDetail (헬스식품 - 상세보기)
	public List<HealthFoodDTO> healthFoodDetail(int hfid) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthfoodMapper.healthFoodDetail", hfid);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}
}
