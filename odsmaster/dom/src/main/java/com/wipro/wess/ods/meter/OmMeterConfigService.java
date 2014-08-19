package com.wipro.wess.ods.meter;

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

import com.wipro.wess.ods.meter.OmMeterConfig.FunctionalType;
import com.wipro.wess.ods.site.OmSite;

@Named("Meter")
public class OmMeterConfigService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "OmMeterConfigService";
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
    @Named("List of Meter configs")
    public List<OmMeterConfig> listAllMeterConfigs() {
        return allMatches(new QueryDefault<OmMeterConfig>(OmMeterConfig.class, "fetch_meterconfigs_by_user",
                "userName", this.container.getUser().getName()));
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Meter config")
    public OmMeterConfig createMeterConfig(final @Named("MeterUid") String meterUid, final @Named("Site") OmSite site,
            final @Named("Functional Type") String functionalType) {
        OmMeterConfig meterConfig = newTransientInstance(OmMeterConfig.class);
        meterConfig.setMeterUid(meterUid);
        meterConfig.setFunctionalType(functionalType);
        meterConfig.setSite(site);
        meterConfig.setInsertedBy(this.container.getUser().getName());
        meterConfig.setInsertedTimeTs(new Date());
        persistIfNotAlready(meterConfig);
        return meterConfig;
    }

    public List<OmSite> choices1CreateMeterConfig() {
        return allMatches(new QueryDefault<OmSite>(OmSite.class, "fetch_sites_by_user", "userName", this.container
                .getUser().getName()));
    }

    public List<String> choices2CreateMeterConfig() {
        List<String> functionalTypes = new ArrayList<String>();
        functionalTypes.add(FunctionalType.OM.name());
        functionalTypes.add(FunctionalType.UM.name());
        return functionalTypes;
    }
}
