package com.wipro.wess.pdm.security;

/**
 * Inner class representing Primary Key
 */
public class OmRolePK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long roleId;

    public OmRolePK() {
    }

    public OmRolePK(String roleId) {
        if (roleId != null) {
            try {
                this.roleId = Long.parseLong(roleId);
            } catch (NumberFormatException e) {

            }

        }
    }

    public String toString() {
        return "" + roleId;
    }
    

    
    public long getRoleId() {
        return roleId;
    }

    
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (roleId ^ (roleId >>> 32));
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
        OmRolePK other = (OmRolePK) obj;
        if (roleId != other.roleId)
            return false;
        return true;
    }

   

}
