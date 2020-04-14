package org.rjae.antipatterns.closedforextension;

public interface IMessageProducer {
    void produce(int partition, String message);
}
