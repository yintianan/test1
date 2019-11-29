package homework2;

public class ParamInfo {
	private int paramId,methodId,paramIndex;
	private String paramType;
	
	public ParamInfo() {
		// TODO Auto-generated constructor stub
	}
	public ParamInfo( int methodId, int paramIndex, String paramType) {
		super();
		this.methodId = methodId;
		this.paramIndex = paramIndex;
		this.paramType = paramType;
	}
	
	
	public int getParamId() {
		return paramId;
	}
	public void setParamId(int paramId) {
		this.paramId = paramId;
	}

	public int getParamIndex() {
		return paramIndex;
	}
	public void setParamIndex(int paramIndex) {
		this.paramIndex = paramIndex;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
	public int getMethodId() {
		return methodId;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	
}
