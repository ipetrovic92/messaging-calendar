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
	@SequenceGenerator(name="ROK_ROKID_GENERATOR", sequenceName="ROK_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROK_ROKID_GENERATOR")
	@Column(name="rok_id", unique=true, nullable=false)
	private Long rokId;

	@Column(nullable=false)
	private Long godina;

	@Column(name="naziv_roka", nullable=false, length=255)
	private String nazivRoka;

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

	public String getNazivRoka() {
		return this.nazivRoka;
	}

	public void setNazivRoka(String nazivRoka) {
		this.nazivRoka = nazivRoka;
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