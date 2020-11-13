package br.com.study.spring_producer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerRabbitConfiguration {

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.dead-letter.producer}")
    private String deadletter;

    @Value("${spring.rabbitmq.request.parking-lot.producer}")
    private String parkingLot;

    @Bean
    public Binding bindingQueue() {
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(queue);
    }

    @Bean
    public Binding bindingDeadLetter() {
        return BindingBuilder.bind(deadLetter())
                .to(exchange()).with(deadletter);
    }

    @Bean
    public Binding bindingParkingLot() {
        return BindingBuilder.bind(parkingLot())
                .to(exchange())
                .with(parkingLot);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue deadLetter() {
        return QueueBuilder
                .durable(deadletter)
                .deadLetterExchange(exchange)
                .deadLetterRoutingKey(queue)
                .build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(queue)
                .deadLetterExchange(exchange)
                .deadLetterRoutingKey(deadletter)
                .build();
    }

    @Bean
    Queue parkingLot() {
        return new Queue(parkingLot);
    }
}
