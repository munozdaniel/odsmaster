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
import com.wipro.wess.ods.msa.OmMsaConsFr;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelMsaConsFormula extends ExcelSheet {

    private String assetNum;

    private String sourceTypeCode;

    private String meterFormula;

    private String siteId;

    private String orgId;

    public ExcelMsaConsFormula() {
        super();
    }

    public ExcelMsaConsFormula(String assetNum, String sourceTypeCode, String meterFormula, String siteId, String orgId) {
        super();
        this.assetNum = assetNum;
        this.sourceTypeCode = sourceTypeCode;
        this.meterFormula = meterFormula;
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

    public String getMeterFormula() {
        return meterFormula;
    }

    public void setMeterFormula(String meterFormula) {
        this.meterFormula = meterFormula;
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
            MsaConsFormulaHeaders msaConsFormulaHeaders = MsaConsFormulaHeaders.getMsaConsFormulaHeaders(headerVal,
                    odsMasterProps);
            if (msaConsFormulaHeaders != null) {
                switch (msaConsFormulaHeaders) {
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
                    case METER_FORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String meterFormula = (String) valObj;
                            this.setMeterFormula(meterFormula);
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
                ProvisioningConstants.MSA_CONS_FR_SHEET, ProvisioningConstants.ASSETNUM);
        this.validateTypeCodeExistence(odsMasterProps, isisJdocontainer, this.getSourceTypeCode(),
                ProvisioningConstants.MSA_CONS_FR_SHEET);

        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, siteId,
                odsMasterProps.getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET));
        OmMsaConsFr msaConsFr = isisJdocontainer.firstMatch(new QueryDefault<OmMsaConsFr>(OmMsaConsFr.class,
                "fetch_OmMsaConsFr_by_pk", "orgId", orgId, "typeCode", this.getSourceTypeCode(), "msaUid", msaUid));
        String uploadedBy = isisJdocontainer.getUser().getName();
        Date uploadedOn = new Date();
        if (msaConsFr == null) {
            msaConsFr = isisJdocontainer.newTransientInstance(OmMsaConsFr.class);
            msaConsFr.setMsaUid(msaUid);
            msaConsFr.setOrgId(orgId);
            msaConsFr.setTypeCode(this.getSourceTypeCode());
            msaConsFr.setInsertedBy(uploadedBy);
            msaConsFr.setInsertedTs(uploadedOn);
            msaConsFr.setUpdatedBy(uploadedBy);
            msaConsFr.setUpdatedTimeTs(uploadedOn);
        }
        msaConsFr.setMeterFormula(this.getMeterFormula());
        isisJdocontainer.persistIfNotAlready(msaConsFr);
    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET));
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
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET));
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
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_CONS_FR_SHEET));
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

    }

    @Override
    public String toString() {
        return "ExcelMsaConsFormula [assetNum=" + assetNum + ", sourceTypeCode=" + sourceTypeCode + ", meterFormula="
                + meterFormula + ", siteId=" + siteId + ", orgId=" + orgId + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
