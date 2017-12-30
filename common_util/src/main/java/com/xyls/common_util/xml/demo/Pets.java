package com.xyls.common.xml.demo;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

public class Pets{
    @XStreamImplicit(itemFieldName="pet")
    private List<Animal> animalList;
     
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
     
}
