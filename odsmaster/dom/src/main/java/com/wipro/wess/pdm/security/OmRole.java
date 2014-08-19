package com.wipro.wess.pdm.security;

import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
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
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "roles", objectIdClass = OmRolePK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_OmRoles_by_roleName", language = "JDOQL", value = "SELECT "
        + " OmRoles FROM com.wipro.wess.pdm.security.OmRoles OmRoles " + " WHERE roleName == :roleName") })
@Audited
@ObjectType("OmRoles")
@Bookmarkable
@Sequence(name = "role_id", datastoreSequence = "role_id", strategy = SequenceStrategy.CONTIGUOUS)
public class OmRole implements java.io.Serializable, InstanceCallbacks{

    /**
     * 
     */
    private static final long serialVersionUID = 3784104872145564689L;

    private long roleId;

    private String roleName;
    
    private String configUser;

    public OmRole() {
        super();
    }

    public OmRole(String roleName) {
        super();
        this.roleName = roleName;
    }

    @Column(allowsNull = "false", name = "role_id")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.SEQUENCE, sequence = "role_id")
    // @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Column(allowsNull = "false", name = "role_name")
    @Unique
    @Title
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public String toString() {
        return "OmRoles [roleId=" + roleId + ", roleName=" + roleName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
        OmRole other = (OmRole) obj;
        if (roleName == null) {
            if (other.roleName != null)
                return false;
        } else if (!roleName.equals(other.roleName))
            return false;
        return true;
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
    public List<OmRole> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.pdmSecurityService.listAllRoles();

    }
}
