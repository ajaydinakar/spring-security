package com.ajay.springsecurity1.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Document(collection = "AuditRequest2")
public class AuditRequest {

    @Id
    private String uid;
    private String emailid;

    private String eventName;

    private String eventTime;


    public AuditRequest(String uid, String emailid, String eventName) {
        this.uid = UUID.randomUUID().toString();
        this.emailid = emailid;
        this.eventName = eventName;
        this.eventTime = getDate();
    }

    public AuditRequest() {
    }

    private String getDate()
    {
        Instant date= new Date().toInstant();
        return date.toString();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
