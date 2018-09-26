package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@Table(name="korisnik")
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KORISNIK_KORISNIKID_GENERATOR", sequenceName="KORISNIK_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KORISNIK_KORISNIKID_GENERATOR")
	@Column(name="korisnik_id", unique=true, nullable=false)
	private Long korisnikId;

	@Column(name="korisnicko_ime", nullable=false, length=255)
	private String korisnickoIme;

	@Column(nullable=false, length=255)
	private String lozinka;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="rola_id", nullable=false)
	private Rola rola;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="korisnik", fetch=FetchType.EAGER)
	private Set<Profesor> profesors;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="korisnik", fetch=FetchType.EAGER)
	private Set<Student> students;

	public Korisnik() {
	}

	public Long getKorisnikId() {
		return this.korisnikId;
	}

	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setKorisnik(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setKorisnik(null);

		return profesor;
	}

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setKorisnik(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setKorisnik(null);

		return student;
	}

}