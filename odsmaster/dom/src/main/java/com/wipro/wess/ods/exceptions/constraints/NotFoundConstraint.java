package com.wipro.wess.ods.exceptions.constraints;

public class NotFoundConstraint extends Constraint {

    private String fieldValue;

    public NotFoundConstraint(String fieldName) {
        super(fieldName);
    }
    
    public NotFoundConstraint(String fieldName, String errorCode) {
        super(fieldName, errorCode);
    }
    
    public NotFoundConstraint(String fieldName, String errorCode, String fieldValue) {
        super(fieldName, errorCode);
        this.fieldValue = fieldValue;
    }

    public NotFoundConstraint(String fieldName, String errorCode, String errorMessage, String fieldValue) {
        super(fieldName, errorCode, errorMessage);
        this.fieldValue = fieldValue;
    }
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    @Override
    public String toString() {
        return "NotFoundConstraint [parameterName= " + parameterName + " error = " + getErrorCode() + " fieldValue = " + fieldValue + "]";
    }

   
}
