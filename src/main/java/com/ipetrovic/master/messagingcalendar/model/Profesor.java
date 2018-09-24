package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@Table(name="profesor")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="profesor_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long profesorId;

	@Column(nullable=false, length=255)
	private String ime;

	@Column(nullable=false, length=255)
	private String prezime;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	@JoinColumn(name="predmet", nullable=false)
	private Predmet predmetBean;

	//bi-directional many-to-many association to PredmetRok
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="dezurstva_profesora"
		, joinColumns={
			@JoinColumn(name="profesor_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="predmet_akronim", referencedColumnName="predmet_akronim", nullable=false),
			@JoinColumn(name="rok_id", referencedColumnName="rok_id", nullable=false)
			}
		)
	private Set<PredmetRok> predmetRoks;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="rola", nullable=false)
	private Role role;

	public Profesor() {
	}

	public Long getProfesorId() {
		return this.profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Predmet getPredmetBean() {
		return this.predmetBean;
	}

	public void setPredmetBean(Predmet predmetBean) {
		this.predmetBean = predmetBean;
	}

	public Set<PredmetRok> getPredmetRoks() {
		return this.predmetRoks;
	}

	public void setPredmetRoks(Set<PredmetRok> predmetRoks) {
		this.predmetRoks = predmetRoks;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}