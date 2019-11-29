package homework2;

public class MethodInfo {
	private long classid, methodid;
	private String methodname, returntype;

	public MethodInfo() {
		// TODO Auto-generated constructor stub
	}

	public long getMethodid() {
		return methodid;
	}

	public void setMethodid(int methodid) {
		this.methodid = methodid;
	}

	public MethodInfo(int classid, String methodname, String returntype) {
		// TODO Auto-generated constructor stub
		this.classid = classid;
		this.methodname = methodname;
		this.returntype = returntype;
	}

	public long getClassid() {
		return classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public void setMethodid(long methodid) {
		this.methodid = methodid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getMethodname() {
		return methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public String getReturntype() {
		return returntype;
	}

	public void setReturntype(String returntype) {
		this.returntype = returntype;
	}

}
