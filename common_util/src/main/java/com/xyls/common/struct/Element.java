package com.xyls.common.struct;

public class Element
{
  private Object obj;
  private Element next = null;

  public Object getValue()
  {
    return this.obj;
  }

  public void setNext(Element element)
  {
    this.next = element;
  }

  public Element getNext()
  {
    return this.next;
  }

  public Element(Object obj)
  {
    this.obj = obj;
  }
}