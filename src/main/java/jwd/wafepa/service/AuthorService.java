package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Author;


public interface AuthorService {

	Author save(Author author);
	
	List<Author> findAll(); 
	
	Author findOneByLastNameOrFirstName(String lastName,String firstName);
	
}
