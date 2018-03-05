package jwd.wafepa.support;

import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

@Component
public class BookDTOtoBook implements Converter<BookDTO, Book>{

	@Autowired
	AuthorDTOToAuthor aDTOToA;
	
	@Override
	public Book convert(BookDTO bookDTO) {
		return new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getPrice(), bookDTO.getYear(), aDTOToA.convert(bookDTO.getAuthor()));
	}

}
