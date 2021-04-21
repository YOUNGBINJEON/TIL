package list.linkedlist.implementation;

public class main {

	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(30);
		numbers.addFirst(20);
		numbers.addFirst(10);
		numbers.addLast(40);
		numbers.addLast(50);
		numbers.add(2, 25);
		
		System.out.println(numbers);
		
		
		
	}

}
