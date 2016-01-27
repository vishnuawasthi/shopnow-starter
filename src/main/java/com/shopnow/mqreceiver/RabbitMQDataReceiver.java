/*package com.shopnow.mqreceiver;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import com.shopnow.dto.Book;

@Component("rabbitMQDataReceiver")
public class RabbitMQDataReceiver extends MessageListenerAdapter {

	@PostConstruct
	private void initialize() {
		setDefaultListenerMethod("getMessage"); // the name of the method that will get called when a user is received
	}

	public void getMessage(Book book) {
		System.out.println("getMessage()  -start");

		System.out.println("book  {}  "+book);
		
		System.out.println("getMessage()  -end");

	}
}
*/