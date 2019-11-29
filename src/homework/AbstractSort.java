package homework;

public abstract class AbstractSort<T> {
	public void sort(T[] objs) {
		// 基于compare方法定义排序算法
		for(int i=0;i<objs.length-1;i++) {//从小到大进行冒泡排序
			for(int j=i+1;j<objs.length;j++) {
				if(compare(objs[i], objs[j])>0) {
					T k=objs[i];
					objs[i]=objs[j];
					objs[j]=k;
				}
			}
		}
	}

	protected abstract int compare(T o1, T o2);//返回大于0，则前者大，等于0则一样大，小于0则前者小

}
