package jwd.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	public Book(Long id, String title, double price, int year, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.year = year;
		this.author = author;
	}

	public Book() {
		super();
	}

	public Book(String title, double price, int year, Author author) {
		super();
		this.title = title;
		this.price = price;
		this.year = year;
		this.author = author;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	
	private double price;
	
	private int year;

	@ManyToOne(fetch=FetchType.LAZY)
	private Author author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price
				+ ", year=" + year + ", author=" + author + "]";
	}
}
