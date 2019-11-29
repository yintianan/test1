/*用于输出到文件的基本类*/
package homework3;

import java.util.ArrayList;

import homework2.ClassInfo;
import homework2.MethodInfo;
import homework2.ParamInfo;

public class MyClass {

	ClassInfo[] classinfo;
	MethodInfo[] methodinfo;
	ParamInfo[] paraminfo;

	public MyClass(ClassInfo[] classinfo, MethodInfo[] methodinfo, ParamInfo[] paraminfo) {
		super();
		this.classinfo = classinfo;
		this.methodinfo = methodinfo;
		this.paraminfo = paraminfo;
	}
	public ClassInfo[] getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(ClassInfo[] classinfo) {
		this.classinfo = classinfo;
	}
	public MethodInfo[] getMethodinfo() {
		return methodinfo;
	}
	public void setMethodinfo(MethodInfo[] methodinfo) {
		this.methodinfo = methodinfo;
	}
	public ParamInfo[] getParaminfo() {
		return paraminfo;
	}
	public void setParaminfo(ParamInfo[] paraminfo) {
		this.paraminfo = paraminfo;
	}
	
	
}
