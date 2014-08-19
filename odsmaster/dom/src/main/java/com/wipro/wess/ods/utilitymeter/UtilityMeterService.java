package com.wipro.wess.ods.utilitymeter;

import java.util.ArrayList;
import java.util.Date;
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
import com.wipro.wess.ods.upload.ProvisioningConstants;

@Named("Utility Meters")
public class UtilityMeterService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "UtilityMeterService";
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
    @Named("List all Utility suppliers")
    public List<OmUtilitySupplier> listAllUtiltySuppliers() {
        return allMatches(new QueryDefault<OmUtilitySupplier>(OmUtilitySupplier.class, "fetch_utilsuppl_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    public OmUtilitySupplier createUtilitySupplier(final @Named("Id") MOrganisation orgId,
            final @Named("SupplierCode") String supplierCode, final @Named("SupplierName") String supplierName,
            final @Named("Status") String status) {
        OmUtilitySupplier utilitySupplier = newTransientInstance(OmUtilitySupplier.class);
        utilitySupplier.setMOrganisation(orgId);
        utilitySupplier.setSupplierCode(supplierCode);
        utilitySupplier.setSupplierName(supplierName);
        utilitySupplier.setStatus(status);
        utilitySupplier.setCreatedBy(this.container.getUser().getName());
        utilitySupplier.setCreateDate(new Date());
        utilitySupplier.setInsertedBy(this.container.getUser().getName());
        utilitySupplier.setInsertedTimeTs(new Date());
        persistIfNotAlready(utilitySupplier);
        return utilitySupplier;
    }

    OrganisationService orgService;

    public void injectOrganisationService(OrganisationService orgService) {
        this.orgService = orgService;
    }

    public List<MOrganisation> choices0CreateUtilitySupplier() {
        return this.orgService.listAllOrganisations();
    }

    public List<String> choices3CreateUtilitySupplier() {
        List<String> statusList = new ArrayList<String>();
        statusList.add(ProvisioningConstants.ZERO + "");
        statusList.add(ProvisioningConstants.ONE + "");
        return statusList;
    }

}
