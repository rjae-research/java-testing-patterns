package org.rjae.antipatterns.closedforextension;

import com.google.gson.Gson;

public class Broker {
    private final IMessageProducer itsProducer;

    public Broker(IMessageProducer producer) {
        itsProducer = producer;
    }

    public void publish(Object value) {
        String message = new Gson().toJson(value);
        int partition = Broker.getPartition(message);
        publish(partition, message);
    }

    private static int getPartition(String message) {
        return 1;
    }

    private IMessageProducer getProducer() {
        return itsProducer;
    }

    private void publish(int partition, String message) {
        getProducer().produce(partition, message);
    }
}
