package homework3;

import homework2.ClassInfo;
import homework2.MethodInfo;
import homework2.ParamInfo;

public interface MyClassMapper{
	public ClassInfo[] findClass(String classname);//输入class名得到数据库classid
	public MethodInfo[] findMethod(Long classid);
	public ParamInfo[] findParam(Long methodid);
}
