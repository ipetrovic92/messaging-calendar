package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the moguce_prijave_student database table.
 * 
 */
@Entity
@Table(name="moguce_prijave_student")
@NamedQuery(name="MogucePrijaveStudent.findAll", query="SELECT m FROM MogucePrijaveStudent m")
public class MogucePrijaveStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MogucePrijaveStudentPK id;

	private Long ocena;

	//bi-directional many-to-one association to PredmetRok
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="predmet_akronim", referencedColumnName="predmet_akronim", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="rok_id", referencedColumnName="rok_id", nullable=false, insertable=false, updatable=false)
		})
	private PredmetRok predmetRok;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="broj_indeksa_studenta", nullable=false, insertable=false, updatable=false)
	private Student student;

	public MogucePrijaveStudent() {
	}

	public MogucePrijaveStudentPK getId() {
		return this.id;
	}

	public void setId(MogucePrijaveStudentPK id) {
		this.id = id;
	}

	public Long getOcena() {
		return this.ocena;
	}

	public void setOcena(Long ocena) {
		this.ocena = ocena;
	}

	public PredmetRok getPredmetRok() {
		return this.predmetRok;
	}

	public void setPredmetRok(PredmetRok predmetRok) {
		this.predmetRok = predmetRok;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}