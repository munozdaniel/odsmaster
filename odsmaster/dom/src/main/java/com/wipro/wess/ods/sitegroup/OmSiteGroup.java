package com.wipro.wess.ods.sitegroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.MinLength;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.PublishedAction;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.annotation.Title;

import com.wipro.wess.ods.site.OmMsaSiteMap;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteService;




@Named("Sites Group")
@Bookmarkable
@Audited
@ObjectType("OmSiteGroup")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_site_group", identityType = IdentityType.APPLICATION)
@Sequence(name = "sitegroup_id", datastoreSequence = "sitegroup_id", strategy = SequenceStrategy.CONTIGUOUS)
public class OmSiteGroup {

	// //////////////////////////////////////
	// ViewModel contract
	// //////////////////////////////////////

	public OmSiteGroup() {

	}

	/*
	 * public OmSiteGroup(OmSite site) { String siteOrgId = site.getSiteId() +
	 * ":" + site.getOrgId(); siteOrgIds.add(siteOrgId);
	 * 
	 * }
	 */
	/*
	 * private String memento;
	 * 
	 * @Override public String viewModelMemento() { return memento; }
	 * 
	 * @Override public void viewModelInit(String memento) { this.memento =
	 * memento; }
	 */

	/*
	 * private Set<String> siteOrgIds = new HashSet<String>();
	 * 
	 * @NotContributed(As.EITHER) public Set<String> getSiteOrgIds() { return
	 * siteOrgIds; }
	 * 
	 * public void setSiteOrgIds(Set<String> siteOrgIds) { this.siteOrgIds =
	 * siteOrgIds; }
	 * 
	 * 
	 * @Title public String groupSiteIds() { return
	 * Joiner.on(", ").join(this.siteOrgIds); }
	 */

	private Long sitegroupId;
	private String groupName;
	private Set<OmSite> sites = new HashSet<OmSite>();
	private BigDecimal ecoUtilHrsThreshold;

	@Column(allowsNull = "false", name = "sitegroup_id")
	@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.SEQUENCE, sequence = "sitegroup_id")
	public Long getSitegroupId() {
		return sitegroupId;
	}

	public void setSitegroupId(Long sitegroupId) {
		this.sitegroupId = sitegroupId;
	}

	@Column(allowsNull = "false", name = "group_name")
	@Title
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

/*	@Column(name = "eco_util_hrs_threshold")
	@Optional
	public BigDecimal getEcoUtilHrsThreshold() {
		return ecoUtilHrsThreshold;
	}

	public void setEcoUtilHrsThreshold(BigDecimal ecoUtilHrsThreshold) {
		this.ecoUtilHrsThreshold = ecoUtilHrsThreshold;
	}*/

	@Render(Type.EAGERLY)
	@javax.jdo.annotations.Persistent(table = "om_site_groups")
	@javax.jdo.annotations.Join(column = "group_id")
	@javax.jdo.annotations.Element(columns = {
			@Column(name = "site_id", target = "site_id"),
			@Column(name = "org_id", target = "org_id") })
	public Set<OmSite> getSites() {
		if (this.sites == null) {
			this.sites = new HashSet<OmSite>();
		}
		return sites;
	}

	public void setSites(Set<OmSite> sites) {
		this.sites = sites;
	}

	@PublishedAction
	public OmSiteGroup add(final @Named("JDOQL-Query Criteria")String query, final OmSite site) {
		getSites().add(site);
		return this;
	}

	private OmSiteService omSites;

	public void injectOmSiteService(OmSiteService omSites) {
		this.omSites = omSites;
	}

	public List<OmSite> autoComplete1Add(final @MinLength(2) String siteName) {
		final List<OmSite> list = this.omSites.autoComplete(siteName);
		list.removeAll(getSites());
		list.remove(this);
		return list;
	}
	
	public List<OmSite> choices1Add(final String query) {
		List<OmSite> list = null;
		if(query != null){
			try{
				list = this.omSites.findOmSiteByCriteria(query);
				if(list != null){
					list.removeAll(getSites());
				} else {
					list = new ArrayList<OmSite>();
				}
			}
			catch(Exception e){
				e.printStackTrace();
				//this.container.informUser("SQL query is not proper/not yet ready ");
				this.container.raiseError("SQL query is not proper/not yet ready ");
			}			
			
		}
		
		return list;
	}
	
    @CssClass("x-caution")
    public OmSiteGroup remove(final OmSite site) {
    	getSites().remove(site);
        return this;
    }
    
    // provide a drop-down
    public Collection<OmSite> choices0Remove() {
        return getSites();
    }

	/*private OmSiteGroupContributions omSiteGroupContributions;

	public void injectOmSiteGroupContributions(
			OmSiteGroupContributions omSiteGroupContributions) {
		this.omSiteGroupContributions = omSiteGroupContributions;
	}*/

	private DomainObjectContainer container;

	public void injectDomainObjectContainer(
			final DomainObjectContainer container) {
		this.container = container;
	}

/*	private OmSiteGroups groupService;

	public void injectOmSiteGroups(final OmSiteGroups groupService) {
		this.groupService = groupService;
	}
*/
	@PublishedAction
	@Named("Update Site attributes")
	public OmSiteGroup updateSite(final @Named("Eco util hrs threshold") BigDecimal ecoUtilHrsThreshold) {
		for (OmSite site : this.getSites()) {
			site.setEcoUtilHrsThreshold(ecoUtilHrsThreshold);
			//this.container.objectChanged(site);
		}
		this.container.informUser("Updated " + container.titleOf(this));

		return this;
	}
	
	@PublishedAction
	@Named("Update MSA attributes")
	public OmSiteGroup updateMsa(final @Named("Threshold percent") BigDecimal ahThresholdPercent) {
		//System.out.println("\n *** ahThresholdPercent *** "+ahThresholdPercent);
		for (OmSite site : this.getSites()) {
			//System.out.println("\n *** site *** "+site.getSiteId());
			for(OmMsaSiteMap msaSite: site.getMsaSites()){
				//System.out.println("\n *** Msauid *** "+msaSite.getMsaUid());
				msaSite.getMsaUid().setAhThresholdPercent(ahThresholdPercent);
				this.container.informUser("Updated " + container.titleOf(msaSite.getMsaUid()));
				//System.out.println("\n *** ahThresholdPercent from Msauid *** "+msaSite.getMsaUid().getAhThresholdPercent());
			}
		}
		

		return this;
	}

}
