package com.luster.fistIdeaItem.common.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by dell on 2017-8-10.
 */
public class SampleMqttCallback implements MqttCallbackExtended {

    /**
     * 连接丢失
     * @param throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("connectionLost：连接断开");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("messageArrived：消息来了！topic:"+s);
        System.out.println("messageArrived：消息来了！qos:"+mqttMessage.getQos());
        System.out.println("messageArrived：消息来了！content:"+new String(mqttMessage.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete：消息发布成功！");
    }

    @Override
    public void connectComplete(boolean b, String s) {
        System.out.println("connectionLost：连接完成");
    }
}
