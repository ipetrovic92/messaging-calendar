package com.ipetrovic.master.messagingcalendar.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the event database table.
 * 
 */
@Component
@Entity
@Table(name="event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	private Long creator;

	private Timestamp date;

	@Column(length=255)
	private String name;

	@Column(name="user_id")
	private Long userId;

	@Column(name="whole_day")
	private Boolean wholeDay;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="events", fetch=FetchType.EAGER)
	private Set<User> users;

	public Event() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getWholeDay() {
		return this.wholeDay;
	}

	public void setWholeDay(Boolean wholeDay) {
		this.wholeDay = wholeDay;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}