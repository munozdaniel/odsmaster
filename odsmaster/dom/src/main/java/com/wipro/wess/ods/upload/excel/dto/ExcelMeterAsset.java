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
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utils.StringUtil;
import com.wipro.wess.pdm.security.SecurityUtil;

public class ExcelMeterAsset extends ExcelSheet {

    private String assetNum;

    private String description;

    private String type;

    private String subType;

    private String physicalLocation;

    private String manufacturer;

    private String model;

    private String vendor;

    private Date installDate;

    private String serialNumber;

    private String assetTag;

    private Date yearPurchased;

    private String lceFlag;

    private String meterType;

    private String location;

    private String pluspCustomer;

    private String siteId;

    private String estimationEnabled;

    public ExcelMeterAsset() {
        super();
    }

    public ExcelMeterAsset(String assetNum, String description, String type, String subType, String physicalLocation,
            String manufacturer, String model, String vendor, Date installDate, String serialNumber, String assetTag,
            Date yearPurchased, String lceFlag, String meterType, String location, String pluspCustomer, String siteId,
            String estimationEnabled) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.type = type;
        this.subType = subType;
        this.physicalLocation = physicalLocation;
        this.manufacturer = manufacturer;
        this.model = model;
        this.vendor = vendor;
        this.installDate = installDate;
        this.serialNumber = serialNumber;
        this.assetTag = assetTag;
        this.yearPurchased = yearPurchased;
        this.lceFlag = lceFlag;
        this.meterType = meterType;
        this.location = location;
        this.pluspCustomer = pluspCustomer;
        this.siteId = siteId;
        this.estimationEnabled = estimationEnabled;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public Date getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(Date yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    public String getLceFlag() {
        return lceFlag;
    }

    public void setLceFlag(String lceFlag) {
        this.lceFlag = lceFlag;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
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

    public String getEstimationEnabled() {
        return estimationEnabled;
    }

    public void setEstimationEnabled(String estimationEnabled) {
        this.estimationEnabled = estimationEnabled;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            MeterAssetsHeaders meterAssetsHeaders = MeterAssetsHeaders.getMeterAssetsHeaders(headerVal, odsMasterProps);
            if (meterAssetsHeaders != null) {
                switch (meterAssetsHeaders) {
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
                    case TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String type = (String) valObj;
                            this.setType(type);
                        }
                        break;
                    case SUBTYPE:
                        if (valObj != null && valObj instanceof String) {
                            String subType = (String) valObj;
                            this.setSubType(subType);
                        }
                        break;
                    case PHYSICALLOCATION:
                        if (valObj != null && valObj instanceof String) {
                            String physicalLocation = (String) valObj;
                            this.setPhysicalLocation(physicalLocation);
                        }
                        break;
                    case MANUFACTURER:
                        if (valObj != null && valObj instanceof String) {
                            String manufacturer = (String) valObj;
                            this.setManufacturer(manufacturer);
                        }
                        break;
                    case MODEL:
                        if (valObj != null && valObj instanceof String) {
                            String model = (String) valObj;
                            this.setModel(model);
                        }
                        break;
                    case VENDOR:
                        if (valObj != null && valObj instanceof String) {
                            String vendor = (String) valObj;
                            this.setVendor(vendor);
                        }
                        break;
                    case INSTALLDATE:
                        if (valObj != null && valObj instanceof Date) {
                            Date installDate = (Date) valObj;
                            this.setInstallDate(installDate);
                        }
                        break;
                    case SERIALNUM:
                        if (valObj != null && valObj instanceof String) {
                            String vendor = (String) valObj;
                            this.setVendor(vendor);
                        }
                        break;
                    case ASSETTAG:
                        if (valObj != null && valObj instanceof String) {
                            String assetTag = (String) valObj;
                            this.setAssetTag(assetTag);
                        }
                        break;
                    case YEARPURCHASED:
                        if (valObj != null && valObj instanceof Date) {
                            Date yearPurchased = (Date) valObj;
                            this.setYearPurchased(yearPurchased);
                        }
                        break;
                    case LCE_FLAG:
                        if (valObj != null && valObj instanceof String) {
                            String lceFlag = (String) valObj;
                            this.setLceFlag(lceFlag);
                        }
                        break;
                    case METER_TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String meterType = (String) valObj;
                            this.setMeterType(meterType);
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
                    case ESTIMATION_ENABLED:
                        if (valObj != null && valObj instanceof String) {
                            String estimationEnabled = (String) valObj;
                            this.setEstimationEnabled(estimationEnabled);
                        }
                        break;
                }
            }
        }
        if (StringUtil.isNotEmpty(this.getSheetRowId()) && StringUtil.isNotEmpty(this.getLocation())
                && StringUtil.isNotEmpty(this.getSiteId())) {
            boolean updateSitePermitted = SecurityUtil.checkSitePermission(this.getSiteId(), this.getLocation());
            if (!updateSitePermitted) {
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.SUB_ASSET_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);

        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(),
                ProvisioningConstants.METER_ASSET_SHEET);

        OmMeterConfig meterConfig = isisJdocontainer.firstMatch(new QueryDefault<OmMeterConfig>(OmMeterConfig.class,
                "fetch_OmMeterConfig_by_pk", "meterUid", this.getAssetNum()));
        if (meterConfig == null) {
            meterConfig = isisJdocontainer.newTransientInstance(OmMeterConfig.class);
            meterConfig.setMeterUid(this.getAssetNum());
            meterConfig.setInsertedBy(isisJdocontainer.getUser().getName());
            meterConfig.setInsertedTimeTs(new Date());
        }
        meterConfig.setEstimationEnabled(this.getEstimationEnabled());
        meterConfig.setFunctionalType(ProvisioningConstants.FUNC_TYPE_OM);
        meterConfig.setSubtype(this.getSubType());
        meterConfig.setSite(site);
        meterConfig.setStatus(ProvisioningConstants.OPERATING);
        isisJdocontainer.persistIfNotAlready(meterConfig);
        this.processAsset(isisJdocontainer, locationMap, odsMasterProps, ProvisioningConstants.METER_ASSET_SHEET);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.METER_ASSET_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SITEID);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SITEID);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), errorMessage.toString()));
            throw exception;
        }
        if (this.getLocation() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.METER_ASSET_SHEET));
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
        return "ExcelMeterAsset [assetNum=" + assetNum + ", description=" + description + ", type=" + type
                + ", subType=" + subType + ", physicalLocation=" + physicalLocation + ", manufacturer=" + manufacturer
                + ", model=" + model + ", vendor=" + vendor + ", installDate=" + installDate + ", serialNumber="
                + serialNumber + ", assetTag=" + assetTag + ", yearPurchased=" + yearPurchased + ", lceFlag=" + lceFlag
                + ", meterType=" + meterType + ", location=" + location + ", pluspCustomer=" + pluspCustomer
                + ", siteId=" + siteId + ", estimationEnabled=" + estimationEnabled + ", getSheetId()="
                + getSheetRowId() + "]";
    }

}
