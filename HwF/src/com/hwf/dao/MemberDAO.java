package com.hwf.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.MemberDTO;

@Component
public class MemberDAO {

	private SqlSession session = null; // DML쿼리문 다 갖는 SqlSession 인터페이스

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리함수 가짐

	public MemberDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory(); // openSession() 가능
	}

	// AdminMemberSelect
	public List<MemberDTO> AdminMemberSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.AdminMemberSelect");

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// checkMemberb
	public boolean checkMemberb(MemberDTO dto) {

		if (dto.getMemberpwd() == sqlSession.selectOne("memberdao.selectpwd", dto.getMemberid()))
			return true;
		else
			return false;
	}

	// checkMember
	public MemberDTO checkMember(MemberDTO dto) {
		try {
			System.out.println(dto.toString());

			sqlSession = sqlSessionFactory.openSession();

			return sqlSession.selectOne("memberdao.selectpwd", dto.getMemberid());

		} catch (Exception e) {

			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// insert
	public int insert(MemberDTO dto) {
		System.out.println(dto.toString());

		try {

			System.out.println("1");
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("2");
			int result = sqlSession.insert("memberdao.insert", dto);
			System.out.println("3");
			sqlSession.commit();
			System.out.println("4");
			return result;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // write end
}