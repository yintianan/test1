package homework;

import java.sql.Date;
import java.util.Random;

public class UserInfo {
	private Integer userId;
	private String userName;
	private String userSex;
	private Date birthday;

	public UserInfo() {
		userId=new Random().nextInt();//避免初始化时空指针
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
