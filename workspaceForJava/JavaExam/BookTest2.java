import java.util.ArrayList;
import java.util.Iterator;

class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	public Book(String isbn, String title, String author, String publisher, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return isbn + "\t |" + title + "\t |" + author + "\t |" + publisher
				+ "\t |" + price + "\t |" + desc + "\n";
	}	
}

class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
	public Magazine(String isbn, String title, String author, String publisher, int price, int year, int month,
			String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	}
	public Magazine(String isbn, String title, String author, String publisher, int price, int year, int month) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return isbn + "\t |" + title + "\t |" + author + "\t |" + publisher
				+ "\t |" + price + "\t |" + desc + "\t |" + year+ "." + month + "\n";
	}	
}

public class BookTest2 {

	public static void main(String[] args) {
		ArrayList<Book> booklist = new ArrayList<Book>();
		booklist.add(new Book("21424", "Java Vasic", "김하나", "Jean.kr", 15000, "Java 기본 문법"));
		booklist.add(new Book("33455", "JDBC Pro", "김철수", "Jean.kr", 23000, ""));
		booklist.add(new Book("55355", "Servlet/JSP", "박자바", "Jean.kr", 41000, "Model12 기반"));
		booklist.add(new Book("35332", "Android App", "홍길동", "Jean.kr", 25000, "Lightweight Framework"));
		booklist.add(new Book("35355", "OOAD 분석, 설계", "소나무", "Jean.kr", 30000, ""));
		
		ArrayList<Magazine> magazinelist = new ArrayList<Magazine>();
		magazinelist.add(new Magazine("35535", "Java World", "편집부", "Jean.kr", 7000, 2013, 2, ""));
		magazinelist.add(new Magazine("33434", "Mobile World", "편집부", "Jean.kr", 8000, 2013, 8,""));
		magazinelist.add(new Magazine("75342", "Next Web", "편집부", "Jean.kr", 10000, 2012, 10,"AJAX 소개"));
		magazinelist.add(new Magazine("76543", "Architecture", "편집부", "Jean.kr", 5000, 2010, 3,"java 시스템"));
		magazinelist.add(new Magazine("76534", "data Modeling", "편집부", "Jean.kr", 14000, 2012, 12, ""));
		
		//System.out.println(String.format("%10s", booklist));
		Iterator<Book> booklist2 = booklist.iterator();
		
		System.out.println("\t ***************  도서목록  ***************");
		while (booklist2.hasNext()) {
			System.out.print(booklist2.next());
		}
		
		System.out.println("\t ***************  잡지목록  ***************");
		Iterator<Magazine> magazinelist2 = magazinelist.iterator();
		while (magazinelist2.hasNext()) {
			System.out.print(String.format("%10s", magazinelist2.next()));
		}

	}

}
