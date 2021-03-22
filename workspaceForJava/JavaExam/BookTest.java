
class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc; //
	
	@Override
	public String toString() {
		return isbn + "\t |" + title + "\t |" + author + "\t |" + publisher
				+ "\t |" + price + "\t |" + desc;
	}
		
}

class Magazine{
	String isbn;
	String title;
	String author;
	String publisher;
	int year;
	int month;
	int price;
	String desc;
	
	
	@Override
	public String toString() {
		
		return isbn + "\t |" + title + "\t |" + author + "\t |" + publisher
				+ "\t |" + price + "\t |" + desc + "\t |" + year+ "." + month;
	}
	
	
	
}



public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.isbn = "21424";
		b1.title = "Java Pro";
		b1.author = "김하나";
		b1.publisher = "Jean.kr";
		b1.price = 15000;
		b1.desc = "기본문법";
		
		Book b2 = new Book();
		b2.isbn = "35355";
		b2.title = "OOAD 분석, 설계";
		b2.author = "소나무";
		b2.publisher = "Jean.kr";
		b2.price = 30000;
		b2.desc = "";
		
		Magazine m = new Magazine();
		m.isbn = "35535";
		m.title = "Java World";
		m.author = "편집부";
		m.publisher = "androidjava.com";
		m.year = 2013;
		m.month = 2;
		m.price = 7000;
		m.desc = "";
		
		System.out.println("\t ***************  도서목록  ***************");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(m);
		
		

	}

}
