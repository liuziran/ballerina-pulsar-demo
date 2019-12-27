package org.ballerinalang.messaging.pulsar;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.ballerinalang.jvm.values.ObjectValue;

/**
 * @author Stephen.Liu
 * @date 2019/12/26 14:50
 */
public class NewPulsarProducer {
    public static Object newPulsarProducer(ObjectValue obj, String serviceUrl, String topicName) throws PulsarClientException {
        try {
            PulsarClient client = PulsarClient.builder().serviceUrl(serviceUrl)
                    .build();
            Producer<String> producer = client.newProducer(Schema.JSON(String.class))
                    .topic(topicName)
                    .create();
            obj.addNativeData(Constants.PULSAR_PRODUCER, producer);
        } catch (Exception e) {
            System.out.println("error->"+e.getMessage());
            return e.getMessage();
        }

        return null;
    }
}
