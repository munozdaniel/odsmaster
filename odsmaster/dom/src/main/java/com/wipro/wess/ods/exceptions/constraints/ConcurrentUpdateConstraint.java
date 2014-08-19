package com.wipro.wess.ods.exceptions.constraints;

public class ConcurrentUpdateConstraint extends Constraint {

    public ConcurrentUpdateConstraint(String fieldName) {
        super(fieldName);
    }

    @Override
    public String toString() {
        return "ConcurrentUpdateConstraint [parameterName= " + parameterName + " error = " + getErrorCode() + "]";
    }

    public ConcurrentUpdateConstraint(String fieldName, String errorCode) {
        super(fieldName, errorCode);
    }
}
