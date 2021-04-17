package list.arraylist.implementation;

import java.util.Arrays;

public class ArrayList {
	
	// size의 시작이 0부터 시작한
	private int size = 0;
	
	// 리스트가 수용할 수 있는 갯수 100개
	private Object[] elementData = new Object[100];
	
	
	public boolean addFirst(Object element) {
		return add(0, element);
		
	}
	 
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
		
	}
	
	//리스트의 add 메소드 구현 
	public boolean add(int index, Object element) {
		//index값에 삽입되면 나머지 값이 인덱스값까지 하나씩 elementData가 뒤로 밀려나도록 구현
		for (int i = size - 1; i >= index; i-- ) {
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}

	public Object remove(int index) {
		Object removed = elementData[index];
		for (int i = index+1; i<= size-1; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
		elementData[size] = null; 
		return removed;
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(int i=0; i<size; i++) {
			str += elementData[i];
			if(i < size-1) {
				str += ",";
			}
			
		}
		
		return str + "]";
	}
	
	

}
