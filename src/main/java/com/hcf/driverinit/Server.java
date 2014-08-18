package com.hcf.driverinit;

public class Server {

	public String portNumber;
	
	public String getPortNumber() {
		return portNumber;
	}

	public String getGridAddress() {
		return gridAddress;
	}

	public String gridAddress;

	public Server() {
		portNumber = "4444";
		gridAddress = "localhost";
	}

	public Server(String gridAddress,String portNumber) {
		this.portNumber = portNumber;
		this.gridAddress = gridAddress;
	}
}
