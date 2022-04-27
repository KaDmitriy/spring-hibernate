/**
 * 
 */
package exe.np.springhibernate.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exe.np.springhibernate.model.Book;
import exe.np.springhibernate.servise.BookDAO;

/**
 * @author KDA
 *
 */

@RestController
@RequestMapping("/book/gen/")
public class BookGeneration {

	@Autowired
	private BookDAO bookDAO;
	
	/**
	 * url = http://localhost/book/gen/addbook
	 * @return
	 */
	@RequestMapping("add")
	public String createBook() {
		
		//bookDAO.deleteAll();
		
		int count = 10;
		for(int i=0; i<count; i++) {
			Book book = new Book();
			book.setName("book "+i);
			book.setDescr("descr "+i);
			book.setPages(2*i+1);
			book.setRelease(new Date());
			bookDAO.save(book);
		}		
		return "oK";
	}
	
}
