package com.wipro.wess.ods.uom;

import java.io.Serializable;

public class MeasurementEntityPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3477262612510656264L;

    public String measureEntityId;

    public MeasurementEntityPK() {
    }

    public MeasurementEntityPK(String key) {
        this.measureEntityId = key;
    }

    public String getMeasureEntityId() {
        return measureEntityId;
    }

    public void setMeasureEntityId(String measureEntityId) {
        this.measureEntityId = measureEntityId;
    }

    @Override
    public String toString() {
        return "" + measureEntityId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((measureEntityId == null) ? 0 : measureEntityId.hashCode());
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
        MeasurementEntityPK other = (MeasurementEntityPK) obj;
        if (measureEntityId == null) {
            if (other.measureEntityId != null)
                return false;
        } else if (!measureEntityId.equals(other.measureEntityId))
            return false;
        return true;
    }

}
