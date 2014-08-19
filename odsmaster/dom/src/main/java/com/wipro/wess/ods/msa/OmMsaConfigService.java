package com.wipro.wess.ods.msa;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.masterconfig.MSourcetypeConfigs;
import com.wipro.wess.ods.sca.OmScaConfig;
import com.wipro.wess.ods.sca.OmScaConfigService;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.service.OmServiceConfigService;
import com.wipro.wess.ods.site.OmMsaSiteMap;
import com.wipro.wess.ods.site.OmSite;

@Named("MSA")
public class OmMsaConfigService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmMsaConfigService";
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    private MSourcetypeConfigs sourcetypeConfigService;

    public void injectMSourcetypeConfigs(MSourcetypeConfigs sourcetypeConfigService) {
        this.sourcetypeConfigService = sourcetypeConfigService;
    }

    private OmScaConfigService scaService;

    public void injectOmScaConfigService(OmScaConfigService scaService) {
        this.scaService = scaService;
    }

    private OmServiceConfigService omServiceConfigService;

    public void injectOmServiceConfigService(OmServiceConfigService omServiceConfigService) {
        this.omServiceConfigService = omServiceConfigService;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named("List of Msa configs")
    public List<OmMsaConfig> listAllMsaConfigs() {
        return allMatches(new QueryDefault<OmMsaConfig>(OmMsaConfig.class, "fetch_msaconfigs_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Msa config")
    public OmMsaConfig createMsaConfig(final @Named("MsaUid") String msaUid,
            final @Named("Msa Name") @Optional String msaName, final @Named("Site") OmSite site) {
        OmMsaConfig msaConfig = newTransientInstance(OmMsaConfig.class);
        msaConfig.setMsaUid(msaUid);
        // msaConfig.setSite(site);
        msaConfig.setOrgId(site.getOrgId());
        msaConfig.setChangeBy(this.container.getUser().getName());
        msaConfig.setChangeDt(new Date());
        msaConfig.setMsaName(msaName);
        persistIfNotAlready(msaConfig);
        OmMsaSiteMap msaSiteMap = newTransientInstance(OmMsaSiteMap.class);
        msaSiteMap.setMsaUid(msaConfig);
        msaSiteMap.setOmSite(site);
        msaSiteMap.setChangeBy(this.container.getUser().getName());
        msaSiteMap.setChangeDt(new Date());
        persistIfNotAlready(msaSiteMap);
        return msaConfig;
    }

    public List<OmSite> choices2CreateMsaConfig() {
        return allMatches(new QueryDefault<OmSite>(OmSite.class, "fetch_sites_by_user", "userName", this.container
                .getUser().getName()));
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    @Named("List of Msa Cons Formula")
    public List<OmMsaConsFr> listAllMsaConsFr() {
        return allMatches(new QueryDefault<OmMsaConsFr>(OmMsaConsFr.class, "fetch_msaconsfr_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "4")
    @Named("Create Msa Cons Formula")
    public OmMsaConsFr createMsaConsFr(final @Named("MsaUid") OmMsaConfig msaUid,
            final @Named("MeterFormula") String meterFormula, final @Named("Typecode") MSourcetypeConfig typeCode) {
        OmMsaConsFr msaConsFr = newTransientInstance(OmMsaConsFr.class);
        msaConsFr.setMsaUid(msaUid);
        msaConsFr.setTypeCode(typeCode.getTypeCode());
        msaConsFr.setMeterFormula(meterFormula);
        msaConsFr.setOrgId(msaUid.getOrgId());
        msaConsFr.setInsertedBy(this.container.getUser().getName());
        msaConsFr.setInsertedTs(new Date());
        msaConsFr.setUpdatedBy(this.container.getUser().getName());
        msaConsFr.setUpdatedTimeTs(new Date());
        persistIfNotAlready(msaConsFr);
        return msaConsFr;
    }

    public List<OmMsaConfig> choices0CreateMsaConsFr() {
        return this.listAllMsaConfigs();
    }

    public List<MSourcetypeConfig> choices2CreateMsaConsFr() {
        return this.sourcetypeConfigService.listAll();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    @Named("List of Msa Cons ServiceType Formula")
    public List<OmMsaConsStFr> listAllMsaConsStFr() {
        return allMatches(new QueryDefault<OmMsaConsStFr>(OmMsaConsStFr.class, "fetch_msaconsstfr_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create Msa Cons ServiceType Formula")
    public OmMsaConsStFr createMsaConsStFr(final @Named("MsaUid") OmMsaConfig msaUid,
            final @Named("MeterFormula") String meterFormula, final @Named("Typecode") MSourcetypeConfig typeCode,
            final @Named("ServiceType") String serviceType, final @Named("BusinessLoad") String businessLoad) {
        OmMsaConsStFr msaConsStFr = newTransientInstance(OmMsaConsStFr.class);
        msaConsStFr.setMsaUid(msaUid);
        msaConsStFr.setTypeCode(typeCode.getTypeCode());
        msaConsStFr.setMeterFormula(meterFormula);
        msaConsStFr.setOrgId(msaUid.getOrgId());
        msaConsStFr.setServiceType(serviceType);
        msaConsStFr.setInsertedBy(this.container.getUser().getName());
        msaConsStFr.setInsertedTs(new Date());
        msaConsStFr.setUpdatedBy(this.container.getUser().getName());
        msaConsStFr.setUpdatedTimeTs(new Date());
        msaConsStFr.setBusinessLoad(businessLoad);
        persistIfNotAlready(msaConsStFr);
        return msaConsStFr;
    }

    public List<OmMsaConfig> choices0CreateMsaConsStFr() {
        return this.listAllMsaConfigs();
    }

    public List<MSourcetypeConfig> choices2CreateMsaConsStFr() {
        return this.sourcetypeConfigService.listAll();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    @Named("List of Msa Cons ServiceSubType Formula")
    public List<OmMsaConsStsubtFr> listAllMsaConsStSubtFr() {
        return allMatches(new QueryDefault<OmMsaConsStsubtFr>(OmMsaConsStsubtFr.class, "fetch_msaconsstsubtfr_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "8")
    @Named("Create Msa Cons ServiceSubType Formula")
    public OmMsaConsStsubtFr createMsaConsStsubtFr(final @Named("MsaUid") OmMsaConfig msaUid,
            final @Named("MeterFormula") String meterFormula, final @Named("Typecode") MSourcetypeConfig typeCode,
            final @Named("ServiceType") String serviceType, final @Named("ServiceSubtype") String serviceSubType) {
        OmMsaConsStsubtFr msaConsStsubtFr = newTransientInstance(OmMsaConsStsubtFr.class);
        msaConsStsubtFr.setMsaUid(msaUid);
        msaConsStsubtFr.setTypeCode(typeCode.getTypeCode());
        msaConsStsubtFr.setMeterFormula(meterFormula);
        msaConsStsubtFr.setOrgId(msaUid.getOrgId());
        msaConsStsubtFr.setServiceType(serviceType);
        msaConsStsubtFr.setInsertedBy(this.container.getUser().getName());
        msaConsStsubtFr.setInsertedTs(new Date());
        msaConsStsubtFr.setUpdatedBy(this.container.getUser().getName());
        msaConsStsubtFr.setUpdatedTimeTs(new Date());
        msaConsStsubtFr.setServiceSubType(serviceSubType);
        persistIfNotAlready(msaConsStsubtFr);
        return msaConsStsubtFr;
    }

    public List<OmMsaConfig> choices0CreateMsaConsStsubtFr() {
        return this.listAllMsaConfigs();
    }

    public List<MSourcetypeConfig> choices2CreateMsaConsStsubtFr() {
        return this.sourcetypeConfigService.listAll();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "9")
    @Named("List of Msa Sca Map")
    public List<OmMsaScaMap> listAllMsaScaMap() {
        return allMatches(new QueryDefault<OmMsaScaMap>(OmMsaScaMap.class, "fetch_msascamap_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "10")
    @Named("Create Msa Sca Map")
    public OmMsaScaMap createMsaScaMap(final @Named("MsaUid") OmMsaConfig msaUid,
            final @Named("ScaUid") OmScaConfig scaUid) {
        OmMsaScaMap msaScaMap = newTransientInstance(OmMsaScaMap.class);
        msaScaMap.setOmMsaConfig(msaUid);
        msaScaMap.setOmScaConfig(scaUid);
        msaScaMap.setOrgId(msaUid.getOrgId());
        msaScaMap.setChangeBy(this.container.getUser().getName());
        msaScaMap.setChangeDt(new Date());
        persistIfNotAlready(msaScaMap);
        return msaScaMap;
    }

    public List<OmMsaConfig> choices0CreateMsaScaMap() {
        return this.listAllMsaConfigs();
    }

    public List<OmScaConfig> choices1CreateMsaScaMap() {
        return this.scaService.listAllScaConfigs();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "11")
    @Named("List of Msa Service Map")
    public List<OmMsaServiceMap> listAllMsaServiceMap() {
        return allMatches(new QueryDefault<OmMsaServiceMap>(OmMsaServiceMap.class, "fetch_msaservicemap_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "12")
    @Named("Create Msa Service Map")
    public OmMsaServiceMap createMsaServiceMap(final @Named("MsaUid") OmMsaConfig msaUid,
            final @Named("ScaUid") OmServiceConfig serviceUid) {
        OmMsaServiceMap msaServiceMap = newTransientInstance(OmMsaServiceMap.class);
        msaServiceMap.setOmMsaConfig(msaUid);
        msaServiceMap.setServiceUid(serviceUid);
        msaServiceMap.setOrgId(msaUid.getOrgId());
        persistIfNotAlready(msaServiceMap);
        return msaServiceMap;
    }

    public List<OmMsaConfig> choices0CreateMsaServiceMap() {
        return this.listAllMsaConfigs();
    }

    public List<OmServiceConfig> choices1CreateMsaServiceMap() {
        return this.omServiceConfigService.listAllServiceConfigs();
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "13")
    @Named("List of Msa Mode Opr Def")
    public List<OmMsaModeopDef> listAllMsaModeOpDef() {
        return allMatches(new QueryDefault<OmMsaModeopDef>(OmMsaModeopDef.class, "fetch_MsaModeopDef_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "14")
    @Named("Create Msa Mode Opr Def")
    public OmMsaModeopDef createMsaModeopDef(final @Named("MSA") OmMsaConfig msa,
            final @Named("Mode of Operation") OmModeOfOperationConfig modeOfOpr,
            final @Named("Mode definition") String modeDefinition) {
        OmMsaModeopDef msaModeopDef = newTransientInstance(OmMsaModeopDef.class);
        msaModeopDef.setOmMsaConfig(msa);
        msaModeopDef.setOmModeOfOperationConfig(modeOfOpr);
        msaModeopDef.setModeDefinition(modeDefinition);
        persistIfNotAlready(msaModeopDef);
        return msaModeopDef;
    }

    public List<OmMsaConfig> choices0CreateMsaModeopDef() {
        return this.listAllMsaConfigs();
    }

    private OmModeOfOperationConfigService modeOfOperationConfigService;

    public void injectOmModeOfOperationConfigService(OmModeOfOperationConfigService modeOfOperationConfigService) {
        this.modeOfOperationConfigService = modeOfOperationConfigService;
    }

    public List<OmModeOfOperationConfig> choices1CreateMsaModeopDef() {
        return this.modeOfOperationConfigService.listAllModeOprConfigs();
    }
}
