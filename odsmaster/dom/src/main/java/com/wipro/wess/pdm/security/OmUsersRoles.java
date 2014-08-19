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
import org.apache.isis.applib.annotation.Where;

@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "user_roles", objectIdClass = OmUserRolePK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_OmUsersRoles_by_uk", language = "JDOQL", value = "SELECT "
        + " OmUsersRoles FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles "
        + " WHERE user == :user && role == :role") })
@Audited
@ObjectType("OmUsersRoles")
@Bookmarkable
@Sequence(name = "user_role_id", datastoreSequence = "user_role_id", strategy = SequenceStrategy.CONTIGUOUS)
@Unique(members = { "user", "role" })
public class OmUsersRoles implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = 1237129742300241657L;

    private long userRoleId;

    private OmUser user;

    private OmRole role;

    private String configUser;

    public OmUsersRoles() {
        super();
    }

    @Column(allowsNull = "false", name = "user_role_id")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.SEQUENCE, sequence = "user_role_id")
    // @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Column(allowsNull = "false", name = "user_id")
    public OmUser getUser() {
        return user;
    }

    public void setUser(OmUser user) {
        this.user = user;
    }

    @Column(allowsNull = "false", name = "role_id")
    public OmRole getRole() {
        return role;
    }

    public void setRole(OmRole role) {
        this.role = role;
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
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        OmUsersRoles other = (OmUsersRoles) obj;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
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
    public List<OmUsersRoles> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.pdmSecurityService.listUserRoles();

    }
}
