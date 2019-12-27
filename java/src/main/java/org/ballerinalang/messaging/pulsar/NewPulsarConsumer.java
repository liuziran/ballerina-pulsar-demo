package org.ballerinalang.messaging.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.ballerinalang.jvm.values.ObjectValue;

/**
 * @author Stephen.Liu
 * @date 2019/12/27 14:36
 */
public class NewPulsarConsumer {
    public static Object newPulsarConsumer(ObjectValue obj, String serviceUrl, String topicName, String subscriptionName) {
        try {
            PulsarClient client = PulsarClient.builder().serviceUrl(serviceUrl).build();
            Consumer consumer = client.newConsumer()
                    .topic(topicName)
                    .subscriptionName(subscriptionName)
                    .subscribe();
            obj.addNativeData(Constants.PULSAR_CONSUMER, consumer);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
