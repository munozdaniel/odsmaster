package com.wipro.wess.ods.asset.servicemapping;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.asset.OmAssetService;
import com.wipro.wess.ods.service.OmServiceConfig;

@Named("AssetServiceMapping")
public class AssetServiceMappingService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "AssetServiceMappingService";
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<OmAssetInputservice> listAllAssetInputServices() {
        return allMatches(new QueryDefault<OmAssetInputservice>(OmAssetInputservice.class,
                "fetch_input_services_by_user", "userName", this.container.getUser().getName()));
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "2")
    public List<OmAssetOutputservice> listAllAssetOutputServices() {
        return allMatches(new QueryDefault<OmAssetOutputservice>(OmAssetOutputservice.class,
                "fetch_output_services_by_user", "userName", this.container.getUser().getName()));
    }

    @MemberOrder(sequence = "3")
    public OmAssetInputservice createAssetInputService(final @Named("Asset") OmAsset asset,
            final @Named("Service") OmServiceConfig service) {
        OmAssetInputservice assetInputservice = newTransientInstance(OmAssetInputservice.class);
        assetInputservice.setAssetUid(asset);
        assetInputservice.setOrgId(asset.getOrganisation());
        assetInputservice.setInputserviceAssetUid(service);
        assetInputservice.setChangedt(new Date());
        persistIfNotAlready(assetInputservice);
        return assetInputservice;
    }

    private OmAssetService assetService;

    public void injectOmAssetService(OmAssetService assetService) {
        this.assetService = assetService;
    }

    public List<OmAsset> choices0CreateAssetInputService() {
        return this.assetService.listAllAssets();
    }

    public List<OmServiceConfig> choices1CreateAssetInputService() {
        return allMatches(new QueryDefault<OmServiceConfig>(OmServiceConfig.class, "fetch_serviceconfigs_by_user",
                "userName", this.container.getUser().getName()));
    }

    @MemberOrder(sequence = "4")
    public OmAssetOutputservice createAssetOutputService(final @Named("Asset") OmAsset asset,
            final @Named("Service") OmServiceConfig service) {
        OmAssetOutputservice assetOutputservice = newTransientInstance(OmAssetOutputservice.class);
        assetOutputservice.setAssetUid(asset);
        assetOutputservice.setOrgId(asset.getOrganisation());
        assetOutputservice.setOutputserviceAssetUid(service);
        assetOutputservice.setChangedt(new Date());
        persistIfNotAlready(assetOutputservice);
        return assetOutputservice;
    }

    public List<OmAsset> choices0CreateAssetOutputService() {
        return this.assetService.listAllAssets();
    }

    public List<OmServiceConfig> choices1CreateAssetOutputService() {
        return allMatches(new QueryDefault<OmServiceConfig>(OmServiceConfig.class, "fetch_serviceconfigs_by_user",
                "userName", this.container.getUser().getName()));
    }

}
