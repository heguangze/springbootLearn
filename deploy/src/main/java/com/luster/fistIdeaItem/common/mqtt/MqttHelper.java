package com.luster.fistIdeaItem.common.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by dell on 2017-8-10.
 */
public class MqttHelper {

    public static void main(String[] args) {

        String topic        = "MQTT Examples";
        String content      = "Message from MqttPublishSample";
        int qos             = 2;
        String broker       = "tcp://172.16.3.89:1883";//89
        String clientId     = "JavaSample";
        String userName="luster";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);//是否清除客户端连接信息
            connOpts.setConnectionTimeout(3);//设置连接超时时间
            connOpts.setUserName(userName);//设置用户名
            connOpts.setWill(topic,content.getBytes(),2,false);
            MqttCallback sampleCallBack=new SampleMqttCallback();//自定义回调方法
            sampleClient.setCallback(sampleCallBack);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);//建立连接
            System.out.println("Connected");

            //订阅消息
            sampleClient.subscribe("MQTT Examples",1);
            System.out.println("Message subscribed");

            //推送消息
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");

            //断开连接
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}
