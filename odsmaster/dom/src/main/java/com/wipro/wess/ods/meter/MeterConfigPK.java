package com.wipro.wess.ods.meter;

/**
 * Inner class representing Primary Key
 */
public class MeterConfigPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public String meterUid;

    public MeterConfigPK() {
    }

    public MeterConfigPK(String meterUid) {
        this.meterUid = meterUid;
    }

    public String toString() {
        return "" + meterUid;
    }

    public String getMeterUid() {
        return meterUid;
    }

    public void setMeterUid(String meterUid) {
        this.meterUid = meterUid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((meterUid == null) ? 0 : meterUid.hashCode());
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
        MeterConfigPK other = (MeterConfigPK) obj;
        if (meterUid == null) {
            if (other.meterUid != null)
                return false;
        } else if (!meterUid.equals(other.meterUid))
            return false;
        return true;
    }

}
