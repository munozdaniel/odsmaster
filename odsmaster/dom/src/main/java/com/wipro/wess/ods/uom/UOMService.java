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

import com.wipro.wess.ods.munit.MUnit;
import com.wipro.wess.ods.munit.MUnitFamily;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.organisation.OrganisationService;

@Named("UOM Configuration")
public class UOMService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "UOMService";
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
    public List<MUomDefaults> listAllUOMDefaults() {
        return allInstances(MUomDefaults.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create UOM Defaults")
    public MUomDefaults createUOMdefaults(final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        MUomDefaults uomDefaults = newTransientInstance(MUomDefaults.class);
        uomDefaults.setMeasureEntityId(measureEntityId);
        uomDefaults.setMeasureId(measureId);
        uomDefaults.setMUnitFamily(unitFamilyId);
        uomDefaults.setMUnit(unitId);
        uomDefaults.setChangeDate(new Date());
        persistIfNotAlready(uomDefaults);
        return uomDefaults;
    }

    public List<MMeasurementEntity> choices0CreateUOMdefaults() {
        return this.container.allInstances(MMeasurementEntity.class);
    }

    public List<MMeasurement> choices1CreateUOMdefaults() {
        return this.container.allInstances(MMeasurement.class);
    }

    public List<MUnitFamily> choices2CreateUOMdefaults() {
        return this.container.allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices3CreateUOMdefaults() {
        return this.container.allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    public List<OmUomCountryExcept> listAllUOMCountryExcept() {
        return allMatches(new QueryDefault<OmUomCountryExcept>(OmUomCountryExcept.class,
                "fetch_ouomcountryexcept_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "4")
    @Named("Create UOM Country Except")
    public OmUomCountryExcept createUOMCountryExcept(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomCountryExcept uomCountryExcept = newTransientInstance(OmUomCountryExcept.class);
        uomCountryExcept.setOrgId(orgId);
        uomCountryExcept.setLocCountryId(locCountryId);
        uomCountryExcept.setMeasureEntityId(measureEntityId);
        uomCountryExcept.setMeasureId(measureId);
        uomCountryExcept.setMUnitFamily(unitFamilyId);
        uomCountryExcept.setMUnit(unitId);
        uomCountryExcept.setChangeDate(new Date());
        persistIfNotAlready(uomCountryExcept);
        return uomCountryExcept;
    }

    private OrganisationService orgService;

    public void injectOrganisationService(OrganisationService orgService) {
        this.orgService = orgService;
    }

    public List<MOrganisation> choices0CreateUOMCountryExcept() {
        return this.orgService.listAllOrganisations();
    }

    private UOMMeasurementService uomMeasurementService;

    public void injectUOMMeasurementService(UOMMeasurementService uomMeasurementService) {
        this.uomMeasurementService = uomMeasurementService;
    }

    public List<MMeasurementEntity> choices2CreateUOMCountryExcept() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMCountryExcept() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMCountryExcept() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMCountryExcept() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    public List<OmUomCountryExceptAudit> listAllUOMCountryExceptAudit() {
        return allMatches(new QueryDefault<OmUomCountryExceptAudit>(OmUomCountryExceptAudit.class,
                "fetch_ouomcountryexceptaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create UOM Country ExceptAudit")
    public OmUomCountryExceptAudit createUOMCountryExceptAudit(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomCountryExceptAudit uomCountryExceptAudit = newTransientInstance(OmUomCountryExceptAudit.class);
        uomCountryExceptAudit.setOrgId(orgId);
        uomCountryExceptAudit.setLocCountryId(locCountryId);
        uomCountryExceptAudit.setMeasureEntityId(measureEntityId);
        uomCountryExceptAudit.setMeasureId(measureId);
        uomCountryExceptAudit.setUnitFamilyId(unitFamilyId);
        uomCountryExceptAudit.setUnitId(unitId);
        uomCountryExceptAudit.setChangeDate(new Date());
        persistIfNotAlready(uomCountryExceptAudit);
        return uomCountryExceptAudit;
    }

    public List<MOrganisation> choices0CreateUOMCountryExceptAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMCountryExceptAudit() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMCountryExceptAudit() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMCountryExceptAudit() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMCountryExceptAudit() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    public List<OmUomCountryPolicy> listAllUOMCountryPolicies() {
        return allMatches(new QueryDefault<OmUomCountryPolicy>(OmUomCountryPolicy.class,
                "fetch_uomcountrypolicy_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "8")
    @Named("Create UOM Country Policy")
    public OmUomCountryPolicy createUOMCountryPolicy(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomCountryPolicy uomCountryPolicy = newTransientInstance(OmUomCountryPolicy.class);
        uomCountryPolicy.setOrgId(orgId);
        uomCountryPolicy.setLocCountryId(locCountryId);
        uomCountryPolicy.setMeasureEntityId(measureEntityId);
        uomCountryPolicy.setMeasureId(measureId);
        uomCountryPolicy.setMUnitFamily(unitFamilyId);
        uomCountryPolicy.setMUnit(unitId);
        uomCountryPolicy.setChangeDate(new Date());
        persistIfNotAlready(uomCountryPolicy);
        return uomCountryPolicy;
    }

    public List<MOrganisation> choices0CreateUOMCountryPolicy() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMCountryPolicy() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMCountryPolicy() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMCountryPolicy() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMCountryPolicy() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "9")
    public List<OmUomCountryPolicyAudit> listAllUOMCountryPoliciyAudits() {
        return allMatches(new QueryDefault<OmUomCountryPolicyAudit>(OmUomCountryPolicyAudit.class,
                "fetch_uomcountrypolicyaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "10")
    @Named("Create UOM Country PolicyAudit")
    public OmUomCountryPolicyAudit createUOMCountryPolicyAudit(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomCountryPolicyAudit uomCountryPolicyAudit = newTransientInstance(OmUomCountryPolicyAudit.class);
        uomCountryPolicyAudit.setOrgId(orgId);
        uomCountryPolicyAudit.setLocCountryId(locCountryId);
        uomCountryPolicyAudit.setMeasureEntityId(measureEntityId);
        uomCountryPolicyAudit.setMeasureId(measureId);
        uomCountryPolicyAudit.setUnitFamilyId(unitFamilyId);
        uomCountryPolicyAudit.setUnitId(unitId);
        uomCountryPolicyAudit.setChangeDate(new Date());
        persistIfNotAlready(uomCountryPolicyAudit);
        return uomCountryPolicyAudit;
    }

    public List<MOrganisation> choices0CreateUOMCountryPolicyAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMCountryPolicyAudit() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMCountryPolicyAudit() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMCountryPolicyAudit() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMCountryPolicyAudit() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "11")
    public List<OmUomExtDataSourceExcept> listAllUOMExtDataSrcExcept() {
        return allInstances(OmUomExtDataSourceExcept.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "12")
    @Named("Create UOM Ext Data Src Except")
    public OmUomExtDataSourceExcept createUOMExtDataSrcExcept(
            final @Named("ExtDataSourceId") MExtDataSourceInfo extDataSourceId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomExtDataSourceExcept uomExtDataSourceExcept = newTransientInstance(OmUomExtDataSourceExcept.class);
        uomExtDataSourceExcept.setExtDataSourceId(extDataSourceId);
        uomExtDataSourceExcept.setMeasureEntityId(measureEntityId);
        uomExtDataSourceExcept.setMeasureId(measureId);
        uomExtDataSourceExcept.setMUnitFamily(unitFamilyId);
        uomExtDataSourceExcept.setMUnit(unitId);
        uomExtDataSourceExcept.setChangeDate(new Date());
        persistIfNotAlready(uomExtDataSourceExcept);
        return uomExtDataSourceExcept;
    }

    public List<MExtDataSourceInfo> choices0CreateUOMExtDataSrcExcept() {
        return allInstances(MExtDataSourceInfo.class);
    }

    public List<MMeasurementEntity> choices2CreateUOMExtDataSrcExcept() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMExtDataSrcExcept() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMExtDataSrcExcept() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMExtDataSrcExcept() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "13")
    public List<OmUomOrgPolicy> listAllUOMOrgPolicy() {
        return allMatches(new QueryDefault<OmUomOrgPolicy>(OmUomOrgPolicy.class, "fetch_uomorgpolicy_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "14")
    @Named("Create UOM Org Policy")
    public OmUomOrgPolicy createUOMOrgPolicy(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomOrgPolicy uomOrgPolicy = newTransientInstance(OmUomOrgPolicy.class);
        uomOrgPolicy.setOrgId(orgId);
        uomOrgPolicy.setMeasureEntityId(measureEntityId);
        uomOrgPolicy.setMeasureId(measureId);
        uomOrgPolicy.setMUnitFamily(unitFamilyId);
        uomOrgPolicy.setMUnit(unitId);
        uomOrgPolicy.setChangeDate(new Date());
        persistIfNotAlready(uomOrgPolicy);
        return uomOrgPolicy;
    }

    public List<MOrganisation> choices0CreateUOMOrgPolicy() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMOrgPolicy() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMOrgPolicy() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMOrgPolicy() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMOrgPolicy() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "15")
    public List<OmUomOrgPolicyAudit> listAllUOMOrgPolicyAudit() {
        return allMatches(new QueryDefault<OmUomOrgPolicyAudit>(OmUomOrgPolicyAudit.class,
                "fetch_uomorgpolicyaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "16")
    @Named("Create UOM Org PolicyAudit")
    public OmUomOrgPolicyAudit createUOMOrgPolicyAudit(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomOrgPolicyAudit uomOrgPolicyAudit = newTransientInstance(OmUomOrgPolicyAudit.class);
        uomOrgPolicyAudit.setOrgId(orgId);
        uomOrgPolicyAudit.setMeasureEntityId(measureEntityId);
        uomOrgPolicyAudit.setMeasureId(measureId);
        uomOrgPolicyAudit.setUnitFamilyId(unitFamilyId);
        uomOrgPolicyAudit.setUnitId(unitId);
        uomOrgPolicyAudit.setChangeDate(new Date());
        persistIfNotAlready(uomOrgPolicyAudit);
        return uomOrgPolicyAudit;
    }

    public List<MOrganisation> choices0CreateUOMOrgPolicyAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMOrgPolicyAudit() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMOrgPolicyAudit() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMOrgPolicyAudit() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMOrgPolicyAudit() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "17")
    public List<OmUomSiteExcept> listAllUOMSiteExcept() {
        return allMatches(new QueryDefault<OmUomSiteExcept>(OmUomSiteExcept.class, "fetch_uomsiteexcept_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "18")
    @Named("Create UOM Site Except")
    public OmUomSiteExcept createUOMSiteExcept(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomSiteExcept uomSiteExcept = newTransientInstance(OmUomSiteExcept.class);
        uomSiteExcept.setOrgId(orgId);
        uomSiteExcept.setMeasureEntityId(measureEntityId);
        uomSiteExcept.setMeasureId(measureId);
        uomSiteExcept.setMUnitFamily(unitFamilyId);
        uomSiteExcept.setMUnit(unitId);
        uomSiteExcept.setChangeDate(new Date());
        persistIfNotAlready(uomSiteExcept);
        return uomSiteExcept;
    }

    public List<MOrganisation> choices0CreateUOMSiteExcept() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMSiteExcept() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMSiteExcept() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMSiteExcept() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMSiteExcept() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "19")
    public List<OmUomSiteExceptAudit> listAllUOMSiteExceptAudit() {
        return allMatches(new QueryDefault<OmUomSiteExceptAudit>(OmUomSiteExceptAudit.class,
                "fetch_uomsiteexceptaudit_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "18")
    @Named("Create UOM Site Except")
    public OmUomSiteExceptAudit createUOMSiteExceptAudit(final @Named("OrgId") MOrganisation orgId,
            final @Named("LocCountryId") String locCountryId,
            final @Named("MeasureEntityId") MMeasurementEntity measureEntityId,
            final @Named("MeasureId") MMeasurement measureId, final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("UnitId") MUnit unitId) {
        OmUomSiteExceptAudit uomSiteExceptAudit = newTransientInstance(OmUomSiteExceptAudit.class);
        uomSiteExceptAudit.setOrgId(orgId);
        uomSiteExceptAudit.setMeasureEntityId(measureEntityId);
        uomSiteExceptAudit.setMeasureId(measureId);
        uomSiteExceptAudit.setUnitFamilyId(unitFamilyId);
        uomSiteExceptAudit.setUnitId(unitId);
        uomSiteExceptAudit.setChangeDate(new Date());
        persistIfNotAlready(uomSiteExceptAudit);
        return uomSiteExceptAudit;
    }

    public List<MOrganisation> choices0CreateUOMSiteExceptAudit() {
        return this.orgService.listAllOrganisations();
    }

    public List<MMeasurementEntity> choices2CreateUOMSiteExceptAudit() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choices3CreateUOMSiteExceptAudit() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    public List<MUnitFamily> choices4CreateUOMSiteExceptAudit() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices5CreateUOMSiteExceptAudit() {
        return allInstances(MUnit.class);
    }

}
