package com.xyls.common.xml.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public  class Animal{
    @XStreamAlias("name")
    private String name;
    
    @XStreamAlias("age")
    private int age;
    
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}