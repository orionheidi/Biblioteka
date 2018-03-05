package jwd.wafepa;

import javax.annotation.PostConstruct;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Address;
import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.model.User;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.AddressService;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.service.BookService;
import jwd.wafepa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@PostConstruct
	public void init(){		
		/*Author francKafka = new Author("Franc", "Kafka");
		authorService.save(francKafka);
		Book proces = new Book("proces", 880, 2015, francKafka);
		bookService.save(proces);
		Book preobrazaj = new Book("preobrazaj", 750, 2013, francKafka);
		bookService.save(preobrazaj);
		Book zamak = new Book("zamak", 1200, 2012, francKafka);
		bookService.save(zamak);
		
		Author alberKami = new Author("Alber", "Kami");
		authorService.save(alberKami);
		Book stranac = new Book("stranac", 780, 2010, alberKami);
		bookService.save(stranac);*/
		
		
	       for (int i = 1; i <= 100; i++) {
	            User user = new User();
	            user.setFirstName("First name " + i);
	            user.setLastName("Last name " + i);
	            user.setEmail("email" + i + "@example.com");
	            user.setPassword("123");
	            userService.save(user);

	            for (int j = 1; j <= 3; j++) {
	                Address address = new Address();
	                address.setNumber(j + "c/7");
	                address.setStreat("Narodnog fronta");

	                address.setUser(user);
	                user.addAddress(address);
	                addressService.save(address);
	            }
	            Activity a = new Activity("Activity_"+i);
	            activityService.save(a);
	       }
	}
}
