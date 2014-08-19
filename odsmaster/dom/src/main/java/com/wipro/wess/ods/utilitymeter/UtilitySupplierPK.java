package com.wipro.wess.ods.utilitymeter;

/**
 * Inner class representing Primary Key
 */
public class UtilitySupplierPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long supplierId;

    public UtilitySupplierPK() {
    }

    public UtilitySupplierPK(String supplierId) {
        if (supplierId != null) {
            try {
                this.supplierId = Long.parseLong(supplierId);
            } catch (NumberFormatException e) {

            }

        }
    }

    public String toString() {
        return "" + supplierId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (supplierId ^ (supplierId >>> 32));
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
        UtilitySupplierPK other = (UtilitySupplierPK) obj;
        if (supplierId != other.supplierId)
            return false;
        return true;
    }

}
