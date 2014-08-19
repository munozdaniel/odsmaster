package com.wipro.wess.ods.asset;

/**
 * Inner class representing Primary Key
 */
public class SupplierAssetConfigPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public String supAssetUid;

    public SupplierAssetConfigPK() {
    }

    public SupplierAssetConfigPK(String supAssetUid) {
        this.supAssetUid = supAssetUid;
    }

    public String getSupAssetUid() {
        return supAssetUid;
    }

    public void setSupAssetUid(String supAssetUid) {
        this.supAssetUid = supAssetUid;
    }

    public String toString() {
        return "" + supAssetUid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((supAssetUid == null) ? 0 : supAssetUid.hashCode());
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
        SupplierAssetConfigPK other = (SupplierAssetConfigPK) obj;
        if (supAssetUid == null) {
            if (other.supAssetUid != null)
                return false;
        } else if (!supAssetUid.equals(other.supAssetUid))
            return false;
        return true;
    }

}
