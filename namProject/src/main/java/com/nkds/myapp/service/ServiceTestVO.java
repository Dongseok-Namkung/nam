package com.nkds.myapp.service;

import org.springframework.stereotype.Service;

@Service("com.nkds.myapp.service.ServiceTestVO")
public class ServiceTestVO {
	String testStr = "";
	String id = "";
	String pw = "";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
