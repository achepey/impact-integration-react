package impact.integration.site.common.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
	@Autowired
	private InterviewDao interviewDao;

}