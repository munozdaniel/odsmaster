package com.wipro.wess.pdm.security;

/**
 * Inner class representing Primary Key
 */
public class OmRolePermissionPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long rolePermissionId;

    public OmRolePermissionPK() {
    }

    public OmRolePermissionPK(String rolePermissionId) {
        if (rolePermissionId != null) {
            try {
                this.rolePermissionId = Long.parseLong(rolePermissionId);
            } catch (NumberFormatException e) {

            }

        }
    }

    public String toString() {
        return "" + rolePermissionId;
    }

    public long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (rolePermissionId ^ (rolePermissionId >>> 32));
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
        OmRolePermissionPK other = (OmRolePermissionPK) obj;
        if (rolePermissionId != other.rolePermissionId)
            return false;
        return true;
    }

}
