package com.example.remya.kafka.kafkaProducer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaProducerController {
	@Autowired
	@Qualifier("kafkaTemplateString")
	private KafkaTemplate<String,String> kafkaTemplateString;
	@Autowired
	@Qualifier("kafkaTemplateJSON")
	private KafkaTemplate<String, User> kafkaTemplateJSON;
	
	private static final String TOPIC="TestTopic";
	private static final String TOPICJSON="NewTopic";
	
	@Value("${cep.table}")
	private  String test;
	
	@Value("#{'${cep.oh.functionalRoleList}'.split(',')}") 
	private  List<String> testList;
	
	
	//@ConditionalOnMissingBean(KafkaTemplate.class)
	@GetMapping("/produce/{message}")
	public String KafkaProducer(@PathVariable("message") String messageValue) {
		//kafkaTemplateString.send(TOPIC,messageValue);
		String s= "select"+test+"."+test+" where";
		
		System.out.println("string s "+s);
		testList.forEach(System.out::println);
		
		System.out.println(testList.contains("oh_developer"));
		
		
		return "produced kafka topic "+messageValue;
	}
	
	 @GetMapping("/publish/{name}")
	    public String post(@PathVariable("name") final String name) {

		 kafkaTemplateJSON.send(TOPICJSON, new User(name, "Technology", 12000L));

	        return "Published successfully";
	    }

}
