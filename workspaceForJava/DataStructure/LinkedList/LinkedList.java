package list.linkedlist.implementation;

import java.util.ListIterator;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size =0;
	
	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head =newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
		
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}
		else {
			tail.next= newNode;
			tail = newNode;
			size++;
		}
	}
	
	// 
	Node node(int index) {
		Node x = head;
		for(int i =0; i< index; i++) {
			x = x.next;
		}
		return x;
		
	}
	
	public void add(int k, Object input) {
		if(k == 0) {
			addFirst(input);
		}
		else {
			Node temp1 = node(k-1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	public String toString() {
		if(head == null ) {
			return "[]";
			
		}
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
	}

	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	public Object remove(int k) {
		if(k ==0) {
			return removeFirst();
		}
		Node temp = node(k-1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = temp;
		}
		todoDeleted = null;
		size--;
		return returnData;
	}
	
	public Object removeLast() {
		return remove(size-1);
		
	}
	public int size(){
        return size;
    }
    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
    public int indexOf(Object data){
        // 탐색 대상이 되는 노드를 temp로 지정합니다.
        Node temp = head;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교합니다. 
        while(temp.data != data){
            temp = temp.next;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
            if(temp == null)
                return -1;
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
        return index;
    }
    
    public ListIterator listIterator() {
    	return new ListIterator();
    }
    
    class ListIterator{
    	private Node next;
    	private Node lastReturned;
    	private int nextIndex;
    	ListIterator(){
    		next = head;
    	}
    	
    	public Object next() {
    		lastReturned = next;
    		next = next.next;
    		nextIndex++;
    		return lastReturned.data;
    	}
    	
    	public boolean hasNext( ) {
    		return nextIndex < size();
    	}
    	
    	public void add(Object input) {
    		Node newNode = new Node(input);
    		
    		
    		if(lastReturned == null) {   			
    			head = newNode;
    			newNode.next = next;
    		} else {
    			lastReturned.next = newNode;
    			newNode.next = next;
    			
    		}
    		  		
    		lastReturned = newNode;
    		nextIndex++;
    		size++;
    		
    	}
    	
    	public void remove() {
    		if(nextIndex == 0) {
    			throw new IllegalStateException();
    		}
    		LinkedList.this.remove(nextIndex-1);
    		nextIndex--;
    	}
    	
    }
    
	
	
}
