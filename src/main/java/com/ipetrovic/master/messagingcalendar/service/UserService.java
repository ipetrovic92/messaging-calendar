package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.UserDao;
import com.ipetrovic.master.messagingcalendar.model.User;

@Service
public class UserService extends com.ipetrovic.master.messagingcalendar.service.Service<User, Long> {

    @Autowired private UserDao dao;

    @Autowired
    public UserService(UserDao adminDao) {
        super(adminDao);
    }

    public User findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }

}
