package com.ipetrovic.master.messagingcalendar.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.User;

@Repository
public class UserDao extends Dao<User, Long> {

    @Autowired
    public UserDao() {
        super(User.class);
    }

    public User findUserByEmail(String email) {
        Query q = entityManager.createQuery("from User where username = :username");
        q.setParameter("username", email);
        return (User) q.getSingleResult();
    }

}
