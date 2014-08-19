package com.wipro.wess.ods.msa;

import java.io.Serializable;

public class OmMsaScaMapPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6478514434403377593L;

    public long msaScaMapId;

    public OmMsaScaMapPK() {
    }

    public OmMsaScaMapPK(long msaScaMapId) {
        this.msaScaMapId = msaScaMapId;
    }

    public OmMsaScaMapPK(String key) {
        if (key != null) {
            try {
                this.msaScaMapId = Long.parseLong(key);
            } catch (NumberFormatException e) {

            }
        }

    }

    @Override
    public String toString() {
        return "" + this.msaScaMapId;
    }

    public long getMsaScaMapId() {
        return msaScaMapId;
    }

    public void setMsaScaMapId(long msaScaMapId) {
        this.msaScaMapId = msaScaMapId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (msaScaMapId ^ (msaScaMapId >>> 32));
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
        OmMsaScaMapPK other = (OmMsaScaMapPK) obj;
        if (msaScaMapId != other.msaScaMapId)
            return false;
        return true;
    }

}
