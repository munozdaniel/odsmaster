package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;

public class ExcelUom extends ExcelSheet {

    private String defaultUnit;

    private String familyName;

    private String customer;

    public ExcelUom() {
        super();
    }

    public ExcelUom(String defaultUnit, String fmailyName, String customer) {
        super();
        this.defaultUnit = defaultUnit;
        this.familyName = fmailyName;
        this.customer = customer;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String fmailyName) {
        this.familyName = fmailyName;
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
            UOMHeaders uomHeader = UOMHeaders.getUomHeader(headerVal, odsMasterProps);
            if(uomHeader != null){
                switch(uomHeader){
                    case DEFAULTUNIT:
                        if(valObj != null && valObj instanceof String){
                            String defaultUnit = (String)valObj;
                            this.setSheetRowId(defaultUnit);
                            this.setDefaultUnit(defaultUnit);
                        }
                        break;
                    case CUSTOMER:
                        if(valObj != null && valObj instanceof String){
                            String customer = (String)valObj;
                            this.setCustomer(customer);
                        }
                        break;
                    case FAMILYNAME:
                        if(valObj != null && valObj instanceof String){
                            String familyName = (String)valObj;
                            this.setFamilyName(familyName);
                        }
                        break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ExcelUom [defaultUnit=" + defaultUnit + ", familyName=" + familyName + ", customer=" + customer
                + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
