package org.ballerinalang.messaging.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageId;
import org.ballerinalang.jvm.values.ObjectValue;

/**
 * @author Stephen.Liu
 * @date 2019/12/27 14:45
 */
public class Get {
    public static Object get(ObjectValue obj) {
        try {
            Consumer consumer = (Consumer) obj.getNativeData(Constants.PULSAR_CONSUMER);
            String s = "default";
            while (true) {
                Message message = consumer.receive();
                if (message.getData() != null) {
                    s += new String(message.getData());
                    MessageId messageId = message.getMessageId();
                    consumer.acknowledge(messageId);
                    consumer.close();
                    break;
                }
            }

            return s;
        } catch (Exception e) {
            return "get error";
        }

    }
}
