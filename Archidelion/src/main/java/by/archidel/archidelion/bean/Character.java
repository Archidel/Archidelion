package by.archidel.archidelion.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*@Entity
@Table(name = "character")*/
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @GeneratedValue()
	 * 
	 * @Column(name = "ch_id")
	 */
	private int id;

	/* @Column(name = "ch_name") */
	private String name;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="u_id") private User user;
	 */

	public Character() {
	}

	public Character(int id, String name) {
		super();
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
		return "Character [id=" + id + ", name=" + name + "]";
	}

}
