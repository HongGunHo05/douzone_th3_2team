package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.CartDTO;
import com.hwf.model.NutrientsDTO;

@Component
public class CartDAO {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public CartDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	// 헬스용품,헬스식품 장바구니에 담기
	public int insertDataExcept(CartDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();
			int result = sqlSession.insert("cartdao.insertDataExcept", dto);
			sqlSession.commit();

			return result;

		} catch (Exception e) {

			return 0;
		}
	}

	// 영양제 장바구니에 담기
	public int insertData(CartDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();
			int result = sqlSession.insert("cartdao.insertnutr", dto);
			sqlSession.commit();

			return result;

		} catch (Exception e) {

			return 0;
		}
	}

	// 고객 id에 따른 장바구니 조회
	public List<CartDTO> selectcartall(String id) {

		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("cartdao.selectbyid", id);

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	// 장바구니 id에 따른 장바구니 조회
	public List<CartDTO> selectPrice(int id) {
		try {
			sqlSession = sqlSessionFactory.openSession();

			return sqlSession.selectList("cartdao.selectPrice", id);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 장바구니 삭제
	public int deleteData(int id) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			int result = sqlSession.delete("cartdao.deleteid", id);
			sqlSession.commit();

			return result;

		} catch (Exception e) {
			return 0;
		}

	}

}