package org.rjae.antipatterns.closedforextension;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokerTests {
    @Test
    void publishMustProduceMessage() {
        MockMessageProducer producer = new MockMessageProducer();
        MeaningOfLife question = new MeaningOfLife();
        new Broker(producer).publish(question);
        assertEquals("42", question.Answer);
        assertTrue(producer.getMessages().contains("{\"Answer\":\"42\"}"));
    }

    private static class MeaningOfLife {
        public String Answer = "42";

        public MeaningOfLife() {
        }
    }

    private class MockMessageProducer implements IMessageProducer {
        private final ArrayList<String> itsMessages = new ArrayList<String>();

        public ArrayList<String> getMessages() {
            return itsMessages;
        }

        @Override
        public void produce(int partition, String message) {
            getMessages().add(message);
        }
    }
}
