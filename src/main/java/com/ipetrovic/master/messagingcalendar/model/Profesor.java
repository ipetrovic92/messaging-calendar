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
	@SequenceGenerator(name="PROFESOR_PROFESORID_GENERATOR", sequenceName="PROFESOR_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESOR_PROFESORID_GENERATOR")
	@Column(name="profesor_id", unique=true, nullable=false)
	private Long profesorId;

	@Column(name="ime_profesora", nullable=false, length=255)
	private String imeProfesora;

	@Column(name="prezime_profesora", nullable=false, length=255)
	private String prezimeProfesora;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_id", nullable=false)
	private Korisnik korisnik;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	@JoinColumn(name="akronim_predmeta")
	private Predmet predmet;

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

	public Profesor() {
	}

	public Long getProfesorId() {
		return this.profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}

	public String getImeProfesora() {
		return this.imeProfesora;
	}

	public void setImeProfesora(String imeProfesora) {
		this.imeProfesora = imeProfesora;
	}

	public String getPrezimeProfesora() {
		return this.prezimeProfesora;
	}

	public void setPrezimeProfesora(String prezimeProfesora) {
		this.prezimeProfesora = prezimeProfesora;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Set<PredmetRok> getPredmetRoks() {
		return this.predmetRoks;
	}

	public void setPredmetRoks(Set<PredmetRok> predmetRoks) {
		this.predmetRoks = predmetRoks;
	}

}