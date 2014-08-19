package com.wipro.wess.ods.msa;



/**
 * Inner class representing Primary Key
 */
public class OmMsaConfigPK implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7777390197993009932L;
	public String msaUid;



	public OmMsaConfigPK() {
	}

	public OmMsaConfigPK(String msaUid) {
		this.msaUid = msaUid;
	}
	
	public String getMsaUid() {
		return msaUid;
	}

	public void setMsaUid(String msaUid) {
		this.msaUid = msaUid;
	}

	@Override
	public String toString() {
		return "" + msaUid;
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
		OmMsaConfigPK other = (OmMsaConfigPK) obj;
		if (msaUid == null) {
			if (other.msaUid != null)
				return false;
		} else if (!msaUid.equals(other.msaUid))
			return false;
		return true;
	}

}
