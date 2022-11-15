package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.HealthGoodsDTO;

@Component
public class HealthGoodsDAO {

	private SqlSession session = null; // DML쿼리문 다 갖는 SqlSession 인터페이스

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리함수 가짐

	public HealthGoodsDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory(); // openSession() 가능
	}



	/*************** 헬스용품 ***************/

	// healthGoodsList (헬스용품 전체 조회)
	public List<HealthGoodsDTO> healthGoodsList() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할
			return sqlSession.selectList("healthgoodsMapper.healthGoodsList"); 

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// selectDumbbell (헬스용품 - 카테고리 '운동용품' 조회)
	public List<HealthGoodsDTO> selectDumbbell() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthgoodsMapper.selectDumbbell");

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// selectBelt (헬스용품 - 카테고리 '벨트' 조회)
	public List<HealthGoodsDTO> selectBelt() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthgoodsMapper.selectBelt");

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// selectGloves (헬스용품 - 카테고리 '장갑' 조회)
	public List<HealthGoodsDTO> selectGloves() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthgoodsMapper.selectGloves");

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// healthGoodsDetail (헬스용품 - 상세보기)
	public List<HealthGoodsDTO> healthGoodsDetail(int healthGoodsId) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("healthgoodsMapper.healthGoodsDetail", healthGoodsId);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
