package com.wipro.wess.ods.organisation;

import java.util.StringTokenizer;



public class OmOrgExtendedAttrPK implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7282567374375801189L;
	public String parameterName; // Same name as real field above
	public OrganisationPK organisation; // Same name as the real
														// field above

	public OmOrgExtendedAttrPK() {
	}

	public OmOrgExtendedAttrPK(String key) {
		StringTokenizer token = new StringTokenizer(key, "-");
		this.parameterName = token.nextToken();
		this.organisation = new OrganisationPK(token.nextToken());
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public OrganisationPK getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationPK organisation) {
		this.organisation = organisation;
	}

	public String toString() {
		return "" + parameterName + "-" + this.organisation.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((organisation == null) ? 0 : organisation.hashCode());
		result = prime * result
				+ ((parameterName == null) ? 0 : parameterName.hashCode());
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
		OmOrgExtendedAttrPK other = (OmOrgExtendedAttrPK) obj;
		if (organisation == null) {
			if (other.organisation != null)
				return false;
		} else if (!organisation.equals(other.organisation))
			return false;
		if (parameterName == null) {
			if (other.parameterName != null)
				return false;
		} else if (!parameterName.equals(other.parameterName))
			return false;
		return true;
	}

}
