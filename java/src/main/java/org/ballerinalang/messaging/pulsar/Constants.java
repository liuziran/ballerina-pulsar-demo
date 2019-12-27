package org.ballerinalang.messaging.pulsar;

import org.ballerinalang.jvm.types.BPackage;

import static org.ballerinalang.jvm.util.BLangConstants.BALLERINA_BUILTIN_PKG_PREFIX;

/**
 * @author Stephen.Liu
 * @date 2019/12/26 15:14
 */
public class Constants {
    public static final String PULSAR_PRODUCER = "pulsarProducer";
    public static final String PULSAR_CONSUMER = "pulsarConsumer";
    public static final String PULSAR_ERROR_DETAIL_RECORD = "Detail";
    public static final BPackage PULSAR_PACKAGE_ID = new BPackage(BALLERINA_BUILTIN_PKG_PREFIX, "pulsar");
    public static final String PULSAR_ERROR_CODE = "{ballerina/pulsar}Error";
}
