package by.archidel.archidelion.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

/*	private boolean errorStatus;
	private String errorMessage;
*/
	@Column(name = "u_id")
	private int id;

	@Column(name = "u_login")
	private String login;

	@Column(name = "u_password")
	private String password;

	public User() {
	}

	/*public User(boolean errorStatus, String errorMessage) {
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}*/

/*	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
