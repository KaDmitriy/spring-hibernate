package exe.np.springhibernate.controller;

import java.time.LocalDateTime;
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

import exe.np.springhibernate.model.Book;
import exe.np.springhibernate.servise.BookDAO;

/**
 * @author Kartashov Dmitriy
 *
 */

@RestController
@RequestMapping("/book/")
public class Rest {

	private final Logger log = LoggerFactory.getLogger(Rest.class);
	
	@Autowired
	private BookDAO bookDAO;

	/**
	 * URL = http://localhost:8080/book/list?release=2010-06-25T11:30
	 * 
	 * @param name
	 * @param page
	 * @param release
	 * @return
	 */
	@GetMapping("/list")
	public List<Book> getListBook(@RequestParam(required = false, defaultValue = "") String name,
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  Date release) {
		log.debug("String name: {}", name);
		log.debug("Integer page: {}", page);
		log.debug("Date release: {}", release);
		return bookDAO.findAll((root, query, cb) -> cb
				.and((name != null && !name.isBlank()) ? cb.like(root.get("name").as(String.class), "%" + name + "%")
						: cb.conjunction(),
						(release != null) ? cb.equal(root.get("release"), release) : cb.conjunction(),
						(page != null && page > 0) ? cb.le(root.get("page"), page) : cb.conjunction()					
						));
	}

}
