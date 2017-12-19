package com.yangfuzhao.study.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ipaynow0929 on 2017/10/12.
 */
public class Producer {


    /**
     * 顺序消息
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("order_producer");
            producer.setNamesrvAddr("192.168.3.173:9876");
            producer.start();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(date);

            for (int i = 0; i < 5; i++) {
                String body = dateStr + " hello rocketMQ " + i;
                Message msg = new Message("TopicOrder2", "TagB", "KEY" + i, body.getBytes());
                //发送数据:如果使用顺序消息,则必须自己实现MessageQueueSelector,保证消息进入同一个队列中去.
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {

                        Integer id = (Integer) arg;
                        System.out.println("id : " + id);
                        return mqs.get(id);
                    }
                },2 );//队列下标 //orderID是选定的topic中队列的下标

                System.out.println(sendResult + " , body : " + body);

            }
            
          /*  for (int i = 0; i < 5; i++) {
                String body = dateStr + " hello rocketMQ " + i;
                Message msg = new Message("TopicOrder2", "TagA", "KEY" + i, body.getBytes());
                //发送数据:如果使用顺序消息,则必须自己实现MessageQueueSelector,保证消息进入同一个队列中去.
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {

                        Integer id = (Integer) arg;
                        System.out.println("id : " + id);
                        return mqs.get(id);
                    }
                }, 2);//队列下标 //orderID是选定的topic中队列的下标

                System.out.println(sendResult + " , body : " + body);
            }*/

            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    /**
     * 普通消息
     * @param args
     * @throws MQClientException
     * @throws InterruptedException
     */
   /* public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr("192.168.3.173:9876");
        producer.setInstanceName("rmq-instance");
        producer.start();
        try {
            for (int i = 0; i < 3; i++) {
                Message msg = new Message("TopicA-test",// topic
                        "TagA",// tag
                        (new Date() + "Hello RocketMQ ,QuickStart" + i).getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
                //System.out.print(sendResult);
            }
        } catch (Exception e) {
            e.printStackTrace();                        
        }
        producer.shutdown();
    }*/
}
