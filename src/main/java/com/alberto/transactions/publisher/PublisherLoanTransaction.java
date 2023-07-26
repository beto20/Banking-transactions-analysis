package com.alberto.transactions.publisher;

import com.alberto.transactions.service.LoanServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
@Qualifier("loan-publisher")
public class PublisherLoanTransaction implements PublisherTransaction{

    Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
    @Value("${kafka-topic-loan}")
    private String topicLoan;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PublisherLoanTransaction(KafkaTemplate<String, Object> kafka) {
        this.kafkaTemplate = kafka;
    }

    @Override
    public void publishMessage(String message) {
        logger.info("Message:: {}, topic:: {}", message, topicLoan);

        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        System.out.println("message Output Bytes:: " + Arrays.toString(bytes));

        var process = kafkaTemplate.send(topicLoan, bytes);

        process.completable().whenComplete((result, exception) -> {
            if (exception == null) logger.info("Message send successfully, offset {}", result.getRecordMetadata().offset());
            else logger.error("Message send failed, offset {}", result.getRecordMetadata());
        });
    }
}
