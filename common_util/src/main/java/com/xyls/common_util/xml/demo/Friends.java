package com.xyls.common_util.xml.demo;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

public class Friends{
	
    @XStreamImplicit(itemFieldName="name")
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}