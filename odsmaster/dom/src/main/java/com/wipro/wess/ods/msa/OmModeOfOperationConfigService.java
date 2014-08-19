package com.wipro.wess.ods.msa;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.organisation.OrganisationService;

//@Named("Operation Mode Config")
public class OmModeOfOperationConfigService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmModeOfOperationConfigService";
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(name = "MSA", sequence = "MSA.OmModeOfOperationConfig.1")
    @Named("List of operation modes")
    public List<OmModeOfOperationConfig> listAllModeOprConfigs() {
        return allMatches(new QueryDefault<OmModeOfOperationConfig>(OmModeOfOperationConfig.class,
                "fetch_oprmodeconfigs_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(name = "MSA", sequence = "MSA.OmModeOfOperationConfig.2")
    @Named("Create Operation mode config")
    public OmModeOfOperationConfig createModeOprConfig(final @Named("Mode name") String modeName,
            final @Named("Organization") MOrganisation organisation, final @Named("Description") String modeDescription) {
        OmModeOfOperationConfig modeOprConfig = newTransientInstance(OmModeOfOperationConfig.class);
        modeOprConfig.setModeName(modeName);
        modeOprConfig.setModeDescription(modeDescription);
        modeOprConfig.setOrganisation(organisation);
        persistIfNotAlready(modeOprConfig);
        return modeOprConfig;
    }

    private OrganisationService orgService;

    public void injectOrganisationService(OrganisationService orgService) {
        this.orgService = orgService;
    }

    public List<MOrganisation> choices1CreateModeOprConfig() {
        return this.orgService.listAllOrganisations();
    }
}
