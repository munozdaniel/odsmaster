package com.wipro.wess.ods.service;

/**
 * Inner class representing Primary Key
 */
public class ServiceConfigPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public String serviceUid;

    public ServiceConfigPK() {
    }

    public ServiceConfigPK(String serviceUid) {
        this.serviceUid = serviceUid;
    }

    public String getServiceUid() {
        return serviceUid;
    }

    public void setServiceUid(String serviceUid) {
        this.serviceUid = serviceUid;
    }

    public String toString() {
        return "" + serviceUid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serviceUid == null) ? 0 : serviceUid.hashCode());
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
        ServiceConfigPK other = (ServiceConfigPK) obj;
        if (serviceUid == null) {
            if (other.serviceUid != null)
                return false;
        } else if (!serviceUid.equals(other.serviceUid))
            return false;
        return true;
    }

}
