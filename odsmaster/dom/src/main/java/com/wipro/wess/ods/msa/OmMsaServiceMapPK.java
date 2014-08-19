package com.wipro.wess.ods.msa;

import java.io.Serializable;

public class OmMsaServiceMapPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6478514434403377593L;

    public long msaServiceMapId;

    public OmMsaServiceMapPK() {
    }

    public OmMsaServiceMapPK(long msaServiceMapId) {
        this.msaServiceMapId = msaServiceMapId;
    }

    public OmMsaServiceMapPK(String key) {
        if (key != null) {
            try {
                this.msaServiceMapId = Long.parseLong(key);
            } catch (NumberFormatException e) {

            }
        }

    }

    @Override
    public String toString() {
        return "" + this.msaServiceMapId;
    }

    public long getMsaServiceMapId() {
        return msaServiceMapId;
    }

    public void setMsaServiceMapId(long msaServiceMapId) {
        this.msaServiceMapId = msaServiceMapId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (msaServiceMapId ^ (msaServiceMapId >>> 32));
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
        OmMsaServiceMapPK other = (OmMsaServiceMapPK) obj;
        if (msaServiceMapId != other.msaServiceMapId)
            return false;
        return true;
    }

}
