package com.hwf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;

@Component
public class RecommendDAO {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리 함수를 갖고 있다.

	public RecommendDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	// ----------------------------------------------------------------

	// 헬스용품 검색
	public List<HealthGoodsDTO> SearchHealthGoodsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("dao.SearchHealthGoodsSelect"); // member-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// food 검색
	public List<HealthFoodDTO> SearchHealthFoodSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("dao.SearchHealthFoodSelect"); // member-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 영양제 검색
	public List<NutrientsDTO> SearchNutrientsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("dao.SearchNutrientsSelect"); // member-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 설문 추천 헬스용품매칭
	public List<HealthGoodsDTO> suverysearchingHealthGoods(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("DAO 오셨나요? " + map);
			return sqlSession.selectList("dao.suverysearchingHealthGoods", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 인바디 추천 헬스용품매칭
	public List<HealthGoodsDTO> inbodysearchingHealthGoods(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("DAO 오셨나요? " + map);
			return sqlSession.selectList("dao.inbodysearchingHealthGoods", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 설문 추천 식품 매칭
	public List<HealthFoodDTO> suverysearchingHealthFood(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("DAO 오셨나요? " + map);
			return sqlSession.selectList("dao.suverysearchingHealthFood", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 인바디 추천 식품 매칭
	public List<HealthFoodDTO> inbodysearchingHealthFood(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("DAO 오셨나요? " + map);
			return sqlSession.selectList("dao.inbodysearchingHealthFood", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 설문 추천 영양제 매칭
	public List<NutrientsDTO> suverysearchingNutrients(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("DAO 오셨나요? " + map);
			return sqlSession.selectList("dao.suverysearchingNutrients", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 인바디 추천 영양제 매칭
	public List<NutrientsDTO> inbodysearchingNutrients(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("DAO 오셨나요? " + map);
			return sqlSession.selectList("dao.inbodysearchingNutrients", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}