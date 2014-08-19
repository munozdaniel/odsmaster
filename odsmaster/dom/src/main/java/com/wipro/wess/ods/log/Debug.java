package com.wipro.wess.ods.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public enum Debug implements LoggerInterface {

    PDMDEBUG;

    static Logger logger = LoggerFactory.getLogger(Debug.class);

    /**
	 *
	 */
    public static boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * Outputs a message at debug level. The message is built by taking each args in turn, and converting it to a
     * String. As the goal is logging, this is enough. As a result, pass the objects to the method, do not format
     * beforehand. This method first tests if debug is enabled.
     * 
     * @param args The objects that you want to be included in the message.
     * @return the message that was built; or null if debug is disabled
     */
    public String format(Object... args) {
        if (logger.isDebugEnabled()) {
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
        Debug.logger.debug(message);
    }

    /*
     * (non-Javadoc)
     * @see net.atos.wlp.commoncomponent.logaudit.log.A#log(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void log(String message, Throwable e) {
        Debug.logger.debug(message, e);
    }
}
