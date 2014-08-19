package com.wipro.wess.pdm.security;

import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Columns;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.site.OmSite;

@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "permissions", objectIdClass = OmPermissionPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_OmPermissions_by_permission", language = "JDOQL", value = "SELECT "
        + " OmPermissions FROM com.wipro.wess.pdm.security.OmPermissions OmPermissions "
        + " WHERE permission == :permission") })
@Audited
@ObjectType("OmPermissions")
@Bookmarkable
@Sequence(name = "permission_id", datastoreSequence = "permission_id", strategy = SequenceStrategy.CONTIGUOUS)
public class OmPermission implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = 1384850872891203859L;

    private long permissionId;

    private String permission;

    private OmSite site;

    private String configUser;

    public OmPermission() {
        super();
    }

    public OmPermission(String permission) {
        super();
        this.permission = permission;
    }

    @Column(allowsNull = "false", name = "permission_id")
    // @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.SEQUENCE, sequence = "permission_id")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Column(allowsNull = "false", name = "permission")
    @Unique
    @Title
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Columns(value = { @Column(name = "org_id"), @Column(name = "site_id") })
    @Optional
    @Unique
    public OmSite getSite() {
        return site;
    }

    public void setSite(OmSite site) {
        this.site = site;
    }

    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
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
        OmPermission other = (OmPermission) obj;
        if (permission == null) {
            if (other.permission != null)
                return false;
        } else if (!permission.equals(other.permission))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return permission;
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    public void jdoPostLoad() {
    }

    public void jdoPreClear() {
    }

    public void jdoPreStore() {
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }

    private PDMSecurityService pdmSecurityService;

    public void injectPDMSecurityService(PDMSecurityService pdmSecurityService) {
        this.pdmSecurityService = pdmSecurityService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmPermission> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.pdmSecurityService.listAllPermissions();

    }
}
