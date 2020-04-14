package org.rjae.patterns.openforextension;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokerTests {
    @Test
    void publishMustProduceMessage() {
        MockMessageProducer producer = new MockMessageProducer();
        MeaningOfLife question = new MeaningOfLife();
        new ShardedBroker(producer).publish(question);
        String message = String.format("{\"Answer\":\"%s\"}", question.Answer);
        assertTrue(producer.getMessages().containsKey(message.hashCode()));
        assertTrue(producer.getMessages().get(message.hashCode()).contains(message));
    }

    @Test
    void getPartitionMustReturnStaticValueWhenCalled() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getPartition = Broker.class.getDeclaredMethod("getPartition", String.class);
        getPartition.setAccessible(true);
        assertEquals(1, getPartition.invoke(new Broker(null), "Bob"));
        assertEquals(1, getPartition.invoke(new Broker(null), "Alice"));
    }

    private static class MeaningOfLife {
        public String Answer = "42";

        public MeaningOfLife() {
        }
    }

    private class MockMessageProducer implements IMessageProducer {
        private final Map<Integer, ArrayList<String>> itsMessages = new HashMap<>();

        public Map<Integer, ArrayList<String>> getMessages() {
            return itsMessages;
        }

        @Override
        public void produce(int partition, String message) {
            if (!getMessages().containsKey(partition)) {
                getMessages().put(partition, new ArrayList<>());
            }
            getMessages().get(partition).add(message);
        }
    }
}
