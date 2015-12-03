package com.shopnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.form.PaymentGateWayForm;
import com.shopnow.service.PayPalService;

@Controller
public class PayPalPaymentGatewayController {

	@Autowired
	private PayPalService payPalService;
	
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView showCheckout() {
		System.out.println("showCheckout() -start");
		
		/*try {
			payPalService.accssToken();
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("checkout");
		System.out.println("showCheckout() -end");
		return modelAndView;
	}

	@RequestMapping(value = "/processCheckout")
	public ModelAndView proceedToCheckout() {
		ModelAndView modelAndView = new ModelAndView();
		PaymentGateWayForm paymentGateWayForm = new PaymentGateWayForm();
		paymentGateWayForm.setActionURL("https://www.sandbox.paypal.com/cgi-bin/webscr");
		paymentGateWayForm.setBusiness("vishnu.awasthi-facilitator-1@valuelabs.net");
		paymentGateWayForm.setPassword("Z5B77QK29LTDCQBK");
		paymentGateWayForm.setApiSignature("AFcWxV21C7fd0v3bYYYRCpSSRl31A0wEzYtNYGvWfMLwsGszIolcEMv6");
		paymentGateWayForm.setCmd("_xclick");
		paymentGateWayForm.setCustom("1234");
		
		paymentGateWayForm.setCancelURL("http://192.168.24.4:8090/shopnow/success");
		paymentGateWayForm.setReturnURL("http://192.168.24.4:8090/shopnow/success");
		
		
		paymentGateWayForm.setAmount(3000.32f);
		paymentGateWayForm.setItemName("MICROMAX MOBILE UNITE 5");
	

		modelAndView.addObject("paymentGateWayForm", paymentGateWayForm);
		modelAndView.setViewName("autoSubmitForm");
		return modelAndView;
	}

	// http://192.168.24.4:8090/shopnow/success

	@RequestMapping(value = "/success")
	public ModelAndView success() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paymentSuccess");
		modelAndView.addObject("message", "Your transaction has been completed successfaully");
		return modelAndView;
	}

}
