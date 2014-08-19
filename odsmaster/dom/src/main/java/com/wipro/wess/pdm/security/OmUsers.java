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
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Security")
public class OmUsers extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmUsers";
    }

    public String iconName() {
        return "SimpleObject";
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named("List All Users")
    public List<OmUser> listAllUsers() {
        return allInstances(OmUser.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @Bookmarkable
    @MemberOrder(sequence = "6")
    @Named("Create User")
    public OmUser createUser(final @Named("Name") String name, final @Named("Password") String password) {
        final OmUser obj = newTransientInstance(OmUser.class);
        obj.setUserName(name);
        obj.setPassword(password);
        persistIfNotAlready(obj);
        return obj;
    }

    @Bookmarkable
    @MemberOrder(sequence = "7")
    @Named("Create Role")
    public OmRole createRole(final @Named("Name") String name) {
        final OmRole obj = newTransientInstance(OmRole.class);
        obj.setRoleName(name);
        persistIfNotAlready(obj);
        return obj;
    }
    
  

}
