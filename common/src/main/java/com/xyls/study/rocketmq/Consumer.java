package com.xyls.study.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;

/**
 * Created by ipaynow0929 on 2017/10/12.
 */
public class Consumer {

    /**
     * 顺序消息
     *
     * @param args
     * @throws MQClientException
     */
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order_producer");
        consumer.setNamesrvAddr("192.168.3.173:9876");
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("TopicOrder2", "TagA");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(msg+ " , content : "+ new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }

            private Random random = new Random();
        });
//            @Override
//            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
//                //设置自动提交
//                context.setAutoCommit(true);
//
//                for (MessageExt msg:msgs){
//                    System.out.println(msg+ " , content : "+ new String(msg.getBody()));
//                }
//                try {
//                    //模拟业务处理
//                    TimeUnit.SECONDS.sleep(random.nextInt(5));
//                }catch (Exception e){
//                    e.printStackTrace();
//                    return  ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
//                }
//                return ConsumeOrderlyStatus.SUCCESS;
//            }
//        });

        consumer.start();
        System.out.println("consume ! ");
    }

    /**
     * 普通消息
     * @param args
     * @throws InterruptedException
     * @throws MQClientException
     */
   /* public static void main(String[] args) throws InterruptedException, MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                "rmq-group");

        consumer.setNamesrvAddr("192.168.3.173:9876");
        consumer.setInstanceName("rmq-instance");
        consumer.subscribe("TopicA-test", "TagA");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started.");
    }*/
}
