package com.wipro.wess.ods.organisation;

import java.nio.charset.Charset;

import com.google.common.io.BaseEncoding;

/**
 * Inner class representing Primary Key
 */
public class OrganisationPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public String orgId;

    public OrganisationPK() {
    }

    public OrganisationPK(String orgId) {
        this.orgId = decode(orgId);
    }

    @Override
    public String toString() {
        return encode("" + orgId);
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
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
        OrganisationPK other = (OrganisationPK) obj;
        if (orgId == null) {
            if (other.orgId != null)
                return false;
        } else if (!orgId.equals(other.orgId))
            return false;
        return true;
    }

    private static String encode(String str) {
        return BaseEncoding.base32().encode(str.getBytes(Charset.forName("UTF-8")));
    }

    public static String decode(String str) {
        return new String(BaseEncoding.base32().decode(str), Charset.forName("UTF-8"));
    }

}
