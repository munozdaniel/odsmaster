package com.wipro.wess.ods.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Warn logs
public enum Warn implements LoggerInterface {

    /**
     * 
     * 
     * 
     */
    W0000;

    static Logger logger = LoggerFactory.getLogger(Warn.class);

    public String format(Object... args) {
        if(Warn.isWarnEnabled()){
            String message = LoggerHelper.format(this, args);
            return message;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see net.atos.wlp.commoncomponent.logaudit.log.A#log(java.lang.String)
     */
    @Override
    public void log(String message) {
        Warn.logger.warn(message);
    }

    /*
     * (non-Javadoc)
     * @see net.atos.wlp.commoncomponent.logaudit.log.A#log(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void log(String message, Throwable e) {
        Warn.logger.warn(message, e);
    }

    /**
    *
    */
    public static boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

}
