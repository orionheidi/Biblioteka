package jwd.wafepa.web.dto;


public class BookDTO {

	public BookDTO() {
		super();
	}

	public BookDTO(Long id, String title, double price, int year,
			AuthorDTO authorDTO) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.year = year;
		this.author = authorDTO;
	}

	private Long id;

	private String title;
	
	private double price;
	
	private int year;

	private AuthorDTO author;

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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO authorDTO) {
		this.author = authorDTO;
	}

}
