package com.wipro.wess.ods.uom;

import java.io.Serializable;

public class MExtDataSourceInfoPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4821863741045027893L;

    public String extDataSourceId;

    public MExtDataSourceInfoPK() {
    }

    public MExtDataSourceInfoPK(String key) {
        this.extDataSourceId = key;
    }

    @Override
    public String toString() {
        return "" + extDataSourceId;
    }

    public String getExtDataSourceId() {
        return extDataSourceId;
    }

    public void setExtDataSourceId(String extDataSourceId) {
        this.extDataSourceId = extDataSourceId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((extDataSourceId == null) ? 0 : extDataSourceId.hashCode());
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
        MExtDataSourceInfoPK other = (MExtDataSourceInfoPK) obj;
        if (extDataSourceId == null) {
            if (other.extDataSourceId != null)
                return false;
        } else if (!extDataSourceId.equals(other.extDataSourceId))
            return false;
        return true;
    }

}
