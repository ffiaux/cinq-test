package com.cinq.rh.jms;

import java.util.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.springframework.stereotype.Component;

@Component
public class Client  
{	
	private KafkaProducer<String, String> producer;
	private Map<String, Object> config;
	
	public Client()
	{
		config = new HashMap<String, Object>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		producer = new KafkaProducer<String, String>(config);
	}

	public boolean sendAMessage(String greeting) 
	{
		producer.send(new ProducerRecord<String, String>("testTopic", "msg", greeting));
		System.out.println("[Client.sendAMessage()] Sending message: " + greeting);
		
		return true;
	}
}