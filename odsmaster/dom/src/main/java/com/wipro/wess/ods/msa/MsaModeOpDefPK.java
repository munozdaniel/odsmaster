package com.wipro.wess.ods.msa;

/**
 * Inner class representing Primary Key
 */
public class MsaModeOpDefPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public int msaMopDefId;

    public MsaModeOpDefPK() {
    }

    public MsaModeOpDefPK(int msaMopDefId) {
        this.msaMopDefId = msaMopDefId;
    }
    
    public MsaModeOpDefPK(String key) {
        this.msaMopDefId = Integer.parseInt(key);
    }

    public String toString() {
        return "" + msaMopDefId;
    }

    public int getMsaMopDefId() {
        return msaMopDefId;
    }

    public void setMsaMopDefId(int msaMopDefId) {
        this.msaMopDefId = msaMopDefId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + msaMopDefId;
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
        MsaModeOpDefPK other = (MsaModeOpDefPK) obj;
        if (msaMopDefId != other.msaMopDefId)
            return false;
        return true;
    }

}
