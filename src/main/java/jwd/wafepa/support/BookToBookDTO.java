package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDTO implements Converter<Book, BookDTO> {

	@Autowired
	AuthorToAuthorDTO aToADTO;
	
	@Override
	public BookDTO convert(Book book) {
		
		return new BookDTO(book.getId(),book.getTitle(), book.getPrice(),book.getYear(),aToADTO.convert(book.getAuthor()));
	}

	public List<BookDTO> convert(List<Book> books){
		List<BookDTO> ret = new ArrayList<>();
		
		for(Book book : books){
			ret.add(convert(book));
		}
		
		return ret;
	}

	
}
