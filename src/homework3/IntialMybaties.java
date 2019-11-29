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
			// 1-读取MyBatis配置文件
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		//	System.out.println(" ds csdcdsssssssssssssssssssssssssssc");
			// 2-创建会话工程(连接工厂)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//	System.out.println(" ds csdcdssssssssc");
			// 3-创建会话(连接)
			session = sqlSessionFactory.openSession();
			// 4-生成映射器
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
