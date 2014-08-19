package com.wipro.wess.ods.masterconfig;



/**
 * Inner class representing Primary Key
 */
public class AssetClassPK implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7777390197993009932L;
	public String assetclassCode;

	public AssetClassPK() {
	}

	public AssetClassPK(String assetclassCode) {
		this.assetclassCode = assetclassCode;
	}

	public String toString() {
		return "" + assetclassCode;
	}

    
    public String getAssetclassCode() {
        return assetclassCode;
    }

    
    public void setAssetclassCode(String assetclassCode) {
        this.assetclassCode = assetclassCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assetclassCode == null) ? 0 : assetclassCode.hashCode());
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
        AssetClassPK other = (AssetClassPK) obj;
        if (assetclassCode == null) {
            if (other.assetclassCode != null)
                return false;
        } else if (!assetclassCode.equals(other.assetclassCode))
            return false;
        return true;
    }

	

}
