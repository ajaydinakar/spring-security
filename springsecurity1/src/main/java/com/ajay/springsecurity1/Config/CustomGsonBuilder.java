package com.ajay.springsecurity1.Config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.datatype.XMLGregorianCalendar;

public class CustomGsonBuilder {
    public static Gson getGson(){
return new GsonBuilder()
        .registerTypeAdapter(XMLGregorianCalendarAdapter.class, new XMLGregorianCalendarAdapter())
        .setPrettyPrinting()
        .create();
    }
}
