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
			ClassInfo mycls = new ClassInfo(cls.toString());// ����classӳ����
			System.out.println("obj1 class:" + cls);

			// 1-��ȡMyBatis�����ļ�
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 2-�����Ự����(���ӹ���)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 3-�����Ự(����)
			session = sqlSessionFactory.openSession();
			// 4-����ӳ����
			classmapper = session.getMapper(ClassMapper.class);

			try {
				classmapper.insertClass(mycls);// �ύclass��Ϣ
				session.commit();
			} catch (Exception e) {

			}

			classid = classmapper.findClass(mycls);// ��ȡ���ݿ��Զ����ɵ�classid
			mycls.setClassId(classid);
			System.out.println("classid=" + classid);
			
	
			methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println();
				System.out.println("method name:" + m.getName());

				retType = m.getReturnType(); // ��������

				MethodInfo method = new MethodInfo(classid, m.getName(), retType.toString());

				methodmapper = session.getMapper(MethodMapper.class);
				try {
					methodmapper.insertMethod(method);// �ύmethod��Ϣ
					session.commit();
				} catch (Exception e) {

				}
				try {
					try {
						methodid = methodmapper.findMethod(method);// ��ȡ���ݿ����ɵ�methodid
						method.setClassid(classid);
						System.out.println("methodid=" + methodid);
					} catch (Exception e) {
						methodid++;//��ֹ����������ͬ�ķ��������³�ͻ
					}

					paramTypes = m.getParameterTypes(); // ��������
					// System.out.println(paramTypes[0]);

					parammapper = session.getMapper(ParamMapper.class);// ����ӳ����

					for (int i = 0; i < paramTypes.length; i++) {
						parammapper.insertParam(new ParamInfo(methodid, i + 1, paramTypes[i].getName()));// �ύparam��Ϣ
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
		homework3.MAIN.main(args);//������ļ�

	//	classoutput.print();
		System.out.println("����");
	}

}
