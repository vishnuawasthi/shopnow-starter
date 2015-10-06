package com.shopnow.configuration;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.shopnow.rabbitmq.Receiver;

public class RabbitMQConfiguration {

	/*private final static String queueName = "shopnow.queue";

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost",15672);
														connectionFactory.setUsername("guest");
														connectionFactory.setPassword("guest");
														//connectionFactory.setConnectionTimeout(20000);
														return connectionFactory;
		}

	@Bean
	@Primary
	public AmqpAdmin getRabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate =new RabbitTemplate(connectionFactory());
										rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter() );
										return rabbitTemplate; 
	}

	@Bean
	@Primary
	public MessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}*/
}
