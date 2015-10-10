package com.shopnow.configuration;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RabbitMQIntegrationConfiguration {

	/*@Autowired
	AmqpAdmin rabbitAdmin;

	public static final String EXCHANGE_NAME = "shopnow.starter.exchange";
	
	public static final String CREATE_SHOPNOW_STARTER_DATA_QUEUE_NAME = "shopnow.starter.queue";
	
	public static final String CREATE_SHOPNOW_STARTER_DATA_ROUTING_KEY = "shopnow.starter.routingkey";
	
	@Bean(name = "createShopnowDataQueue")
	public Queue getcreateShopnowDataQueue() {
		return new Queue(CREATE_SHOPNOW_STARTER_DATA_QUEUE_NAME, true);
	}
	
	@Bean(name = "shopnowDirectExchange")
	public DirectExchange getShopnowDirectExchange() {
		return new DirectExchange(EXCHANGE_NAME, true, false);
	}
	
	@Bean(name = "createShopnowDataBinding")
	Binding getShopnowDataBinding(Queue createShopnowDataQueue, DirectExchange shopnowDirectExchange) {
		return BindingBuilder.bind(createShopnowDataQueue).to(shopnowDirectExchange).with(CREATE_SHOPNOW_STARTER_DATA_ROUTING_KEY);
	}
	
	@PostConstruct
	public void initializeShopnowMessageQueue() {
		DirectExchange shopnowDirectExchange =  getShopnowDirectExchange();
		
		Queue getcreateShopnowDataQueue =  getcreateShopnowDataQueue();
		Binding createShopnowDataBinding = getShopnowDataBinding(getcreateShopnowDataQueue, shopnowDirectExchange);
		
		rabbitAdmin.declareBinding(createShopnowDataBinding);
		rabbitAdmin.declareQueue();
		
	}
	*/
	
}
