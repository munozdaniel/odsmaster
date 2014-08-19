package com.wipro.wess.ods.exceptions.constraints;

public class MandatoryConstraint extends Constraint {
    
    private String rowId;
    

    public MandatoryConstraint(String fieldName) {
        super(fieldName);
    }

    
    public String getRowId() {
        return rowId;
    }

    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Override
    public String toString() {
        return "MandatoryConstraint [parameterName= " + parameterName + " error = " + getErrorCode() + " row = "+ this.rowId + "]";
    }

    public MandatoryConstraint(String fieldName, String errorCode) {
        super(fieldName, errorCode);
    }
    
    public MandatoryConstraint(String fieldName, String errorCode, String rowId) {
        super(fieldName, errorCode);
        this.rowId = rowId;
    }
    
    public MandatoryConstraint(String fieldName, String errorCode, String errorMessage, String rowId) {
        super(fieldName, errorCode, errorMessage);
        this.rowId = rowId;
    }
}
