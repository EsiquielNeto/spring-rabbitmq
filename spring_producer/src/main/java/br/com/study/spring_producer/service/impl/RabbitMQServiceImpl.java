package br.com.study.spring_producer.service.impl;

import br.com.study.spring_producer.amqp.AmqpProducer;
import br.com.study.spring_producer.dto.MessageQueue;
import br.com.study.spring_producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<MessageQueue> amqpProducer;

    @Override
    public void sendToConsumer(MessageQueue messageQueue) {
        amqpProducer.producer(messageQueue);
    }
}
