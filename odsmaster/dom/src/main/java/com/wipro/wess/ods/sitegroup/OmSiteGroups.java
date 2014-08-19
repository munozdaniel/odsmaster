package com.wipro.wess.ods.sitegroup;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

public class OmSiteGroups extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "omsitegroup";
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<OmSiteGroup> listAll() {
        return allInstances(OmSiteGroup.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    public OmSiteGroup create(final @Named("Group Name") String groupName) {
        OmSiteGroup group = newTransientInstance(OmSiteGroup.class);
        group.setGroupName(groupName);
        persistIfNotAlready(group);
        return group;

    }
}
