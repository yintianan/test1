package homework2;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class cls;
		Method[] methods;
		Class[] paramTypes;
		Class retType;
		Integer classid, methodid = -1;

		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory;
		SqlSession session;
		ClassMapper classmapper;
		MethodMapper methodmapper;
		ParamMapper parammapper;
		
		
	

		try {
			cls = Class.forName(args[0]);
			ClassInfo mycls = new ClassInfo(cls.toString());// 创建class映射类
			System.out.println("obj1 class:" + cls);

			// 1-读取MyBatis配置文件
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 2-创建会话工程(连接工厂)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 3-创建会话(连接)
			session = sqlSessionFactory.openSession();
			// 4-生成映射器
			classmapper = session.getMapper(ClassMapper.class);

			try {
				classmapper.insertClass(mycls);// 提交class信息
				session.commit();
			} catch (Exception e) {

			}

			classid = classmapper.findClass(mycls);// 获取数据库自动生成的classid
			mycls.setClassId(classid);
			System.out.println("classid=" + classid);
			
	
			methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println();
				System.out.println("method name:" + m.getName());

				retType = m.getReturnType(); // 方法参数

				MethodInfo method = new MethodInfo(classid, m.getName(), retType.toString());

				methodmapper = session.getMapper(MethodMapper.class);
				try {
					methodmapper.insertMethod(method);// 提交method信息
					session.commit();
				} catch (Exception e) {

				}
				try {
					try {
						methodid = methodmapper.findMethod(method);// 获取数据库生成的methodid
						method.setClassid(classid);
						System.out.println("methodid=" + methodid);
					} catch (Exception e) {
						methodid++;//防止存在已有相同的方法名导致冲突
					}

					paramTypes = m.getParameterTypes(); // 方法参数
					// System.out.println(paramTypes[0]);

					parammapper = session.getMapper(ParamMapper.class);// 参数映射器

					for (int i = 0; i < paramTypes.length; i++) {
						parammapper.insertParam(new ParamInfo(methodid, i + 1, paramTypes[i].getName()));// 提交param信息
						System.out.println("\tparam" + (i + 1) + "type:" + paramTypes[i].getName());
						session.commit();
					}

				} catch (Exception e) {

				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		args[0]="class "+args[0];
		homework3.MAIN.main(args);//输出到文件

	//	classoutput.print();
		System.out.println("结束");
	}

}
