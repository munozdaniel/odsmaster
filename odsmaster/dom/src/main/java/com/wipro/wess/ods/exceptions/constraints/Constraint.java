package com.wipro.wess.ods.exceptions.constraints;

public class Constraint {

    private String errorCode;

    public String parameterName;
    
    private String errorMessage;

    public Constraint(String parameterName, String errorCode) {
        setParameterName(parameterName);
        setErrorCode(errorCode);
    }

    public Constraint(String parameterName) {
        setParameterName(parameterName);
    }

    public Constraint(String parameterName, String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.parameterName = parameterName;
        this.errorMessage = errorMessage;
    }

    public Constraint() {
    }

    

    @Override
    public String toString() {
        return "Constraint [errorCode=" + errorCode + ", parameterName=" + parameterName + ", errorMessage="
                + errorMessage + "]";
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return this.parameterName;
    }

    
    public String getErrorMessage() {
        return errorMessage;
    }

    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
