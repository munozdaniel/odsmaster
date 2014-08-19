package com.wipro.wess.ods.munit;

import java.io.Serializable;

public class MUnitFamilyPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3919510683162507605L;

    public String unitFamilyId;

    public MUnitFamilyPK() {
    }

    public MUnitFamilyPK(String key) {
        this.unitFamilyId = key;
    }

    public String getUnitFamilyId() {
        return unitFamilyId;
    }

    public void setUnitFamilyId(String unitFamilyId) {
        this.unitFamilyId = unitFamilyId;
    }

    @Override
    public String toString() {
        return "" + unitFamilyId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((unitFamilyId == null) ? 0 : unitFamilyId.hashCode());
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
        MUnitFamilyPK other = (MUnitFamilyPK) obj;
        if (unitFamilyId == null) {
            if (other.unitFamilyId != null)
                return false;
        } else if (!unitFamilyId.equals(other.unitFamilyId))
            return false;
        return true;
    }

}
