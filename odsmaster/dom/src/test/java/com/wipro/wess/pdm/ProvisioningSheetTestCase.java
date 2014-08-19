package com.wipro.wess.pdm;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.AbstractService;
import org.apache.isis.applib.DomainObjectContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.upload.ProvisionSheetUpload;
import com.wipro.wess.ods.upload.excel.dto.ExcelConsumptionProfile;
import com.wipro.wess.ods.upload.excel.dto.LocationHierarchyLookup;



public class ProvisioningSheetTestCase extends AbstractService{
    
    private static final String ID = "ProvisioningService";
    
    private static Properties ODSMASTER_PROPS = new Properties();

    private static InputStream propertiesFile = ProvisionSheetUpload.class.getClassLoader().getResourceAsStream(
            "odsmaster.properties");
    
    //@Rule
   // public JUnitRuleMockery2 context = JUnitRuleMockery2.createFor(Mode.INTERFACES_AND_CLASSES);

    
    //@Mock
    private DomainObjectContainer container;
    
    public void injectDomainObjectContainer(DomainObjectContainer container){
        this.container = container;
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ODSMASTER_PROPS.load(propertiesFile);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws Exception{
        try{
           
            
            /*final File excelFile = new File(ODSMASTER_PROPS.getProperty("testUploadPath"));
            FileInputStream stream = new FileInputStream(excelFile);
            //BufferedInputStream is = new BufferedInputStream(stream);
            
            byte[] buffer = new  byte[(int)excelFile.length()];
            stream.read(buffer);*/
         
            final ExcelConsumptionProfile consumptionProfile = new ExcelConsumptionProfile();
            consumptionProfile.setModeName("Normal Hours");
            consumptionProfile.setDescription("Store operation Hours");
            consumptionProfile.setCustomer("BBY");
            consumptionProfile.setSiteId("BBY");
            
            //final Blob provSheet = new Blob("BBY Provisioning Template V1 12.3.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer);
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap = new HashMap<LocationHierarchyLookup, LocationHierarchyLookup>();
            final MOrganisation organisation = new MOrganisation();
        /*   context.checking(new Expectations() {
                {
                    oneOf(mockContainer).firstMatch(new QueryDefault<MOrganisation>(
                            MOrganisation.class, "fetch_orgnaisation_by_id", "orgId", consumptionProfile.getSiteId()));        
                    will(returnValue(organisation));
                    
                    oneOf(mockContainer)
                    .firstMatch(new QueryDefault<OmModeOfOperationConfig>(OmModeOfOperationConfig.class,
                            "fetch_OmModeOfOperationConfig_by_pk", "modeName", consumptionProfile.getModeName(), "organisation",
                            organisation));
                   // oneOf(provisionSheetUpload).upload(excelFile.getAbsolutePath());
                    
                }
            });*/
           
            //assertThat(null, is(nullValue()));
            //assertFalse(odsProvisioning.isUploaded());
            
            consumptionProfile.process(locationMap, ODSMASTER_PROPS, container);
            
            
            //assertThat(odsUpload, is(odsProvisioning));
        } catch(Exception e){
            e.printStackTrace();
        }
       
        
        //odsProvisioning.upload(provSheet)
       //fail("Not yet implemented");
    }

}
