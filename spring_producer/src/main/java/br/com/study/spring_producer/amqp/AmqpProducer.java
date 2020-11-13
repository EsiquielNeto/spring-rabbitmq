package br.com.study.spring_producer.amqp;

public interface AmqpProducer<T> {

    void producer(T t);
}
