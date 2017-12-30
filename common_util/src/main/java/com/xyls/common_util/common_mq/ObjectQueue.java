package com.xyls.common_util.common_mq;


public class ObjectQueue
{
	private Element first = null;
	private Element last = null;
	
	private int len = 0;
	int size()
	{
	    return len;
	}
	
	PriorityMessage addElement(PriorityMessage obj)
	{
	    Element localElement = new Element(obj);
	    if (this.first == null)
	    {
	      this.first = (this.last = localElement);
	    }else{
	      this.last.setNext(localElement);
	      this.last = localElement;
	    }
	    this.len += 1;
	    return obj;
	}
	
	PriorityMessage removeFirstElement()
	{
	    if (this.first == null)
	      return null;
	    PriorityMessage localObject = this.first.getValue();
	    this.first = this.first.getNext();
	    this.len -= 1;
	    return localObject;
	}
	
}