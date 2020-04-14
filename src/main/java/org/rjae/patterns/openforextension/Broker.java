package org.rjae.patterns.openforextension;

import com.google.gson.Gson;

public class Broker {
    private final IMessageProducer itsProducer;

    public Broker(IMessageProducer producer) {
        itsProducer = producer;
    }

    public void publish(Object value) {
        String message = new Gson().toJson(value);
        int partition = getPartition(message);
        publish(partition, message);
    }

    protected int getPartition(String message) {
        return 1;
    }

    protected void publish(int partition, String message) {
        getProducer().produce(partition, message);
    }

    private IMessageProducer getProducer() {
        return itsProducer;
    }
}
