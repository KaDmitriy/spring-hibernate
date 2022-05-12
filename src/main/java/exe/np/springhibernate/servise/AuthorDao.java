/**
 * 
 */
package exe.np.springhibernate.servise;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import exe.np.springhibernate.model.Author;

/**
 * @author Kartashov Dmitriy
 *
 */
public interface AuthorDao extends JpaRepository<Author, UUID>, JpaSpecificationExecutor<Author> {

}
