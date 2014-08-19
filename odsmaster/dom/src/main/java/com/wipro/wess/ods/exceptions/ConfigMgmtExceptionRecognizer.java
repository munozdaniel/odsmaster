package com.wipro.wess.ods.exceptions;

import org.apache.isis.applib.services.exceprecog.ExceptionRecognizerForType;


public class ConfigMgmtExceptionRecognizer extends ExceptionRecognizerForType {

    public ConfigMgmtExceptionRecognizer() {
        super(Exception.class, 
                prefix("Technical Exception occured, Please contact administrator"));
    }
}
