package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@Table(name="rola")
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLA_ROLAID_GENERATOR", sequenceName="ROLA_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLA_ROLAID_GENERATOR")
	@Column(name="rola_id", unique=true, nullable=false)
	private Long rolaId;

	@Column(name="naziv_role", nullable=false, length=255)
	private String nazivRole;

	//bi-directional many-to-one association to Korisnik
	@OneToMany(mappedBy="rola", fetch=FetchType.EAGER)
	private Set<Korisnik> korisniks;

	public Rola() {
	}

	public Long getRolaId() {
		return this.rolaId;
	}

	public void setRolaId(Long rolaId) {
		this.rolaId = rolaId;
	}

	public String getNazivRole() {
		return this.nazivRole;
	}

	public void setNazivRole(String nazivRole) {
		this.nazivRole = nazivRole;
	}

	public Set<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(Set<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Korisnik addKorisnik(Korisnik korisnik) {
		getKorisniks().add(korisnik);
		korisnik.setRola(this);

		return korisnik;
	}

	public Korisnik removeKorisnik(Korisnik korisnik) {
		getKorisniks().remove(korisnik);
		korisnik.setRola(null);

		return korisnik;
	}

}