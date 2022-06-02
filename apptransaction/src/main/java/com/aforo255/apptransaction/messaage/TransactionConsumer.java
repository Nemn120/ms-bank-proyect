package com.aforo255.apptransaction.messaage;

import com.aforo255.apptransaction.dtos.TransactionRequest;
import com.aforo255.apptransaction.models.TransactionModel;
import com.aforo255.apptransaction.services.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer  {

	   @Autowired
	    private ITransactionService transactionService;
	    @Autowired
	    private ObjectMapper objectMapper;
	    private Logger log = LoggerFactory.getLogger(TransactionConsumer.class);
	
	    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
		public void onMessage(ConsumerRecord<Integer, String> data) {
			// TODO Auto-generated method stub	    
	        try {

	            log.info("****************************************************************");
	            log.info("****************************************************************");
	            log.info("Consumer Receives in Microservice Account");
	            log.info("ConsumerRecord : {}", data.value());

	            TransactionRequest requestEvent = objectMapper.readValue(data.value(), TransactionRequest.class);
				TransactionModel transactionModel = new TransactionModel();
				transactionModel.setAmount(requestEvent.getAmount());
				transactionModel.setIdInvoice(requestEvent.getIdInvoice());
				transactionModel.setTransactionId(requestEvent.getIdOperation());
				transactionModel.setType(requestEvent.getType());
				transactionModel.setCreationDate(requestEvent.getDate());
				transactionService.add(transactionModel);
	            log.info("Id Transaction: {} -  Type: {} - Ammount: {}", requestEvent.getIdOperation(), requestEvent.getType(),
	                    requestEvent.getAmount());
	            log.info("****************************************************************");
	            log.info("****************************************************************");
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	       
	    }
	}
