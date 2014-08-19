package com.wipro.wess.ods.asset;

/**
 * Inner class representing Primary Key
 */
public class SupplierAssetServiceMapPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long saServiceMapId;

    public SupplierAssetServiceMapPK() {
    }

    public SupplierAssetServiceMapPK(String key) {
        this.saServiceMapId = Long.parseLong(key);
    }
    public SupplierAssetServiceMapPK(long saServiceMapId) {
        this.saServiceMapId = saServiceMapId;
    }

    public long getSaServiceMapId() {
        return saServiceMapId;
    }

    public void setSaServiceMapId(long saServiceMapId) {
        this.saServiceMapId = saServiceMapId;
    }

    public String toString() {
        return "" + saServiceMapId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (saServiceMapId ^ (saServiceMapId >>> 32));
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
        SupplierAssetServiceMapPK other = (SupplierAssetServiceMapPK) obj;
        if (saServiceMapId != other.saServiceMapId)
            return false;
        return true;
    }

}
