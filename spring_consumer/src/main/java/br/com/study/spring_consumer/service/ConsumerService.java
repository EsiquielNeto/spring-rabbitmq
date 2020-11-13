package br.com.study.spring_consumer.service;

import br.com.study.spring_consumer.dto.MessageQueue;

public interface ConsumerService {
    void action(MessageQueue messageQueue) throws Exception;
}
