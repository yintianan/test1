package homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClassOutputToJSON {

	private String str;
	public ClassOutputToJSON createJSON(Object obj) {

		// 2-创建一个Gson对象
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Gson gson = builder.create();

		// 3- Java对象——>JSON对象
		str = gson.toJson(obj);
	

		return this;

	}
	
	public ClassOutputToJSON print() {
		System.out.println(str);
		return this;
	}
	
	public ClassOutputToJSON createToFile(Object obj,String addr) {
		createJSON(obj);
		File file=new File(addr);
		try {
			PrintWriter p=new PrintWriter(file);
			p.write(str);
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
}
