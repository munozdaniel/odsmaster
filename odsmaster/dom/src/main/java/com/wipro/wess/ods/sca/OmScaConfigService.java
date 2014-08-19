package com.wipro.wess.ods.sca;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotContributed;
import org.apache.isis.applib.annotation.NotInServiceMenu;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.msa.OmMsaConfig;
import com.wipro.wess.ods.msa.OmMsaConfigService;
import com.wipro.wess.ods.msa.OmMsaScaMap;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.service.OmServiceConfigService;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteService;

@Named("SCA")
public class OmScaConfigService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmScaConfigService";
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
    @Named("List of Sca configs")
    public List<OmScaConfig> listAllScaConfigs() {
        return allMatches(new QueryDefault<OmScaConfig>(OmScaConfig.class, "fetch_scaconfigs_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Sca config")
    public OmScaConfig createScaConfig(final @Named("ScaUid") String scaUid, final @Named("Sca Name") String scaName,
            final @Named("MsaUid") OmMsaConfig msaUid, final @Named("Site") OmSite site) {
        OmScaConfig scaConfig = newTransientInstance(OmScaConfig.class);
        scaConfig.setScaUid(scaUid);
        scaConfig.setScaName(scaName);
        scaConfig.setOmSite(site);
        scaConfig.setChangeBy(this.container.getUser().getName());
        scaConfig.setChangeDt(new Date());
        persistIfNotAlready(scaConfig);
        OmMsaScaMap msaScaMap = newTransientInstance(OmMsaScaMap.class);
        msaScaMap.setOmMsaConfig(msaUid);
        msaScaMap.setOmScaConfig(scaConfig);
        msaScaMap.setOrgId(site.getOrgId());
        msaScaMap.setChangeBy(this.container.getUser().getName());
        msaScaMap.setChangeDt(new Date());
        persistIfNotAlready(msaScaMap);
        return scaConfig;
    }

    private OmMsaConfigService msaConfigService;

    public void injectOmMsaConfigService(OmMsaConfigService msaConfigService) {
        this.msaConfigService = msaConfigService;
    }

    public List<OmMsaConfig> choices2CreateScaConfig() {
        return this.msaConfigService.listAllMsaConfigs();
    }

    private OmSiteService siteService;

    public void injectOmSiteService(OmSiteService siteService) {
        this.siteService = siteService;
    }

    public List<OmSite> choices3CreateScaConfig() {
        return this.siteService.listAllSites();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    @Named("List of Sca extended attrs")
    public List<OmScaConfigExtAttr> listAllScaConfigExtAttrs() {
        return allMatches(new QueryDefault<OmScaConfigExtAttr>(OmScaConfigExtAttr.class, "fetch_scaextattrs_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "4")
    @Named("Create Sca config extended attr")
    public OmScaConfigExtAttr createScaConfigExtAttr(final @Named("ScaUid") OmScaConfig scaUid,
            final @Named("AttributeName") String attributeName, final @Named("AlnValue") @Optional String alnValue,
            final @Named("NumValue") @Optional BigDecimal numValue) {
        OmScaConfigExtAttr scaConfigExtAttr = newTransientInstance(OmScaConfigExtAttr.class);
        scaConfigExtAttr.setScaUid(scaUid);
        scaConfigExtAttr.setAttributeName(attributeName);
        scaConfigExtAttr.setAlnValue(alnValue);
        scaConfigExtAttr.setNumValue(numValue);
        persistIfNotAlready(scaConfigExtAttr);
        return scaConfigExtAttr;
    }

    public List<OmScaConfig> choices0CreateScaConfigExtAttr() {
        return this.listAllScaConfigs();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    @Named("List of Sca monitor asset map")
    public List<OmScaMonitorassetMap> listAllScaMoniterAssetMap() {
        return allMatches(new QueryDefault<OmScaMonitorassetMap>(OmScaMonitorassetMap.class,
                "fetch_scamonitorassets_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create Sca Monitor asset map")
    public OmScaMonitorassetMap createScaMonitorAssetMap(final @Named("ScaUid") OmScaConfig scaUid,
            final @Named("Monitoring Asset") OmAsset monitorAssetUid) {
        OmScaMonitorassetMap scaMonitorAssetMap = newTransientInstance(OmScaMonitorassetMap.class);
        scaMonitorAssetMap.setScaUid(scaUid);
        scaMonitorAssetMap.setMonitorAssetUid(monitorAssetUid);
        scaMonitorAssetMap.setChangeBy(this.container.getUser().getName());
        scaMonitorAssetMap.setChangeDt(new Date());
        persistIfNotAlready(scaMonitorAssetMap);
        return scaMonitorAssetMap;
    }

    public List<OmScaConfig> choices0CreateScaMonitorAssetMap() {
        return this.listAllScaConfigs();
    }

    public List<OmAsset> choices1CreateScaMonitorAssetMap() {
        return this.listAllMonitoringAssets();
    }

    @Programmatic
    @NotContributed
    @NotInServiceMenu
    public List<OmAsset> listAllMonitoringAssets() {
        return allMatches(new QueryDefault<OmAsset>(OmAsset.class, "fetch_assets_by_type_and_user", "type",
                "Monitoring Asset", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    @Named("List of Sca Service Map")
    public List<OmScaServiceMap> listAllScaServiceMap() {
        return allMatches(new QueryDefault<OmScaServiceMap>(OmScaServiceMap.class, "fetch_scaservicemap_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "8")
    @Named("Create Sca Service Map")
    public OmScaServiceMap createScaServiceMap(final @Named("MsaUid") OmScaConfig scaUid,
            final @Named("ScaUid") OmServiceConfig serviceUid) {
        OmScaServiceMap scaServiceMap = newTransientInstance(OmScaServiceMap.class);
        scaServiceMap.setScaUid(scaUid);
        scaServiceMap.setServiceUid(serviceUid);
        scaServiceMap.setOrgId(scaUid.getOmSite().getOrgId());
        scaServiceMap.setChangeBy(this.container.getUser().getName());
        scaServiceMap.setChangeDt(new Date());
        persistIfNotAlready(scaServiceMap);
        return scaServiceMap;
    }

    public List<OmScaConfig> choices0CreateScaServiceMap() {
        return this.listAllScaConfigs();
    }

    private OmServiceConfigService omServiceConfigService;

    public void injectOmServiceConfigService(OmServiceConfigService omServiceConfigService) {
        this.omServiceConfigService = omServiceConfigService;
    }

    public List<OmServiceConfig> choices1CreateScaServiceMap() {
        return this.omServiceConfigService.listAllServiceConfigs();
    }
}
