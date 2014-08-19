package com.wipro.wess.ods.upload;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.Constraint;
import com.wipro.wess.ods.exceptions.constraints.TechnicalConstraint;
import com.wipro.wess.ods.log.Debug;
import com.wipro.wess.ods.log.Info;
import com.wipro.wess.ods.upload.excel.dto.ExcelConsumptionProfile;
import com.wipro.wess.ods.upload.excel.dto.ExcelControlAsset;
import com.wipro.wess.ods.upload.excel.dto.ExcelMeterAsset;
import com.wipro.wess.ods.upload.excel.dto.ExcelMeterReferences;
import com.wipro.wess.ods.upload.excel.dto.ExcelMonitorAsset;
import com.wipro.wess.ods.upload.excel.dto.ExcelMsa;
import com.wipro.wess.ods.upload.excel.dto.ExcelMsaConsFormula;
import com.wipro.wess.ods.upload.excel.dto.ExcelMsaServSubTypeFormula;
import com.wipro.wess.ods.upload.excel.dto.ExcelMsaServTypeFormula;
import com.wipro.wess.ods.upload.excel.dto.ExcelMsaToSca;
import com.wipro.wess.ods.upload.excel.dto.ExcelMsaToServices;
import com.wipro.wess.ods.upload.excel.dto.ExcelOrgMeterGroup;
import com.wipro.wess.ods.upload.excel.dto.ExcelSca;
import com.wipro.wess.ods.upload.excel.dto.ExcelScaToMonitoring;
import com.wipro.wess.ods.upload.excel.dto.ExcelScaToServices;
import com.wipro.wess.ods.upload.excel.dto.ExcelServiceAsset;
import com.wipro.wess.ods.upload.excel.dto.ExcelServiceToMonitoring;
import com.wipro.wess.ods.upload.excel.dto.ExcelSheet;
import com.wipro.wess.ods.upload.excel.dto.ExcelSite;
import com.wipro.wess.ods.upload.excel.dto.ExcelSourceEnergyIdent;
import com.wipro.wess.ods.upload.excel.dto.ExcelSubAssets;
import com.wipro.wess.ods.upload.excel.dto.ExcelSupplSysControlAsset;
import com.wipro.wess.ods.upload.excel.dto.ExcelSupplSysInputService;
import com.wipro.wess.ods.upload.excel.dto.ExcelSupplSysOutputService;
import com.wipro.wess.ods.upload.excel.dto.ExcelSupplierAssets;
import com.wipro.wess.ods.upload.excel.dto.ExcelSupplierSystem;
import com.wipro.wess.ods.upload.excel.dto.ExcelUom;
import com.wipro.wess.ods.upload.excel.dto.ExcelUtilityMeter;
import com.wipro.wess.ods.upload.excel.dto.ExcelUtilitySupplier;
import com.wipro.wess.ods.utils.StringUtil;

public class ProvisionSheetUpload {

    // private static Logger log = LoggerFactory.getLogger(ProvisionSheetUpload.class);

    public static Properties ODSMASTER_PROPS = new Properties();

    private static InputStream propertiesFile = ProvisionSheetUpload.class.getClassLoader().getResourceAsStream(
            "odsmaster.properties");

    private Map<String, Set<ExcelSheet>> excelSheetMap = new HashMap<String, Set<ExcelSheet>>();

    private String siteId;

    private String location;

    // private Set<ExcelSheet> sheets = new HashSet<ExcelSheet>();

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Set<ExcelSheet>> getExcelSheetMap() {
        return excelSheetMap;
    }

    public void setExcelSheetMap(Map<String, Set<ExcelSheet>> excelSheetMap) {
        this.excelSheetMap = excelSheetMap;
    }

    public ProvisionSheetUpload() throws Exception {
        ODSMASTER_PROPS.load(propertiesFile);
    }

    public static void main(String[] args) throws ConstraintViolatedException {
        try {
            File excelFile = new File("E:\\Work\\WESS\\ODS_MASTER\\Inputs\\BBY Provisioning Template V1 12.3.xlsx");
            Workbook wb = WorkbookFactory.create(excelFile);
            ProvisionSheetUpload provSheetUpload = new ProvisionSheetUpload();
            provSheetUpload.readExcel(wb);
        } catch (ConstraintViolatedException e) {
            throw e;
        } catch (Exception e) {
            Constraint technicalConstraint = new TechnicalConstraint(e.getMessage());
            Set<Constraint> constraints = new HashSet<Constraint>();
            constraints.add(technicalConstraint);
            ConstraintViolatedException exception = new ConstraintViolatedException(e.getMessage(), e, constraints);
            throw exception;
        }

    }

    public void upload(String file) throws Exception {
        Info.PDMINFO.format("File reading begins");
        File excelFile = new File(file);
        Workbook wb = WorkbookFactory.create(excelFile);
        Debug.PDMDEBUG.format("Workbook created");
        this.readExcel(wb);
        Info.PDMINFO.format("Uploading ends");
    }


    public void readExcel(Workbook wb) throws Exception {

        String allSheetsToProcess = ODSMASTER_PROPS.getProperty("allSheetsToProcess");
        boolean allSheetsToProcessFlg = true;
        if (StringUtil.isNotEmpty(allSheetsToProcess)) {
            try {
                allSheetsToProcessFlg = Boolean.parseBoolean(allSheetsToProcess);
            } catch (Exception e) {
                allSheetsToProcessFlg = true;
            }

        }
        Debug.PDMDEBUG.format("allSheetsToProcessFlg", allSheetsToProcessFlg);
        if (allSheetsToProcessFlg) {
            this.processAllSheets(wb);
        } else {
            this.processSelectedSheets(wb);
        }

    }

    private Set<ExcelSheet> fetchSheetSet(String sheetKey) {
        Set<ExcelSheet> sheetSet = excelSheetMap.get(sheetKey);
        if (sheetSet == null) {
            excelSheetMap.put(sheetKey, new HashSet<ExcelSheet>());
        }
        return excelSheetMap.get(sheetKey);
    }

    private void processAllSheets(Workbook wb) throws Exception {

        Info.PDMINFO.format("All sheets to be processed.");
        Sheet sheet = wb.getSheetAt(0);
        Info.PDMINFO.format("Unmarshalling sheet by sheet begins");
        for (Row row : sheet) {
            Iterator<Cell> cellItr = row.cellIterator();
            while (cellItr.hasNext()) {
                Cell cell = cellItr.next();
                Hyperlink link = cell.getHyperlink();
                if (link != null) {
                    String cellRef = null;
                    cellRef = ODSMASTER_PROPS.getProperty("cellRef");
                    String sheetName = link.getLabel();
                    sheetName = sheetName.replace(cellRef, "");
                    Debug.PDMDEBUG.format("sheetName: ", sheetName);
                    Sheet sheetObj = wb.getSheet(sheetName);
                    if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET));
                        this.processSheet(
                                sheetObj,
                                ExcelConsumptionProfile.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty("SiteDetailSheet"))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS.getProperty("SiteDetailSheet"));
                        this.processSheet(sheetObj, ExcelSite.class,
                                ODSMASTER_PROPS.getProperty("SiteDetailSheetHeaderRow"),
                                ODSMASTER_PROPS.getProperty("SiteDetailSheetDataRow"), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty("ORGMeterGroupSheet"))) {
                        Set<ExcelSheet> sheetSet = this
                                .fetchSheetSet(ODSMASTER_PROPS.getProperty("ORGMeterGroupSheet"));
                        this.processSheet(sheetObj, ExcelOrgMeterGroup.class,
                                ODSMASTER_PROPS.getProperty("ORGMeterGroupSheetHeaderRow"),
                                ODSMASTER_PROPS.getProperty("ORGMeterGroupSheetDataRow"), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty("UOMSheet"))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS.getProperty("UOMSheet"));
                        this.processSheet(sheetObj, ExcelUom.class, ODSMASTER_PROPS.getProperty("UOMSheetHeaderRow"),
                                ODSMASTER_PROPS.getProperty("UOMSheetDataRow"), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET));
                        this.processSheet(sheetObj, ExcelSourceEnergyIdent.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET));
                        this.processSheet(sheetObj, ExcelUtilitySupplier.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.UTILITY_METER_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.UTILITY_METER_SHEET));
                        this.processSheet(sheetObj, ExcelUtilityMeter.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.UTILITY_METER_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.UTILITY_METER_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.METER_REF_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.METER_REF_SHEET));
                        this.processSheet(sheetObj, ExcelMeterReferences.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.METER_REF_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.METER_REF_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MSA_SHEET));
                        this.processSheet(sheetObj, ExcelMsa.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SCA_SHEET));
                        this.processSheet(sheetObj, ExcelSca.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET));
                        this.processSheet(sheetObj, ExcelServiceAsset.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SUPPL_SYS_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUPPL_SYS_SHEET));
                        this.processSheet(sheetObj, ExcelSupplierSystem.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SUPPL_SYS_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SUPPL_SYS_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SUPPL_ASSET_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUPPL_ASSET_SHEET));
                        this.processSheet(sheetObj, ExcelSupplierAssets.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SUPPL_ASSET_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SUPPL_ASSET_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SUB_ASSET_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUB_ASSET_SHEET));
                        this.processSheet(sheetObj, ExcelSubAssets.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SUB_ASSET_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SUB_ASSET_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.METER_ASSET_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.METER_ASSET_SHEET));
                        this.processSheet(sheetObj, ExcelMeterAsset.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.METER_ASSET_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.METER_ASSET_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.MONITOR_ASSET_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MONITOR_ASSET_SHEET));
                        this.processSheet(sheetObj, ExcelMonitorAsset.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MONITOR_ASSET_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MONITOR_ASSET_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.CONTROL_ASSET_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.CONTROL_ASSET_SHEET));
                        this.processSheet(sheetObj, ExcelControlAsset.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.CONTROL_ASSET_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.CONTROL_ASSET_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET));
                        this.processSheet(sheetObj, ExcelMsaConsFormula.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
                        this.processSheet(sheetObj, ExcelMsaServTypeFormula.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.MSA_SERVICE_SUBTYPE_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MSA_SERVICE_SUBTYPE_SHEET));
                        this.processSheet(
                                sheetObj,
                                ExcelMsaServSubTypeFormula.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SERVICE_SUBTYPE_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_SERVICE_SUBTYPE_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET));
                        this.processSheet(sheetObj, ExcelMsaToSca.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET_DATA_ROW), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.MSA_TO_SERVICE_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.MSA_TO_SERVICE_SHEET));
                        this.processSheet(sheetObj, ExcelMsaToServices.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_TO_SERVICE_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.MSA_TO_SERVICE_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET));
                        this.processSheet(sheetObj, ExcelScaToMonitoring.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SCA_TO_SERVICES_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SCA_TO_SERVICES_SHEET));
                        this.processSheet(sheetObj, ExcelScaToServices.class,
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_TO_SERVICES_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS.getProperty(ProvisioningConstants.SCA_TO_SERVICES_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SUPPL_SYS_INPUT_SERVICES_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUPPL_SYS_INPUT_SERVICES_SHEET));
                        this.processSheet(sheetObj, ExcelSupplSysInputService.class, ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUPPL_SYS_INPUT_SERVICES_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS
                                        .getProperty(ProvisioningConstants.SUPPL_SYS_INPUT_SERVICES_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS
                            .getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET));
                        this.processSheet(sheetObj, ExcelSupplSysOutputService.class, ODSMASTER_PROPS
                                .getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET_HEADER_ROW),
                                ODSMASTER_PROPS
                                        .getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET_DATA_ROW),
                                sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty("SupplSysControlAssetSheet"))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty("SupplSysControlAssetSheet"));
                        this.processSheet(sheetObj, ExcelSupplSysControlAsset.class,
                                ODSMASTER_PROPS.getProperty("SupplSysControlAssetSheetHeaderRow"),
                                ODSMASTER_PROPS.getProperty("SupplSysControlAssetSheetDataRow"), sheetSet);
                    } else if (sheetName.equalsIgnoreCase(ODSMASTER_PROPS.getProperty("ServiceToMonitoringSheet"))) {
                        Set<ExcelSheet> sheetSet = this.fetchSheetSet(ODSMASTER_PROPS
                                .getProperty("ServiceToMonitoringSheet"));
                        this.processSheet(sheetObj, ExcelServiceToMonitoring.class,
                                ODSMASTER_PROPS.getProperty("ServiceToMonitoringSheetHeaderRow"),
                                ODSMASTER_PROPS.getProperty("ServiceToMonitoringSheetDataRow"), sheetSet);
                    }

                }

            }

        }
        Info.PDMINFO.format("Unmarshalling sheet by sheet ends");

    }

    private void processSelectedSheets(Workbook wb) throws Exception {
        if (Info.isInfoEnabled()) {
            Info.PDMINFO.format("Selected sheets to be processed");
        }
        String sheetsToProcess = ODSMASTER_PROPS.getProperty("SheetsToProcess");
        String[] sheetsToProcessArr = sheetsToProcess.split(",");
        for (String sheetToProcess : sheetsToProcessArr) {
            String[] sheetInfo = sheetToProcess.split(":");
            Sheet sheetObj = wb.getSheet(sheetInfo[0]);
            int headerRow = Integer.parseInt(sheetInfo[2]);
            int dataRow = Integer.parseInt(sheetInfo[3]);
            String sheetClass = ODSMASTER_PROPS.getProperty("ExcelSheetPackage") + "." + sheetInfo[1];

            String sheetName = sheetInfo[0];
            Set<ExcelSheet> sheetSet = excelSheetMap.get(sheetName);
            if (sheetSet == null) {
                excelSheetMap.put(sheetName, new HashSet<ExcelSheet>());
            }
            sheetSet = excelSheetMap.get(sheetName);
            this.readSheetData(sheetClass, sheetObj, headerRow, dataRow, sheetSet);
        }

    }

    private void processSheet(Sheet sheetObj, Class<?> sheetClass, String sheetHeaderRow, String sheetDataRow,
            Set<ExcelSheet> sheets) throws Exception {
        int headerRow = 1;
        int dataRow = 3;
        try {
            headerRow = Integer.parseInt(sheetHeaderRow);
            Debug.PDMDEBUG.format(" Header row : ", headerRow);
        } catch (NumberFormatException e) {
            headerRow = 1;
            Debug.PDMDEBUG.format(" Header row default set to 1 ");
        }
        try {
            dataRow = Integer.parseInt(sheetDataRow);
            Debug.PDMDEBUG.format(" Data row : ", headerRow);
        } catch (NumberFormatException e) {
            dataRow = 3;
            Debug.PDMDEBUG.format(" Data row default set to 3 ");
        }
        this.readSheetData(sheetClass.getName(), sheetObj, headerRow, dataRow, sheets);
    }

    public void readSheetData(String sheetClassName, Sheet siteSheet, int headerRowNum, int rowNum,
            Set<ExcelSheet> sheets) throws Exception {

        Class<?> sheetClass = Class.forName(sheetClassName);
        Row headerRow = siteSheet.getRow(headerRowNum);
        Map<Integer, Cell> headerColumns = new HashMap<Integer, Cell>();
        Iterator<Cell> headerCellItr = headerRow.cellIterator();
        while (headerCellItr.hasNext()) {
            Cell cell = headerCellItr.next();
            String headerVal = cell.getStringCellValue();
            if (headerVal != null && !headerVal.trim().equals("")) {
                headerColumns.put(cell.getColumnIndex(), cell);
            }
        }
        Set<Integer> orderedHeader = new TreeSet<Integer>(headerColumns.keySet());
        // System.out.println("Headers = " + orderedHeader);
        int rowCount = siteSheet.getLastRowNum();
        for (int rowIndex = rowNum; rowIndex <= rowCount; rowIndex++) {
            Row row = siteSheet.getRow(rowIndex);
            if (row != null) {
                ExcelSheet excelSheetOBJ = null;
                for (Integer headerCellNum : orderedHeader) {
                    Cell currRowCell = row.getCell(headerCellNum);
                    if (currRowCell != null && !currRowCell.toString().equals("")) {
                        if (excelSheetOBJ == null) {
                            excelSheetOBJ = (ExcelSheet) sheetClass.newInstance();
                        }
                        excelSheetOBJ
                                .populateExcelSheetData(currRowCell, headerCellNum, headerColumns, ODSMASTER_PROPS);
                    }

                }
                if (excelSheetOBJ != null && StringUtil.isNotEmpty(excelSheetOBJ.getSheetRowId())) {
                    sheets.add(excelSheetOBJ);
                    /*
                     * if (StringUtil.isEmpty(this.getLocation()) && StringUtil.isNotEmpty(excelSheetOBJ.getLocation()))
                     * { this.setLocation(excelSheetOBJ.getLocation()); } if (StringUtil.isEmpty(this.getSiteId()) &&
                     * StringUtil.isNotEmpty(excelSheetOBJ.getSiteId())) { this.setSiteId(excelSheetOBJ.getSiteId()); }
                     */
                }

            }

        }

    }

}
