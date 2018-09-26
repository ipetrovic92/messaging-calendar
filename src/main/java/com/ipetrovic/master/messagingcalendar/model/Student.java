package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDENT_BROJINDEKSASTUDENTA_GENERATOR", sequenceName="STUDENT_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENT_BROJINDEKSASTUDENTA_GENERATOR")
	@Column(name="broj_indeksa_studenta", unique=true, nullable=false, length=255)
	private String brojIndeksaStudenta;

	@Column(name="ime_studenta", nullable=false, length=255)
	private String imeStudenta;

	@Column(name="prezime_studenta", nullable=false, length=255)
	private String prezimeStudenta;

	@Column(name="studijski_smer", nullable=false, length=255)
	private String studijskiSmer;

	@Column(name="upisana_godina", nullable=false)
	private Long upisanaGodina;

	//bi-directional many-to-one association to MogucePrijaveStudent
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	private Set<MogucePrijaveStudent> mogucePrijaveStudents;

	//bi-directional many-to-one association to MogucePrijaveStudentskaSluzba
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	private Set<MogucePrijaveStudentskaSluzba> mogucePrijaveStudentskaSluzbas;

	//bi-directional many-to-many association to Predmet
	@ManyToMany(mappedBy="students", fetch=FetchType.EAGER)
	private Set<Predmet> predmets;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_id", nullable=false)
	private Korisnik korisnik;

	public Student() {
	}

	public String getBrojIndeksaStudenta() {
		return this.brojIndeksaStudenta;
	}

	public void setBrojIndeksaStudenta(String brojIndeksaStudenta) {
		this.brojIndeksaStudenta = brojIndeksaStudenta;
	}

	public String getImeStudenta() {
		return this.imeStudenta;
	}

	public void setImeStudenta(String imeStudenta) {
		this.imeStudenta = imeStudenta;
	}

	public String getPrezimeStudenta() {
		return this.prezimeStudenta;
	}

	public void setPrezimeStudenta(String prezimeStudenta) {
		this.prezimeStudenta = prezimeStudenta;
	}

	public String getStudijskiSmer() {
		return this.studijskiSmer;
	}

	public void setStudijskiSmer(String studijskiSmer) {
		this.studijskiSmer = studijskiSmer;
	}

	public Long getUpisanaGodina() {
		return this.upisanaGodina;
	}

	public void setUpisanaGodina(Long upisanaGodina) {
		this.upisanaGodina = upisanaGodina;
	}

	public Set<MogucePrijaveStudent> getMogucePrijaveStudents() {
		return this.mogucePrijaveStudents;
	}

	public void setMogucePrijaveStudents(Set<MogucePrijaveStudent> mogucePrijaveStudents) {
		this.mogucePrijaveStudents = mogucePrijaveStudents;
	}

	public MogucePrijaveStudent addMogucePrijaveStudent(MogucePrijaveStudent mogucePrijaveStudent) {
		getMogucePrijaveStudents().add(mogucePrijaveStudent);
		mogucePrijaveStudent.setStudent(this);

		return mogucePrijaveStudent;
	}

	public MogucePrijaveStudent removeMogucePrijaveStudent(MogucePrijaveStudent mogucePrijaveStudent) {
		getMogucePrijaveStudents().remove(mogucePrijaveStudent);
		mogucePrijaveStudent.setStudent(null);

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
		mogucePrijaveStudentskaSluzba.setStudent(this);

		return mogucePrijaveStudentskaSluzba;
	}

	public MogucePrijaveStudentskaSluzba removeMogucePrijaveStudentskaSluzba(MogucePrijaveStudentskaSluzba mogucePrijaveStudentskaSluzba) {
		getMogucePrijaveStudentskaSluzbas().remove(mogucePrijaveStudentskaSluzba);
		mogucePrijaveStudentskaSluzba.setStudent(null);

		return mogucePrijaveStudentskaSluzba;
	}

	public Set<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(Set<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}