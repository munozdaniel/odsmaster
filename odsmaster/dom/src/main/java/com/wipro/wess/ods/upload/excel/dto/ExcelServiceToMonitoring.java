package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;

public class ExcelServiceToMonitoring extends ExcelSheet {

    private String serviceAsset;

    private String monitoringAsset;

    private String siteId;

    private String customer;

    public ExcelServiceToMonitoring() {
        super();
    }

    public ExcelServiceToMonitoring(String serviceAsset, String monitoringAsset, String siteId, String customer) {
        super();
        this.serviceAsset = serviceAsset;
        this.monitoringAsset = monitoringAsset;
        this.siteId = siteId;
        this.customer = customer;
    }

    public String getServiceAsset() {
        return serviceAsset;
    }

    public void setServiceAsset(String serviceAsset) {
        this.serviceAsset = serviceAsset;
    }

    public String getMonitoringAsset() {
        return monitoringAsset;
    }

    public void setMonitoringAsset(String monitoringAsset) {
        this.monitoringAsset = monitoringAsset;
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
            ServiceToMonitoringHeaders serviceToMonitoringHeaders = ServiceToMonitoringHeaders
                    .getServiceToMonitoringHeaders(headerVal, odsMasterProps);
            if (serviceToMonitoringHeaders != null) {
                switch (serviceToMonitoringHeaders) {
                    case SERVICEASSET:
                        if (valObj != null && valObj instanceof String) {
                            String serviceAsset = (String) valObj;
                            this.setSheetRowId(serviceAsset);
                            this.setServiceAsset(serviceAsset);
                        }
                        break;
                    case MONITORINGASSET:
                        if (valObj != null && valObj instanceof String) {
                            String monitoringAsset = (String) valObj;
                            this.setMonitoringAsset(monitoringAsset);
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
        return "ExcelServiceToMonitroing [serviceAsset=" + serviceAsset + ", monitoringAsset=" + monitoringAsset
                + ", siteId=" + siteId + ", customer=" + customer + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
