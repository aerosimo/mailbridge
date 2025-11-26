/******************************************************************************
 * This piece of work is to enhance mailbridge project functionality.         *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      RelayPoint.java                                                  *
 * Created:   26/11/2025, 00:18                                               *
 * Modified:  26/11/2025, 00:18                                               *
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

package com.aerosimo.ominet.core.model;

import com.aerosimo.ominet.core.config.Connect;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Date;

public class RelayPoint {

    private static final Logger log = LogManager.getLogger(RelayPoint.class);

    public static String send(String emailAddress, String emailSubject,
                              String emailMessage, String emailFiles,
                              String emailFrom) {
        try {
            Message msg = new MimeMessage(Connect.email());
            msg.setFrom(new InternetAddress(emailFrom));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            msg.setSubject(emailSubject);
            msg.setSentDate(new Date());

            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(emailMessage, "text/html; charset=UTF-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);

            if (emailFiles != null && !emailFiles.isBlank()) {
                for (String filePath : emailFiles.split(",")) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    attachPart.attachFile(filePath.trim());
                    multipart.addBodyPart(attachPart);
                }
            }

            msg.setContent(multipart);
            Transport.send(msg);
            log.info("Message sent successfully to {}", emailAddress);
            return "Message sent successfully";
        } catch (MessagingException | IOException err) {
            log.error("RelayPoint failed to send email", err);
            return "Message not successful: " + err.getMessage();
        }
    }
}