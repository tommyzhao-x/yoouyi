package com.yoouyi.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public final static String YEAR_MONTH_DAY = "YYYY-MM-dd";

    public static String getDateStr(Long timeStamp, String format) {

        Date date = new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);
    }

}
