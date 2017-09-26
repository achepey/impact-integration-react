package impact.integration.site.common.admin;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by achepey on 9/25/17.
 */
@Repository
public class AdminDao {
	@PersistenceContext
	private EntityManager em;

	public String findPassword() {
		return em.createQuery(
				"SELECT a.password FROM Admin a ").getSingleResult().toString();
	}
}
