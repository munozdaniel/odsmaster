package com.wipro.wess.ods.organisation;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;

@Named("Organisation")
public class OrganisationService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "morganisation";
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
    public List<MOrganisation> listAllOrganisations() {
        return allMatches(new QueryDefault<MOrganisation>(MOrganisation.class, "fetch_organizations_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    public MOrganisation createOrganisation(final @Named("Id") String orgId, final @Named("Name") String orgName,
            final @Named("Description") String orgDesc) {
        MOrganisation organisation = newTransientInstance(MOrganisation.class);
        organisation.setOrgId(orgId);
        organisation.setOrgName(orgName);
        organisation.setOrgDesc(orgDesc);
        persistIfNotAlready(organisation);
        return organisation;

    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    public List<OmOrgExtendedAttr> listAllOrgExtdAttr() {
        return allInstances(OmOrgExtendedAttr.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "4")
    public OmOrgExtendedAttr createOrgExtdAttr(final @Named("OrgId") MOrganisation orgId,
            final @Named("ParameterName") String parameterName, final @Named("ParameterValue") String parameterValue,
            final @Named("Description") String desc) {
        OmOrgExtendedAttr omOrgExtendedAttr = newTransientInstance(OmOrgExtendedAttr.class);
        // OmOrgExtendedAttrId id = new OmOrgExtendedAttrId(orgId, parameterName);
        // omOrgExtendedAttr.setOrgId(orgId);
        omOrgExtendedAttr.setParameterName(parameterName);
        /*
         * MOrganisation organisation = null; QueryDefault<MOrganisation> query = new
         * QueryDefault<MOrganisation>(MOrganisation.class, "fetch_orgnaisation_by_id", "orgId",
         * mOrganisation.getOrgId()); List<MOrganisation> organisatinsList = allMatches(query); if(organisatinsList !=
         * null && organisatinsList.size() > 0){ organisation = organisatinsList.get(0); } if(organisation == null){
         * raiseError("Organisation association is mandatory"); }
         */
        omOrgExtendedAttr.setOrganisation(orgId);
        omOrgExtendedAttr.setParameterValue(parameterValue);
        omOrgExtendedAttr.setParamDes(desc);
        persistIfNotAlready(omOrgExtendedAttr);
        return omOrgExtendedAttr;

    }

    // @NotInServiceMenu
    /*
     * public List<String> choices0Create(){ List<String> orgIds = new ArrayList<String>(); for(MOrganisation
     * organisation : allInstances(MOrganisation.class)){ orgIds.add(organisation.getOrgId()); } return orgIds; }
     */
    public List<MOrganisation> choices0CreateOrgExtdAttr() {

        return this.listAllOrganisations();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    public List<OmOrgSrefName> listAllOrgSrefName() {
        return allMatches(new QueryDefault<OmOrgSrefName>(OmOrgSrefName.class, "fetch_orgsrefs_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    public OmOrgSrefName createOrgSrefName(final @Named("OrgId") MOrganisation MOrganisation,
            final @Named("SourceTypeId") MSourcetypeConfig MSourcetypeConfig,
            final @Named("RefUMDisplay") String refUmDisplay, final @Named("RefOmDisplay") String refOmDisplay,
            final @Named("RefCmDisplay") String refCmDisplay, final @Named("RefMDisplay") String refMDisplay) {

        OmOrgSrefName organisationRef = newTransientInstance(OmOrgSrefName.class);
        organisationRef.setMOrganisation(MOrganisation);
        organisationRef.setMSourcetypeConfig(MSourcetypeConfig);
        organisationRef.setRefUmDisplay(refUmDisplay);
        organisationRef.setRefOmDisplay(refOmDisplay);
        organisationRef.setRefCmDisplay(refCmDisplay);
        organisationRef.setRefMDisplay(refMDisplay);
        organisationRef.setInsertedBy(this.container.getUser().getName());
        organisationRef.setInsertedTimeTs(new Date());
        persistIfNotAlready(organisationRef);
        return organisationRef;

    }

    public List<MOrganisation> choices0CreateOrgSrefName() {
        return this.listAllOrganisations();
    }

    public List<MSourcetypeConfig> choices1CreateOrgSrefName() {
        return allInstances(MSourcetypeConfig.class);
    }

}
