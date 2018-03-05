package jwd.wafepa.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;

public interface BookService {

	 Book save(Book book);

	 Page<Book> findAll(int page);

	 Page<Book> findAllBetween(double priceFrom, double priceTo, int page);	

	  Page<Book> findByAuthorOrderByTitle(Author author, int page);
	
	  Page<Book> findByAuthorOrderByTitleDesc(Author author, int page);
	
}
