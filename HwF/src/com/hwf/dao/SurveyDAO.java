package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.SearchDTO;
import com.hwf.model.SurveyDTO;

@Component
public class SurveyDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;
	

	public SurveyDAO() {
		
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	
	
	
	public List<SurveyDTO>  serachAll(String memberid) {
		try {
			sqlSession = sqlSessionFactory.openSession();   // app과 db를 연결(통로)
			return sqlSession.selectList("surveydao.serachAll",memberid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if( sqlSession != null ) { sqlSession.close(); }
		}  // try end
	}

	
	// insert
	public int insert(SurveyDTO dto) {
		System.out.println(dto.toString());
		try {
			sqlSession = sqlSessionFactory.openSession();
			int result = sqlSession.insert("surveydao.insert", dto);
			sqlSession.commit();
			return result;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // write end

	
	// 삭제
	public int SurveyDelete(int surveyid) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			int resultSurveyDelete = sqlSession.delete("surveydao.delete", surveyid); //""자리에는 mapper.xml에서의 namespace.id
			sqlSession.commit();
			return resultSurveyDelete;
		
		} catch (Exception e) {
			return 0;
			
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	
}