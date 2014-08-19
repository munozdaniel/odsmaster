package com.wipro.wess.ods.service;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteService;

@Named("Service")
public class OmServiceConfigService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmServiceConfigService";
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
    @Named("List of Service configs")
    public List<OmServiceConfig> listAllServiceConfigs() {
        return allMatches(new QueryDefault<OmServiceConfig>(OmServiceConfig.class, "fetch_serviceconfigs_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Service config")
    public OmServiceConfig createServiceConfig(final @Named("Site") OmSite site,
            final @Named("ServiceUid") String serviceUid) {
        OmServiceConfig serviceConfig = newTransientInstance(OmServiceConfig.class);
        serviceConfig.setSite(site);
        serviceConfig.setServiceUid(serviceUid);
        serviceConfig.setChangeBy(this.container.getUser().getName());
        serviceConfig.setChangeTs(new Date());
        persistIfNotAlready(serviceConfig);
        return serviceConfig;
    }

    private OmSiteService siteService;

    public void injectOmSiteService(OmSiteService siteService) {
        this.siteService = siteService;
    }

    public List<OmSite> choices0CreateServiceConfig() {
        return this.siteService.listAllSites();
    }
}
