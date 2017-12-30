package com.xyls.common_util.xml.demo;



import com.xyls.common_util.xml.XStreamHelper;

import java.util.ArrayList;
import java.util.List;

public class XStreamHelperTest {
    
    public static void main(String[] args) {
        
        PersonBean per=new PersonBean();
        per.setFirstName("chen");
        per.setLastName("youlong");
         
        PhoneNumber tel=new PhoneNumber();
        tel.setCode(137280);
        tel.setNumber("137280968");
         
        PhoneNumber fax=new PhoneNumber();
        fax.setCode(20);
        fax.setNumber("020221327");
        per.setTel(tel);
        per.setFax(fax);
         
         
        //测试一个标签下有多个同名标签
        List<String> friendList=new ArrayList<String>();
        friendList.add("A1");
        friendList.add("A2");
        friendList.add("A3");
        Friends friend1=new Friends();
        friend1.setName(friendList);
        per.setFriend(friend1);
         
        //测试一个标签下循环对象
        Animal dog=new Animal("Dolly",2);
        Animal cat=new Animal("Ketty",2);
        List<Animal> petList=new ArrayList<Animal>();
        petList.add(dog);
        petList.add(cat);
        Pets pet=new Pets();
        pet.setAnimalList(petList);
        per.setPet(pet);
         
                    //java对象转换成xml
        String xml= XStreamHelper.toXml(per);
        System.out.println("xml==="+xml);
        
        
        
        
        
        
        
        
        
        String xmlStr="<person>"+
                "<firstName>chen</firstName>"+
                "<lastName>youlong</lastName>"+
                "<telphone>"+
                  "<code>137280</code>"+
                  "<number>137280968</number>"+
                "</telphone>"+
                "<faxphone>"+
                  "<code>20</code>"+
                  "<number>020221327</number>"+
                "</faxphone>"+
                "<friends>"+
                  "<name>A1</name>"+
                  "<name>A2</name>"+
                  "<name>A3</name>"+
                "</friends>"+
                "<pets>"+
                  "<pet>"+
                    "<name>doly</name>"+
                    "<age>2</age>"+
                  "</pet>"+
                  "<pet>"+
                    "<name>Ketty</name>"+
                    "<age>2</age>"+
                  "</pet>"+
                "</pets>"+
              "</person>";
      PersonBean person=XStreamHelper.toBean(xmlStr, PersonBean.class);
      System.out.println("person=firstname=="+person.getFirstName());
      System.out.println("person=getCode=="+person.getTel().getCode());
      System.out.println("person==Friends==name1=="+person.getFriend().getName().get(0));
      System.out.println("person==Pets==name2=="+person.getPet().getAnimalList().get(1).getName());
         
    }
}