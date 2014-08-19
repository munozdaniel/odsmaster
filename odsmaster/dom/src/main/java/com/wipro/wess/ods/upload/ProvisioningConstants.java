package com.wipro.wess.ods.upload;

/*********************************************************************************************************
*  Copyright (C) 2011 Wipro Ltd. All rights reserved
*  This file and its content must not be copied or distributed, in part or entirety, in any form without prior written consent from:
*  Wipro Ltd., Hyderabad Andhra, India
*  @Version 1.0
*  @Date 05/08/2011
*  @Description ProvisioningConstants is used to declare Constants across the application.
********************************************************************************************************
*/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vreddysi
 */
public interface ProvisioningConstants {
   
    

    //forwards
    String SUCCESS="success";
    String FAILURE="failure";

    //general
    String DOMAIN_OBJ_SEPERATOR = "~";
    int ZERO=0;
    int ONE = 1;
    int TWO=2;
    int THREE=3;
    int FOUR = 4;
    String C_="C_";
    String L_="L_";
    String X="x";
    String ASSETS="asset";
    String ERROR="error";
    String STATUS="STATUS";
    String ERRORMSG_WRONGFILE="The File Uploaded is not Supported by this application,Please Upload Ms Excel 97-2003 Format only";
    String MSEXCEL972003="Microsoft Office Excel 97-2003 Worksheet";
    String MSEXCEL2007="Microsoft Office Excel Worksheet";
    String CSV=".csv";
    String DAT=".dat";
    String H_NAME="h_name";
    String HEADER_NAME="Header_Name";
    String CSV_ERROR="Can`t create CSV Flat file templates in folder: ";
    String FILE_NAME="File name: ";
    String NOT_FOUND="Not Found";
    String ERRORMSG_FILE_NOT_FOUND="File Not Found";
    String ERRORMSG_EXCEPTION="Exception : ";
    String SHEET_NAME="Sheet_Name";
    String S_NAME="s_name";
    String CLASS_STRUCTURE="Class_Structure";
    String ID="id";
    String TYPE="type";
    String EN_SMALL="en";
    String EN="EN";
    String LCEASSET="LCEASSET";
    String MSAASSET="MSAASSET";
    String SCAASSET="SCAASSET";
    String SUPPLIERASSET="SUPPLIERASSET";
    String ID_CAP="ID";
    String LCE="LCE";
    String MSA="MSA";
    String SCA="SCA";
    String Monitoring_Asset="Monitoring Asset";
    String Service_Asset="Service Asset";
    String SUBTYPE="SUBTYPE";
    String STAT="stat";
    String LOGOUT="logout";
    String LOGOUT_SUCCESS="Successfully Logged Out";
    String SUCCESS_LOGOUT="SuccessLogout";
    String USERNAME="username";
    String THE_USERNAME="The UserName: ";
    String PWD_INCORRECT=" or Password may be incorrect";
    String ADMIN_CONFIG="Admin_config";
    String PASSWORD="password";
    String ASSET_DESCRIPTION="Asset_Description";
    String UNKNOWN="Unknown";
    String CONFIG_FILE_NOT_FOUND="Configfile  (file name) doesn't found!";
    String LOC="loc";
    String A_KEY="a_key";
    String C_KEY="c_key";
    String L_KEY="l_key";
    String U_KEY="u_key";
    String VALUE="value";
    String VALUES="values";
    String CUSTOMER_LOOKUP="Cust_Lookup";
    String LOCATION_LOOKUP="Loc_Lookup";
    String LOCATION="LOCATION";
    String PLUSPCUSTOMER="PLUSPCUSTOMER";
    String ASSETLIST="assetlist";
    String ASSETDESC="assetDesc";
    String ASSETKEYS="assetkeys";
    String ASSET_ID_START_WITH="Asset Id Should Start With Customer Identifier C_-- follewd by location id L_--(Upper Case), For more Info Kindly click Help";
    String UFILE="uFile";
    String ERROR_SUBMIT="submitError";
    String SUCCESS_SUBMIT="submitSuccess";
    String ERROR_SAVE_SAVEERROR="error.save.saveError";
    String ERROR_SAVE_SUCCESS="error.save.success";
    String DETAILS="details";
    String GEMS_LOOKUP="GEMS_Lookup";

    //Asset

    String ASSETATTRID="ASSETATTRID";
    String ALNVALUE="ALNVALUE";
    String NUMVALUE="NUMVALUE";
    String ERRORMSG_DATA_CONVERSION_ATTRIBUTES="Exception  converting into two dimens array for attributes in classification: ";
    String ERRORMSG_DATA_CONVERSION="Exception in Classification data, converting into two dimens array: ";
    String ERRORMSG_WRITE_CSV="Exception occured while writing the CSV File for Classication: ";
    String ERRORMSG_CSV_NOT_FOUND="Exception occured while writing the CSV File ,because file not found for Classication: ";
    String ERRORMSG_WRITE_CSV_SUPP="Exception while writing the Supp classification CSV Files: ";
    String ERRORMSG_CSV_NOT_FOUND_SUPP="Exception while writing the Supp classification CSV Files: ";
    String ERRORMSG_ASSET="Exception in Asset Template: ";

    //Association

    String SUPPLIERSYSTEM_INPUTSERVICE="SUPPLIERSYSTEM_INPUTSERVICE";
    String SUPPLIERSYSTEM_OUTPUTSERVICE="SUPPLIERSYSTEM_OUTPUTSERVICE";
    String LCETOSERVICES="LCETOSERVICES";
    String MSATOSERVICES="MSATOSERVICES";
    String SCATOSERVICES="SCATOSERVICES";
    String MSATOSCA="MSATOSCA";
    String SCATOLCE="SCATOLCE";
    String SCATOMONITORING="SCATOMONITORING";
    String SUPPLIERSYSTEM_CONTROLASSET="SUPPLIERSYSTEM_CONTROLASSET";
    String ERRORMSG_ASSOCIATION="Exception in Association Template: ";
        
    // ID names changed as per Shalini
    String SUPPLIERSYSTEM_INPUTSERVICEID = "ASSET_INPUTSERVICEID";
    String SUPPLIERSYSTEM_OUTPUTSERVICEID = "ASSET_OUTPUTSERVICEID";
    String SUPPLIERSYSTEM_CONTROLASSETID = "SUPPLIERASSETTOCONTROLASSETID";
    
    
    // Classification

    String COLUMN_NAME="col_name";
    String ATTRIBUTE="Attribute";
    String ASSETNUM="ASSETNUM";
    String CLASSSTRUCTUREID="CLASSSTRUCTUREID";
    String CLASSSTRUCTUREIDALIAS="CLASSSTRUCTUREIDALIAS";
    String SITEID="SITEID";
    String LINEARASSETSPECID="LINEARASSETSPECID";
    String SECTION="SECTION";
    String MEASUREUNITID = "MEASUREUNITID";
    String MEASUREUNITID_2 = "MEASUREUNITID2";
    String ASSET_SUBTYPE="Asset_SubType";
    String KEY="key";
    String KEYS="keys";
    String D_T="D_T";
    String ERRORMSG_CLASSIFICATION="Exception in general Classfication Template: ";
    String ERRORMSG_SHEET="Error has occured while accessing sheet: ";
    String ERRORMSG_COLUMN=", under this sheet column for error is: ";
    String ERRORMSG_UNKNOWN_COLUMN="Error:: UNKNOWN Colunm name from XML Config..";
    String SPECIFIED_RATING_1 = "SPECIFIED RATING 1";
    String SPECIFIED_RATING_2 = "SPECIFIED RATING 2";
    String SITEDETAILS = "Site Details";
    String ECONOMIZER = "ECONOMIZER";
    //XML File Names

    String ASSET_TYPES_LOOKUP="Asset_Types_Lookup.xml";
    String ASSET_ASSOCIATION_TEMPLATE_LOOKUP="Asset_Association_Template_Lookup.xml";
    String Classification_Class_ID_Lookup="Classification_Class_ID_Lookup.xml";
    String Classfication_Template_Lookup="Classfication_Template_Lookup.xml";
    String Classfication_SupplierAsset_System_Template_Lookup="Classfication_SupplierAsset_System_Template_Lookup.xml";
    
    String CONSUMPTION_PROFILE_SHEET = "ConsumptionProfileSheet";
    String MANDATORY_ERROR_MESSAGE = " IS MANDATORY ";
    String PERMISSION_DENIED_ERROR_MESSAGE = " Permission denied, user is not authorized to upload this site. ";
    String RECORD_NOT_FOUND_ERROR_MESSAGE = " Record not found ";
    String CONSUMPTION_PROFILE_SHEET_HEADER_ROW = "ConsumptionProfileSheetHeaderRow";
    String CONSUMPTION_PROFILE_SHEET_DATA_ROW = "ConsumptionProfileSheetDataRow";
    String MODENAME = "MODENAME";
    String CONTROL_ASSET_SHEET = "ControlAssetSheet";
    String CONTROL_ASSET_SHEET_HEADER_ROW = "ControlAssetSheetHeaderRow";
    String CONTROL_ASSET_SHEET_DATA_ROW = "ControlAssetSheetDataRow";
    String DOT_CHAR = ".";
    String UPLOADED_BY = "UploadedBy";
    String SOURCEENERGY_IDENT_SHEET = "SourceEnergyIdentSheet";
    String GENTECHTYPE = "GENTECHTYPE";
    String SETYPECODE = "SETYPECODE";
    String CATEGORYCODE = "CATEGORYCODE";
    String MAPPING = "MAPPING";
    String SOURCEENERGY_IDENT_SHEET_HEADER_ROW = "SourceEnergyIdentSheetHeaderRow";
    String SOURCEENERGY_IDENT_SHEET_DATA_ROW = "SourceEnergyIdentSheetDataRow";
    String UTILITY_SUPPLIER_SHEET = "UtilitySupplierSheet";
    String UTILITY_SUPPLIER_SHEET_HEADER_ROW = "UtilitySupplierSheetHeaderRow";
    String UTILITY_SUPPLIER_SHEET_DATA_ROW = "UtilitySupplierSheetDataRow";    
    String UTILITY_METER_SHEET = "UtilityMeterSheet";
    String SUPPLIERCODE = "SUPPLIERCODE";
    String UTILITY_METER_SHEET_HEADER_ROW = "";
    String UTILITY_METER_SHEET_DATA_ROW = "";
    String METER_REF_SHEET = "MeterReferencesSheet";
    String METER_REF_SHEET_HEADER_ROW = "MeterReferencesSheetHeaderRow";
    String METER_REF_SHEET_DATA_ROW = "MeterReferencesSheetDataRow";    
    String MSA_SHEET = "MSASheet";
    String MSA_SHEET_HEADER_ROW = "MSASheetHeaderRow";
    String MSA_SHEET_DATA_ROW = "MSASheetDataRow";
    String OPERATING = "OPERATING";
    String AFTER_HRS_CONFIG_MODE_NAME = "After Hours";
    String PARTIAL_HRS_CONFIG_MODE_NAME = "Partial Hours";
    String DEMAND_LIMIT_HRS_CONFIG_MODE_NAME = "Demand Limit Hours";
    String SCA_SHEET = "SCASheet";
    String SCA_SHEET_HEADER_ROW = "SCASheetHeaderRow";
    String SCA_SHEET_DATA_ROW = "SCASheetDataRow";
    String DESCRIPTION = "DESCRIPTION";
    String CO2LIMIT = "CO2LIMIT";
    String ILLUMINATION_LOW_LIMIT_LUX = "ILLUMINATION LOW LIMIT LUX";
    String ILLUMINATION_HIGH_LIMIT_LUX = "ILLUMINATION HIGH LIMIT LUX";
    String SERVICE_ASSET_SHEET = "ServiceAssetSheet";
    String SERVICE_ASSET_SHEET_HEADER_ROW = "ServiceAssetSheetHeaderRow";
    String SERVICE_ASSET_SHEET_DATA_ROW = "ServiceAssetSheetDataRow";
    String SUPPL_SYS_SHEET = "SupplierSystemSheet";
    String SUPPL_SYS_SHEET_HEADER_ROW = "SupplierSystemSheetHeaderRow";
    String SUPPL_SYS_SHEET_DATA_ROW = "SupplierSystemSheetDataRow";
    String ACTIVE_COMPNENTS = "Active Components";
    String REDUNDANT_COMPNENTS = "Redundant Components";
    String SYS_AVAIL_THRESHOLD = "System Availability% Threshold";
    String LOSS_THRESHOLD = "Loss % Thresold";
    String OVER_UTIL_THRESHOLD = "Over-Utilization Threshold %";
    String UNDER_UTIL_THRESHOLD = "Under Utilization Threshold %";
    String PLI_THRESHOLD = "Phase Load Imbalance Threshold %";    
    String SUPPL_ASSET_SHEET = "SupplierAssetsSheet";
    String SUPPL_ASSET_SHEET_HEADER_ROW = "SupplierAssetsSheetHeaderRow";
    String SUPPL_ASSET_SHEET_DATA_ROW = "SupplierAssetsSheetDataRow";
    String PARENT = "PARENT";
    String RATED_CONSUMPTION = "RATED CONSUMPTION";    
    String SPECIFIED_RATING_3 = "SPECIFIED RATING 3";
    String SPECIFIED_RATING_4 = "SPECIFIED RATING 4";
    String SUB_ASSET_SHEET = "SubAssetsSheet";
    String SUB_ASSET_SHEET_HEADER_ROW = "SubAssetsSheetHeaderRow";
    String SUB_ASSET_SHEET_DATA_ROW = "SubAssetsSheetDataRow";
    String METER_ASSET_SHEET = "MeterAssetSheet";
    String METER_ASSET_SHEET_HEADER_ROW = "MeterAssetSheetHeaderRow";
    String METER_ASSET_SHEET_DATA_ROW = "MeterAssetSheetDataRow";
    String FUNC_TYPE_OM = "OM";
    String MONITOR_ASSET_SHEET = "MonitorAssetSheet";
    String MONITOR_ASSET_SHEET_HEADER_ROW = "MonitorAssetSheetHeaderRow";
    String MONITOR_ASSET_SHEET_DATA_ROW = "MonitorAssetSheetDataRow";
    String MSA_CONS_FR_SHEET = "MSAConsumptionFormulaSheet";
    String MSA_CONS_FR_SHEET_HEADER_ROW = "MSAConsumptionFormulaSheetHeaderRow";
    String MSA_CONS_FR_SHEET_DATA_ROW = "MSAConsumptionFormulaSheetDataRow";
    String METERFORMULA = "METERFORMULA";
    String MSA_SERVICE_TYPE_SHEET = "MSAServiceTypeFormulaSheet";
    String MSA_SERVICE_TYPE_SHEET_HEADER_ROW = "MSAServiceTypeFormulaSheetHeaderRow";
    String MSA_SERVICE_TYPE_SHEET_DATA_ROW = "MSAServiceTypeFormulaSheetDataRow";
    String SERVICETYPE = "SERVICETYPE";
    String BUSINESSLOAD = "BUSINESSLOAD";
    String MSA_SERVICE_SUBTYPE_SHEET = "MSAServiceSubTypeFormulaSheet";
    String MSA_SERVICE_SUBTYPE_SHEET_HEADER_ROW = "MSAServiceSubTypeFormulaSheetHeaderRow";
    String MSA_SERVICE_SUBTYPE_SHEET_DATA_ROW = "MSAServiceSubTypeFormulaSheetDataRow";
    String SERVICESUBTYPE = "SERVICESUBTYPE";
    String MSA_TO_SCA_SHEET = "MsaToScaSheet";
    String MSA_TO_SCA_SHEET_HEADER_ROW = "MsaToScaSheetHeaderRow";
    String MSA_TO_SCA_SHEET_DATA_ROW = "MsaToScaSheetDataRow"; 
    String MSA_TO_SERVICE_SHEET = "MsaToServicesSheet";
    String MSA_TO_SERVICE_SHEET_HEADER_ROW = "MsaToServicesSheetHeaderRow";
    String MSA_TO_SERVICE_SHEET_DATA_ROW = "MsaToServicesSheetDataRow"; 
    String SERVICEASSET = "SERVICEASSET";
    String SCA_TO_MONITORING_SHEET = "ScaToMonitoringSheet";
    String SCA_TO_MONITORING_SHEET_HEADER_ROW = "ScaToMonitoringSheetHeaderRow";
    String SCA_TO_MONITORING_SHEET_DATA_ROW = "ScaToMonitoringSheetDataRow"; 
    String MONITORINGASSET = "MONITORINGASSET";
    String SCA_TO_SERVICES_SHEET = "ScaToServicesSheet";
    String SCA_TO_SERVICES_SHEET_HEADER_ROW = "ScaToServicesSheetHeaderRow";
    String SCA_TO_SERVICES_SHEET_DATA_ROW = "ScaToServicesSheetDataRow";
    String SUPPL_SYS_INPUT_SERVICES_SHEET = "SupplSysInputServiceSheet";
    String SUPPL_SYS_INPUT_SERVICES_SHEET_HEADER_ROW = "SupplSysInputServiceSheetHeaderRow";
    String SUPPL_SYS_INPUT_SERVICES_SHEET_DATA_ROW = "SupplSysInputServiceSheetDataRow";    
    String INPUTSERVICE = "INPUTSERVICE";
    String SUPPL_SYS_OUTPUT_SERVICES_SHEET = "SupplSysOutputServiceSheet";
    String SUPPL_SYS_OUTPUT_SERVICES_SHEET_HEADER_ROW = "SupplSysOutputServiceSheetHeaderRow";
    String SUPPL_SYS_OUTPUT_SERVICES_SHEET_DATA_ROW = "SupplSysOutputServiceSheetDataRow";
    String OUTPUTSERVICE = "OUTPUTSERVICE";
    String PEOPLE_COUNT = "PEOPLE_COUNT";
    String CUSTOMER = "CUSTOMER";
    String COMPANY = "COMPANY";


}
