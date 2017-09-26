package impact.integration.site.endpoint;

import impact.integration.site.common.applicant.ApplicantDto;
import impact.integration.site.common.applicant.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/owner")
public class ApplicantEndpoint {
	@Autowired
	private ApplicantService applicantService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ApplicantDto findApplicant(@PathVariable(name = "id") Long id) {
		return null;
	}
}