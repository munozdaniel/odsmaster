package com.wipro.wess.ods.sca;

/**
 * Inner class representing Primary Key
 */
public class OmScaServiceMapPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long scaServiceMapId;

    public OmScaServiceMapPK() {
    }

    public OmScaServiceMapPK(long scaServiceMapId) {
        this.scaServiceMapId = scaServiceMapId;
    }

    public OmScaServiceMapPK(String key) {
        if (key != null) {
            try {
                this.scaServiceMapId = Long.parseLong(key);
            } catch (NumberFormatException e) {

            }
        }
    }

    public long getScaServiceMapId() {
        return scaServiceMapId;
    }

    public void setScaServiceMapId(long scaServiceMapId) {
        this.scaServiceMapId = scaServiceMapId;
    }

    public String toString() {
        return "" + scaServiceMapId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (scaServiceMapId ^ (scaServiceMapId >>> 32));
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
        OmScaServiceMapPK other = (OmScaServiceMapPK) obj;
        if (scaServiceMapId != other.scaServiceMapId)
            return false;
        return true;
    }

}
