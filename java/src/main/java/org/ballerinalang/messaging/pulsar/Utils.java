package org.ballerinalang.messaging.pulsar;

import org.ballerinalang.jvm.BallerinaErrors;
import org.ballerinalang.jvm.BallerinaValues;
import org.ballerinalang.jvm.TypeChecker;
import org.ballerinalang.jvm.types.BType;
import org.ballerinalang.jvm.values.ArrayValue;
import org.ballerinalang.jvm.values.ErrorValue;
import org.ballerinalang.jvm.values.MapValue;

import java.nio.charset.StandardCharsets;

/**
 * @author Stephen.Liu
 * @date 2019/12/26 15:17
 */
public class Utils {
    public static ErrorValue createPulsarError(String detailedErrorMessage) {
        MapValue<String, Object> errorDetailRecord = BallerinaValues
                .createRecordValue(Constants.PULSAR_PACKAGE_ID, Constants.PULSAR_ERROR_DETAIL_RECORD);
        errorDetailRecord.put("message", detailedErrorMessage);
        return BallerinaErrors.createError(Constants.PULSAR_ERROR_CODE, errorDetailRecord);
    }

    public static byte[] convertDataIntoByteArray(Object data) {
        BType dataType = TypeChecker.getType(data);
        int typeTag = dataType.getTag();
        if (typeTag == org.wso2.ballerinalang.compiler.util.TypeTags.STRING) {
            return ((String) data).getBytes(StandardCharsets.UTF_8);
        } else {
            return ((ArrayValue) data).getBytes();
        }
    }
}
