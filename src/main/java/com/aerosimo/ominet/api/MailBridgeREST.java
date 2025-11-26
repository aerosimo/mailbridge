/******************************************************************************
 * This piece of work is to enhance mailbridge project functionality.         *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      MailBridgeREST.java                                             *
 * Created:   26/11/2025, 00:30                                               *
 * Modified:  26/11/2025, 00:30                                               *
 *                                                                            *
 * Copyright (c)  2025.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo.ominet.api;

import com.aerosimo.ominet.core.model.RelayPoint;
import com.aerosimo.ominet.dao.impl.APIResponseDTO;
import com.aerosimo.ominet.dao.impl.EmailRequestDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/bridge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MailBridgeREST {

    private static final Logger log = LogManager.getLogger(MailBridgeREST.class);

    @POST
    @Path("/dispatch")
    public Response sendMail(EmailRequestDTO req) {
        if (req == null ||
                req.getEmailAddress() == null || req.getEmailAddress().isBlank() ||
                req.getEmailSubject() == null || req.getEmailSubject().isBlank() ||
                req.getEmailMessage() == null || req.getEmailMessage().isBlank()) {
            log.error("Missing required parameters in EmailRequestDTO");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new APIResponseDTO("unsuccessful", "missing required fields"))
                    .build();
        }
        String ref = RelayPoint.send(
                req.getEmailAddress(),
                req.getEmailSubject(),
                req.getEmailMessage(),
                req.getEmailFiles(),
                "Aerosimo Support<support@aerosimo.com>"
        );
        if ("Message sent successfully".equals(ref)) {
            return Response.ok(new APIResponseDTO("success", "message sent successfully")).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new APIResponseDTO("unsuccessful", "message not successful"))
                    .build();
        }
    }
}