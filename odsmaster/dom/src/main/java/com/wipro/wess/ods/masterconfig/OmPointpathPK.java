package com.wipro.wess.ods.masterconfig;

/**
 * Inner class representing Primary Key
 */
public class OmPointpathPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public String pointpath;

    public OmPointpathPK() {
    }

    public OmPointpathPK(String key) {
        this.pointpath = key;
    }

    public String getPointpath() {
        return pointpath;
    }

    public void setPointpath(String pointpath) {
        this.pointpath = pointpath;
    }

    public String toString() {
        return "" + pointpath;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pointpath == null) ? 0 : pointpath.hashCode());
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
        OmPointpathPK other = (OmPointpathPK) obj;
        if (pointpath == null) {
            if (other.pointpath != null)
                return false;
        } else if (!pointpath.equals(other.pointpath))
            return false;
        return true;
    }

}
