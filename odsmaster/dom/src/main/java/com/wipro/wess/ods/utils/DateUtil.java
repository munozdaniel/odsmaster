package com.wipro.wess.ods.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    
    public static String format(Date date, String format){
        if(format != null){
            formatter = new SimpleDateFormat(format);
        }
        return formatter.format(date);
    }
    public static Date parse(String date, String format){
        if(format != null){
            formatter = new SimpleDateFormat(format);
        }
        Date dt = null;
        try{
            dt = formatter.parse(date);
        }
        catch(ParseException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return dt;
    }

}
