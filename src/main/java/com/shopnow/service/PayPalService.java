package com.shopnow.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.paypal.api.openidconnect.CreateFromAuthorizationCodeParameters;
import com.paypal.api.openidconnect.Tokeninfo;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public interface PayPalService {

	public abstract String accssToken() throws PayPalRESTException;

	@Service
	public class Impl implements PayPalService {

		@Override
		public String accssToken() throws PayPalRESTException {
			
			System.out.println("accssToken() -start");
			
			Map<String, String> configurationMap = new HashMap<String, String>();
			configurationMap.put("clientID", "vishnu.awasthi-facilitator-1_api1.valuelabs.net");
			configurationMap.put("clientSecret", "Z5B77QK29LTDCQBK");
			configurationMap.put("service.EndPoint", "https://api.sandbox.paypal.com");
			APIContext apiContext = new APIContext();
			apiContext.setConfigurationMap(configurationMap);
			CreateFromAuthorizationCodeParameters param = new CreateFromAuthorizationCodeParameters();
			//param.setCode("");
			
			param.setClientID("vishnu.awasthi-facilitator-1_api1.valuelabs.net");
			param.setClientSecret("Z5B77QK29LTDCQBK");
			param.setCode("TEST");
			
			Tokeninfo info = Tokeninfo.createFromAuthorizationCode(apiContext, param);
			String accessToken = info.getAccessToken();
			
			System.out.println("accssToken  :  "+accessToken);
			
			System.out.println("accssToken() -end");
			return accessToken;
		}

	}

}
