package org.rjae.patterns.openforextension;

public class ShardedBroker extends Broker {
    public ShardedBroker(IMessageProducer producer) {
        super(producer);
    }

    @Override
    protected int getPartition(String message) {
        super.getPartition(message);
        return message.hashCode();
    }
}
