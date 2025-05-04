package com.ajay.springsecurity1.domain;

import javax.xml.datatype.XMLGregorianCalendar;

public class LoginRequest extends AuditRequest {
    public LoginRequest() {
        super();

    }

    public LoginRequest(String uid, String emailid, String eventName) {
        super(uid, emailid, eventName);
    }
}
