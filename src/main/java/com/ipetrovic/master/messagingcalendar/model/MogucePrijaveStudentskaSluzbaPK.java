package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the moguce_prijave_studentska_sluzba database table.
 * 
 */
@Embeddable
public class MogucePrijaveStudentskaSluzbaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="predmet_akronim", insertable=false, updatable=false, unique=true, nullable=false, length=255)
	private String predmetAkronim;

	@Column(name="rok_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Long rokId;

	@Column(name="broj_indeksa_studenta", insertable=false, updatable=false, unique=true, nullable=false, length=255)
	private String brojIndeksaStudenta;

	public MogucePrijaveStudentskaSluzbaPK() {
	}
	public String getPredmetAkronim() {
		return this.predmetAkronim;
	}
	public void setPredmetAkronim(String predmetAkronim) {
		this.predmetAkronim = predmetAkronim;
	}
	public Long getRokId() {
		return this.rokId;
	}
	public void setRokId(Long rokId) {
		this.rokId = rokId;
	}
	public String getBrojIndeksaStudenta() {
		return this.brojIndeksaStudenta;
	}
	public void setBrojIndeksaStudenta(String brojIndeksaStudenta) {
		this.brojIndeksaStudenta = brojIndeksaStudenta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MogucePrijaveStudentskaSluzbaPK)) {
			return false;
		}
		MogucePrijaveStudentskaSluzbaPK castOther = (MogucePrijaveStudentskaSluzbaPK)other;
		return 
			this.predmetAkronim.equals(castOther.predmetAkronim)
			&& this.rokId.equals(castOther.rokId)
			&& this.brojIndeksaStudenta.equals(castOther.brojIndeksaStudenta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.predmetAkronim.hashCode();
		hash = hash * prime + this.rokId.hashCode();
		hash = hash * prime + this.brojIndeksaStudenta.hashCode();
		
		return hash;
	}
}