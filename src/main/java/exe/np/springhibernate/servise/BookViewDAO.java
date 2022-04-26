package exe.np.springhibernate.servise;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import exe.np.springhibernate.model.BookView;

public interface BookViewDAO extends JpaRepository<BookView, UUID>, JpaSpecificationExecutor<BookView> {

	/*
	@Query(nativeQuery = true, value = "select b.*, "
			+ " (select count(*) from \"public\".\"book_user\" bu where bu.bookid = b.uid and userid='b47d48df-c10b-445a-b1d2-471526b480c9') as count_user"
			+ " from \"public\".\"book\" b;")
	List<BookView> findAllQuery(); // @Param("uidDoc") UUID uidDoc
	*/
	

}
