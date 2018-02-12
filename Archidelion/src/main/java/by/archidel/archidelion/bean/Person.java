package by.archidel.archidelion.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "p_id")
	private int id;

	@Column(name = "p_name")
	private String name;

	@ManyToOne()
	@JoinColumn(name = "u_id")
	private User user;

	private String race;

	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRace() {
		return race;
	}

	public Person(int id, String name, String race) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
	}

	public Person(int id, String name, String race, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.sex = sex;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Person() {
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", user=" + user + ", race=" + race + ", sex=" + sex + "]";
	}

}
