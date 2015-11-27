package com.shopnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.PaymentGateWayForm;

@Controller
public class PayPalPaymentGatewayController {

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView showCheckout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("checkout");
		return modelAndView;
	}

	@RequestMapping(value = "/processCheckout")
	public ModelAndView proceedToCheckout() {
		ModelAndView modelAndView = new ModelAndView();
		PaymentGateWayForm paymentGateWayForm = new PaymentGateWayForm();
		paymentGateWayForm.setPaymentGateWayURL("https://www.google.com");

		modelAndView.addObject("paymentGateWayForm", paymentGateWayForm);
		modelAndView.setViewName("autoSubmitForm");
		return modelAndView;
	}

}
