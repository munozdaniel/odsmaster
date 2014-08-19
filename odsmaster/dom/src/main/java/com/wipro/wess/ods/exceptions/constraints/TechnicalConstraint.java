package com.wipro.wess.ods.exceptions.constraints;

public class TechnicalConstraint extends Constraint {

    

    @Override
    public String toString() {
        return "TechnicalConstraint [error = " + getErrorCode() + "]";
    }

    public TechnicalConstraint(String errorCode) {
        super(errorCode);
    }
}
