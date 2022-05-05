package exe.np.springhibernate.servise;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exe.np.springhibernate.model.BookView;

@Repository
@Transactional(readOnly = true)
public class BookViewDAO {

	@PersistenceContext
	private EntityManager em;

	/*
	 * @Query(nativeQuery = true, value = "select b.*, " +
	 * " (select count(*) from \"public\".\"book_user\" bu where bu.bookid = b.uid and userid='b47d48df-c10b-445a-b1d2-471526b480c9') as count_user"
	 * + " from \"public\".\"book\" b;") List<BookView> findAllQuery();
	 * // @Param("uidDoc") UUID uidDoc
	 */

	//@Query(nativeQuery = true, value = "select * from \"public\".\"book\" b;")
	public List<BookView> findAllQuery(Specification<BookView> spec) {
		Query query =  em.createNativeQuery("select bookview.uid, bookview.descr, bookview.name, bookview.pages from \"public\".\"book\" bookview");

	   // query.setFirstResult(0);
	   // query.setMaxResults(10);

	    return query.getResultList();
	}

}
