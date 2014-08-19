package com.wipro.wess.ods.upload.excel.dto;

import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;
import com.wipro.wess.ods.site.OmSite;

public class LocationHierarchyLookup {

    private String location;

    private String orgId;
    
    private OmLocationHierarchy locationHierarchy;
    private MOrganisation organisation;
    private OmSite omSite;

    public LocationHierarchyLookup() {
        super();
    }

    public LocationHierarchyLookup(String location, String orgId) {
        super();
        this.location = location;
        this.orgId = orgId;
    }

    
    public String getLocation() {
        return location;
    }

    
    public void setLocation(String location) {
        this.location = location;
    }

    
    public String getOrgId() {
        return orgId;
    }

    
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    
    public OmLocationHierarchy getLocationHierarchy() {
        return locationHierarchy;
    }

    
    public void setLocationHierarchy(OmLocationHierarchy locationHierarchy) {
        this.locationHierarchy = locationHierarchy;
    }

    
    public MOrganisation getOrganisation() {
        return organisation;
    }

    
    public void setOrganisation(MOrganisation organisation) {
        this.organisation = organisation;
    }

    
    public OmSite getOmSite() {
        return omSite;
    }

    
    public void setOmSite(OmSite omSite) {
        this.omSite = omSite;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
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
        LocationHierarchyLookup other = (LocationHierarchyLookup) obj;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (orgId == null) {
            if (other.orgId != null)
                return false;
        } else if (!orgId.equals(other.orgId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LocationHierarchyLookup [location=" + location + ", orgId=" + orgId + ", locationHierarchy="
                + locationHierarchy + ", organisation=" + organisation + "]";
    }



   

}
