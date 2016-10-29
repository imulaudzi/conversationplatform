package com.isaac.conversationplatform.transformation;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * Created by isaac on 2016/10/27.
 */
public class DateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override
    public LocalDateTime unmarshal(String date) throws Exception {
        LocalDateTime unMarshalledDateTime;

        if (date == null) {
            unMarshalledDateTime = null;
        } else {
            unMarshalledDateTime = LocalDateTime.parse(date);
        }
        return unMarshalledDateTime;
    }

    @Override
    public String marshal(LocalDateTime date) throws Exception {
        String marshalledDateTime;
        if (date == null) {
            marshalledDateTime = null;
        } else {
            marshalledDateTime = date.toString();
        }
        return marshalledDateTime;
    }
}
