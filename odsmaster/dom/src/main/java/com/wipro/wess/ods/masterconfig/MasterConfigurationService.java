package com.wipro.wess.ods.masterconfig;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.asset.OmAssetService;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;
import com.wipro.wess.ods.reporting.OmLocationHierarchyService;

@Named("Master Configuration")
public class MasterConfigurationService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmGeoLocationService";
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
    public List<OmGeoLocation> listAllGeolocations() {
        return allMatches(new QueryDefault<OmGeoLocation>(OmGeoLocation.class, "fetch_geolocations_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    
    @MemberOrder(sequence = "2")
    public OmGeoLocation createGeoLocation(final @Named("LocationId") String locationId,
            final @Named("Organization") MOrganisation orgId) {
        OmGeoLocation geoLocation = newTransientInstance(OmGeoLocation.class);
        geoLocation.setLocationId(locationId);
        geoLocation.setOrgId(orgId);
        persistIfNotAlready(geoLocation);
        return geoLocation;
    }

    public List<MOrganisation> choices1CreateGeoLocation() {
        return allMatches(new QueryDefault<MOrganisation>(MOrganisation.class, "fetch_organizations_by_user",
                "userName", this.container.getUser().getName()));
    }
    
    
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    public List<MAssetclass> listAllAssetclass() {
        return allInstances(MAssetclass.class);
    }
    
    
    @MemberOrder(sequence = "4")
    public MAssetclass createAssetClass(final @Named("AssetClassCode")String assetclassCode, final @Named("AssetClass Description")String assetClassDesc){
        MAssetclass assetClass = newTransientInstance(MAssetclass.class);
        assetClass.setAssetclassCode(assetclassCode);
        assetClass.setAssetclass(assetClassDesc);
        assetClass.setChangeby(this.container.getUser().getName());
        assetClass.setChangedt(new Date());
        persistIfNotAlready(assetClass);
        return assetClass;
    }
    
    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    @Named("List all PointList")
    public List<MPointlist> listAllPointList() {
        return allInstances(MPointlist.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    
    @MemberOrder(sequence = "6")
    @Named("Create PointList")
    public MPointlist createPointList(final @Named("AssetClassCode") MAssetclass assetclassCode,
            final @Named("Point") String point, final @Named("Point") String datapointtype) {
        MPointlist pointList = newTransientInstance(MPointlist.class);
        pointList.setAssetclassCode(assetclassCode);
        pointList.setPoint(point);
        pointList.setDatapointtype(datapointtype);
        pointList.setChangeby(this.container.getUser().getName());
        pointList.setChangedate(new Date());
        persistIfNotAlready(pointList);
        return pointList;
    }

    private MasterConfigurationService masterConfigurationService;

    public void injectOmAssetService(MasterConfigurationService masterConfigurationService) {
        this.masterConfigurationService = masterConfigurationService;
    }

    public List<MAssetclass> choices0CreatePointList() {
        return this.masterConfigurationService.listAllAssetclass();
    }
    
    private OmAssetService assetService;
    
    public void injectOmAssetService(OmAssetService assetService){
        this.assetService = assetService;
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    @Named("List all Pointpaths")
    public List<OmPointpath> listAllPointpaths() {
        return allMatches(new QueryDefault<OmPointpath>(OmPointpath.class, "fetch_ompointpaths_by_user", "userName",
                this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    
    @MemberOrder(sequence = "8")
    @Named("Create Pointpath")
    public OmPointpath createPointpath(final @Named("Pointpath") String pointpath,
            final @Named("Pointlist(assetclass_code and point)") MPointlist pointlist,
            final @Named("Location") OmLocationHierarchy locationHierarchy, final @Named("AssetUid") OmAsset assetUid) {
        OmPointpath pointpathObj = newTransientInstance(OmPointpath.class);
        pointpathObj.setPointpath(pointpath);
        pointpathObj.setFieldPointpath(pointpath);
        pointpathObj.setAssetUid(assetUid);
        pointpathObj.setMPointlist(pointlist);
        pointpathObj.setOmLocationHierarchy(locationHierarchy);
        pointpathObj.setChangeby(this.container.getUser().getName());
        pointpathObj.setChangedate(new Date());
        persistIfNotAlready(pointpathObj);
        return pointpathObj;
    }
    
    public List<MPointlist> choices1CreatePointpath() {
        return this.listAllPointList();
    }
    
    private OmLocationHierarchyService hierarchyService;

    public void injectOmLocationHierarchies(OmLocationHierarchyService hierarchyService) {
        this.hierarchyService = hierarchyService;
    }

    public List<OmLocationHierarchy> choices2CreatePointpath() {
        return this.hierarchyService.listAll();
    }

    public List<OmAsset> choices3CreatePointpath() {
        return this.assetService.listAllAssets();
    }

}
