package com.wipro.wess.ods.exceptions.constraints;

public class SecurityCheckFailedConstraint extends Constraint {
    String fieldValue;
    

    public SecurityCheckFailedConstraint() {
        super();
    }

    public SecurityCheckFailedConstraint(String parameterName, String errorCode, String errorMessage) {
        super(parameterName, errorCode, errorMessage);
    }
    
    public SecurityCheckFailedConstraint(String parameterName, String errorCode, String errorMessage, String fieldValue) {
        super(parameterName, errorCode, errorMessage);
        this.fieldValue = fieldValue;
    }

    
    public String getFieldValue() {
        return fieldValue;
    }

    
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "SecurityCheckFailedConstraint [errorCode = " + getErrorCode() + ", parameterName = "
                + getParameterName() + ", errorMessage = " + getErrorMessage() + ", fieldValue = " +this.fieldValue + "]";
    }

}
