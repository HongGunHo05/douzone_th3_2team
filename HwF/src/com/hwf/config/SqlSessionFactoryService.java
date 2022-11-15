package com.hwf.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		String source = "./sqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(source);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end static

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}