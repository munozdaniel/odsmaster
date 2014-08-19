/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.wipro.wess.pdm.security;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MinLength;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotContributed;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.site.OmSite;

@Named("PDM Security")
public class PDMSecurityService extends AbstractFactoryAndRepository {

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "PDMSecurityService";
    }

    public String iconName() {
        return "SimpleObject";
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named("List All Users")
    public List<OmUser> listAllUsers() {
        return allInstances(OmUser.class);
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "2")
    @Named("List All Roles")
    public List<OmRole> listAllRoles() {
        return allInstances(OmRole.class);
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    @Named("List All Permissions")
    public List<OmPermission> listAllPermissions() {
        return allInstances(OmPermission.class);
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "4")
    @Named("List All Roles Of Users ")
    public List<OmUsersRoles> listUserRoles() {
        return allInstances(OmUsersRoles.class);
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    @Named("List All Permissions Of Roles")
    public List<OmRolesPermissions> listPermissionsOfRole() {
        return allInstances(OmRolesPermissions.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create User")
    public OmUser createUser(final @Named("Name") String name, final @Named("Password") String password) {
        final OmUser obj = container.newTransientInstance(OmUser.class);
        obj.setUserName(name);
        obj.setPassword(password);
        persistIfNotAlready(obj);
        return obj;
    }

    @MemberOrder(sequence = "7")
    @Named("Create Role")
    public OmRole createRole(final @Named("Name") String name) {
        final OmRole obj = newTransientInstance(OmRole.class);
        obj.setRoleName(name);
        persistIfNotAlready(obj);
        return obj;
    }

    @MemberOrder(sequence = "8")
    @Named("Create Service Permission")
    public OmPermission createServicePermission(final @Named("Permission") String permission) {
        final OmPermission obj = newTransientInstance(OmPermission.class);
        obj.setPermission(permission);
        persistIfNotAlready(obj);
        return obj;
    }

    @MemberOrder(sequence = "9")
    @Named("Create Site Permission")
    @NotContributed
    public OmPermission createSitePermission(final @Named("Choose a site") OmSite site) {
        final OmPermission obj = newTransientInstance(OmPermission.class);
        obj.setPermission(SecurityUtil.formatSitePermission(site.getOrgId().getOrgId(), site.getSiteId()));
        obj.setSite(site);
        persistIfNotAlready(obj);
        return obj;
    }

    public List<OmSite> autoComplete0CreateSitePermission(final @MinLength(2) String search) {
        List<OmSite> sitesList = this.findOmSiteBySiteIdOrgIdSiteName(search);
        return sitesList;
    }

    public List<OmSite> findOmSiteBySiteIdOrgIdSiteName(final String siteName) {
        return allMatches(new QueryDefault<OmSite>(OmSite.class, "findOmSiteBySiteIdOrgIdSiteName", "siteName",
                siteName));
    }

    /*
     * public List<OmSite> choices1CreatePermission() { return allInstances(OmSite.class); }
     */

    @MemberOrder(sequence = "10")
    @Named("Add Role To User")
    public OmUsersRoles addRoleToUser(final @Named("User") OmUser user, final @Named("Role") OmRole role) {
        final OmUsersRoles obj = newTransientInstance(OmUsersRoles.class);
        obj.setUser(user);
        obj.setRole(role);
        persistIfNotAlready(obj);
        return obj;
    }

    public List<OmUser> choices0AddRoleToUser() {
        return allInstances(OmUser.class);
    }

    public List<OmRole> choices1AddRoleToUser() {
        return allInstances(OmRole.class);
    }

    @MemberOrder(sequence = "11")
    @Named("Add Permission To Role")
    public OmRolesPermissions addPermissionToRole(final @Named("Role") OmRole role,
            final @Named("Permission") OmPermission permission) {
        final OmRolesPermissions obj = newTransientInstance(OmRolesPermissions.class);
        obj.setRole(role);
        obj.setPermission(permission);
        persistIfNotAlready(obj);
        return obj;
    }

    public List<OmRole> choices0AddPermissionToRole() {
        return allInstances(OmRole.class);
    }

    public List<OmPermission> choices1AddPermissionToRole() {
        return allInstances(OmPermission.class);
    }

}
