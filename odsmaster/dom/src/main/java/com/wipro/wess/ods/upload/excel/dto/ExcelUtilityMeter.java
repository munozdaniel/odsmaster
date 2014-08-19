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
import com.wipro.wess.ods.meter.OmMeterConfig;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utilitymeter.OmUtilitySupplier;
import com.wipro.wess.pdm.security.SecurityUtil;
import com.wipro.wess.pdm.security.StringUtil;

public class ExcelUtilityMeter extends ExcelSheet {

    private String assetNum;

    private String description;

    private String supplierCode;

    private String mapping;

    private String uom;

    private String type;

    private String subtype;

    private String functype;

    private String location;

    private String pluspCustomer;

    private String siteId;

    private String suppUtilityMeterId;

    public ExcelUtilityMeter() {
        super();
    }

    public ExcelUtilityMeter(String assetNum, String description, String supplierCode, String mapping, String uom,
            String type, String subtype, String functype, String location, String pluspCustomer, String siteId,
            String suppUtilityMeterId) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.supplierCode = supplierCode;
        this.mapping = mapping;
        this.uom = uom;
        this.type = type;
        this.subtype = subtype;
        this.functype = functype;
        this.location = location;
        this.pluspCustomer = pluspCustomer;
        this.siteId = siteId;
        this.suppUtilityMeterId = suppUtilityMeterId;
    }

    public String getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(String assetNum) {
        this.assetNum = assetNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getFunctype() {
        return functype;
    }

    public void setFunctype(String functype) {
        this.functype = functype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPluspCustomer() {
        return pluspCustomer;
    }

    public void setPluspCustomer(String pluspCustomer) {
        this.pluspCustomer = pluspCustomer;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSuppUtilityMeterId() {
        return suppUtilityMeterId;
    }

    public void setSuppUtilityMeterId(String suppUtilityMeterId) {
        this.suppUtilityMeterId = suppUtilityMeterId;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            UtilityMeterHeaders utilityMeterHeaders = UtilityMeterHeaders.getUtilityMeterHeaders(headerVal,
                    odsMasterProps);
            if (utilityMeterHeaders != null) {
                switch (utilityMeterHeaders) {
                    case ASSETNUM:
                        if (valObj != null && valObj instanceof String) {
                            String assetNum = (String) valObj;
                            this.setSheetRowId(assetNum);
                            this.setAssetNum(assetNum);
                        }
                        break;
                    case DESCRIPTION:
                        if (valObj != null && valObj instanceof String) {
                            String description = (String) valObj;
                            this.setDescription(description);
                        }
                        break;
                    case SUPPLIERCODE:
                        if (valObj != null && valObj instanceof String) {
                            String supplierCode = (String) valObj;
                            this.setSupplierCode(supplierCode);
                        }
                        break;
                    case MAPPING:
                        if (valObj != null && valObj instanceof String) {
                            String mapping = (String) valObj;
                            this.setMapping(mapping);
                        }
                        break;
                    case UOM:
                        if (valObj != null && valObj instanceof String) {
                            String uom = (String) valObj;
                            this.setUom(uom);
                        }
                        break;
                    case TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String type = (String) valObj;
                            this.setType(type);
                        }
                        break;
                    case SUBTYPE:
                        if (valObj != null && valObj instanceof String) {
                            String subtype = (String) valObj;
                            this.setSubtype(subtype);
                        }
                        break;
                    case FUNCTYPE:
                        if (valObj != null && valObj instanceof String) {
                            String functype = (String) valObj;
                            this.setFunctype(functype);
                        }
                        break;
                    case LOCATION:
                        if (valObj != null && valObj instanceof String) {
                            String location = (String) valObj;
                            this.setLocation(location);
                        }
                        break;
                    case PLUSPCUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String pluspCustomer = (String) valObj;
                            this.setPluspCustomer(pluspCustomer);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
                        }
                        break;
                    case SUPPLIER_UTILITY_METER_ID:
                        if (valObj != null && valObj instanceof String) {
                            String suppUtilityMeterId = (String) valObj;
                            this.setSuppUtilityMeterId(suppUtilityMeterId);
                        }
                        break;
                }
            }
        }
        if (StringUtil.isNotEmpty(this.getSheetRowId()) && StringUtil.isNotEmpty(this.getLocation())
                && StringUtil.isNotEmpty(this.getSiteId())) {
            boolean updateSitePermitted = SecurityUtil.checkSitePermission(this.getSiteId(), this.getLocation());
            if (!updateSitePermitted) {
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.UTILITY_METER_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }

        }

    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        MOrganisation organisation = this.lookupOrganisation(isisJdocontainer, locationMap, this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.UTILITY_METER_SHEET));
        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(), ProvisioningConstants.UTILITY_METER_SHEET);
        OmMeterConfig meterConfig = isisJdocontainer.firstMatch(new QueryDefault<OmMeterConfig>(OmMeterConfig.class,
                "fetch_OmMeterConfig_by_pk", "meterUid", this.getAssetNum()));
        if (meterConfig == null) {
            meterConfig = isisJdocontainer.newTransientInstance(OmMeterConfig.class);
            meterConfig.setMeterUid(this.getAssetNum());
            meterConfig.setInsertedBy(odsMasterProps.getProperty(ProvisioningConstants.UPLOADED_BY));
            meterConfig.setInsertedTimeTs(new Date());
        }
        meterConfig.setOmUtilitySupplier(isisJdocontainer.firstMatch(new QueryDefault<OmUtilitySupplier>(
                OmUtilitySupplier.class, "fetch_OmUtilitySupplier_by_supplier_code", "supplierCode", this
                        .getSupplierCode(), "orgId", organisation)));
        meterConfig.setUnitOfMeasurement(this.getUom());
        meterConfig.setSubtype(this.getSubtype());
        //meterConfig.setMOrganisation(organisation);
        meterConfig.setSite(site);
        meterConfig.setEnergyidenityCode(this.getMapping());
        meterConfig.setFunctionalType(this.getFunctype());
        meterConfig.setIdentificationCode(this.getSuppUtilityMeterId());       
        isisJdocontainer.persistIfNotAlready(meterConfig);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSupplierCode() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.UTILITY_METER_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SUPPLIERCODE);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SUPPLIERCODE);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_SUPPLIERCODE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_SUPPLIERCODE_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.UTILITY_METER_SHEET));
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
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.UTILITY_METER_SHEET));
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
        return "ExcelUtilityMeter [assetNum=" + assetNum + ", description=" + description + ", supplierCode="
                + supplierCode + ", mapping=" + mapping + ", uom=" + uom + ", type=" + type + ", subtype=" + subtype
                + ", functype=" + functype + ", location=" + location + ", pluspCustomer=" + pluspCustomer
                + ", siteId=" + siteId + ", suppUtilityMeterId=" + suppUtilityMeterId + ", getSheetId()="
                + getSheetRowId() + "]";
    }

}
