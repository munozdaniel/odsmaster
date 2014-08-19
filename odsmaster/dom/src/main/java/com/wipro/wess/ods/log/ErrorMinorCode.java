package com.wipro.wess.ods.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// Error logs
public enum ErrorMinorCode implements LoggerInterface {

    /**
     * @meaning Mandatory Constraint error minor code 
     */
    PDMError001,
    
    /**
     * @meaning NotFound Constraint error minor code 
     */
    PDMError002,
    
    /**
     * @meaning No data or wrong format excel minor code
     */
    PDMError003,
    
    /**
     * @meaning Technical Exception minor code
     */
    PDMError004,
    
    /**
     * @meaning Permission denied minor code
     */
    PDMError005,
    
    ;
    
    static Logger logger = LoggerFactory.getLogger(ErrorMinorCode.class);

    /**
     * @param args
     * @return String
     */
    public String format(Object... args) {
        if (ErrorMinorCode.isErrorEnabled()) {
            final String message = LoggerHelper.format(this, args);
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
        ErrorMinorCode.logger.error(message);
    }

    /*
     * (non-Javadoc)
     * @see net.atos.wlp.commoncomponent.logaudit.log.A#log(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void log(String message, Throwable e) {
        ErrorMinorCode.logger.error(message, e);
    }

    /**
    *
    */
    public static boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }
}
