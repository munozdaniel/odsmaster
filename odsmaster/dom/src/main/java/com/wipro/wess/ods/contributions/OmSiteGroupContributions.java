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
package com.wipro.wess.ods.contributions;



import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.NotContributed;
import org.apache.isis.applib.annotation.NotInServiceMenu;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.NotContributed.As;
import org.apache.isis.applib.annotation.Hidden;

import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteService;
import com.wipro.wess.ods.sitegroup.OmGroup;
import com.wipro.wess.ods.sitegroup.OmSiteGroup;

@Hidden
public class OmSiteGroupContributions extends AbstractFactoryAndRepository {



	private DomainObjectContainer container;
	public void injectDomainObjectContainer(
			final DomainObjectContainer container) {
		this.container = container;
	}
	
	
    // //////////////////////////////////////
    // AnalyseCategory
    // //////////////////////////////////////
	
	OmGroup group = null;

    @NotInServiceMenu
    @NotContributed(As.ASSOCIATION)
    @ActionSemantics(Of.SAFE)
    public OmGroup groupTheSites(final OmSite site) {
    	System.out.println("\n *** GROUP is *** "+this.group);
    	if(this.group == null){
    		this.group = new OmGroup(site);
    	}
    	
    	//System.out.println("\n *** GROUP sites *** "+this.group.getSites());
        return this.group;
    }
	
	
    
/*	@Bulk
	//@CssClass("x-caution")
	public List<OmSite> update(OmSite site) {
		if(this.group == null){
			this.group = new OmSiteGroup();
		}	
		OmSiteGroup group = new OmSiteGroup();		
		group.getSites().add(this);	
		System.out.println("\n added site is ---> "+this);
		System.out.println("\n group sites are ---> "+group.getSites());
		this.container.informUser("Updated " + container.titleOf(site));
		
		return this.omSites.listAll();
	}*/
    

}
