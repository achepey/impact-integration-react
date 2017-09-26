package impact.integration.site.common.interview;

import impact.integration.site.common.applicant.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class InterviewDto {
	private Long id;
	private Date startDate;
	private Date endDate;
	private boolean isTaken;
	private Applicant applicant;
}