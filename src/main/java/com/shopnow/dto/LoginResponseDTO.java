package com.shopnow.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "loginDTO")
public class LoginResponseDTO {

	private String username;
	private String sessionId;

	public String getUsername() {
		return this.username;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	@XmlElement
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
