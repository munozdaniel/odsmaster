package com.wipro.wess.pdm.security;

/**
 * Inner class representing Primary Key
 */
public class OmUserPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long userId;

    public OmUserPK() {
    }

    public OmUserPK(String userId) {
        if (userId != null) {
            try {
                this.userId = Long.parseLong(userId);
            } catch (NumberFormatException e) {

            }

        }
    }

    public String toString() {
        return "" + userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userId ^ (userId >>> 32));
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
        OmUserPK other = (OmUserPK) obj;
        if (userId != other.userId)
            return false;
        return true;
    }

}
