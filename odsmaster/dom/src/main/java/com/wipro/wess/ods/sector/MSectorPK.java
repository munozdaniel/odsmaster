package com.wipro.wess.ods.sector;

/**
 * Inner class representing Primary Key
 */
public class MSectorPK implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1255675944783682980L;

	public String sectorId;

	public MSectorPK() {
	}

	public MSectorPK(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String toString() {
		return "" + sectorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sectorId == null) ? 0 : sectorId.hashCode());
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
		MSectorPK other = (MSectorPK) obj;
		if (sectorId == null) {
			if (other.sectorId != null)
				return false;
		} else if (!sectorId.equals(other.sectorId))
			return false;
		return true;
	}

}
