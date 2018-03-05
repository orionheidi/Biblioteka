package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.service.BookService;
import jwd.wafepa.support.BookDTOtoBook;
import jwd.wafepa.support.BookToBookDTO;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/books")
public class ApiBookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	BookToBookDTO bToBDTO;

	@Autowired
	BookDTOtoBook bDTOToB;
	
	@Autowired
	AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBooks(
			@RequestParam(value = "priceFrom", defaultValue = "0") double priceFrom,
			@RequestParam(value = "priceTo", defaultValue = "500000") double priceTo,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		System.out.println("!!!!!!");
		System.out.println(priceFrom + ";" + priceTo);
		Page<Book> books;

		books = bookService.findAllBetween(priceFrom, priceTo, page);
				
		
		return new ResponseEntity<>(bToBDTO.convert(books.getContent()), HttpStatus.OK);
	}

	@RequestMapping(value = "/author",method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookForAuthor(
			@RequestParam(value="firstName", defaultValue = "") String firstName,
			@RequestParam(value="lastName", defaultValue = "") String lastName,
			@RequestParam(value="order", defaultValue = "") int order,
			@RequestParam(value = "page", defaultValue = "0") int page){
		
		Author author = authorService.findOneByLastNameOrFirstName(lastName,firstName);
	
		Page<Book> books;
		
		if(order == 1)
		{
			books = bookService.findByAuthorOrderByTitleDesc(author, page);
		}
		else
		{
			books = bookService.findByAuthorOrderByTitle(author, page);
		}
		
		
		return new ResponseEntity<>(bToBDTO.convert(books.getContent()), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BookDTO> add(@RequestBody BookDTO newBook) {

		Book savedBook = bookService.save(
				bDTOToB.convert(newBook));

		return new ResponseEntity<>(bToBDTO.convert(savedBook), HttpStatus.CREATED);
	}

	
}
