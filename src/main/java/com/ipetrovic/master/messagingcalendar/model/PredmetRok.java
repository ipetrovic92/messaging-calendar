package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the predmet_rok database table.
 * 
 */
@Entity
@Table(name="predmet_rok")
@NamedQuery(name="PredmetRok.findAll", query="SELECT p FROM PredmetRok p")
public class PredmetRok implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PredmetRokPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date datum;

	//bi-directional many-to-one association to MogucePrijaveStudent
	@OneToMany(mappedBy="predmetRok", fetch=FetchType.EAGER)
	private Set<MogucePrijaveStudent> mogucePrijaveStudents;

	//bi-directional many-to-one association to MogucePrijaveStudentskaSluzba
	@OneToMany(mappedBy="predmetRok", fetch=FetchType.EAGER)
	private Set<MogucePrijaveStudentskaSluzba> mogucePrijaveStudentskaSluzbas;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	@JoinColumn(name="predmet_akronim", nullable=false, insertable=false, updatable=false)
	private Predmet predmet;

	//bi-directional many-to-one association to Rok
	@ManyToOne
	@JoinColumn(name="rok_id", nullable=false, insertable=false, updatable=false)
	private Rok rok;

	//bi-directional many-to-many association to Profesor
	@ManyToMany(mappedBy="predmetRoks", fetch=FetchType.EAGER)
	private Set<Profesor> profesors;

	public PredmetRok() {
	}

	public PredmetRokPK getId() {
		return this.id;
	}

	public void setId(PredmetRokPK id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Set<MogucePrijaveStudent> getMogucePrijaveStudents() {
		return this.mogucePrijaveStudents;
	}

	public void setMogucePrijaveStudents(Set<MogucePrijaveStudent> mogucePrijaveStudents) {
		this.mogucePrijaveStudents = mogucePrijaveStudents;
	}

	public MogucePrijaveStudent addMogucePrijaveStudent(MogucePrijaveStudent mogucePrijaveStudent) {
		getMogucePrijaveStudents().add(mogucePrijaveStudent);
		mogucePrijaveStudent.setPredmetRok(this);

		return mogucePrijaveStudent;
	}

	public MogucePrijaveStudent removeMogucePrijaveStudent(MogucePrijaveStudent mogucePrijaveStudent) {
		getMogucePrijaveStudents().remove(mogucePrijaveStudent);
		mogucePrijaveStudent.setPredmetRok(null);

		return mogucePrijaveStudent;
	}

	public Set<MogucePrijaveStudentskaSluzba> getMogucePrijaveStudentskaSluzbas() {
		return this.mogucePrijaveStudentskaSluzbas;
	}

	public void setMogucePrijaveStudentskaSluzbas(Set<MogucePrijaveStudentskaSluzba> mogucePrijaveStudentskaSluzbas) {
		this.mogucePrijaveStudentskaSluzbas = mogucePrijaveStudentskaSluzbas;
	}

	public MogucePrijaveStudentskaSluzba addMogucePrijaveStudentskaSluzba(MogucePrijaveStudentskaSluzba mogucePrijaveStudentskaSluzba) {
		getMogucePrijaveStudentskaSluzbas().add(mogucePrijaveStudentskaSluzba);
		mogucePrijaveStudentskaSluzba.setPredmetRok(this);

		return mogucePrijaveStudentskaSluzba;
	}

	public MogucePrijaveStudentskaSluzba removeMogucePrijaveStudentskaSluzba(MogucePrijaveStudentskaSluzba mogucePrijaveStudentskaSluzba) {
		getMogucePrijaveStudentskaSluzbas().remove(mogucePrijaveStudentskaSluzba);
		mogucePrijaveStudentskaSluzba.setPredmetRok(null);

		return mogucePrijaveStudentskaSluzba;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Rok getRok() {
		return this.rok;
	}

	public void setRok(Rok rok) {
		this.rok = rok;
	}

	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

}