package br.com.study.spring_consumer.amqp;

public interface AmqpConsumer<T> {
    void consumer(T t);
}
