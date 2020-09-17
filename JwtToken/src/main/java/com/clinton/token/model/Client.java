package com.clinton.token.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Client")
public class Client {
	private Long clientID;
	private String clientName;
	private String password;
	private String address;

	public Client(Long clientID, String clientName, String password, String address) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.password = password;
		this.address = address;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
