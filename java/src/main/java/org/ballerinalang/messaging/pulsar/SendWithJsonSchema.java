package org.ballerinalang.messaging.pulsar;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

/**
 * @author Stephen.Liu
 * @date 2019/12/25 18:50
 */
public class SendWithJsonSchema {
//    private static final Logger logger = LoggerFactory.getLogger(SendWithJsonSchema.class);

    public static void sendWithJsonSchema() throws PulsarClientException {

        PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://47.112.134.254:6650")
                .build();
        Producer<String> producer = client.newProducer(Schema.JSON(String.class))
                .topic("abc-lzr")
                .create();
        producer.send("i am coming !!!111");
    }
}
