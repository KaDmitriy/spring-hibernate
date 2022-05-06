/**
 * 
 */
package exe.np.springhibernate.servise;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import exe.np.springhibernate.model.TableInt;
import exe.np.springhibernate.model.TableUid;

/**
 * @author Kartashov Dmitriy
 *
 */
@Repository
public class TestTDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<TableInt> findAllQuery() {
		Query query =  em.createNativeQuery("select *  from table_int ", TableInt.class);
		//Query query =  em.createQuery("select *  from table_int ");
	    return query.getResultList();
	}
	
	public List<TableUid> findAllQueryUid() {
		Query query =  em.createNativeQuery("select uid, name  from table_uid ", TableUid.class);
	    return query.getResultList();
	}

	
}
