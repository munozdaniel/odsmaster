package com.wipro.wess.ods.site;

import com.wipro.wess.ods.msa.OmMsaConfigPK;



/**
 * Inner class representing Primary Key
 */
public class OmMsaSiteMapPK implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7777390197993009932L;
	public OmMsaConfigPK msaUid;



	public OmMsaSiteMapPK() {
	}

	public OmMsaSiteMapPK(String msaUid) {
		this.msaUid = new OmMsaConfigPK(msaUid);
	}
	
	public OmMsaConfigPK getMsaUid() {
		return msaUid;
	}

	public void setMsaUid(OmMsaConfigPK msaUid) {
		this.msaUid = msaUid;
	}

	public String toString() {
		return "" + msaUid.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msaUid == null) ? 0 : msaUid.hashCode());
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
		OmMsaSiteMapPK other = (OmMsaSiteMapPK) obj;
		if (msaUid == null) {
			if (other.msaUid != null)
				return false;
		} else if (!msaUid.equals(other.msaUid))
			return false;
		return true;
	}


}
