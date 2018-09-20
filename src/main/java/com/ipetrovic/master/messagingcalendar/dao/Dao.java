package com.ipetrovic.master.messagingcalendar.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Dao<T, ID extends Serializable> {

	@PersistenceContext
	EntityManager entityManager;

	private final Class klass;

	public Dao(Class clazz) {
		this.klass = clazz;
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T find(Object id) {
		return (T) entityManager.find(klass, id);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public void delete(ID id) {
		entityManager.remove(find(id));
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + klass.getSimpleName()).getResultList();
	}
}
