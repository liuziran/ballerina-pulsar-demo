package org.ballerinalang.messaging.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.ballerinalang.jvm.values.ObjectValue;

/**
 * @author Stephen.Liu
 * @date 2019/12/27 14:45
 */
public class Get {
    public static Object get(ObjectValue obj) {
        try {
            Consumer consumer = (Consumer) obj.getNativeData(Constants.PULSAR_CONSUMER);
            Message message = consumer.receive();
            String msgStr = new String(message.getData());
            return msgStr;

        } catch (Exception e) {
            return "get error";
        }

    }
}
