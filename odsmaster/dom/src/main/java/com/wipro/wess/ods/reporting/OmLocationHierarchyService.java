package com.wipro.wess.ods.reporting;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.site.OmSite;

@Named("OmLocationHierarchies")
public class OmLocationHierarchyService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmLocationHierarchies";
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
    public List<OmLocationHierarchy> listAll() {
        return allMatches(new QueryDefault<OmLocationHierarchy>(OmLocationHierarchy.class, "fetch_lochcy_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    public OmLocationHierarchy create(final @Named("LocationId") OmSite locationUid,
            final @Named("OrgId") MOrganisation organisation, final @Named("ContinentCode") String continent,
            final @Named("ContinentName") String continentName, final @Named("CountryCode") String country,
            final @Named("CountryName") String countryName, final @Named("Region1Code") String region1,
            final @Named("Region1Name") String region1Name, final @Named("Region2Code") String region2,
            final @Named("Region2Name") String region2Name, final @Named("CityCode") String city,
            final @Named("CityName") String cityName, final @Named("SourceId") Long sourceId) {

        OmLocationHierarchy omLocationHierarchy = newTransientInstance(OmLocationHierarchy.class);
        // omLocationHierarchy.set
        persistIfNotAlready(omLocationHierarchy);
        return omLocationHierarchy;

    }

    public List<MOrganisation> choices0Create() {
        return allInstances(MOrganisation.class);
    }

    public List<MSourcetypeConfig> choices1Create() {
        return allInstances(MSourcetypeConfig.class);
    }

}
