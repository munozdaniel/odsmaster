package com.wipro.wess.ods.uom;

import java.io.Serializable;

public class MeasurementPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3477262612510656264L;

    public String measureId;

    public MeasurementPK(){}
    
    public MeasurementPK(String key){
        this.measureId = key;
    }
    
    public String getMeasureId() {
        return measureId;
    }

    
    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }

    

    @Override
    public String toString() {
        return "" + measureId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((measureId == null) ? 0 : measureId.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MeasurementPK other = (MeasurementPK) obj;
        if (measureId == null) {
            if (other.measureId != null)
                return false;
        } else if (!measureId.equals(other.measureId))
            return false;
        return true;
    }
    
}
