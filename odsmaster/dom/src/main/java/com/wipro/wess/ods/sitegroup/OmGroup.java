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
package com.wipro.wess.ods.sitegroup;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.isis.applib.AbstractViewModel;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.util.ObjectContracts;

import com.wipro.wess.ods.site.OmSite;

@Named("Group")
@Bookmarkable
public class OmGroup 
        extends AbstractViewModel 
        implements Comparable<OmGroup> {

    
    // //////////////////////////////////////
    // ViewModel implementation
    // //////////////////////////////////////
	
	public OmGroup(){}
	
	public OmGroup(OmSite site){
		String siteOrgId = site.getSiteId() + "+" + site.getOrgId();
		this.setGroupName(siteOrgId);
		//this.siteOrgIds.add(siteOrgId);
	}

    @Override
    public String viewModelMemento() {
        return this.getGroupName();
    }

    @Override
    public void viewModelInit(String memento) {
    	this.setGroupName(memento);
    }
    

    // //////////////////////////////////////
    // Sites List
    // //////////////////////////////////////
    
 /*   private List<String> siteOrgIds = new ArrayList<String>();
    
    public List<String> getSiteOrgIds() {
  		return siteOrgIds;
  	}

  	public void setSiteOrgIds(List<String> siteOrgIds) {
  		this.siteOrgIds = siteOrgIds;
  	}*/
    
    
/*    private Set<OmSite> sites = new HashSet<OmSite>();
    

    @Render(Type.EAGERLY)
	public Set<OmSite> getSites() {
		return sites;
	}

	public void setSites(Set<OmSite> sites) {
		this.sites = sites;
	}*/
    

    // //////////////////////////////////////
    // groupName
    // //////////////////////////////////////

  




	private String groupName;

    /**
     * Used as {@link #viewModelMemento() memento}
     */
    @Title
    public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	private BigDecimal ecoUtilHrsThreshold;
	

    public BigDecimal getEcoUtilHrsThreshold() {
		return ecoUtilHrsThreshold;
	}

	public void setEcoUtilHrsThreshold(BigDecimal ecoUtilHrsThreshold) {
		this.ecoUtilHrsThreshold = ecoUtilHrsThreshold;
	}
    
    

    // //////////////////////////////////////
    // compareTo
    // //////////////////////////////////////



	@Override
    public int compareTo(OmGroup other) {
        return ObjectContracts.compare(this, other, "groupName");
    }




}
