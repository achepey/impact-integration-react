package impact.integration.site.common.applicant;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "Applicant")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "emailAddress")
	private String emailAddress;

	@Column(name = "gender")
	@NotNull
	private boolean gender; // True for male

	protected Applicant() {}

	public Applicant(String firstName, String lastName, String emailAddress, boolean gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.gender = gender;
	}
}
