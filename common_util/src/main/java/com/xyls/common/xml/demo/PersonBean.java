package com.xyls.common.xml.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("person")
public class PersonBean {
	
    @XStreamAlias("firstName")
    private String firstName;
    
    @XStreamAlias("lastName")
    private String lastName;
     
    @XStreamAlias("telphone")
    private PhoneNumber tel;
    
    @XStreamAlias("faxphone")
    private PhoneNumber fax;
     
    //一个标签下有多个同名标签
    @XStreamAlias("friends")
    private Friends friend;
     
    //一个标签下循环对象
    @XStreamAlias("pets")
    private Pets pet;

    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PhoneNumber getTel() {
		return tel;
	}

	public void setTel(PhoneNumber tel) {
		this.tel = tel;
	}

	public PhoneNumber getFax() {
		return fax;
	}

	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}

	public Friends getFriend() {
		return friend;
	}

	public void setFriend(Friends friend) {
		this.friend = friend;
	}

	public Pets getPet() {
		return pet;
	}

	public void setPet(Pets pet) {
		this.pet = pet;
	}
     
     
}