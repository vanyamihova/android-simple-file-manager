package com.android.androidtask.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by vanya on 28.05.16.
 */
public class ATCalendarUtils {

    public static String formatDate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);

        SimpleDateFormat format1 = new SimpleDateFormat(CalendarFormat.FORMAT_1.getType(), Locale.getDefault());
        format1.setTimeZone(TimeZone.getDefault());

        return format1.format(calendar.getTime());
    }




    //*******************************
    //
    //*******************************
    public enum CalendarFormat {
        FORMAT_1("MMM d, yyyy");

        CalendarFormat(String type) {
            this.type = type;
        }
        private String type;
        public String getType() { return this.type; }
    }

}
