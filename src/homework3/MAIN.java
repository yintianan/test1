package homework3;



import java.util.ArrayList;

import homework2.ClassInfo;
import homework2.MethodInfo;
import homework2.ParamInfo;


public class MAIN{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass allclassinfo=createMyClass.create("class "+args[0]);//���������MyCLass
		//MyClass allclassinfo=createMyClass.create("class java.lang.Throwable");
		
		/*������ļ��Ϳ���̨*/
		new ClassOutputToXML().createToFile(allclassinfo, "G:\\c\\x.txt").print();
		new ClassOutputToJSON().createToFile(allclassinfo, "G:\\c\\j.txt").print();
		
	}

}
