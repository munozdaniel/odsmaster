package com.wipro.wess.ods.site;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.objectstore.jdo.applib.service.support.IsisJdoSupport;

import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.masterconfig.MSourcetypeConfigs;
import com.wipro.wess.ods.organisation.MOrganisation;

@Named("Site")
public class OmSiteService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmSiteService";
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
    public List<OmSite> listAllSites() {
        return allMatches(new QueryDefault<OmSite>(OmSite.class, "fetch_sites_by_user", "userName", this.container
                .getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Site")
    public OmSite createSite(final @Named("OrgId") MOrganisation orgId, final @Named("SiteId") String siteId,
            final @Named("SiteType") String siteType) {
        OmSite omSite = newTransientInstance(OmSite.class);
        omSite.setSiteId(siteId);
        omSite.setOrgId(orgId);
        omSite.setSiteType(siteType);
        omSite.setChangeBy(this.container.getUser().getName());
        omSite.setChangeDt(new Date());
        persistIfNotAlready(omSite);
        return omSite;

    }

    public List<MOrganisation> choices0CreateSite() {
        return allInstances(MOrganisation.class);
    }

    public List<String> choices2CreateSite() {
        List<String> siteTypeList = new ArrayList<String>();
        siteTypeList.add(OmSite.SiteType.CAMPUS.name());
        siteTypeList.add(OmSite.SiteType.BUILDING.name());
        return siteTypeList;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    @Named("List all Site Data Agg Map")
    public List<OmSiteDataAggMap> listAllSiteDataAggMap() {
        return allMatches(new QueryDefault<OmSiteDataAggMap>(OmSiteDataAggMap.class, "fetch_sitedataaggmap_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "4")
    @Named("Create Site Data Agg Map")
    public OmSiteDataAggMap createSiteDataAggMap(final @Named("Site") OmSite site,
            final @Named("IpAddress") String ipAddress, final @Named("Port") int port) {
        OmSiteDataAggMap omSiteDataAggMap = newTransientInstance(OmSiteDataAggMap.class);
        omSiteDataAggMap.setOmSite(site);
        omSiteDataAggMap.setIpAddress(ipAddress);
        omSiteDataAggMap.setPort(port);
        persistIfNotAlready(omSiteDataAggMap);
        return omSiteDataAggMap;

    }

    public List<OmSite> choices0CreateSiteDataAggMap() {
        return this.listAllSites();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    @Named("List all Site Extended Attr")
    public List<OmSiteExtendedAttr> listAllSiteExtdAttr() {
        return allMatches(new QueryDefault<OmSiteExtendedAttr>(OmSiteExtendedAttr.class, "fetch_siteextdattr_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create Site Extended Attr")
    public OmSiteExtendedAttr createSiteExtdAttr(final @Named("Site") OmSite site,
            final @Named("ParamName") String paramName, final @Named("alnValue") @Optional String alnValue,
            final @Named("NumValue") @Optional BigDecimal numValue) {
        OmSiteExtendedAttr siteExtendedAttr = newTransientInstance(OmSiteExtendedAttr.class);
        siteExtendedAttr.setSite(site);
        siteExtendedAttr.setParamName(paramName);
        siteExtendedAttr.setAlnValue(alnValue);
        siteExtendedAttr.setNumValue(numValue);
        siteExtendedAttr.setUpdatedBy(this.container.getUser().getName());
        siteExtendedAttr.setUpdatedTimeTs(new Date());
        persistIfNotAlready(siteExtendedAttr);
        return siteExtendedAttr;

    }

    public List<OmSite> choices0CreateSiteExtdAttr() {
        return this.listAllSites();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    @Named("List all Site Info Element")
    public List<OmSiteInfoElement> listAllSiteInfoElement() {
        return allMatches(new QueryDefault<OmSiteInfoElement>(OmSiteInfoElement.class,
                "fetch_siteinfoelements_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "8")
    @Named("Create Site Info Element")
    public OmSiteInfoElement createSiteInfoElement(final @Named("Site") OmSite site,
            final @Named("MeasurementEntityId") String measurementEntityId, final @Named("MeasureId") String measureId,
            final @Named("StartDate") Date startDate, final @Named("ValueType") String valueType) {
        OmSiteInfoElement siteInfoElement = newTransientInstance(OmSiteInfoElement.class);
        siteInfoElement.setSite(site);
        siteInfoElement.setMeasurementEntityId(measurementEntityId);
        siteInfoElement.setMeasureId(measureId);
        siteInfoElement.setStartDate(startDate);
        siteInfoElement.setValueType(valueType);
        siteInfoElement.setChangeby(this.container.getUser().getName());
        siteInfoElement.setChangedt(new Date());
        persistIfNotAlready(siteInfoElement);
        return siteInfoElement;

    }

    public List<OmSite> choices0CreateSiteInfoElement() {
        return this.listAllSites();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "9")
    @Named("List all Site ref formula")
    public List<OmSiteSrefFormula> listAllSiteRefFormula() {
        return allMatches(new QueryDefault<OmSiteSrefFormula>(OmSiteSrefFormula.class, "fetch_siterefformulas_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "10")
    @Named("Create Site ref formula")
    public OmSiteSrefFormula createSiteRefFormula(final @Named("Site") OmSite site,
            final @Named("sourceTypeId") MSourcetypeConfig sourceTypeId,
            final @Named("ReferenceUmF") @Optional String referenceUmF,
            final @Named("ReferenceCmF") @Optional String referenceCmF,
            final @Named("ReferenceOmF") @Optional String referenceOmF, final @Named("MasterF") @Optional String masterF) {
        OmSiteSrefFormula siteRefFormula = newTransientInstance(OmSiteSrefFormula.class);
        siteRefFormula.setOmSite(site);
        siteRefFormula.setMSourcetypeConfig(sourceTypeId);
        siteRefFormula.setReferenceUmF(referenceUmF);
        siteRefFormula.setReferenceCmF(referenceCmF);
        siteRefFormula.setReferenceOmF(referenceOmF);
        siteRefFormula.setMasterF(masterF);
        siteRefFormula.setInsertedBy(this.container.getUser().getName());
        siteRefFormula.setInsertedTimeTs(new Date());
        siteRefFormula.setChangeTs(new Date());
        persistIfNotAlready(siteRefFormula);
        return siteRefFormula;

    }

    public List<OmSite> choices0CreateSiteRefFormula() {
        return this.listAllSites();
    }

    private MSourcetypeConfigs sourceTypeConfigService;

    public void injectMSourcetypeConfigs(MSourcetypeConfigs sourceTypeConfigService) {
        this.sourceTypeConfigService = sourceTypeConfigService;
    }

    public List<MSourcetypeConfig> choices1CreateSiteRefFormula() {
        return this.sourceTypeConfigService.listAll();
    }

    @Programmatic
    public List<OmSite> autoComplete(final String siteName) {
        return allMatches(new QueryDefault<OmSite>(OmSite.class, "omsite_autoComplete", "siteName", siteName));
    }

    @Programmatic
    // not part of metamodel
    public List<OmSite> findOmSiteByCriteria(final String criteria) {
        // allMa
        List<OmSite> sites = null;
        try {
            String sql = "SELECT FROM com.wipro.wess.OmSite ";
            if (criteria != null) {
                sql = sql + " WHERE " + criteria;
            }
            // List<Map<String, Object>> result = isisJdoSupport.executeSql(sql);
            PersistenceManager pm = isisJdoSupport.getJdoPersistenceManager();
            Query query = pm.newQuery(sql);
            query.setClass(OmSite.class);
            sites = (List<OmSite>) query.execute();
        } catch (JDOUserException e) {
            raiseError(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            raiseError("SQL query is not proper/not yet ready ");
            return null;
        }

        return sites;
    }

    private IsisJdoSupport isisJdoSupport;

    public void injectIsisJdoSupport(IsisJdoSupport isisJdoSupport) {
        this.isisJdoSupport = isisJdoSupport;
    }

    /*
     * private OmSiteGroupContributions omSiteGroupContributions; public void
     * injectOmSiteGroupContributions(OmSiteGroupContributions omSiteGroupContributions){ this.omSiteGroupContributions
     * = omSiteGroupContributions; System.out.println("\n grp contirb injected ---> "+this.omSiteGroupContributions); }
     */

}
