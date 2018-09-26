package com.ipetrovic.master.messagingcalendar.dao;

import org.springframework.stereotype.Repository;

import com.ipetrovic.master.messagingcalendar.model.Student;

@Repository
public class StudentDao extends Dao<Student, String> {
	
	public StudentDao() {
		super(Student.class);
	}
}
