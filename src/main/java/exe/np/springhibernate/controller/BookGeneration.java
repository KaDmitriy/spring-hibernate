/**
 * 
 */
package exe.np.springhibernate.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exe.np.springhibernate.model.Author;
import exe.np.springhibernate.model.Book;
import exe.np.springhibernate.model.User;
import exe.np.springhibernate.servise.AuthorDao;
import exe.np.springhibernate.servise.BookDAO;
import exe.np.springhibernate.servise.UserDao;

/**
 * @author KDA
 *
 */

@RestController
@RequestMapping("/book/gen/")
public class BookGeneration {

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private UserDao userDAO;

	@Autowired
	private AuthorDao authorDAO;

	private List<User> listUser = new ArrayList<User>();
	private List<Author> listAuthor = new ArrayList<Author>();

	
	
	/**
	 * url = http://localhost:8080/book/gen/all
	 * 
	 * @return
	 */
	@RequestMapping("all")
	public String createAll() {
		createAuthor();
		createUser();
		createBook();
		return "ok";
	}
	
	/**
	 * url = http://localhost:8080/book/gen/add
	 * 
	 * @return
	 */
	@RequestMapping("addbook")
	public String createBook() {

		bookDAO.deleteAll();

		Random rand = new Random();

		int count = 10;
		int countUser = 10;
		int countAuthor = 10;
		for (int i = 0; i < count; i++) {
			Book book = new Book();
			book.setName("book " + (i+1));
			book.setDescr("descr " + i);
			book.setPages(2 * i + 1);
			book.setRelease(new Date());

			if (!listAuthor.isEmpty())
				for (int a = 0; a < countAuthor; a++) {
					book.getAuthors().add(listAuthor.get(rand.nextInt(listAuthor.size())));
				}

			if(!listUser.isEmpty())
				for (int a = 0; a < countAuthor; a++) {
					book.getUsers().add(listUser.get(rand.nextInt(listUser.size())));
				}
			
			bookDAO.save(book);
		}
		return "oK";
	}

	/**
	 * url = http://localhost:8080/book/gen/adduser
	 * 
	 * @return
	 */
	@RequestMapping("adduser")
	public String createUser() {

		userDAO.deleteAll();

		int count = 100;
		for (int i = 0; i < count; i++) {
			User user = new User();
			user.setName("User " + (i+1));
			userDAO.save(user);
			listUser.add(user);
		}
		return "oK";
	}

	/**
	 * url = http://localhost:8080/book/gen/addauthor
	 * 
	 * @return
	 */
	@RequestMapping("addauthor")
	public String createAuthor() {

		authorDAO.deleteAll();
		int count = 100;
		for (int i = 0; i < count; i++) {
			Author author = new Author();
			author.setName("User " + (i + 1));
			authorDAO.save(author);
			listAuthor.add(author);
		}
		return "oK";
	}

}
