package com.wipro.wess.ods.organisation;

import java.util.StringTokenizer;

public class OmOrgSrefNamePK implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029133262264139013L;
	/**
	 * 
	 */

	public OrganisationPK MOrganisation; // Same name as the real
											// field above

	public OmOrgSrefNamePK() {
	}

	public OmOrgSrefNamePK(String key) {
		StringTokenizer token = new StringTokenizer(key, "-");
		this.MOrganisation = new OrganisationPK(token.nextToken());
	}

	public OrganisationPK getMOrganisation() {
		return MOrganisation;
	}

	public void setMOrganisation(OrganisationPK mOrganisation) {
		MOrganisation = mOrganisation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((MOrganisation == null) ? 0 : MOrganisation.hashCode());
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
		OmOrgSrefNamePK other = (OmOrgSrefNamePK) obj;
		if (MOrganisation == null) {
			if (other.MOrganisation != null)
				return false;
		} else if (!MOrganisation.equals(other.MOrganisation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+this.MOrganisation.toString();
	}

}
