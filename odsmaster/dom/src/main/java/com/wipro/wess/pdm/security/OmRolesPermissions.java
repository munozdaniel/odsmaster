package com.wipro.wess.pdm.security;

import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Where;

@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "roles_permissions", objectIdClass = OmRolePermissionPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_OmRolesPermissions_by_uk", language = "JDOQL", value = "SELECT "
                + " OmRolesPermissions FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role == :role && permission == :permission"),
        @javax.jdo.annotations.Query(name = "fetch_Permissions_by_roleName", language = "JDOQL", value = "SELECT "
                + " OmRolesPermissions FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role.roleName == :roleName"),
                @javax.jdo.annotations.Query(name = "fetch_Permissions_by_user", language = "JPQL", value = "SELECT "
                        + " OmRolesPermissions FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                        + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName)") })
@Audited
@ObjectType("OmRolesPermissions")
@Bookmarkable
//@Sequence(name = "role_permission_id", datastoreSequence = "role_permission_id", strategy = SequenceStrategy.CONTIGUOUS)
@Unique(members = { "role", "permission" })
public class OmRolesPermissions implements java.io.Serializable, InstanceCallbacks{

    /**
     * 
     */
    private static final long serialVersionUID = -5323139507240941709L;

    private long rolePermissionId;

    private OmRole role;

    private OmPermission permission;
    
    private String configUser;

    public OmRolesPermissions() {
        super();
    }

    @Column(allowsNull = "false", name = "role_permission_id")
    //@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.SEQUENCE, sequence = "role_permission_id")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    public long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    @Column(allowsNull = "false", name = "role_id")
    public OmRole getRole() {
        return role;
    }

    public void setRole(OmRole role) {
        this.role = role;
    }

    @Column(allowsNull = "false", name = "permission_id")
    public OmPermission getPermission() {
        return permission;
    }

    public void setPermission(OmPermission permission) {
        this.permission = permission;
    }
    
    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
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
    public List<OmRolesPermissions> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.pdmSecurityService.listPermissionsOfRole();

    }
}
