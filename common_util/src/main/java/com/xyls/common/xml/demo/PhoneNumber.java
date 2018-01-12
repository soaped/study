package com.xyls.common.xml.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("phoneNumber")
public  class PhoneNumber{
    
	@XStreamAlias("code")
    private int code;
    
    @XStreamAlias("number")
    private String number;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
