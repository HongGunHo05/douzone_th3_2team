package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.InbodyDTO;
import com.hwf.model.SurveyDTO;

@Component
public class InbodyDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public InbodyDAO() {

		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	public List<InbodyDTO>  serachAll(String memberid) {
		try {
			sqlSession = sqlSessionFactory.openSession(); 
			System.out.println("인바디 서치 올");
			return sqlSession.selectList("inbodydao.serachAll",memberid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if( sqlSession != null ) { sqlSession.close(); }
		}  // try end
	}
	
	
	
	// insert
	public int insert(InbodyDTO dto) {

		System.out.println(dto.toString());

		try {

			sqlSession = sqlSessionFactory.openSession();

			int result = sqlSession.insert("inbodydao.insert", dto);

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
	public int InbodyDelete(int inbodyid) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			
			System.out.println("인바디 다오 인바디 삭제 ");
			int resultSurveyDelete = sqlSession.delete("inbodydao.delete", inbodyid); //
			System.out.println("인바디 다오 인바디 삭제2");
			sqlSession.commit();
			return resultSurveyDelete;
		
		} catch (Exception e) {
			return 0;
			
		} finally {
			if (sqlSession != null) {sqlSession.close();}
		}
	}
	
	
	
	
	
	
	
}