package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@Table(name="predmet")
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String akronim;

	@Column(name="godina_studija", nullable=false, length=255)
	private String godinaStudija;

	@Column(nullable=false, length=255)
	private String naziv;

	@Column(name="tip_predmeta", nullable=false, length=255)
	private String tipPredmeta;

	//bi-directional many-to-many association to Student
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="predmet_student"
		, joinColumns={
			@JoinColumn(name="akronim_predmeta", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="broj_indeksa_studenta", nullable=false)
			}
		)
	private Set<Student> students;

	//bi-directional many-to-one association to PredmetRok
	@OneToMany(mappedBy="predmet", fetch=FetchType.EAGER)
	private Set<PredmetRok> predmetRoks;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="predmetBean", fetch=FetchType.EAGER)
	private Set<Profesor> profesors;

	public Predmet() {
	}

	public String getAkronim() {
		return this.akronim;
	}

	public void setAkronim(String akronim) {
		this.akronim = akronim;
	}

	public String getGodinaStudija() {
		return this.godinaStudija;
	}

	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTipPredmeta() {
		return this.tipPredmeta;
	}

	public void setTipPredmeta(String tipPredmeta) {
		this.tipPredmeta = tipPredmeta;
	}

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<PredmetRok> getPredmetRoks() {
		return this.predmetRoks;
	}

	public void setPredmetRoks(Set<PredmetRok> predmetRoks) {
		this.predmetRoks = predmetRoks;
	}

	public PredmetRok addPredmetRok(PredmetRok predmetRok) {
		getPredmetRoks().add(predmetRok);
		predmetRok.setPredmet(this);

		return predmetRok;
	}

	public PredmetRok removePredmetRok(PredmetRok predmetRok) {
		getPredmetRoks().remove(predmetRok);
		predmetRok.setPredmet(null);

		return predmetRok;
	}

	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setPredmetBean(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setPredmetBean(null);

		return profesor;
	}

}