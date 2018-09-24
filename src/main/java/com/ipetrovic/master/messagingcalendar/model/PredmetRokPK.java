package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the predmet_rok database table.
 * 
 */
@Embeddable
public class PredmetRokPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="predmet_akronim", insertable=false, updatable=false, unique=true, nullable=false, length=255)
	private String predmetAkronim;

	@Column(name="rok_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Long rokId;

	public PredmetRokPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PredmetRokPK)) {
			return false;
		}
		PredmetRokPK castOther = (PredmetRokPK)other;
		return 
			this.predmetAkronim.equals(castOther.predmetAkronim)
			&& this.rokId.equals(castOther.rokId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.predmetAkronim.hashCode();
		hash = hash * prime + this.rokId.hashCode();
		
		return hash;
	}
}