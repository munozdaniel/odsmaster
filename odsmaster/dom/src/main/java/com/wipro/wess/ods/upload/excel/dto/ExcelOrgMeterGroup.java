package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;


public class ExcelOrgMeterGroup extends ExcelSheet{
    
    private String sourceTypeCode;
    private String umDisplayName;
    private String cmDisplayName;
    private String omDisplayName;
    private String masterDisplayName;
    private String customer;
    private String orgId;
    
    public ExcelOrgMeterGroup(){}
    
    
    public ExcelOrgMeterGroup(String sourceTypeCode, String umDisplayName, String cmDisplayName, String omDisplayName,
            String masterDisplayName, String customer, String orgId) {
        super();
        this.sourceTypeCode = sourceTypeCode;
        this.umDisplayName = umDisplayName;
        this.cmDisplayName = cmDisplayName;
        this.omDisplayName = omDisplayName;
        this.masterDisplayName = masterDisplayName;
        this.customer = customer;
        this.orgId = orgId;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }
    
    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }
    
    public String getUmDisplayName() {
        return umDisplayName;
    }
    
    public void setUmDisplayName(String umDisplayName) {
        this.umDisplayName = umDisplayName;
    }
    
    public String getCmDisplayName() {
        return cmDisplayName;
    }
    
    public void setCmDisplayName(String cmDisplayName) {
        this.cmDisplayName = cmDisplayName;
    }
    
    public String getOmDisplayName() {
        return omDisplayName;
    }
    
    public void setOmDisplayName(String omDisplayName) {
        this.omDisplayName = omDisplayName;
    }
    
    public String getMasterDisplayName() {
        return masterDisplayName;
    }
    
    public void setMasterDisplayName(String masterDisplayName) {
        this.masterDisplayName = masterDisplayName;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public String getOrgId() {
        return orgId;
    }
    
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }


    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException{
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            ORGMeterGroupHeaders meterGroupHeaders = ORGMeterGroupHeaders.getOrgMeterGroup(headerVal, odsMasterProps);
            if(meterGroupHeaders != null){
                switch(meterGroupHeaders){
                    case SOURCETYPECODE:
                        if (valObj != null && valObj instanceof String) {
                            String sourceTypeCode = (String) valObj;
                            this.setSheetRowId(sourceTypeCode);
                            this.setSourceTypeCode(sourceTypeCode);
                        }
                        break;
                    case UMDISPLAYNAME:
                        if (valObj != null && valObj instanceof String) {
                            String umDisplayName = (String) valObj;
                            this.setUmDisplayName(umDisplayName);
                        }
                        break;
                    case CMDISPLAYNAME:
                        if (valObj != null && valObj instanceof String) {
                            String cmDisplayName = (String) valObj;
                            this.setCmDisplayName(cmDisplayName);
                        }
                        break;
                    case OMDISPLAYNAME:
                        if (valObj != null && valObj instanceof String) {
                            String omDisplayName = (String) valObj;
                            this.setOmDisplayName(omDisplayName);
                        }
                        break;
                    case MASTERDISNAME:
                        if (valObj != null && valObj instanceof String) {
                            String masterDisplayName = (String) valObj;
                            this.setMasterDisplayName(masterDisplayName);
                        }
                        break;
                    case CUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String customer = (String) valObj;
                            this.setCustomer(customer);
                        }
                        break;
                    case ORGID:
                        if (valObj != null && valObj instanceof String) {
                            String orgId = (String) valObj;
                            this.setOrgId(orgId);
                        }
                        break;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "ExcelOrgMeterGroup [sourceTypeCode=" + sourceTypeCode + ", umDisplayName=" + umDisplayName
                + ", cmDisplayName=" + cmDisplayName + ", omDisplayName=" + omDisplayName + ", masterDisplayName="
                + masterDisplayName + ", customer=" + customer + ", orgId=" + orgId + ", getSheetId()=" + getSheetRowId()
                + "]";
    }
    
    

}
