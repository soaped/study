package com.xyls.common.struct;



public class ObjectQueue
{
	private Element first = null;
	private Element last = null;
	private int len = 0;
	
	public synchronized int size()
	  {
	    return len;
	  }
	
	public synchronized Object addElement(Object obj)
	  {
		Element localElement = new Element(obj);
	    if (this.first == null)
	    {
	      this.first = (this.last = localElement);
	    }
	    else
	    {
	      this.last.setNext(localElement);
	      this.last = localElement;
	    }
	    this.len += 1;
	    return obj;
	  }
	
	public synchronized Object removeFirstElement()
	  {
	    if (this.first == null)
	      return null;
	    Object localObject = this.first.getValue();
	    this.first = this.first.getNext();
	    this.len -= 1;
	    return localObject;
	  }
	
	public synchronized Object getFirstElement()
	  {
	    return this.first == null ? null : this.first.getValue();
	  }
	
}