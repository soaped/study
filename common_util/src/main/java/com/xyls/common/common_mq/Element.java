package com.yangfuzhao.common.common_mq;


public class Element
{
  private PriorityMessage obj;
  private Element next = null;

  PriorityMessage getValue()
  {
    return this.obj;
  }

  void setNext(Element element)
  {
    this.next = element;
  }

  Element getNext()
  {
    return this.next;
  }

  Element(PriorityMessage obj)
  {
    this.obj = obj;
  }
}