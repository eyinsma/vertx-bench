/*
 * ----------------------------------------------------------------------
 * COPYRIGHT Ericsson 2016
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 * ----------------------------------------------------------------------
 */

package com.unknown;

import io.vertx.core.buffer.Buffer;

/**
 * Created by eyinsma on 2016/4/11.
 */
public class Common {
    public static String message;
    public static Buffer messageBuffer;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
            if (sb.length() >= 1024) {
                break;
            }
        }
        message = sb.toString();
        messageBuffer = Buffer.buffer(message);
    }

}
