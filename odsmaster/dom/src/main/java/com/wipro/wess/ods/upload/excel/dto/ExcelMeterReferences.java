package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.exceptions.constraints.NotFoundConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteSrefFormula;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelMeterReferences extends ExcelSheet {

    private String location;

    private String sourceTypeCode;

    private String umRefFormula;

    private String cmRefFormula;

    private String omRefFormula;

    private String masterRefFormula;

    private String siteId;

    private String orgId;

    public ExcelMeterReferences() {
        super();
    }

    public ExcelMeterReferences(String location, String sourceTypeCode, String umRefFormula, String cmRefFormula,
            String omRefFormula, String masterRefFormula, String siteId, String orgId) {
        super();
        this.location = location;
        this.sourceTypeCode = sourceTypeCode;
        this.umRefFormula = umRefFormula;
        this.cmRefFormula = cmRefFormula;
        this.omRefFormula = omRefFormula;
        this.masterRefFormula = masterRefFormula;
        this.siteId = siteId;
        this.orgId = orgId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getUmRefFormula() {
        return umRefFormula;
    }

    public void setUmRefFormula(String umRefFormula) {
        this.umRefFormula = umRefFormula;
    }

    public String getCmRefFormula() {
        return cmRefFormula;
    }

    public void setCmRefFormula(String cmRefFormula) {
        this.cmRefFormula = cmRefFormula;
    }

    public String getOmRefFormula() {
        return omRefFormula;
    }

    public void setOmRefFormula(String omRefFormula) {
        this.omRefFormula = omRefFormula;
    }

    public String getMasterRefFormula() {
        return masterRefFormula;
    }

    public void setMasterRefFormula(String masterRefFormula) {
        this.masterRefFormula = masterRefFormula;
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
            MeterReferencesHeaders meterReferencesHeaders = MeterReferencesHeaders.getMeterReferencesHeaders(headerVal,
                    odsMasterProps);
            if (meterReferencesHeaders != null) {
                switch (meterReferencesHeaders) {
                    case LOCATION:
                        if (valObj != null && valObj instanceof String) {
                            String location = (String) valObj;
                            this.setLocation(location);
                        }
                        break;
                    case SETYPECODE:
                        if (valObj != null && valObj instanceof String) {
                            String sourceTypeCode = (String) valObj;
                            this.setSheetRowId(sourceTypeCode + "");
                            this.setSourceTypeCode(sourceTypeCode);
                        }
                        break;
                    case CMREFFORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String cmRefFormula = (String) valObj;
                            this.setCmRefFormula(cmRefFormula);
                        }
                        break;
                    case UMREFFORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String umRefFormula = (String) valObj;
                            this.setUmRefFormula(umRefFormula);
                        }
                        break;
                    case OMREFFORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String omRefFormula = (String) valObj;
                            this.setOmRefFormula(omRefFormula);
                        }
                        break;
                    case MASTERREFFORM:
                        if (valObj != null && valObj instanceof String) {
                            String masterRefFormula = (String) valObj;
                            this.setMasterRefFormula(masterRefFormula);
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
        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.METER_REF_SHEET));

        MSourcetypeConfig sourceType = isisJdocontainer.firstMatch(new QueryDefault<MSourcetypeConfig>(
                MSourcetypeConfig.class, "fetch_MSourcetypeConfig_by_pk", "sourceTypeCode", this.getSourceTypeCode()));
        if (sourceType == null) {
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps
                    .getProperty(ProvisioningConstants.METER_REF_SHEET) + "." + ProvisioningConstants.SETYPECODE,
                    ProvisioningConstants.SETYPECODE + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE));
            throw exception;
        }
        MOrganisation organisation = site.getOrgId();

        OmSiteSrefFormula siteRefFormula = isisJdocontainer.firstMatch(new QueryDefault<OmSiteSrefFormula>(
                OmSiteSrefFormula.class, "fetch_OmSiteSrefFormula_by_uk", "org", organisation, "site", site,
                "sourceType", sourceType));
        String uploadedBy = isisJdocontainer.getUser().getName();
        Date uploadedOn = new Date();
        if (siteRefFormula == null) {
            siteRefFormula = isisJdocontainer.newTransientInstance(OmSiteSrefFormula.class);
            // siteRefFormula.setMOrganisation(organisation);
            siteRefFormula.setOmSite(site);
            siteRefFormula.setMSourcetypeConfig(sourceType);
            siteRefFormula.setInsertedBy(uploadedBy);
            siteRefFormula.setInsertedTimeTs(uploadedOn);
            siteRefFormula.setChangeTs(uploadedOn);
        }
        siteRefFormula.setMasterF(this.getMasterRefFormula());
        siteRefFormula.setReferenceCmF(this.getCmRefFormula());
        siteRefFormula.setReferenceOmF(this.getOmRefFormula());
        siteRefFormula.setReferenceUmF(this.getUmRefFormula());
        isisJdocontainer.persistIfNotAlready(siteRefFormula);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.METER_REF_SHEET));
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
        if (this.getLocation() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.METER_REF_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.LOCATION);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.LOCATION);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_LOCATION_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_LOCATION_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
    }

    @Override
    public String toString() {
        return "ExcelMeterReferences [location=" + location + ", sourceTypeCode=" + sourceTypeCode + ", umRefFormula="
                + umRefFormula + ", cmRefFormula=" + cmRefFormula + ", omRefFormula=" + omRefFormula
                + ", masterRefFormula=" + masterRefFormula + ", siteId=" + siteId + ", orgId=" + orgId
                + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
