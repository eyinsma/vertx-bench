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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eyinsma on 2016/4/11.
 */
public class JsonServlet extends HttpServlet {

    // Response message class.
    public static class HelloMessage {
        public final String message;
        HelloMessage(String m){
            message = m;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Set content type to JSON
        res.setHeader("content-type", "application/json");

        // Write JSON encoded message to the response.
        try {
            Common.MAPPER.writeValue(res.getOutputStream(), new HelloMessage(Common.message));
        } catch (IOException ioe) {
            throw ioe;
        }
    }
}
