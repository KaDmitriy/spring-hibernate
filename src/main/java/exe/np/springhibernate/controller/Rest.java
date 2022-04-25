package exe.np.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exe.np.springhibernate.model.Book;
import exe.np.springhibernate.servise.BookDAO;

/**
 * @author Kartashov Dmitriy
 *
 */

@RestController
@RequestMapping("/base/")
public class Rest {

	@Autowired
	private BookDAO bookDAO;

	@GetMapping("/list")
	public List<Book> getListBook(String name) {

		return bookDAO.findAll((root, query, cb) -> cb
				.and((name != null && !name.isBlank()) ? cb.like(root.get("name").as(String.class), "%" + name + "%")
						: cb.conjunction()));
	}

}
