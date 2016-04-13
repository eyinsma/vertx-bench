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

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by eyinsma on 2016/4/7.
 */
public class Runner {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(50).setEventLoopPoolSize(2 * Runtime.getRuntime().availableProcessors()));
        vertx.deployVerticle("com.unknown.Jproxy");
        System.out.println("running..." + Runtime.getRuntime().availableProcessors());
    }

}
