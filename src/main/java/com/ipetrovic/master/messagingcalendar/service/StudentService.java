package com.ipetrovic.master.messagingcalendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipetrovic.master.messagingcalendar.dao.StudentDao;
import com.ipetrovic.master.messagingcalendar.model.Student;

@Service
public class StudentService extends com.ipetrovic.master.messagingcalendar.service.Service<Student, String> {

	private StudentDao dao;

	@Autowired
	public StudentService(StudentDao dao) {
		super(dao);
		this.dao = dao;
	}

}
