package br.com.study.spring_consumer.amqp.impl;

import br.com.study.spring_consumer.amqp.AmqpConsumer;
import br.com.study.spring_consumer.dto.MessageQueue;
import br.com.study.spring_consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerImpl implements AmqpConsumer<MessageQueue> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(MessageQueue messageQueue) {
        try {
            consumerService.action(messageQueue);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
