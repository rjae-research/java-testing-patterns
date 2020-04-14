package org.rjae.patterns.openforextension;

public interface IMessageProducer {
    void produce(int partition, String message);
}
