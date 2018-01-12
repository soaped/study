package com.xyls.common_util.common_mq;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CommonMq {

    private static Logger logger = Logger.getLogger(CommonMq.class);
    
    private Map<String,PriorityQueue> map_q = new HashMap<String,PriorityQueue>();
    
    public void send(String queueName, PriorityMessage message) {
        PriorityQueue q = map_q.get(queueName);
        if(q == null){
            map_q.put(queueName, new PriorityQueue());
        }
        map_q.get(queueName).addElement(message);
        logger.debug(message);
    }

    public PriorityMessage blockReceive(String queueName) {
        PriorityQueue q = map_q.get(queueName);
        if(q == null){
            map_q.put(queueName, new PriorityQueue());
        }
        PriorityMessage priorityMessage = map_q.get(queueName).removeFirstElement();
        logger.debug(priorityMessage);
        return priorityMessage;
    }

    public int receiveCount(String queueName){
        PriorityQueue q = map_q.get(queueName);
        if(q != null){
            return q.receive_count.intValue();
        }
        return -1;
    }
    public int sendCount(String queueName){
        PriorityQueue q = map_q.get(queueName);
        if(q != null){
            return q.send_count.intValue();
        }
        return -1;
    }
    public int size(String queueName) {
        PriorityQueue q = map_q.get(queueName);
        if(q != null){
            return q.size();
        }
        return -1;
    }

    public void stop(String queueName) {
        PriorityQueue q = map_q.get(queueName);
        if(q != null){
             q.stop();
             map_q.remove(queueName);
        }
    }

    public boolean isStop(String queueName) {
        PriorityQueue q = map_q.get(queueName);
        if(q != null){
             return q.stop;
        }
        return true;
    }
    
    public Set<String> getQueues(){
        return map_q.keySet();
    }
}
