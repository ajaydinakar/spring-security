package com.ajay.springsecurity1.Config;

import com.google.gson.*;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;

public class XMLGregorianCalendarAdapter implements JsonSerializer<XMLGregorianCalendar>, JsonDeserializer<XMLGregorianCalendar> {
    @Override
    public JsonElement serialize(XMLGregorianCalendar src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toXMLFormat()); // Convert to ISO 8601 String format
    }

    @Override
    public XMLGregorianCalendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(json.getAsString());
        } catch (Exception e) {
            throw new JsonParseException("Error deserializing XMLGregorianCalendar", e);
        }
    }
}
