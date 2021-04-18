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
	
	public Object removeFirst( ) {
		return remove(0);
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	// 특장점: ArrayList는 데이터 조회를 할때 index로 접근하기 때문에 매우 빠르게 접근 가능 
	public Object get(int index) {
		return elementData[index];
	}
	
	
	public int size() {
		return size;
	}
	
	public int indexOf(Object o) {
		for(int i=0; i<size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
		
	}
	
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	class ListIterator {
		private int nextIndex = 0;
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		// 순차적으로 엘리먼트를 탐색해서 리턴합니다.
		public Object next() {
			return elementData[nextIndex++];
		}
		// 순차적으로 이전 노드를 리턴합니다.
		public Object previous() {
			// 이전 엘리먼트를 리턴하고 nextIndex의 값을 1 감소합니다.
			return elementData[--nextIndex];
		}
		
		// previous 메소드를 호출해도 되는지를 체크합니다.
		public boolean hasPrevious() {
			// nextIndex가 0보다 크다면 이전 엘리먼트가 존재한다는 의미입니다.
			return nextIndex > 0;
		}
		
		public void add(Object element) {
			// this.add 는 numbers의 add메소드 의미
			ArrayList.this.add(nextIndex++, element);
		}
		
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
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
