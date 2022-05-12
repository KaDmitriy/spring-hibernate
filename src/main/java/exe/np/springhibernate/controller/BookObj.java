/**
 * 
 */
package exe.np.springhibernate.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exe.np.springhibernate.model.Author;
import exe.np.springhibernate.model.Book;
import exe.np.springhibernate.model.User;
import exe.np.springhibernate.servise.AuthorDao;
import exe.np.springhibernate.servise.BookDAO;
import exe.np.springhibernate.servise.UserDao;

/**
 * Information about the objects
 *  - book
 *  - author
 *  - user
 * 
 * @author Kartashov Dmitriy
 *
 */
@RestController
@RequestMapping("/book/obj/")
public class BookObj {
	
	private final Logger log = LoggerFactory.getLogger(BookObj.class);
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private UserDao userDAO;
	
	@Autowired
	private AuthorDao authorDAO;
	
	
	@GetMapping("/listbook")
	public List<Book> getListBook() {
		log.debug("GET=/book/obj/listbook");
		return bookDAO.findAll();
	}
	
	@GetMapping("/listauthor")
	public List<Author> getListAuthor() {
		log.debug("GET=/book/obj/listauthor");
		return authorDAO.findAll();
	}
	
	@GetMapping("/listuser")
	public List<User> getListUser() {
		log.debug("GET=/book/obj/listuser");
		return userDAO.findAll();
	}

}
