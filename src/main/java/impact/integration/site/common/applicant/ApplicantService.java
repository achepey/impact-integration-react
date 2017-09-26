package impact.integration.site.common.applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {
	@Autowired
	private ApplicantDao applicantDao;

}