package jwd.wafepa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.repository.BookRepository;
import jwd.wafepa.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaBookService implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Page<Book> findAll(int page) {
		return bookRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Page<Book> findAllBetween(double priceFrom, double priceTo, int page) {
		return bookRepository.findByPriceGreaterThanAndPriceLessThan(priceFrom, priceTo, new PageRequest(page, 10));
	}

	@Override
	public Page<Book> findByAuthorOrderByTitle(Author author, int page) {
		return bookRepository.findByAuthorOrderByTitleAsc(author, new PageRequest(page, 10));
	}

	@Override
	public Page<Book> findByAuthorOrderByTitleDesc(Author author, int page) {
		return bookRepository.findByAuthorOrderByTitleDesc(author, new PageRequest(page, 10));
	}


}
