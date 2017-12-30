package com.yangfuzhao.common.common_mq;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityQueue
{

    AtomicLong send_count = new AtomicLong(0);
    AtomicLong receive_count = new AtomicLong(0);
    boolean stop = false;
    private Map<Integer,ObjectQueue> blocks = new HashMap<Integer,ObjectQueue>();
    PriorityQueue(){
        for(int i = 1 ;i <= 9 ;i ++){
            blocks.put(i, new ObjectQueue());
        }
    }
    
    
    
    synchronized int size()
    {
        int size = 0;
        for(int i = 1 ;i <= 9 ;i ++){
            size += blocks.get(i).size();
        }
        return size;
    }
    
    synchronized void stop()
    {
        stop = true;
        notifyAll();
    }
    
    
	
	
	
	
	synchronized PriorityMessage addElement(PriorityMessage message)
    {
	    send_count.incrementAndGet();
	    PriorityMessage localObject = blocks.get(message.getPriority()).addElement(message);
	    notify();
        return localObject;
    }
	
	
	
	synchronized PriorityMessage removeFirstElement()
    {
         waitingCondition();
         
         for(int i = 9 ;i >= 1 ;i --){
             if(blocks.get(i).size() != 0){
                 PriorityMessage priorityMessage = blocks.get(i).removeFirstElement();
                 if(priorityMessage != null){
                     receive_count.incrementAndGet();
                 }
                 return priorityMessage;
             }
         }
         if(!stop){
             throw new RuntimeException("no wait but no data");
         }
        return null;
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