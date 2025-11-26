<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~ This piece of work is to enhance mailbridge project functionality.        ~
  ~                                                                           ~
  ~ Author:    eomisore                                                       ~
  ~ File:      index.html                                                     ~
  ~ Created:   26/11/2025, 00:48                                              ~
  ~ Modified:  26/11/2025, 00:48                                              ~
  ~                                                                           ~
  ~ Copyright (c)  2025.  Aerosimo Ltd                                        ~
  ~                                                                           ~
  ~ Permission is hereby granted, free of charge, to any person obtaining a   ~
  ~ copy of this software and associated documentation files (the "Software"),~
  ~ to deal in the Software without restriction, including without limitation ~
  ~ the rights to use, copy, modify, merge, publish, distribute, sublicense,  ~
  ~ and/or sell copies of the Software, and to permit persons to whom the     ~
  ~ Software is furnished to do so, subject to the following conditions:      ~
  ~                                                                           ~
  ~ The above copyright notice and this permission notice shall be included   ~
  ~ in all copies or substantial portions of the Software.                    ~
  ~                                                                           ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,           ~
  ~ EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES           ~
  ~ OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                  ~
  ~ NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                ~
  ~ HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,              ~
  ~ WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING              ~
  ~ FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                ~
  ~ OR OTHER DEALINGS IN THE SOFTWARE.                                        ~
  ~                                                                           ~
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="Elijah Omisore" name="author">
    <meta content="Aerosimo 1.0.0" name="generator">
    <meta content="Aerosimo" name="application-name">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="Aerosimo IT Consultancy" name="description">
    <meta content="Aerosimo" name="apple-mobile-web-app-title">
    <meta content="Oracle, Java, Tomcat, Maven, Jenkins, Bitbucket, Github" name="keywords">
    <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport" />
    <!-- Title -->
    <title>MailBridge | Aerosimo Ltd</title>
    <!-- Favicon-->
    <link href="assets/img/favicon.ico" rel="shortcut icon"/>
    <link href="assets/img/favicon.ico" rel="icon" type="image/x-icon">
    <link href="assets/img/favicon-32x32.png" rel="icon" sizes="32x32" type="image/png">
    <link href="assets/img/favicon-16x16.png" rel="icon" sizes="16x16" type="image/png">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" sizes="180x180">
    <link href="assets/img/android-chrome-192x192.png" rel="android-chrome" sizes="192x192">
    <style>
        :root {
            --primary: #4d3b7a;
            --primary-light: #6a56a3;
            --bg-dark: #0f0f14;
            --bg-card: #1b1b23;
            --text-light: #e8e8f0;
            --text-muted: #a8a8b8;
        }

        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background: var(--bg-dark);
            color: var(--text-light);
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding: 40px 20px;
        }

        .container {
            width: 100%;
            max-width: 650px;
            background: var(--bg-card);
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 10px 35px rgba(0,0,0,0.5);
            border: 1px solid #2e2e3d;
            animation: fadeIn 0.7s ease;
        }

        @keyframes fadeIn { from {opacity:0;} to {opacity:1;} }

        .branding {
            text-align: center;
            margin-bottom: 25px;
        }

        .branding img {
            width: 110px;
            border-radius: 10px;
        }

        h1 {
            text-align: center;
            color: var(--primary-light);
            margin-bottom: 10px;
            font-size: 28px;
        }

        p.desc {
            text-align: center;
            color: var(--text-muted);
            margin-bottom: 30px;
            font-size: 15px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 18px;
        }

        .input-group label {
            font-size: 14px;
            margin-bottom: 6px;
            display: block;
            color: var(--text-muted);
        }

        .input-group input,
        .input-group textarea {
            width: 100%;
            padding: 12px 14px;
            border-radius: 10px;
            border: 1px solid #3a3a4c;
            background: #13131a;
            color: var(--text-light);
            font-size: 15px;
        }

        textarea {
            resize: vertical;
            min-height: 120px;
        }

        button {
            padding: 14px;
            background: var(--primary);
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 12px;
            cursor: pointer;
            transition: 0.2s;
        }

        button:hover {
            background: var(--primary-light);
        }

        .response-box {
            margin-top: 25px;
            background: #12121a;
            padding: 15px;
            border-radius: 10px;
            border: 1px solid #2f2f3f;
            font-size: 14px;
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="branding">
        <img src="https://thumbs4.imagebam.com/3e/10/82/MED2HDH_t.png" alt="Aerosimo Logo" />
    </div>

    <h1>MailBridge REST Tester</h1>
    <p class="desc">Send an email through the MailBridge REST endpoint.</p>

    <c:set var="baseUrl" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />

    <form id="emailForm">
        <div class="input-group">
            <label>Email Address</label>
            <input type="email" id="emailAddress" required />
        </div>

        <div class="input-group">
            <label>Subject</label>
            <input type="text" id="emailSubject" required />
        </div>

        <div class="input-group">
            <label>Message</label>
            <textarea id="emailMessage" required></textarea>
        </div>

        <button type="submit">Send Email</button>
    </form>

    <div id="response" class="response-box" style="display:none;"></div>
</div>

<script>
    const form = document.getElementById("emailForm");
    const responseBox = document.getElementById("response");
    const endpoint = "${baseUrl}/api/bridge/dispatch";

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const payload = {
            emailAddress: document.getElementById("emailAddress").value,
            emailSubject: document.getElementById("emailSubject").value,
            emailMessage: document.getElementById("emailMessage").value,
            emailFiles: null
        };

        responseBox.style.display = "block";
        responseBox.textContent = "Sending request...";

        try {
            const res = await fetch(endpoint, {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(payload)
            });

            const data = await res.json();
            responseBox.textContent = JSON.stringify(data, null, 4);
        } catch (err) {
            responseBox.textContent = "Error: " + err;
        }
    });
</script>
</body>
</html>