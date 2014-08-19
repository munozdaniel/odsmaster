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

@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "users", objectIdClass = OmUserPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_OmUser_by_userName", language = "JDOQL", value = "SELECT "
        + " OmUser FROM com.wipro.wess.pdm.security.OmUser OmUser " + " WHERE userName == :userName") })
@Audited
@ObjectType("OmUser")
@Bookmarkable
@Sequence(name = "user_id", datastoreSequence = "user_id", strategy = SequenceStrategy.CONTIGUOUS)
public class OmUser implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -3638376305498303306L;

    private long userId;

    private String userName;

    private String password;
    
    private String configUser;

    public OmUser(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public OmUser() {
        super();
    }

    @Column(allowsNull = "false", name = "user_id")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.SEQUENCE, sequence = "user_id")
    // @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(allowsNull = "false", name = "username")
    @Unique
    @Title
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(allowsNull = "false", name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "OmUsers [userId=" + userId + ", userName=" + userName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        OmUser other = (OmUser) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
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
    public List<OmUser> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.pdmSecurityService.listAllUsers();

    }

}
