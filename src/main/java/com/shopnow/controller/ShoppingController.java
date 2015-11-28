package com.shopnow.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopnow.dto.InvoiceDetails;
import com.shopnow.dto.ProductDetails;
import com.shopnow.dto.ShippingDetails;

@Controller
@RequestMapping(value = "/shop")
public class ShoppingController {

	private static final Logger log = Logger.getLogger(ShoppingController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showItems() {
		log.info("showItems()- start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("shop");
		log.info("showItems()- end");
		return modelAndView;
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public ModelAndView generateInvoice() {
		log.info(" generateInvoice()- start");
		ModelAndView modelAndView = new ModelAndView();
		InvoiceDetails invoiceDetails = new InvoiceDetails();
		buildInvoice(invoiceDetails);
		modelAndView.addObject("invoiceDetails", invoiceDetails);
		modelAndView.setViewName("billingInvoice");
		log.info(" generateInvoice()- end");
		return modelAndView;
	}

	private void buildInvoice(InvoiceDetails invoiceDetails) {
		// Build the product
		ProductDetails productDetails = new ProductDetails();
		productDetails.setBrandCode("FASTTRACK");
		productDetails.setBrandName("FASTTRACK");
		productDetails.setDiscount(0L);
		productDetails.setId(201L);
		productDetails.setProductCode("MW BLUE");
		productDetails.setProductName("MEN'S WATCH BLUE 11'2");
		productDetails.setQuantity("1");
		productDetails.setPrice("3500");
		productDetails.setImageURL("/resources/images/watch-fasttrack.jpeg");
		
		
		ProductDetails productDetails2 = new ProductDetails();
		productDetails2.setBrandCode("FASTTRACK");
		productDetails2.setBrandName("FASTTRACK");
		productDetails2.setDiscount(0L);
		productDetails2.setId(202L);
		productDetails2.setProductCode("MW BLUE");
		productDetails2.setProductName("MEN'S WATCH BLUE 11'2");
		productDetails2.setQuantity("1");
		productDetails2.setPrice("3500");
		productDetails2.setImageURL("/resources/images/watch-fasttrack.jpeg");
		
		List<ProductDetails> productDetailsList = new ArrayList<ProductDetails>();
		productDetailsList.add(productDetails);
		productDetailsList.add(productDetails2);

		//
		ShippingDetails shippingDetails = new ShippingDetails();
		shippingDetails.setId(10000L);
		shippingDetails.setFirstName("Vishnu ");
		shippingDetails.setLastName("Awasthi");
		shippingDetails.setAddressLine1("H No, RB II, 157-B West Railway colony");
		shippingDetails.setCity("Bhopal");
		shippingDetails.setState("Madhya Pradesh");
		shippingDetails.setCountry("India");
		shippingDetails.setPhone("+918977307653");
		shippingDetails.setEmail("vishnuawasthi121@gmail.com");
		shippingDetails.setPincode("462001");

		invoiceDetails.setProductDetails(productDetails);
		invoiceDetails.setShippingDetails(shippingDetails);
		invoiceDetails.setProductDetailsList(productDetailsList);
	}

}
