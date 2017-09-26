package impact.integration.site.common.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicantDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private boolean gender;
}