package homework3;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class IntialMybaties {

	
	
	private static InputStream inputStream;
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession session;
	private static MyClassMapper classmapper;
	
	static {
		try {
			// 1-��ȡMyBatis�����ļ�
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		//	System.out.println(" ds csdcdsssssssssssssssssssssssssssc");
			// 2-�����Ự����(���ӹ���)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//	System.out.println(" ds csdcdssssssssc");
			// 3-�����Ự(����)
			session = sqlSessionFactory.openSession();
			// 4-����ӳ����
			classmapper = session.getMapper(MyClassMapper.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public static MyClassMapper getClassmapper() {
		
		return classmapper;
		
	}
	
	
}
