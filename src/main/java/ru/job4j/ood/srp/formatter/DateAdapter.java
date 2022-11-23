package ru.job4j.ood.srp.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAdapter extends XmlAdapter<String, Calendar> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(Calendar v) throws Exception {
        DATE_FORMAT.setTimeZone(v.getTimeZone());
        return DATE_FORMAT.format(v.getTime());
    }
}
