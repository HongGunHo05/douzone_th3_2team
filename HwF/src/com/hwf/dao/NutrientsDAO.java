package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.NutrientsDTO;

@Component
public class NutrientsDAO {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public NutrientsDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	public List<NutrientsDTO> selectAll() {
		try {
			System.out.println("3");
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("4");
			return sqlSession.selectList("nutrdao.selectAll");

		} catch (Exception e) {
			System.out.println("5");
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public List<NutrientsDTO> selectvitamin() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("nutrdao.selectvitamin");

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public List<NutrientsDTO> selectprotein() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("nutrdao.selectprotein");

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public List<NutrientsDTO> selectdiet() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("nutrdao.selectdiet");

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public List<NutrientsDTO> selectdetail(int num) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("nutrdao.selectdetail", num);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}