package com.wipro.wess.ods.uom;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.masterconfig.MPointlist;
import com.wipro.wess.ods.masterconfig.MasterConfigurationService;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.organisation.OrganisationService;

@Named("UOM Pointlist")
public class UOMPointListService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "UOMPointListService";
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<OmPointlistCountryExcept> listAllUOMPointlistCountryExcept() {
        return allMatches(new QueryDefault<OmPointlistCountryExcept>(OmPointlistCountryExcept.class,
                "fetch_pointlistcountryexcept_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create UOM Pointlist Country Except")
    public OmPointlistCountryExcept createUOMPointlistCountryExcept(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryUid, final @Named("PointList") MPointlist pointList) {
        OmPointlistCountryExcept pointlistCountryExcept = newTransientInstance(OmPointlistCountryExcept.class);
        pointlistCountryExcept.setOrgId(orgId);
        pointlistCountryExcept.setLocCountryUid(locCountryUid);
        pointlistCountryExcept.setPointList(pointList);
        pointlistCountryExcept.setChangeby(this.container.getUser().getName());
        pointlistCountryExcept.setChangedate(new Date());
        persistIfNotAlready(pointlistCountryExcept);
        return pointlistCountryExcept;
    }

    private OrganisationService orgService;

    public void injectOrganisationService(OrganisationService orgService) {
        this.orgService = orgService;
    }

    public List<MOrganisation> choices0CreateUOMPointlistCountryExcept() {
        return this.orgService.listAllOrganisations();
    }

    private MasterConfigurationService masterConfigurationService;

    public void injectMasterConfigurationService(MasterConfigurationService masterConfigurationService) {
        this.masterConfigurationService = masterConfigurationService;
    }

    public List<MPointlist> choices2CreateUOMPointlistCountryExcept() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    public List<OmPointlistCountryExceptAudit> listAllUOMPointlistCountryExceptAudit() {
        return allMatches(new QueryDefault<OmPointlistCountryExceptAudit>(OmPointlistCountryExceptAudit.class,
                "fetch_pointlistcountryexceptaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "4")
    @Named("Create UOM Pointlist Country ExceptAudit")
    public OmPointlistCountryExceptAudit createUOMPointlistCountryExceptAudit(
            final @Named("OrgId") MOrganisation orgId, final @Named("LocCountryId") String locCountryUid,
            final @Named("PointList") MPointlist pointList) {
        OmPointlistCountryExceptAudit pointlistCountryExceptAudit = newTransientInstance(OmPointlistCountryExceptAudit.class);
        pointlistCountryExceptAudit.setOrgId(orgId);
        pointlistCountryExceptAudit.setLocCountryUid(locCountryUid);
        pointlistCountryExceptAudit.setPointList(pointList);
        pointlistCountryExceptAudit.setChangeby(this.container.getUser().getName());
        pointlistCountryExceptAudit.setChangedate(new Date());
        persistIfNotAlready(pointlistCountryExceptAudit);
        return pointlistCountryExceptAudit;
    }

    public List<MOrganisation> choices0CreateUOMPointlistCountryExceptAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices2CreateUOMPointlistCountryExceptAudit() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    public List<OmPointlistCountryPolicy> listAllUOMPointlistCountryPolicy() {
        return allMatches(new QueryDefault<OmPointlistCountryPolicy>(OmPointlistCountryPolicy.class,
                "fetch_pointlistcountrypolicy_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create UOM Pointlist Country Policy")
    public OmPointlistCountryPolicy createUOMPointlistCountryPolicy(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryUid, final @Named("PointList") MPointlist pointList,
            final @Named("Datapointtype") String datapointtype) {
        OmPointlistCountryPolicy pointlistCountryPolicy = newTransientInstance(OmPointlistCountryPolicy.class);
        pointlistCountryPolicy.setOrgId(orgId);
        pointlistCountryPolicy.setLocCountryUid(locCountryUid);
        pointlistCountryPolicy.setPointList(pointList);
        pointlistCountryPolicy.setChangeby(this.container.getUser().getName());
        pointlistCountryPolicy.setChangedate(new Date());
        pointlistCountryPolicy.setDatapointtype(datapointtype);
        persistIfNotAlready(pointlistCountryPolicy);
        return pointlistCountryPolicy;
    }

    public List<MOrganisation> choices0CreateUOMPointlistCountryPolicy() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices2CreateUOMPointlistCountryPolicy() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    public List<OmPointlistCountryPolicyAudit> listAllUOMPointlistCountryPolicyAudit() {
        return allMatches(new QueryDefault<OmPointlistCountryPolicyAudit>(OmPointlistCountryPolicyAudit.class,
                "fetch_pointlistcountrypolicyaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "8")
    @Named("Create UOM Pointlist Country PolicyAudit")
    public OmPointlistCountryPolicyAudit createUOMPointlistCountryPolicyAudit(
            final @Named("OrgId") MOrganisation orgId, final @Named("LocCountryId") String locCountryUid,
            final @Named("PointList") MPointlist pointList) {
        OmPointlistCountryPolicyAudit pointlistCountryPolicyAudit = newTransientInstance(OmPointlistCountryPolicyAudit.class);
        pointlistCountryPolicyAudit.setOrgId(orgId);
        pointlistCountryPolicyAudit.setLocCountryUid(locCountryUid);
        pointlistCountryPolicyAudit.setPointList(pointList);
        pointlistCountryPolicyAudit.setChangeby(this.container.getUser().getName());
        pointlistCountryPolicyAudit.setChangedate(new Date());
        persistIfNotAlready(pointlistCountryPolicyAudit);
        return pointlistCountryPolicyAudit;
    }

    public List<MOrganisation> choices0CreateUOMPointlistCountryPolicyAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices2CreateUOMPointlistCountryPolicyAudit() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "9")
    public List<OmPointlistOrgPolicy> listAllUOMPointlistOrgPolicy() {
        return allMatches(new QueryDefault<OmPointlistOrgPolicy>(OmPointlistOrgPolicy.class,
                "fetch_pointlistorgpolicy_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "10")
    @Named("Create UOM Pointlist Org Policy")
    public OmPointlistOrgPolicy createUOMPointlistOrgPolicy(final @Named("OrgId") MOrganisation orgId,
            final @Named("PointList") MPointlist pointList, final @Named("Datapointtype") String datapointtype) {
        OmPointlistOrgPolicy pointlistOrgPolicy = newTransientInstance(OmPointlistOrgPolicy.class);
        pointlistOrgPolicy.setOrgId(orgId);
        pointlistOrgPolicy.setPointList(pointList);
        pointlistOrgPolicy.setDatapointtype(datapointtype);
        pointlistOrgPolicy.setChangeby(this.container.getUser().getName());
        pointlistOrgPolicy.setChangedate(new Date());
        persistIfNotAlready(pointlistOrgPolicy);
        return pointlistOrgPolicy;
    }

    public List<MOrganisation> choices0CreateUOMPointlistOrgPolicy() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices1CreateUOMPointlistOrgPolicy() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "11")
    public List<OmPointlistOrgPolicyAudit> listAllUOMPointlistOrgPolicyAudit() {
        return allMatches(new QueryDefault<OmPointlistOrgPolicyAudit>(OmPointlistOrgPolicyAudit.class,
                "fetch_pointlistorgpolicyaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "12")
    @Named("Create UOM Pointlist Org PolicyAudit")
    public OmPointlistOrgPolicyAudit createUOMPointlistOrgPolicyAudit(final @Named("OrgId") MOrganisation orgId,
            final @Named("PointList") MPointlist pointList, final @Named("Datapointtype") String datapointtype) {
        OmPointlistOrgPolicyAudit pointlistOrgPolicyAudit = newTransientInstance(OmPointlistOrgPolicyAudit.class);
        pointlistOrgPolicyAudit.setOrgId(orgId);
        pointlistOrgPolicyAudit.setPointList(pointList);
        pointlistOrgPolicyAudit.setDatapointtype(datapointtype);
        pointlistOrgPolicyAudit.setChangeby(this.container.getUser().getName());
        pointlistOrgPolicyAudit.setChangedate(new Date());
        persistIfNotAlready(pointlistOrgPolicyAudit);
        return pointlistOrgPolicyAudit;
    }

    public List<MOrganisation> choices0CreateUOMPointlistOrgPolicyAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices1CreateUOMPointlistOrgPolicyAudit() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "13")
    public List<OmPointlistSiteExcept> listAllUOMPointlistSiteExcept() {
        return allMatches(new QueryDefault<OmPointlistSiteExcept>(OmPointlistSiteExcept.class,
                "fetch_pointlistsiteexcept_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "14")
    @Named("Create UOM Pointlist SiteExcept")
    public OmPointlistSiteExcept createUOMPointlistSiteExcept(final @Named("OrgId") MOrganisation orgId,
            final @Named("PointList") MPointlist pointList, final @Named("locationUid") String locationUid) {
        OmPointlistSiteExcept pointlistSiteExcept = newTransientInstance(OmPointlistSiteExcept.class);
        pointlistSiteExcept.setOrgId(orgId);
        pointlistSiteExcept.setPointList(pointList);
        pointlistSiteExcept.setLocationUid(locationUid);
        pointlistSiteExcept.setChangeby(this.container.getUser().getName());
        pointlistSiteExcept.setChangedate(new Date());
        persistIfNotAlready(pointlistSiteExcept);
        return pointlistSiteExcept;
    }

    public List<MOrganisation> choices0CreateUOMPointlistSiteExcept() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices1CreateUOMPointlistSiteExcept() {
        return this.masterConfigurationService.listAllPointList();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "15")
    public List<OmPointlistSiteExceptAudit> listAllUOMPointlistSiteExceptAudit() {
        return allMatches(new QueryDefault<OmPointlistSiteExceptAudit>(OmPointlistSiteExceptAudit.class,
                "fetch_pointlistsiteexceptaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "16")
    @Named("Create UOM Pointlist SiteExceptAudit")
    public OmPointlistSiteExceptAudit createUOMPointlistSiteExceptAudit(final @Named("OrgId") MOrganisation orgId,
            final @Named("PointList") MPointlist pointList, final @Named("locationUid") String locationUid) {
        OmPointlistSiteExceptAudit pointlistSiteExceptAudit = newTransientInstance(OmPointlistSiteExceptAudit.class);
        pointlistSiteExceptAudit.setOrgId(orgId);
        pointlistSiteExceptAudit.setPointList(pointList);
        pointlistSiteExceptAudit.setLocationUid(locationUid);
        pointlistSiteExceptAudit.setChangeby(this.container.getUser().getName());
        pointlistSiteExceptAudit.setChangedate(new Date());
        persistIfNotAlready(pointlistSiteExceptAudit);
        return pointlistSiteExceptAudit;
    }

    public List<MOrganisation> choices0CreateUOMPointlistSiteExceptAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MPointlist> choices1CreateUOMPointlistSiteExceptAudit() {
        return this.masterConfigurationService.listAllPointList();
    }
}
