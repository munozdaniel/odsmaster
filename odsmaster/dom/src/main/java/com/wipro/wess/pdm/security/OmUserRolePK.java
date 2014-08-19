package com.wipro.wess.pdm.security;

/**
 * Inner class representing Primary Key
 */
public class OmUserRolePK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long userRoleId;

    public OmUserRolePK() {
    }

    public OmUserRolePK(String userRoleId) {
        if (userRoleId != null) {
            try {
                this.userRoleId = Long.parseLong(userRoleId);
            } catch (NumberFormatException e) {

            }

        }
    }

    public String toString() {
        return "" + userRoleId;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userRoleId ^ (userRoleId >>> 32));
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
        OmUserRolePK other = (OmUserRolePK) obj;
        if (userRoleId != other.userRoleId)
            return false;
        return true;
    }

}
