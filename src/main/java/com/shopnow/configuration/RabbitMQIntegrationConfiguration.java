/*package com.shopnow.configuration;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQIntegrationConfiguration {

	@Autowired
	AmqpAdmin rabbitAdmin;

	public static final String EXCHANGE_NAME = "shopnow.starter.exchange";
	
	public static final String CREATE_SHOPNOW_STARTER_DATA_QUEUE = "shopnow.starter.queue";
	
	public static final String CREATE_SHOPNOW_STARTER_DATA_ROUTING_KEY = "shopnow.starter.routingkey";
	
	@Bean(name = "createShopnowDataQueue")
	public Queue getcreateShopnowDataQueue() {
		return new Queue(CREATE_SHOPNOW_STARTER_DATA_QUEUE, true);
	}
	
	@Bean(name = "createShopnowDataBinding")
	Binding getShopnowDataBinding(Queue createShopnowDataQueue, DirectExchange shopnowDirectExchange) {
		return BindingBuilder.bind(createShopnowDataQueue).to(shopnowDirectExchange).with(CREATE_SHOPNOW_STARTER_DATA_ROUTING_KEY);
	}
	
	@Bean(name = "shopnowDirectExchange")
	public DirectExchange getShopnowDirectExchange() {
		return new DirectExchange(EXCHANGE_NAME, true, false);
	}
	
	@PostConstruct
	public void initializeShopnowMessageQueue() {
		DirectExchange shopnowDirectExchange =  getShopnowDirectExchange();
		Queue getcreateShopnowDataQueue =  getcreateShopnowDataQueue();
		Binding createShopnowDataBinding = getShopnowDataBinding(getcreateShopnowDataQueue, shopnowDirectExchange);
		rabbitAdmin.declareBinding(createShopnowDataBinding);
		rabbitAdmin.declareQueue();
		
	}
	
	@Bean
	SimpleMessageListenerContainer shopnowMessageListenerContainer(ConnectionFactory connectionFactory,
			MessageListenerAdapter rabbitMQDataReceiver, MessageConverter jsonMessageConverter) {
		System.out.println("shopnowMessageListenerContainer()   -start");
		SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(CREATE_SHOPNOW_STARTER_DATA_QUEUE );
		container.setMessageListener(rabbitMQDataReceiver);
		rabbitMQDataReceiver.setMessageConverter(jsonMessageConverter);
		System.out.println("shopnowMessageListenerContainer()   -end");
		return container;

	}
	
	
}*/
