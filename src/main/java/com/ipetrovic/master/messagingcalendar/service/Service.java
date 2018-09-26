package com.ipetrovic.master.messagingcalendar.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ipetrovic.master.messagingcalendar.dao.Dao;

@Transactional
public abstract class Service<T, ID extends Serializable> {

    protected Dao<T, ID> dao;

    public Service(Dao<T, ID> dao) {
        this.dao = dao;
    }

    public void save(T entity) {
        dao.save(entity);
    }

    public T find(ID primaryKey) {
        return dao.find(primaryKey);
    }

    public T update(T entity) {
        return dao.update(entity);
    }

    public void delete(ID id) {
        dao.delete(id);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

}
