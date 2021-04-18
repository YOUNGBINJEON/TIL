package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {

		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1, 15);
		numbers.addFirst(6);
		
		System.out.println(numbers.remove(1));
		System.out.println(numbers);
		
		ArrayList.ListIterator li = numbers.listIterator();
		
		System.out.println(li.hasNext());
		
		while(li.hasNext()) {
			int number =(int)li.next();
			if(number == 30) {
				li.add(35);
			}
			System.out.println(number);
		}
		System.out.println(numbers);
		
	}

}
