package homework;

public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] objs= {2,18,841,65,165,181,21,231,32};
		new IntegerSort().sort(objs);
		for(int i:objs) {
			System.out.print(i+" ");
		}
		
		System.out.println(".................................");
		
		UserInfo[] Userobjs= {new UserInfo(),new UserInfo() };
		new UserInfoSort().sort(Userobjs);
		for(UserInfo i:Userobjs) {
			System.out.print(i+" ");
		}
		
		
	}

}
