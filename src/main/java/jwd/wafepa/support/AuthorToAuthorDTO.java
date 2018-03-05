package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.AuthorDTO;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorDTO implements Converter<Author, AuthorDTO>{

	@Override
	public AuthorDTO convert(Author author) {
		return new AuthorDTO(author.getId(), author.getFirstName(), author.getLastName());
	
	}

	public List<AuthorDTO> convert(List<Author> authors){
		List<AuthorDTO> ret = new ArrayList<>();
		
		for(Author author : authors){
			ret.add(convert(author));
		}
		
		return ret;
	}

}
