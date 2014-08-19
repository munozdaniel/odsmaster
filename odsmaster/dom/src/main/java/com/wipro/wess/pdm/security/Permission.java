package com.wipro.wess.pdm.security;


import com.wipro.wess.ods.site.OmSite;

public class Permission {

    private long permissionId;

    private String permission;

    public Permission() {
        super();
    }

    public Permission(String permission) {
        super();
        this.permission = permission;
    }

    public Permission(long permissionId, String permission) {
        super();
        this.permissionId = permissionId;
        this.permission = permission;
    }

    public Permission(OmPermission omPermission) {
        super();
        this.permissionId = omPermission.getPermissionId();

        OmSite site = omPermission.getSite();
        if (site != null) {
            StringBuffer siteId = new StringBuffer();
            siteId.append(site.getOrgId());
            siteId.append(":");
            siteId.append(site.getSiteId());
            this.permission = siteId.toString();
        } else {
            this.permission = omPermission.getPermission();
        }
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return permission;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((permission == null) ? 0 : permission.hashCode());
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
        Permission other = (Permission) obj;
        if (permission == null) {
            if (other.permission != null)
                return false;
        } else if (!permission.equals(other.permission))
            return false;
        return true;
    }

}
