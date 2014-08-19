package com.wipro.wess.ods.asset;

import java.math.BigDecimal;
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

import com.wipro.wess.ods.masterconfig.MAssetclass;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;

@Named("Asset")
public class OmAssetService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmAssetService";
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
    public List<OmAsset> listAllAssets() {
        return allMatches(new QueryDefault<OmAsset>(OmAsset.class, "fetch_assets_by_user", "userName", this.container
                .getUser().getName()));
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "4")
    public List<OmAssetspec> listAllAssetspecs() {
        return allMatches(new QueryDefault<OmAssetspec>(OmAssetspec.class, "fetch_assetspecs_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "5")
    public OmAsset createAsset(final @Named("Asset Uid") String assetUid,
            final @Named("Organisation") MOrganisation organisation,
            final @Named("Asset Class") MAssetclass assetClass,
            final @Named("Location Hierarchy") OmLocationHierarchy omLocationHierarchy) {
        OmAsset asset = newTransientInstance(OmAsset.class);
        asset.setAssetUid(assetUid);
        asset.setOrganisation(organisation);
        asset.setOmLocationHierarchy(omLocationHierarchy);
        asset.setMAssetclass(assetClass);
        asset.setChangedate(new Date());
        persistIfNotAlready(asset);
        return asset;

    }

    public List<MOrganisation> choices1CreateAsset() {
        return allMatches(new QueryDefault<MOrganisation>(MOrganisation.class, "fetch_organizations_by_user",
                "userName", this.container.getUser().getName()));
    }

    public List<MAssetclass> choices2CreateAsset() {
        return allInstances(MAssetclass.class);
    }

    public List<OmLocationHierarchy> choices3CreateAsset() {
        return allMatches(new QueryDefault<OmLocationHierarchy>(OmLocationHierarchy.class, "fetch_lochcy_by_user",
                "userName", this.container.getUser().getName()));
    }

    @MemberOrder(sequence = "8")
    public OmAssetspec createAssetspec(final @Named("Asset") OmAsset asset,
            final @Named("AttributeId") int attributeId, final @Named("Attribute Code") String attributeCode,
            final @Named("Num value") BigDecimal numvalue, final @Named("Aln value") @Optional String alnvalue) {
        OmAssetspec assetspec = newTransientInstance(OmAssetspec.class);
        assetspec.setAssetUid(asset);
        // assetspec.setOrgId(asset.getOrganisation());
        assetspec.setAttributeId(attributeId);
        assetspec.setAttributeCode(attributeCode);
        assetspec.setNumvalue(numvalue);
        assetspec.setAlnvalue(alnvalue);
        assetspec.setChangedate(new Date());
        persistIfNotAlready(assetspec);
        return assetspec;
    }

    public List<OmAsset> choices0CreateAssetspec() {
        return this.listAllAssets();
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "11")
    public List<OmAssetInfoElement> listAllAssetInfoElements() {
        return allMatches(new QueryDefault<OmAssetInfoElement>(OmAssetInfoElement.class,
                "fetch_assetinfoelement_by_user", "userName", this.container.getUser().getName()));
    }

    @MemberOrder(sequence = "12")
    public OmAssetInfoElement createAssetInfoElement(final @Named("Asset") OmAsset asset,
            final @Named("MeasurementEntityId") String measurementEntityId, final @Named("MeasureId") String measureId,
            final @Named("StartDate") Date startDate, final @Named("EndDate") @Optional Date endDate,
            final @Named("ValueType") String valueType) {
        OmAssetInfoElement assetInfoElement = newTransientInstance(OmAssetInfoElement.class);
        assetInfoElement.setAsset(asset);
        assetInfoElement.setMeasurementEntityId(measurementEntityId);
        assetInfoElement.setMeasureId(measureId);
        assetInfoElement.setStartDate(startDate);
        assetInfoElement.setEndDate(endDate);
        assetInfoElement.setValueType(valueType);
        assetInfoElement.setChangeby(this.container.getUser().getName());
        assetInfoElement.setChangedt(new Date());
        persistIfNotAlready(assetInfoElement);
        return assetInfoElement;
    }

    public List<OmAsset> choices0CreateAssetInfoElement() {
        return this.listAllAssets();
    }

}
