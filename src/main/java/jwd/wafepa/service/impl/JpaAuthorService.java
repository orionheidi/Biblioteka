package jwd.wafepa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import jwd.wafepa.model.Author;
import jwd.wafepa.repository.AuthorRepository;
import jwd.wafepa.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaAuthorService implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author findOneByLastNameOrFirstName(String lastName, String firstName) {
		return authorRepository.findFirstByLastNameOrFirstName(lastName, firstName);
	}	
}
