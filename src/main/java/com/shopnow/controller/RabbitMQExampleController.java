package com.shopnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.dto.Book;

@Controller
public class RabbitMQExampleController {

	//@Autowired
	//private RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "rabbit")
	public ModelAndView rabbit() {
		System.out.println("rabbit() -start");

		Book book = new Book("SUN OF GOD", "Vishnu", "BSO001", "01-11-2015", 222.44f);
		//rabbitTemplate.convertAndSend("shopnow.starter.routingkey", book);
		
	//	rabbitTemplate.convertAndSend("shopnow.starter.exchange", "shopnow.starter.routingkey", book);

		System.out.println("rabbit() -end ");
		return new ModelAndView("rabbitExample");
	}

}
