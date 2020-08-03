package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year = getYear();
        int month = getMonth();
        int date = getDate();
        int hour = getHour();
        int minute = getMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getMinute() {
        return getInfo("Minute",14,16,0,59);
    }

    private int getHour() {
        return getInfo("Hour",11,13,0,23);
    }

    private int getDate() {
        return getInfo("Date", 8,10,1,31);
    }

    public int getYear() {
        return getInfo("Year",0,4,2000,2012);
    }

    public int getMonth() {
        return getInfo("Month",5,7,1,12);
    }

    public int getInfo(String name, int index1,int index2, int range1, int range2) {
        int info;
        try {
            String monthString = dateAndTimeString.substring(index1, index2);
            info = Integer.parseInt(monthString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(name+" string is less than "+(index2-index1)+" characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(name+" is not an integer");
        }
        if (info < range1 || info > range2)
            throw new IllegalArgumentException(name+" cannot be less than "+range1+" or more than "+range2);

        return info;
    }
}
