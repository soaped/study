package com.xyls.common_util.struct;


public class ProducerConsumerQueue extends ObjectQueue
{
	private boolean stop = false;
	
	
	public synchronized void Stop()
	{
		stop = true;
	    notifyAll();
	}
	public synchronized Object removeFirstElement()
	{
		 waitingCondition();
		 return super.removeFirstElement();
	}
	 
	public synchronized Object addElement(Object obj)
	{
		Object localObject = super.addElement(obj);
		  notify();
		  return localObject;
	}
	
	
	public synchronized Object[] removeBatchForArray(int batchSize)
	{
		waitingCondition();
		int i = size() < batchSize ? size() : batchSize;
		Object[] arrayOfObject = new Object[i];
		for (int j = 0; j < i; j++){
		      arrayOfObject[j] = super.removeFirstElement();
		}
		return arrayOfObject;
	}
	
	
	
	
	private synchronized void waitingCondition()
	{
		 while (!stop && size() == 0){
			 try
			 {
				 wait();
			 }
			 catch (InterruptedException localInterruptedException){}
		 }
	}
	
	
	
}