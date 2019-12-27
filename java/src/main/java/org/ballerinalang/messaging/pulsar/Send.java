package org.ballerinalang.messaging.pulsar;

import org.apache.pulsar.client.api.Producer;
import org.ballerinalang.jvm.values.ObjectValue;

/**
 * @author Stephen.Liu
 * @date 2019/12/26 14:56
 */
public class Send {
    public static Object send(ObjectValue obj, String val) {
        try {
        Producer producer = (Producer) obj.getNativeData(Constants.PULSAR_PRODUCER);
        producer.send(val);
            return null;
        } catch (Exception e) {
//            return Utils.createPulsarError(e.getMessage());
            System.out.println("send error->"+e.getMessage());
            return e.getMessage();
        }


    }
}
