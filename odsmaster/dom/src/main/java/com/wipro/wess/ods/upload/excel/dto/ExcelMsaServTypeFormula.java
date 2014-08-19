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
import com.wipro.wess.ods.msa.OmMsaConsStFr;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelMsaServTypeFormula extends ExcelSheet {

    private String assetNum;

    private String sourceTypeCode;

    private String serviceType;

    private String meterFormula;

    private String businessLoad;

    private String siteId;

    private String orgId;

    public ExcelMsaServTypeFormula() {
        super();
    }

    public ExcelMsaServTypeFormula(String assetNum, String sourceTypeCode, String serviceType, String meterFormula,
            String businessLoad, String siteId, String orgId) {
        super();
        this.assetNum = assetNum;
        this.sourceTypeCode = sourceTypeCode;
        this.serviceType = serviceType;
        this.meterFormula = meterFormula;
        this.businessLoad = businessLoad;
        this.siteId = siteId;
        this.orgId = orgId;
    }

    public String getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(String assetNum) {
        this.assetNum = assetNum;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMeterFormula() {
        return meterFormula;
    }

    public void setMeterFormula(String meterFormula) {
        this.meterFormula = meterFormula;
    }

    public String getBusinessLoad() {
        return businessLoad;
    }

    public void setBusinessLoad(String businessLoad) {
        this.businessLoad = businessLoad;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            MsaServTypeFormulaHeaders msaServTypeFormulaHeaders = MsaServTypeFormulaHeaders
                    .getMsaServTypeFormulaHeaders(headerVal, odsMasterProps);
            if (msaServTypeFormulaHeaders != null) {
                switch (msaServTypeFormulaHeaders) {
                    case ASSETNUM:
                        if (valObj != null && valObj instanceof String) {
                            String assetNum = (String) valObj;
                            this.setSheetRowId(assetNum);
                            this.setAssetNum(assetNum);
                        }
                        break;
                    case SOURCETYPE_CODE:
                        if (valObj != null && valObj instanceof String) {
                            String sourceTypeCode = (String) valObj;
                            this.setSourceTypeCode(sourceTypeCode);
                        }
                        break;
                    case SERVICETYPE:
                        if (valObj != null && valObj instanceof String) {
                            String serviceType = (String) valObj;
                            this.setServiceType(serviceType);
                        }
                        break;
                    case METER_FORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String meterFormula = (String) valObj;
                            this.setMeterFormula(meterFormula);
                        }
                        break;
                    case BUSINESSLOAD:
                        if (valObj != null && valObj instanceof String) {
                            String businessLoad = (String) valObj;
                            this.setBusinessLoad(businessLoad);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
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
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        OmMsaConfig msaUid = this.validateMsaExistence(odsMasterProps, isisJdocontainer, this.getAssetNum(),
                ProvisioningConstants.MSA_SERVICE_TYPE_SHEET, ProvisioningConstants.ASSETNUM);
        this.validateTypeCodeExistence(odsMasterProps, isisJdocontainer, this.getSourceTypeCode(),
                ProvisioningConstants.MSA_SERVICE_TYPE_SHEET);
        this.validateServiceTypeExistence(odsMasterProps, isisJdocontainer, this.getServiceType(),
                ProvisioningConstants.MSA_SERVICE_TYPE_SHEET);
        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, siteId,
                odsMasterProps.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
        OmMsaConsStFr msaConsStFr = isisJdocontainer.firstMatch(new QueryDefault<OmMsaConsStFr>(OmMsaConsStFr.class,
                "fetch_OmMsaConsStFr_by_pk", "orgId", orgId, "typeCode", this.getSourceTypeCode(), "msaUid", msaUid,
                "serviceType", this.getServiceType()));
        String uploadedBy = isisJdocontainer.getUser().getName();
        Date uploadedOn = new Date();
        if (msaConsStFr == null) {
            msaConsStFr = isisJdocontainer.newTransientInstance(OmMsaConsStFr.class);
            msaConsStFr.setOrgId(orgId);
            msaConsStFr.setMsaUid(msaUid);
            msaConsStFr.setTypeCode(this.getSourceTypeCode());
            msaConsStFr.setServiceType(this.getServiceType());
            msaConsStFr.setInsertedBy(uploadedBy);
            msaConsStFr.setInsertedTs(uploadedOn);
            msaConsStFr.setUpdatedBy(uploadedBy);
            msaConsStFr.setUpdatedTimeTs(uploadedOn);
        }
        msaConsStFr.setBusinessLoad(this.getBusinessLoad());
        msaConsStFr.setMeterFormula(this.getMeterFormula());
        isisJdocontainer.persistIfNotAlready(msaConsStFr);
    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SITEID);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SITEID);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_ORGID_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_ORGID_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getSourceTypeCode() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SETYPECODE);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SETYPECODE);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_SETTYPECODE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_SETTYPECODE_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getMeterFormula() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.METERFORMULA);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.METERFORMULA);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_METERFORMULA_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_METERFORMULA_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getServiceType() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SERVICETYPE);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SERVICETYPE);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_SERVICETYPE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_SERVICETYPE_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getBusinessLoad() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_SERVICE_TYPE_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.BUSINESSLOAD);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.BUSINESSLOAD);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_BUSINESSLOAD_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_BUSINESSLOAD_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }

    }

    @Override
    public String toString() {
        return "ExcelMsaServTypeFormula [assetNum=" + assetNum + ", sourceTypeCode=" + sourceTypeCode
                + ", serviceType=" + serviceType + ", meterFormula=" + meterFormula + ", businessLoad=" + businessLoad
                + ", siteId=" + siteId + ", orgId=" + orgId + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
