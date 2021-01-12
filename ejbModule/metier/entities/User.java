package metier.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {

	   
	@Id
	private String username;
	private String password;
	private Boolean role;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Boolean getRole() {
		return this.role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}
   
}
