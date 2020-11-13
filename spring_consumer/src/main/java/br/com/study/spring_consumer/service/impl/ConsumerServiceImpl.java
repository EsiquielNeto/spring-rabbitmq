package br.com.study.spring_consumer.service.impl;

import br.com.study.spring_consumer.dto.MessageQueue;
import br.com.study.spring_consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(MessageQueue messageQueue) throws Exception {
        System.out.printf(messageQueue.getText());
    }
}
