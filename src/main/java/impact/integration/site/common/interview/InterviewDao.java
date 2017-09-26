package impact.integration.site.common.interview;


import impact.integration.site.common.applicant.Applicant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class InterviewDao{

	@PersistenceContext
	private EntityManager em;

	public List<Interview> getAllInterviews() {

		return em.createQuery(
				"SELECT i FROM Interview i ")
				.getResultList();
	}

	@Transactional
	public Interview addInterview(Interview interview) {
		em.persist(interview);
		return interview;
	}

	@Transactional
	public Interview removeInterview(Long id) {
		Interview interview = em.find(Interview.class, id);
		if(interview != null){
			em.remove(interview);
		}
		return interview;
	}

	@Transactional
	public void deleteAllInterviews() {
		em.createQuery(
				"DELETE FROM Interview i").executeUpdate();
	}

	public Interview getInterview(Long id) {
		return em.find(Interview.class, id);
	}

	public List<Interview> getInterviewsForDay(Date day) {

		Calendar c = Calendar.getInstance();
		c.setTime(day);
		c.add(Calendar.DATE, 1);
		Date tomorrow = c.getTime();

		return em.createQuery(
				"SELECT i FROM Interview i WHERE i.startDate >= :date and i.endDate <= :tomorrow")
				.setParameter("date", day)
				.setParameter("tomorrow", tomorrow)
				.getResultList();
	}

	@Transactional
	public void assignApplicantToInterview(Long interviewId, Applicant applicant) {
		Interview interview = getInterview(interviewId);
		interview.setApplicant(applicant);
		interview.setTaken(true);
		em.merge(interview);
	}

	@Transactional
	public void removeApplicantToInterview(Long interviewId) {
		Interview interview = getInterview(interviewId);
		interview.setApplicant(null);
		interview.setTaken(false);
		em.merge(interview);
	}

	@Transactional
	public void removeAllApplicants() {
		List<Interview> interviews = getAllInterviews();
		for(Interview i : interviews) {
			i.setApplicant(null);
			i.setTaken(false);
			em.merge(i);
		}
	}
}
