package com.wipro.wess.ods.sca;

/**
 * Inner class representing Primary Key
 */
public class ScaConfigPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public String scaUid;

    public ScaConfigPK() {
    }

    public ScaConfigPK(String scaUid) {
        this.scaUid = scaUid;
    }

    public String getScaUid() {
        return scaUid;
    }

    public void setScaUid(String scaUid) {
        this.scaUid = scaUid;
    }

    public String toString() {
        return "" + this.scaUid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((scaUid == null) ? 0 : scaUid.hashCode());
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
        ScaConfigPK other = (ScaConfigPK) obj;
        if (scaUid == null) {
            if (other.scaUid != null)
                return false;
        } else if (!scaUid.equals(other.scaUid))
            return false;
        return true;
    }

}
