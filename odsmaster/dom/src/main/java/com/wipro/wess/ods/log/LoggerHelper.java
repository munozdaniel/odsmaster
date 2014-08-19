package com.wipro.wess.ods.log;



public class LoggerHelper {

    public static String format(Enum<? extends LoggerInterface> en, Object[] args) {
      
        StringBuilder builder = new StringBuilder(en.name());
        boolean first = true;
        for (Object o : args) {
            builder.append((first) ? Character.valueOf('\t') : ", ");
            first = false;
            builder.append(o);
        }
        String message = new String(builder.toString());

        LoggerInterface loggerInterface = (LoggerInterface) en;
        if ((args != null) && (args.length > 0) && (args[(args.length - 1)] instanceof Throwable)) {
            loggerInterface.log(message, (Throwable) args[(args.length - 1)]);
        } else
            loggerInterface.log(message);

        return message;
    }
}
