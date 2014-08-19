package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;


public class ExcelSupplSysControlAsset extends ExcelSheet{
    
    private String supplierAsset;
    private String controlAsset;
    private String siteId;
    private String customer;
    public ExcelSupplSysControlAsset() {
        super();
    }
    public ExcelSupplSysControlAsset(String supplierAsset, String controlAsset, String siteId, String customer) {
        super();
        this.supplierAsset = supplierAsset;
        this.controlAsset = controlAsset;
        this.siteId = siteId;
        this.customer = customer;
    }
    
    public String getSupplierAsset() {
        return supplierAsset;
    }
    
    public void setSupplierAsset(String supplierAsset) {
        this.supplierAsset = supplierAsset;
    }
    
    public String getControlAsset() {
        return controlAsset;
    }
    
    public void setControlAsset(String controlAsset) {
        this.controlAsset = controlAsset;
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
            SupplSysControlAssetHeaders supplSysControlAssetHeaders = SupplSysControlAssetHeaders.getSupplSysControlAssetHeaders(headerVal, odsMasterProps);
            if(supplSysControlAssetHeaders != null){
                switch(supplSysControlAssetHeaders){
                    case SUPPLIERASSET:
                        if (valObj != null && valObj instanceof String) {
                            String supplierAsset = (String) valObj;
                            this.setSheetRowId(supplierAsset);
                            this.setSupplierAsset(supplierAsset);
                        }
                        break;
                    case CONTROLASSET:
                        if (valObj != null && valObj instanceof String) {
                            String controlAsset = (String) valObj;
                            this.setControlAsset(controlAsset);
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
    public String toString() {
        return "ExcelSupplSysControlAsset [supplierAsset=" + supplierAsset + ", controlAsset=" + controlAsset
                + ", siteId=" + siteId + ", customer=" + customer + ", getSheetId()=" + getSheetRowId() + "]";
    }
    

}
