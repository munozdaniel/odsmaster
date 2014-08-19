package com.wipro.wess.ods.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Info logs
public enum Info implements LoggerInterface {
    

    /**
     * @meaning Provisioning Data Management info logging
     */
    PDMINFO;

    static Logger logger = LoggerFactory.getLogger(Info.class);

    public String format(Object... args) {
        if(Info.isInfoEnabled()){
            String message = LoggerHelper.format(this, args);
            return message;
        }
        return null;
        
    }

    @Override
    public void log(String message) {
        Info.logger.info(message);
    }

    @Override
    public void log(String message, Throwable e) {
        Info.logger.info(message, e);
    }

    public static boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }
}
