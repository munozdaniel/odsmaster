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
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utilitymeter.OmUtilitySupplier;

public class ExcelUtilitySupplier extends ExcelSheet {

    private String supplierName;

    private String description;

    private String company;

    private Double status;

    private String customer;

    public ExcelUtilitySupplier() {
        super();
    }

    public ExcelUtilitySupplier(String supplierName, String description, String company, Double status, String customer) {
        super();
        this.supplierName = supplierName;
        this.description = description;
        this.company = company;
        this.status = status;
        this.customer = customer;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            UtilitySupplierHeaders supplierHeaders = UtilitySupplierHeaders.getUtilitySupplierHeaders(headerVal,
                    odsMasterProps);
            if (supplierHeaders != null) {
                switch (supplierHeaders) {
                    case SUPPLIERNAME:
                        if (valObj != null && valObj instanceof String) {
                            String supplierName = (String) valObj;
                            this.setSheetRowId(supplierName);
                            this.setSupplierName(supplierName);
                        }
                        break;
                    case DESCRIPTION:
                        if (valObj != null && valObj instanceof String) {
                            String description = (String) valObj;
                            this.setDescription(description);
                        }
                        break;
                    case COMPANY:
                        if (valObj != null && valObj instanceof String) {
                            String company = (String) valObj;
                            this.setCompany(company);
                        }
                        break;
                    case STATUS:
                        if (valObj != null && valObj instanceof Double) {
                            Double status = (Double) valObj;
                            this.setStatus(status);
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
        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, this.getCustomer(),
                ProvisioningConstants.UTILITY_SUPPLIER_SHEET);
        OmUtilitySupplier utilitySupplier = isisJdocontainer.firstMatch(new QueryDefault<OmUtilitySupplier>(
                OmUtilitySupplier.class, "fetch_OmUtilitySupplier_by_supplier_code", "supplierCode", this.getCompany(),
                "orgId", orgId));
        String uploadedBy = odsMasterProps.getProperty(ProvisioningConstants.UPLOADED_BY);
        Date uploadedOn = new Date();
        if (utilitySupplier == null) {
            utilitySupplier = isisJdocontainer.newTransientInstance(OmUtilitySupplier.class);
            utilitySupplier.setSupplierCode(this.getCompany());
            utilitySupplier.setMOrganisation(orgId);
            utilitySupplier.setCreateDate(uploadedOn);
            utilitySupplier.setCreatedBy(uploadedBy);
            utilitySupplier.setInsertedBy(uploadedBy);
            utilitySupplier.setInsertedTimeTs(uploadedOn);
        }
        utilitySupplier.setSupplierName(this.getSupplierName());
        String status = (this.getStatus() == 1) ? "1" : "0";
        utilitySupplier.setStatus(status);
        isisJdocontainer.persistIfNotAlready(utilitySupplier);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getCustomer() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.CUSTOMER);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.CUSTOMER);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_CUSTOMER_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_CUSTOMER_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getCompany() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.COMPANY);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.COMPANY);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_COMPANY_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_COMPANY_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getStatus() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.UTILITY_SUPPLIER_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.STATUS);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.STATUS);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_STATUS_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_STATUS_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }

    }

    @Override
    public String toString() {
        return "ExcelUtilitySupplier [supplierName=" + supplierName + ", description=" + description + ", company="
                + company + ", status=" + status + ", customer=" + customer + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
