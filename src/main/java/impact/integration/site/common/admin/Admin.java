package impact.integration.site.common.admin;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Admin")
public class Admin {

	@Id
	@Column(name = "password")
	private String password;

	protected Admin() {}

	public Admin(String password) {
		this.password = password;
	}
}
