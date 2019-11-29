package homework3;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.TimeZone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

class ClassOutputToXML {

//	private int ClassId;
//	private String ClassName;
//	private String methodname,returntype;
//	private int paramId,methodId,paramIndex;
//	private String paramType;
	XStream xStream=null;
	ByteArrayOutputStream os=null;
	ObjectOutputStream out=null;

	public ClassOutputToXML createXML(Object obj) {
		
		
		xStream = new XStream(new DomDriver("utf-8"));
		DateConverter convert=new DateConverter( "yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8") );
		xStream.registerConverter(convert);

		// 3-Java Object->XML£¬Ð´ÈëÊä³öÁ÷
		try {
			
			os = new ByteArrayOutputStream();
			out = xStream.createObjectOutputStream(os);
			
			out.writeObject(obj);
			
			out.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ClassOutputToXML print() {
		System.out.println(os.toString());
		return this;
	}
	
	public ClassOutputToXML createToFile(Object obj,String addr) {
		try {
			File file=new File(addr);
			createXML(obj);
			os.writeTo(new FileOutputStream(file));
			out.close();
			os.close();
			
			
		}catch(NullPointerException | IOException e) {
			System.out.println("no create");
		}
		
		return this;
	}
	

}
