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
public class PlaintextServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        // Set content type to text/plain.
        res.setHeader("content-type", "text/plain");

        // Write plaintext "Hello, World!" to the response.
        try
        {
            res.getWriter().write(Common.message);
        }
        catch (IOException ioe)
        {
            throw ioe;
        }
    }

}
