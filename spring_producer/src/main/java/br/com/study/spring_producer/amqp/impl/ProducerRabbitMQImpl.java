package br.com.study.spring_producer.amqp.impl;

import br.com.study.spring_producer.amqp.AmqpProducer;
import br.com.study.spring_producer.dto.MessageQueue;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQImpl implements AmqpProducer<MessageQueue> {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageQueue messageQueue) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, messageQueue);

        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
