package homework;

public abstract class AbstractSort<T> {
	public void sort(T[] objs) {
		// ����compare�������������㷨
		for(int i=0;i<objs.length-1;i++) {//��С�������ð������
			for(int j=i+1;j<objs.length;j++) {
				if(compare(objs[i], objs[j])>0) {
					T k=objs[i];
					objs[i]=objs[j];
					objs[j]=k;
				}
			}
		}
	}

	protected abstract int compare(T o1, T o2);//���ش���0����ǰ�ߴ󣬵���0��һ����С��0��ǰ��С

}
