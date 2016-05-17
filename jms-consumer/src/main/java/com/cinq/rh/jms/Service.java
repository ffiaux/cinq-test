package com.cinq.rh.jms;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerConfig;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Service implements Runnable {
	private Properties config;
	private ConsumerConfig consumerConfig;
	private ConsumerConnector consumerConnector;
	private Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap;
	private List<KafkaStream<byte[], byte[]>> streamList;
	private KafkaStream<byte[], byte[]> stream;
	
	public static void main(String args[]) 
	{ 
		System.out.println("Consuming the messages....");
		Thread thread = new Thread(new Service());
		thread.start();
	}
	
	public Service()
	{
		config = new Properties();
		config.put("zookeeper.connect", "localhost:2181");
		config.put("group.id", "default");
		config.put("partition.assignment.strategy", "roundrobin");
		config.put("bootstrap.servers", "localhost:9092");
		config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		kafka.consumer.ConsumerConfig consumerConfig = new kafka.consumer.ConsumerConfig(config);
		consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
	 
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put("testTopic", 1);
	 
		consumerMap = consumerConnector.createMessageStreams(topicCountMap);
	 
		streamList = consumerMap.get("testTopic");
	 
		stream = streamList.get(0);
		
	}

	public void run() {
		// Loop receiving messages
		System.out.println("[Service.run()] Consuming messages...");
		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
		while(iterator.hasNext()) 
		{
			System.out.println(new String(iterator.next().message()));
		}
	}
}