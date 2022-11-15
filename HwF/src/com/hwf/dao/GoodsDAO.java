package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
//import com.hwf.model.GoodsDTO;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;

@Component
public class GoodsDAO {

	private SqlSession session = null; // DML쿼리문 다 갖는 SqlSession 인터페이스

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리함수 가짐

	public GoodsDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory(); // openSession() 가능
	}

	
	
	/*************** 상품 전체 조회 ***************/

	// AdminHealthGoodsSelect (헬스용품 전체 조회)
	public List<HealthGoodsDTO> AdminHealthGoodsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할
			return sqlSession.selectList("adminMapper.AdminHealthGoodsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// AdminHealthFoodSelect (헬스식품 전체 조회)
	public List<HealthFoodDTO> AdminHealthFoodSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.AdminHealthFoodSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// NutrientsSelect (영양제 전체 조회)
	public List<NutrientsDTO> AdminNutrientsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.AdminNutrientsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	

	/*************** 상품 수정 ***************/
	
	//AdminHealthGoodsDetail (헬스용품 상세보기)
	public HealthGoodsDTO AdminHealthGoodsDetail(int healthGoodsId) {	
		try {
			sqlSession = sqlSessionFactory.openSession();
			HealthGoodsDTO dto = sqlSession.selectOne("adminMapper.AdminHealthGoodsDetail", healthGoodsId); //""자리에는 mapper.xml에서의 namespace.id
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	// AdminHealthGoodsUpdate (헬스용품 수정)
	public int AdminHealthGoodsUpdate(HealthGoodsDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
			int result = sqlSession.update("adminMapper.AdminHealthGoodsUpdate", dto); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			
		} finally { 
			if (sqlSession!=null) {sqlSession.close();} 
		}
	}
	
	
	
	//AdminHealthFoodDetail (헬스식품 상세보기)
	public HealthFoodDTO AdminHealthFoodDetail(int hfid) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			HealthFoodDTO dto = sqlSession.selectOne("adminMapper.AdminHealthFoodDetail", hfid); //""자리에는 mapper.xml에서의 namespace.id
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	// AdminHealthFoodUpdate (헬스식품 수정)
	public int AdminHealthFoodUpdate(HealthFoodDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
			int result = sqlSession.update("adminMapper.AdminHealthFoodUpdate", dto); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			
		} finally { 
			if (sqlSession!=null) {sqlSession.close();} 
		}
	}	
	
	
	
	//AdminNutrientsDetail (영양제 상세보기)
	public NutrientsDTO AdminNutrientsDetail(int nutrientsID) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			NutrientsDTO dto = sqlSession.selectOne("adminMapper.AdminNutrientsDetail", nutrientsID); //""자리에는 mapper.xml에서의 namespace.id
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	// AdminNutrientsUpdate (영양제 수정)
	public int AdminNutrientsUpdate(NutrientsDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
			int result = sqlSession.update("adminMapper.AdminNutrientsUpdate", dto); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			
		} finally { 
			if (sqlSession!=null) {sqlSession.close();} 
		}
	}		
	
	
	
	/*************** 상품 삭제 ***************/

	// AdminHealthGoodsDelete (헬스용품 삭제)
	public int AdminHealthGoodsDelete(int healthGoodsId) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			int resultHealthGoodsDelete = sqlSession.delete("adminMapper.AdminHealthGoodsDelete", healthGoodsId); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return resultHealthGoodsDelete;
		
		} catch (Exception e) {
			return 0;
			
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	// AdminHealthFoodDelete (헬스식품 삭제)
	public int AdminHealthFoodDelete(int hfid) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			int resultHealthFoodDelete = sqlSession.delete("adminMapper.AdminHealthFoodDelete", hfid); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return resultHealthFoodDelete;
		
		} catch (Exception e) {
			return 0;
				
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	// AdminNutrientsDelete (영양제 삭제)
	public int AdminNutrientsDelete(int nutrientsID) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			int resultNutrientsDelete = sqlSession.delete("adminMapper.AdminNutrientsDelete", nutrientsID); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return resultNutrientsDelete;
		
		} catch (Exception e) {
			return 0;
				
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}	
	
	
	
	/*************** 상품 등록 ***************/
	
	// AdminHealthGoodsInsert (헬스용품 등록)
	public int AdminHealthGoodsInsert(HealthGoodsDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			int result = sqlSession.insert("adminMapper.AdminHealthGoodsInsert", dto); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함
			sqlSession.commit();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	// AdminHealthFoodInsert (헬스식품 등록)
	public int AdminHealthFoodInsert(HealthFoodDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			int result = sqlSession.insert("adminMapper.AdminHealthFoodInsert", dto); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함
			sqlSession.commit();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); 
			return 0;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	// AdminNutrientsInsert (영양제 등록)
	public int AdminNutrientsInsert(NutrientsDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			int result = sqlSession.insert("adminMapper.AdminNutrientsInsert", dto); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함
			sqlSession.commit();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}	

}