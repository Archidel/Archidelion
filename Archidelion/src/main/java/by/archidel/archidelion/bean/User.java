package by.archidel.archidelion.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "u_id")
	private int id;

	@Column(name = "u_login")
	private String login;

	@Column(name = "u_password")
	private String password;

	@Column(name = "u_email")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Person> person;

	@Transient
	private boolean errorStatus;

	@Transient
	private String errorMessage;

	public User() {
	}

	public User(boolean errorStatus, String errorMessage) {
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

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

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", person="
				+ person + ", errorStatus=" + errorStatus + ", errorMessage=" + errorMessage + "]";
	}

}
