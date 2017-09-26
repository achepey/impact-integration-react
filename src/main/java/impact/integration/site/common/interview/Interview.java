package impact.integration.site.common.interview;

import impact.integration.site.common.applicant.Applicant;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Interview")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "isTaken", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isTaken;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicantId")
	private Applicant applicant;

	protected Interview() {}

	public Interview(Date startDate, Date endDate, boolean isTaken) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.isTaken = isTaken;
	}
}
