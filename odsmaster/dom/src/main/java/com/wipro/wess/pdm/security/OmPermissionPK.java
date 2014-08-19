package com.wipro.wess.pdm.security;

/**
 * Inner class representing Primary Key
 */
public class OmPermissionPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long permissionId;

    public OmPermissionPK() {
    }

    public OmPermissionPK(String permissionId) {
        if (permissionId != null) {
            try {
                this.permissionId = Long.parseLong(permissionId);
            } catch (NumberFormatException e) {

            }

        }
    }

    public String toString() {
        return "" + permissionId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (permissionId ^ (permissionId >>> 32));
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
        OmPermissionPK other = (OmPermissionPK) obj;
        if (permissionId != other.permissionId)
            return false;
        return true;
    }

}
