package homework;

public class UserInfoSort extends AbstractSort<UserInfo> {

	@Override
	protected int compare(UserInfo o1, UserInfo o2) {
		// TODO Auto-generated method stub
		return o1.getUserId()-o2.getUserId();
	}

	
}

