package homework3;

import homework2.ClassInfo;
import homework2.MethodInfo;
import homework2.ParamInfo;

public interface MyClassMapper{
	public ClassInfo[] findClass(String classname);//����class���õ����ݿ�classid
	public MethodInfo[] findMethod(Long classid);
	public ParamInfo[] findParam(Long methodid);
}
