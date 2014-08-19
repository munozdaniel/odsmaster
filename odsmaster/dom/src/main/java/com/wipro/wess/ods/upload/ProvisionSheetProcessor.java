package com.wipro.wess.ods.upload;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.isis.applib.DomainObjectContainer;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.log.Info;
import com.wipro.wess.ods.upload.excel.dto.ExcelSheet;
import com.wipro.wess.ods.upload.excel.dto.LocationHierarchyLookup;

public class ProvisionSheetProcessor {

    private static DomainObjectContainer isisContainer;

    private static boolean uploaded = false;

    public ProvisionSheetProcessor() {
        super();
    }
    


    public static boolean process(ProvisionSheetUpload provisionSheetUpload, 
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
            DomainObjectContainer container) throws ConstraintViolatedException, Exception {
        Info.PDMINFO.format("Conversion from Excel Objects to JDO Entities and persisting Begin");        
        uploaded = false;
        isisContainer = container;
        Properties odsMasterProps = ProvisionSheetUpload.ODSMASTER_PROPS;
        Map<String, Set<ExcelSheet>> sheetsMap = provisionSheetUpload.getExcelSheetMap();
        provisionSheetUpload = null;
        
        if (sheetsMap != null) {
            processConsumptionProfile(locationMap, sheetsMap, odsMasterProps);
            processControlAsset(locationMap, sheetsMap, odsMasterProps);
            processSourceEnergyIdent(locationMap, sheetsMap, odsMasterProps);
            processUtilitySupplier(locationMap, sheetsMap, odsMasterProps);
            processUtilityMeter(locationMap, sheetsMap, odsMasterProps);
            processMeterReferences(locationMap, sheetsMap, odsMasterProps);
            processMSA(locationMap, sheetsMap, odsMasterProps);
            processSCA(locationMap, sheetsMap, odsMasterProps);
            processServiceAsset(locationMap, sheetsMap, odsMasterProps);
            processSupplierSystem(locationMap, sheetsMap, odsMasterProps);
            processSupplierAssets(locationMap, sheetsMap, odsMasterProps);
            processSubAssets(locationMap, sheetsMap, odsMasterProps);
            processMeterAsset(locationMap, sheetsMap, odsMasterProps);
            processMonitorAsset(locationMap, sheetsMap, odsMasterProps);
            processMSAConsumptionFormula(locationMap, sheetsMap, odsMasterProps);
            processMSAServiceTypeFormula(locationMap, sheetsMap, odsMasterProps);
            processMSAServiceSubTypeFormula(locationMap, sheetsMap, odsMasterProps);
            processMsaToSca(locationMap, sheetsMap, odsMasterProps);
            processMsaToServices(locationMap, sheetsMap, odsMasterProps);
            
            processScaToServices(locationMap, sheetsMap, odsMasterProps);
            processSupplSysInputService(locationMap, sheetsMap, odsMasterProps);
            processSupplSysOutputService(locationMap, sheetsMap, odsMasterProps);
            processScaToMonitoring(locationMap, sheetsMap, odsMasterProps);
        }
        Info.PDMINFO.format("Conversion from Excel Objects to JDO Entities and persisting End");
        return uploaded;

       
    }


    private static void process(Set<ExcelSheet> sheets,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        if (sheets != null && sheets.size() > 0) {
            for (ExcelSheet sheet : sheets) {
                sheet.process(locationMap, ProvisionSheetUpload.ODSMASTER_PROPS, isisContainer);
            }
            uploaded = true;
        }

    }

    private static void processConsumptionProfile(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSourceEnergyIdent(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processUtilitySupplier(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }


    private static void processUtilityMeter(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.UTILITY_METER_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMeterReferences(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.METER_REF_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }


    private static void processMSA(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MSA_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSCA(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SCA_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processServiceAsset(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSupplierSystem(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SUPPL_SYS_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSupplierAssets(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SUPPL_ASSET_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSubAssets(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SUB_ASSET_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMeterAsset(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.METER_ASSET_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMonitorAsset(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MONITOR_ASSET_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processControlAsset(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.CONTROL_ASSET_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMSAConsumptionFormula(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMSAServiceTypeFormula(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMSAServiceSubTypeFormula(
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, 
            Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps) throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MSA_SERVICE_SUBTYPE_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMsaToSca(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processMsaToServices(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.MSA_TO_SERVICE_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processScaToMonitoring(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processScaToServices(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SCA_TO_SERVICES_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSupplSysInputService(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SUPPL_SYS_INPUT_SERVICES_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }

    private static void processSupplSysOutputService(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
             Map<String, Set<ExcelSheet>> sheetsMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        Set<ExcelSheet> sheets = sheetsMap.get(ProvisionSheetUpload.ODSMASTER_PROPS
                .getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET));
        process(sheets, locationMap, odsMasterProps);

    }


}
