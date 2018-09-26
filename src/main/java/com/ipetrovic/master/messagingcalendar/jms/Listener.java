package com.ipetrovic.master.messagingcalendar.jms;

import static com.ipetrovic.master.messagingcalendar.jms.JmsConfig.VIRTUAL_TOPIC_PREDMET;
import static com.ipetrovic.master.messagingcalendar.jms.JmsConfig.VIRTUAL_TOPIC_ROK;
import static com.ipetrovic.master.messagingcalendar.jms.JmsConfig.VIRTUAL_TOPIC_STUDENT;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class Listener {

	@JmsListener(destination = "Consumer.studentskaSluzbaEvidencija."
			+ VIRTUAL_TOPIC_ROK, containerFactory = "queueListenerFactory")
	public void receiveTopicMessage1(String poruka) {
		System.out.println("Virtual Topic 1 <" + poruka + ">");
	}

	@JmsListener(destination = "Consumer.studentEvidencija."
			+ VIRTUAL_TOPIC_ROK, containerFactory = "queueListenerFactory")
	public void receiveTopicMessage2(String poruka) {
		System.out.println("Virtual Topic 2 <" + poruka + ">");
	}

	@JmsListener(destination = "Consumer.dezurstvaEvidencija."
			+ VIRTUAL_TOPIC_ROK, containerFactory = "queueListenerFactory")
	public void receiveTopicMessage3(String poruka) {
		System.out.println("Topic 3 <" + poruka + ">");
	}

	@JmsListener(destination = "mailbox.queue", containerFactory = "queueListenerFactory")
	public void receiveQueueMessage1(String poruka) {
		System.out.println("Queue 1 <" + poruka + ">");
	}
	
	@JmsListener(destination = "mailbox.queue", containerFactory = "queueListenerFactory")
	public void receiveQueueMessage2(String poruka) {
		System.out.println("Queue 2 <" + poruka + ">");
	}

}
