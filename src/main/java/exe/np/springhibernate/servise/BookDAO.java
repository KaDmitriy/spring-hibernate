package exe.np.springhibernate.servise;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import exe.np.springhibernate.model.Book;

/**
 * @author Kartashov Dmitriy
 *
 */

@Repository
public interface BookDAO extends JpaRepository<Book, UUID>, JpaSpecificationExecutor<Book> {

}
