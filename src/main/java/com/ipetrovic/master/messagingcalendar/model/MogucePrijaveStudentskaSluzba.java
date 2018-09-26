package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the moguce_prijave_studentska_sluzba database table.
 * 
 */
@Entity
@Table(name="moguce_prijave_studentska_sluzba")
@NamedQuery(name="MogucePrijaveStudentskaSluzba.findAll", query="SELECT m FROM MogucePrijaveStudentskaSluzba m")
public class MogucePrijaveStudentskaSluzba implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MogucePrijaveStudentskaSluzbaPK id;

	@Column(name="cena_prijave")
	private Long cenaPrijave;

	@Column(name="status_prijave", length=255)
	private String statusPrijave;

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

	public MogucePrijaveStudentskaSluzba() {
	}

	public MogucePrijaveStudentskaSluzbaPK getId() {
		return this.id;
	}

	public void setId(MogucePrijaveStudentskaSluzbaPK id) {
		this.id = id;
	}

	public Long getCenaPrijave() {
		return this.cenaPrijave;
	}

	public void setCenaPrijave(Long cenaPrijave) {
		this.cenaPrijave = cenaPrijave;
	}

	public String getStatusPrijave() {
		return this.statusPrijave;
	}

	public void setStatusPrijave(String statusPrijave) {
		this.statusPrijave = statusPrijave;
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