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
import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.sourceenergyident.MSourcecatConfig;
import com.wipro.wess.ods.sourceenergyident.MSourcegenConfig;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelSourceEnergyIdent extends ExcelSheet {

    private String generationTypeCode;

    private String sourceTypeCode;

    private String categoryTypeCode;

    private String mapping;

    private String customer;

    private String siteId;

    public ExcelSourceEnergyIdent() {
        super();
    }

    public ExcelSourceEnergyIdent(String generationTypeCode, String sourceTypeCode, String categoryTypeCode,
            String mapping, String customer, String siteId) {
        super();
        this.generationTypeCode = generationTypeCode;
        this.sourceTypeCode = sourceTypeCode;
        this.categoryTypeCode = categoryTypeCode;
        this.mapping = mapping;
        this.customer = customer;
        this.siteId = siteId;
    }

    public String getGenerationTypeCode() {
        return generationTypeCode;
    }

    public void setGenerationTypeCode(String generationTypeCode) {
        this.generationTypeCode = generationTypeCode;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getCategoryTypeCode() {
        return categoryTypeCode;
    }

    public void setCategoryTypeCode(String categoryTypeCode) {
        this.categoryTypeCode = categoryTypeCode;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            SourceEnergyIdentHeaders identHeader = SourceEnergyIdentHeaders.getSourceEnergyIdentHeaders(headerVal,
                    odsMasterProps);
            if (identHeader != null) {
                switch (identHeader) {
                    case GENTECHTYPE:
                        if (valObj != null && valObj instanceof String) {
                            String generationTypeCode = (String) valObj;
                            this.setSheetRowId(generationTypeCode);
                            this.setGenerationTypeCode(generationTypeCode);
                        }
                        break;
                    case SETYPECODE:
                        if (valObj != null && valObj instanceof String) {
                            String sourceTypeCode = (String) valObj;
                            this.setSourceTypeCode(sourceTypeCode);
                        }
                        break;
                    case CATEGORYCODE:
                        if (valObj != null && valObj instanceof String) {
                            String categoryTypeCode = (String) valObj;
                            this.setCategoryTypeCode(categoryTypeCode);
                        }
                        break;
                    case CUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String customer = (String) valObj;
                            this.setCustomer(customer);
                        }
                        break;
                    case MAPPING:
                        if (valObj != null && valObj instanceof String) {
                            String mapping = (String) valObj;
                            this.setMapping(mapping);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
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
        String uploadedBy = odsMasterProps.getProperty(ProvisioningConstants.UPLOADED_BY);
        Date uploadedOn = new Date();
        MSourcegenConfig sourcegenConfig = isisJdocontainer.firstMatch(new QueryDefault<MSourcegenConfig>(
                MSourcegenConfig.class, "fetch_MSourcegenConfig_by_pk", "generationTypeCode", this
                        .getGenerationTypeCode()));
        if (sourcegenConfig == null) {
            sourcegenConfig = isisJdocontainer.newTransientInstance(MSourcegenConfig.class);
            sourcegenConfig.setGenerationTechnology(this.getGenerationTypeCode());
            sourcegenConfig.setInsertedBy(uploadedBy);
            sourcegenConfig.setInsertedTimeTs(uploadedOn);
        }
        isisJdocontainer.persistIfNotAlready(sourcegenConfig);

        MSourcecatConfig sourcecatConfig = isisJdocontainer
                .firstMatch(new QueryDefault<MSourcecatConfig>(MSourcecatConfig.class, "fetch_MSourcecatConfig_by_pk",
                        "categoryTypeCode", this.getCategoryTypeCode()));
        if (sourcecatConfig == null) {
            sourcecatConfig = isisJdocontainer.newTransientInstance(MSourcecatConfig.class);
            sourcecatConfig.setCategoryCode(this.getCategoryTypeCode());
            sourcecatConfig.setInsertedBy(uploadedBy);
            sourcecatConfig.setInsertedTimeTs(uploadedOn);
        }
        sourcecatConfig.setDisplayName(this.getMapping());
        isisJdocontainer.persistIfNotAlready(sourcecatConfig);

        MSourcetypeConfig sourcetypeConfig = isisJdocontainer.firstMatch(new QueryDefault<MSourcetypeConfig>(
                MSourcetypeConfig.class, "fetch_MSourcetypeConfig_by_pk", "sourceTypeCode", this.getSourceTypeCode()));
        if (sourcetypeConfig == null) {
            sourcetypeConfig = isisJdocontainer.newTransientInstance(MSourcetypeConfig.class);
            sourcetypeConfig.setTypeCode(this.getSourceTypeCode());
            sourcetypeConfig.setInsertedBy(uploadedBy);
            sourcetypeConfig.setInsertedTimeTs(uploadedOn);
        }
        sourcetypeConfig.setDisplayName(this.getMapping());
        isisJdocontainer.persistIfNotAlready(sourcetypeConfig);
    }

    @Override
    public String toString() {
        return "ExcelSourceEnergyIdent [generationTypeCode=" + generationTypeCode + ", sourceTypeCode="
                + sourceTypeCode + ", categoryTypeCode=" + categoryTypeCode + ", mapping=" + mapping + ", customer="
                + customer + ", siteId=" + siteId + ", getSheetId()=" + getSheetRowId() + "]";
    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {

        if (this.getSourceTypeCode() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SETYPECODE);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SETYPECODE);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            errorMessage.append(ProvisioningConstants.DOT_CHAR);
            errorMessage.append(ProvisioningConstants.GENTECHTYPE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_SETTYPECODE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_SETTYPECODE_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getCategoryTypeCode() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.CATEGORYCODE);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.CATEGORYCODE);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            errorMessage.append(ProvisioningConstants.DOT_CHAR);
            errorMessage.append(ProvisioningConstants.GENTECHTYPE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_CATEGORYTYPECODE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_CATEGORYTYPECODE_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getMapping() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SOURCEENERGY_IDENT_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.MAPPING);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.MAPPING);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            errorMessage.append(ProvisioningConstants.DOT_CHAR);
            errorMessage.append(ProvisioningConstants.GENTECHTYPE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_MAPPING_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_MAPPING_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }

    }

}
