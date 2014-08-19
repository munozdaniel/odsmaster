package com.wipro.wess.ods.munit;

import java.io.Serializable;

import com.wipro.wess.ods.utils.OmUtil;

public class MUnitPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2296177951429208104L;

    public String unitId;

    public MUnitPK(){}
    
    public MUnitPK(String key){
        this.unitId = OmUtil.decode(key);
    }
    
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Override
    public String toString() {
        return OmUtil.encode("" + this.unitId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
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
        MUnitPK other = (MUnitPK) obj;
        if (unitId == null) {
            if (other.unitId != null)
                return false;
        } else if (!unitId.equals(other.unitId))
            return false;
        return true;
    }

}
