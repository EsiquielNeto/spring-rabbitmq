package br.com.study.spring_producer.service;

import br.com.study.spring_producer.dto.MessageQueue;

public interface AmqpService {
    void sendToConsumer(MessageQueue messageQueue);
}
