package com.wipro.wess.ods.masterconfig;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("SourceTypeConfig")
public class MSourcetypeConfigs extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "msourcetypeconfig";
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named("ListAllSourceTypeConfig")
    public List<MSourcetypeConfig> listAll() {
        return allInstances(MSourcetypeConfig.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("CreateSourceTypeConfig")
    public MSourcetypeConfig create(final @Named("TypeCode") String typeCode,
            final @Named("DisplayName") String displayName, final @Named("Description") String description,
            final @Named("SourceId") Long sourceId) {
        MSourcetypeConfig sourcetypeConfig = newTransientInstance(MSourcetypeConfig.class);
        sourcetypeConfig.setTypeCode(typeCode);
        sourcetypeConfig.setDisplayName(displayName);
        sourcetypeConfig.setDescription(description);
        sourcetypeConfig.setSourceId(sourceId);
        sourcetypeConfig.setInsertedBy("ETL_ADMIN");
        sourcetypeConfig.setInsertedTimeTs(new Date());
        try {
            persistIfNotAlready(sourcetypeConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sourcetypeConfig;

    }

}
