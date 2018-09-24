package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the rok database table.
 * 
 */
@Entity
@Table(name="rok")
@NamedQuery(name="Rok.findAll", query="SELECT r FROM Rok r")
public class Rok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rok_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rokId;

	@Column(nullable=false)
	private Long godina;

	@Column(nullable=false, length=255)
	private String naziv;

	//bi-directional many-to-one association to PredmetRok
	@OneToMany(mappedBy="rok", fetch=FetchType.EAGER)
	private Set<PredmetRok> predmetRoks;

	public Rok() {
	}

	public Long getRokId() {
		return this.rokId;
	}

	public void setRokId(Long rokId) {
		this.rokId = rokId;
	}

	public Long getGodina() {
		return this.godina;
	}

	public void setGodina(Long godina) {
		this.godina = godina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<PredmetRok> getPredmetRoks() {
		return this.predmetRoks;
	}

	public void setPredmetRoks(Set<PredmetRok> predmetRoks) {
		this.predmetRoks = predmetRoks;
	}

	public PredmetRok addPredmetRok(PredmetRok predmetRok) {
		getPredmetRoks().add(predmetRok);
		predmetRok.setRok(this);

		return predmetRok;
	}

	public PredmetRok removePredmetRok(PredmetRok predmetRok) {
		getPredmetRoks().remove(predmetRok);
		predmetRok.setRok(null);

		return predmetRok;
	}

}