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

	// @Query(nativeQuery = true, value = "select * from \"public\".\"book\" b;")
	// Specification<BookView> speca
	public List<BookView> findAllQuery() {
		Query query = em.createNativeQuery(
				"select *, (select count(*) from  public.book_author where bookid = book.uid) countauthor from book",
				BookView.class);

		// query.setFirstResult(0);
		// query.setMaxResults(10);

		return query.getResultList();
	}

	public List<BookView> findAllRowsWithFilter(UUID userUid) {
		Query query = em.createNativeQuery(
				"""
						select *
						from  public.book b
						where 1=1
						and exists (select 1 as "countuser" from public.book_author a where a.bookid = b.uid  )
						and exists (select 1 as "countuser" from public.book_user bu where bu.bookuid = b.uid and bu.useruid = '3b660c98-d41e-4385-804f-183ccb0cad29' )
						;""",
				BookView.class);
		//query.setParameter(null, query);
		// query.setFirstResult(0);
		// query.setMaxResults(10);

		return query.getResultList();
	}

}
