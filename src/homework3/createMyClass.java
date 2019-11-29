package homework3;

import java.util.ArrayList;

import homework2.ClassInfo;
import homework2.MethodInfo;
import homework2.ParamInfo;

public class createMyClass {

	static MyClass create(String classname) {
		MyClassMapper classmapper = null;
		ArrayList<ParamInfo> paramlist = new ArrayList<>();

		try {
			classmapper = IntialMybaties.getClassmapper();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		ClassInfo[] classinfo = classmapper.findClass(classname);
		System.out.println("\tcalssid=" + classinfo[0].getClassId() + "\tcalssname=" + classinfo[0].getClassName());
		if (classinfo.length > 1) {
			System.out.println("数据库中存在相同类名" + classinfo.length);
		}

		MethodInfo[] methodinfo = classmapper.findMethod(classinfo[0].getClassId());

		for (MethodInfo m : methodinfo) {
			System.out.println("\tClassid=" + m.getClassid() + "\tMethodid=" + m.getMethodid() + "\tMethodname="
					+ m.getMethodname() + "\tReturntype=" + m.getReturntype());
		}

		for (int i = 0; i < methodinfo.length; i++) {
			ParamInfo[] paraminfo = classmapper.findParam(methodinfo[i].getMethodid());

			for (ParamInfo p : paraminfo) {
				System.out.println("\tMethodId=" + p.getMethodId() + "\tParamId=" + p.getParamId() + "\tParamIndex="
						+ p.getParamIndex() + "\tParamType=" + p.getParamType());
				paramlist.add(p);
			}
		}

		/* 生成总的参数表 */
		ParamInfo[] paraminfo = new ParamInfo[paramlist.size()];
		paramlist.toArray(paraminfo);

		/* 生成输出的类 */
		MyClass allclassinfo = new MyClass(classinfo, methodinfo, paraminfo);
		return allclassinfo;
	}
}
