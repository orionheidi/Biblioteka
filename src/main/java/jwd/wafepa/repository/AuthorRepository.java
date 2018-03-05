package jwd.wafepa.repository;


import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository 
	extends JpaRepository<Author, Long>{
	
	Author findFirstByLastNameOrFirstName(String firstName, String lastName);
	
}
