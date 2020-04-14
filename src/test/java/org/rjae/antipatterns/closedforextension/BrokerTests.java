package org.rjae.antipatterns.closedforextension;

import org.junit.jupiter.api.Test;

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
        new Broker(producer).publish(question);
        assertEquals("42", question.Answer);
        assertTrue(producer.getMessages().containsKey(1));
        assertTrue(producer.getMessages().get(1).contains("{\"Answer\":\"42\"}"));
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
