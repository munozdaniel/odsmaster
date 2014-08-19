package com.wipro.wess.ods.asset;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.asset.OmSupplierAssetConfig.AfterHrsFlag;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.service.OmServiceConfigService;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteService;

//@Named("Supplier Asset")
public class OmSupplierAssetService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmSupplierAssetService";
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(name = "Asset", sequence = "Asset.OmSupplierAssetConfig.1")
    @Named("List all Supplier Assets")
    public List<OmSupplierAssetConfig> listAllSupplierAssets() {
        return allMatches(new QueryDefault<OmSupplierAssetConfig>(OmSupplierAssetConfig.class,
                "fetch_supplassets_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(name = "Asset", sequence = "Asset.OmSupplierAssetConfig.2")
    @Named("Create Supplier Asset")
    public OmSupplierAssetConfig createSupplierAsset(final @Named("Site") OmSite site,
            final @Named("SupAssetUid") @Optional String supAssetUid,
            final @Named("SupAssetDesc") @Optional String supAssetDesc,
            final @Named("SupAssetType") @Optional String supAssetType,
            final @Named("AfterHrsFlag") @Optional String afterHrsFlag) {
        OmSupplierAssetConfig supplierAssetConfig = newTransientInstance(OmSupplierAssetConfig.class);
        supplierAssetConfig.setOmSite(site);
        supplierAssetConfig.setSupAssetUid(supAssetUid);
        supplierAssetConfig.setSupAssetDesc(supAssetDesc);
        supplierAssetConfig.setSupAssetType(supAssetType);
        supplierAssetConfig.setAfterHrsFlag(afterHrsFlag);
        persistIfNotAlready(supplierAssetConfig);
        return supplierAssetConfig;

    }

    private OmSiteService siteService;

    public void injectOmSiteService(OmSiteService siteService) {
        this.siteService = siteService;
    }

    public List<OmSite> choices0CreateSupplierAsset() {
        return this.siteService.listAllSites();
    }

    public List<String> choices4CreateSupplierAsset() {
        List<String> afterHrsFlagList = new ArrayList<String>();
        afterHrsFlagList.add(AfterHrsFlag.Y.name());
        afterHrsFlagList.add(AfterHrsFlag.N.name());
        return afterHrsFlagList;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(name = "Asset", sequence = "Asset.OmSupplierAssetServiceMap.1")
    @Named("List all Supplier Asset Service Map")
    public List<OmSupplierAssetServiceMap> listAllSuplAssetServiceMap() {
        return allMatches(new QueryDefault<OmSupplierAssetServiceMap>(OmSupplierAssetServiceMap.class,
                "fetch_suplservicemap_by_user", "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(name = "Asset", sequence = "Asset.OmSupplierAssetServiceMap.2")
    @Named("Create Supplier Asset Service Map")
    public OmSupplierAssetServiceMap createSuplAssetServiceMap(
            final @Named("SupplierAssetConfig") OmSupplierAssetConfig omSupplierAssetConfig,
            final @Named("ServiceConfig") OmServiceConfig omServiceConfig) {
        OmSupplierAssetServiceMap supplierAssetServiceMap = newTransientInstance(OmSupplierAssetServiceMap.class);
        supplierAssetServiceMap.setOmSupplierAssetConfig(omSupplierAssetConfig);
        supplierAssetServiceMap.setOmServiceConfig(omServiceConfig);
        persistIfNotAlready(supplierAssetServiceMap);
        return supplierAssetServiceMap;

    }

    public List<OmSupplierAssetConfig> choices0CreateSuplAssetServiceMap() {
        return this.listAllSupplierAssets();
    }

    private OmServiceConfigService serviceConfigService;

    public void injectOmServiceConfigService(OmServiceConfigService serviceConfigService) {
        this.serviceConfigService = serviceConfigService;
    }

    public List<OmServiceConfig> choices1CreateSuplAssetServiceMap() {
        return this.serviceConfigService.listAllServiceConfigs();
    }
}
