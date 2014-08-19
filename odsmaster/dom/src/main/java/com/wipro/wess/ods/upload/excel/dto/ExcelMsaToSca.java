package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.msa.OmMsaConfig;
import com.wipro.wess.ods.msa.OmMsaScaMap;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.sca.OmScaConfig;
import com.wipro.wess.ods.upload.ProvisioningConstants;


public class ExcelMsaToSca extends ExcelSheet {

    private String msaSet;
    private String scaSet;
    private String siteId;
    private String customer;
    public ExcelMsaToSca() {
        super();
    }
    public ExcelMsaToSca(String msaSet, String scaSet, String siteId, String customer) {
        super();
        this.msaSet = msaSet;
        this.scaSet = scaSet;
        this.siteId = siteId;
        this.customer = customer;
    }
    
    public String getMsaSet() {
        return msaSet;
    }
    
    public void setMsaSet(String msaSet) {
        this.msaSet = msaSet;
    }
    
    public String getScaSet() {
        return scaSet;
    }
    
    public void setScaSet(String scaSet) {
        this.scaSet = scaSet;
    }
    
    public String getSiteId() {
        return siteId;
    }
    
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException{
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            MsaToScaHeaders msaToScaHeaders = MsaToScaHeaders.getMsaToScaHeaders(headerVal, odsMasterProps);
            if(msaToScaHeaders != null){
                switch(msaToScaHeaders){
                    case MSAASSET:
                        if (valObj != null && valObj instanceof String) {
                            String msaSet = (String) valObj;
                            this.setSheetRowId(msaSet);
                            this.setMsaSet(msaSet);
                        }
                        break;
                    case SCAASSET:
                        if (valObj != null && valObj instanceof String) {
                            String scaSet = (String) valObj;
                            this.setScaSet(scaSet);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
                        }
                        break;
                    case CUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String customer = (String) valObj;
                            this.setCustomer(customer);
                        }
                        break;
                }
            }
        }
    }
    
    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
       this.validate(odsMasterProps);
       MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, siteId, ProvisioningConstants.MSA_TO_SCA_SHEET);
       OmMsaConfig msaConfig = this.validateMsaExistence(odsMasterProps, isisJdocontainer, this.getMsaSet(), ProvisioningConstants.MSA_TO_SCA_SHEET, ProvisioningConstants.MSAASSET);
       OmScaConfig scaConfig = this.validateScaExistence(odsMasterProps, isisJdocontainer, this.getScaSet(), ProvisioningConstants.MSA_TO_SCA_SHEET);
       OmMsaScaMap msaScaMap = isisJdocontainer.firstMatch(new QueryDefault<OmMsaScaMap>(OmMsaScaMap.class,
               "fetch_OmMsaScaMap_by_msa_sca_map", "omScaConfig", scaConfig, "omMsaConfig", msaConfig));
       if(msaScaMap == null){
           msaScaMap = isisJdocontainer.newTransientInstance(OmMsaScaMap.class);
           msaScaMap.setOmMsaConfig(msaConfig);
           msaScaMap.setOmScaConfig(scaConfig);
           msaScaMap.setOrgId(orgId);
           msaScaMap.setChangeBy(isisJdocontainer.getUser().getName());
           msaScaMap.setChangeDt(new Date());
       }
       isisJdocontainer.persistIfNotAlready(msaScaMap);
  
    }
    
     
    private void validate(Properties odsMasterProps) throws ConstraintViolatedException{
        if (this.getMsaSet() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.MSAASSET);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.MSAASSET);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_MSA_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_MSA_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getScaSet() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_TO_SCA_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SCAASSET);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SCAASSET);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_SCAASSET_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_SCAASSET_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
    }
    @Override
    public String toString() {
        return "ExcelMsaToSca [msaSet=" + msaSet + ", scaSet=" + scaSet + ", siteId=" + siteId + ", customer="
                + customer + ", getSheetId()=" + getSheetRowId() + "]";
    }
    
}
