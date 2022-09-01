package com.example.remya.kafka.kafkaProducer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaCOnfiguration2 {

	 
		@Bean
	    public ProducerFactory<String, String> producerFactoryString() {
	        Map<String, Object> configString = new HashMap<>();

	        configString.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	        configString.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        configString.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

	        return new DefaultKafkaProducerFactory<String, String>(configString);
	    }


	    @Bean(name="kafkaTemplateString")
	    public KafkaTemplate<String, String> kafkaTemplate() {
	        return new KafkaTemplate<String, String>(producerFactoryString());
	    }

}
