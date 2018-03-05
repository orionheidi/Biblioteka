package jwd.wafepa.support;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.service.BookService;
import jwd.wafepa.web.dto.AuthorDTO;
import jwd.wafepa.web.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthor implements Converter<AuthorDTO, Author>{

	@Autowired
	BookDTOtoBook bdtb;
	
	@Autowired
	BookService bookService;

	@Override
	public Author convert(AuthorDTO authorDTO) {
		// TODO dodati da se lista knjiga preuzima iz baze kroz
		Author author = new Author(authorDTO.getId(), authorDTO.getFirstName(), authorDTO.getLastName(),null);
		return author;
	}
	
	
	
	
}
	


