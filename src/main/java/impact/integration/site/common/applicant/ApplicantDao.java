package impact.integration.site.common.applicant;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by achepey on 9/25/17.
 */
@Repository
public class ApplicantDao {

	@PersistenceContext
	private EntityManager em;

	public List<Applicant> getAllApplicants() {
		return em.createQuery(
				"SELECT a FROM Applicant a ")
				.setMaxResults(10)
				.getResultList();
	}

	public Applicant getApplicant(Long id) {
		return em.find(Applicant.class, id);
	}

	@Transactional
	public Applicant addApplicant(Applicant applicant) {
		em.persist(applicant);
		return applicant;
	}

	@Transactional
	public void removeApplicant(Long id) {
		Applicant app = em.find(Applicant.class, id);
		if(app != null){
			em.remove(app);
		}
	}

	@Transactional
	public void deleteAllApplicants() {
		em.createQuery(
				"DELETE FROM Applicant a").executeUpdate();
	}

}
