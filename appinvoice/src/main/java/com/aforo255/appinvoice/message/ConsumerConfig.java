package com.aforo255.appinvoice.message;
 
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
 
@Configuration
@EnableKafka
public class ConsumerConfig {
 
	 @Bean
	    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
	            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
	            ConsumerFactory<Object, Object> kafkaConsumerFactory) {
	        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
	        configurer.configure(factory, kafkaConsumerFactory);
	        
	         factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
	        return factory;
	 }
}