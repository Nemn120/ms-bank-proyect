package com.aforo255.appinvoice.message;

import com.aforo255.appinvoice.dtos.TransactionRequest;
import com.aforo255.appinvoice.models.InvoiceModel;
import com.aforo255.appinvoice.services.IInvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    Logger log = LoggerFactory.getLogger(TransactionConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private IInvoiceService iInvoiceService;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void listenGroupFoo(String message) {
        log.info("Mensaje Recibido: {}", message);
        try {
            log.info("****************************************************************");
            log.info("****************************************************************");
            log.info("Recibiendo mensaje en microservicio Invoice");
            log.info("ConsumerRecord : {}", message);

            TransactionRequest requestEvent = objectMapper.readValue(message, TransactionRequest.class);

            log.info("Id Transaction: {} -  Type: {} - Amount: {}", requestEvent.getIdOperation(), requestEvent.getType(),
                    requestEvent.getAmount());
            InvoiceModel invoiceModel = iInvoiceService.findById(requestEvent.getIdInvoice());
            if ("pay".equals(requestEvent.getType()) && invoiceModel.getState() != 1) {
                double result = invoiceModel.getAmount() - requestEvent.getAmount();
                if (result >= 0) {
                    invoiceModel.setAmount(result);
                    if (result == 0)
                        invoiceModel.setState(1);
                    else
                        invoiceModel.setState(0);
                    invoiceModel.setIdInvoice(requestEvent.getIdInvoice());
                    invoiceModel.setAmount(requestEvent.getAmount());
                    iInvoiceService.update(invoiceModel);
                }
            }
            log.info("****************************************************************");
            log.info("****************************************************************");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
