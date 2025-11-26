/******************************************************************************
 * This piece of work is to enhance mailbridge project functionality.         *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      EmailRequestDTO.java                                            *
 * Created:   26/11/2025, 00:26                                               *
 * Modified:  26/11/2025, 00:26                                               *
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

package com.aerosimo.ominet.dao.impl;

public class EmailRequestDTO {

    private String emailAddress;
    private String emailSubject;
    private String emailMessage;
    private String emailFiles;

    public EmailRequestDTO() {
    }

    public EmailRequestDTO(String emailAddress, String emailSubject, String emailMessage, String emailFiles) {
        this.emailAddress = emailAddress;
        this.emailSubject = emailSubject;
        this.emailMessage = emailMessage;
        this.emailFiles = emailFiles;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getEmailFiles() {
        return emailFiles;
    }

    public void setEmailFiles(String emailFiles) {
        this.emailFiles = emailFiles;
    }

    @Override
    public String toString() {
        return "EmailRequestDTO{" +
                "emailAddress='" + emailAddress + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", emailMessage='" + emailMessage + '\'' +
                ", emailFiles='" + emailFiles + '\'' +
                '}';
    }
}