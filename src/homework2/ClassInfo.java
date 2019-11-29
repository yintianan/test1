package homework2;

public class ClassInfo {
	private long ClassId;
	private String ClassName;

	public long getClassId() {
		return ClassId;
	}

	public void setClassId(int classId) {
		ClassId = classId;
	}

	public ClassInfo() {
	};

	public ClassInfo(String className) {
		ClassName = className;
	};

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}
}
