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

import java.util.Collections;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;

/**
 * Created by eyinsma on 2016/4/7.
 */
public class Jproxy extends AbstractVerticle{
    public void start() {
        int port = 48080;

        System.out.println("start proxy on port " + port);

        Router router = Router.router(vertx);

        router.route("/home").handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end("Welcome to Jproxy!");
        });

        router.route("/bench-text").handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/plain").end(Common.messageBuffer);
        });

        router.route("/bench-json").handler(routingContext -> {
            Buffer buff = Buffer.buffer(Json.encode(Collections.singletonMap("hello", Common.message)));
            routingContext.response().putHeader("content-type", "application/json").end(buff);
        });

        router.route("/bench-text-sub").handler(routingContext -> {
            routingContext.response().setChunked(true);
            routingContext.response().putHeader("content-type", "text/plain");
            routingContext.next();
        });

        router.route("/bench-text-sub").handler(routingContext -> {
            routingContext.response().write(Common.messageBuffer);
            routingContext.next();
        });

        router.route("/bench-text-sub").handler(routingContext -> {
            routingContext.response().end();
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(port);
    }

    public void stop() {
        System.out.println("stop...");
    }

}
