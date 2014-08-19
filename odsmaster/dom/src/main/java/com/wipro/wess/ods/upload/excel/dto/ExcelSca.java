package com.wipro.wess.ods.upload.excel.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.exceptions.constraints.NotFoundConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;
import com.wipro.wess.ods.sca.OmScaConfig;
import com.wipro.wess.ods.sca.OmScaConfigExtAttr;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utils.StringUtil;
import com.wipro.wess.pdm.security.SecurityUtil;

public class ExcelSca extends ExcelSheet {

    private String assetNum;

    private String description;

    private String status;

    private String type;

    private String subType;

    private String calendarName;

    private String operationPeriod;

    private Double highTempConfigValue;

    private Double lowTempConfigValue;

    private Double heatingProfileOffset;

    private Double coolingProfileOffset;

    private Double overCoolingConfig;

    private Double underCollingConfig;

    private Double adjustableTempBand;

    private Double highHumidityConfig;

    private Double lowHumidityConfig;

    private Double co2Limit;

    private Double subOptThermalProfileDevn;

    private Double illumHighLmtLux;

    private Double illumLowLmtLux;

    private String location;

    private String pluspCustomer;

    private String siteId;

    public ExcelSca() {
        super();
    }

    public ExcelSca(String assetNum, String description, String status, String type, String subType,
            String calendarName, String operationPeriod, Double highTempConfigValue, Double lowTempConfigValue,
            Double heatingProfileOffset, Double coolingProfileOffset, Double overCoolingConfig,
            Double underCollingConfig, Double adjustableTempBand, Double highHumidityConfig, Double lowHumidityConfig,
            Double co2Limit, Double subOptThermalProfileDevn, Double illumHighLmtLux, Double illumLowLmtLux,
            String location, String pluspCustomer, String siteId) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.status = status;
        this.type = type;
        this.subType = subType;
        this.calendarName = calendarName;
        this.operationPeriod = operationPeriod;
        this.highTempConfigValue = highTempConfigValue;
        this.lowTempConfigValue = lowTempConfigValue;
        this.heatingProfileOffset = heatingProfileOffset;
        this.coolingProfileOffset = coolingProfileOffset;
        this.overCoolingConfig = overCoolingConfig;
        this.underCollingConfig = underCollingConfig;
        this.adjustableTempBand = adjustableTempBand;
        this.highHumidityConfig = highHumidityConfig;
        this.lowHumidityConfig = lowHumidityConfig;
        this.co2Limit = co2Limit;
        this.subOptThermalProfileDevn = subOptThermalProfileDevn;
        this.illumHighLmtLux = illumHighLmtLux;
        this.illumLowLmtLux = illumLowLmtLux;
        this.location = location;
        this.pluspCustomer = pluspCustomer;
        this.siteId = siteId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getOperationPeriod() {
        return operationPeriod;
    }

    public void setOperationPeriod(String operationPeriod) {
        this.operationPeriod = operationPeriod;
    }

    public Double getHighTempConfigValue() {
        return highTempConfigValue;
    }

    public void setHighTempConfigValue(Double highTempConfigValue) {
        this.highTempConfigValue = highTempConfigValue;
    }

    public Double getLowTempConfigValue() {
        return lowTempConfigValue;
    }

    public void setLowTempConfigValue(Double lowTempConfigValue) {
        this.lowTempConfigValue = lowTempConfigValue;
    }

    public Double getHeatingProfileOffset() {
        return heatingProfileOffset;
    }

    public void setHeatingProfileOffset(Double heatingProfileOffset) {
        this.heatingProfileOffset = heatingProfileOffset;
    }

    public Double getCoolingProfileOffset() {
        return coolingProfileOffset;
    }

    public void setCoolingProfileOffset(Double coolingProfileOffset) {
        this.coolingProfileOffset = coolingProfileOffset;
    }

    public Double getOverCoolingConfig() {
        return overCoolingConfig;
    }

    public void setOverCoolingConfig(Double overCoolingConfig) {
        this.overCoolingConfig = overCoolingConfig;
    }

    public Double getUnderCollingConfig() {
        return underCollingConfig;
    }

    public void setUnderCollingConfig(Double underCollingConfig) {
        this.underCollingConfig = underCollingConfig;
    }

    public Double getAdjustableTempBand() {
        return adjustableTempBand;
    }

    public void setAdjustableTempBand(Double adjustableTempBand) {
        this.adjustableTempBand = adjustableTempBand;
    }

    public Double getHighHumidityConfig() {
        return highHumidityConfig;
    }

    public void setHighHumidityConfig(Double highHumidityConfig) {
        this.highHumidityConfig = highHumidityConfig;
    }

    public Double getLowHumidityConfig() {
        return lowHumidityConfig;
    }

    public void setLowHumidityConfig(Double lowHumidityConfig) {
        this.lowHumidityConfig = lowHumidityConfig;
    }

    public Double getCo2Limit() {
        return co2Limit;
    }

    public void setCo2Limit(Double co2Limit) {
        this.co2Limit = co2Limit;
    }

    public Double getSubOptThermalProfileDevn() {
        return subOptThermalProfileDevn;
    }

    public void setSubOptThermalProfileDevn(Double subOptThermalProfileDevn) {
        this.subOptThermalProfileDevn = subOptThermalProfileDevn;
    }

    public Double getIllumHighLmtLux() {
        return illumHighLmtLux;
    }

    public void setIllumHighLmtLux(Double illumHighLmtLux) {
        this.illumHighLmtLux = illumHighLmtLux;
    }

    public Double getIllumLowLmtLux() {
        return illumLowLmtLux;
    }

    public void setIllumLowLmtLux(Double illumLowLmtLux) {
        this.illumLowLmtLux = illumLowLmtLux;
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

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            ScaHeaders scaHeaders = ScaHeaders.getScaHeaders(headerVal, odsMasterProps);
            if (scaHeaders != null) {
                switch (scaHeaders) {
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
                    case STATUS:
                        if (valObj != null && valObj instanceof String) {
                            String status = (String) valObj;
                            this.setStatus(status);
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
                    case CALENDAR:
                        if (valObj != null && valObj instanceof String) {
                            String calendarName = (String) valObj;
                            this.setCalendarName(calendarName);
                        }
                        break;
                    case OPERATION_PERIOD:
                        if (valObj != null && valObj instanceof String) {
                            String operationPeriod = (String) valObj;
                            this.setOperationPeriod(operationPeriod);
                        }
                        break;
                    case HIGH_TEMPERATURE_CONFIG_VALUE:
                        if (valObj != null && valObj instanceof Double) {
                            Double highTempConfigValue = (Double) valObj;
                            this.setHighTempConfigValue(highTempConfigValue);
                        }
                        break;
                    case LOW_TEMPERATURE_CONFIG_VALUE:
                        if (valObj != null && valObj instanceof Double) {
                            Double lowTempConfigValue = (Double) valObj;
                            this.setLowTempConfigValue(lowTempConfigValue);
                        }
                        break;
                    case HEATING_PROFILE_OFFSET:
                        if (valObj != null && valObj instanceof Double) {
                            Double heatingProfileOffset = (Double) valObj;
                            this.setHeatingProfileOffset(heatingProfileOffset);
                        }
                        break;
                    case COOLING_PROFILE_OFFSET:
                        if (valObj != null && valObj instanceof Double) {
                            Double coolingProfileOffset = (Double) valObj;
                            this.setCoolingProfileOffset(coolingProfileOffset);
                        }
                        break;
                    case OVERCOOLING_CONFIG:
                        if (valObj != null && valObj instanceof Double) {
                            Double overCoolingConfig = (Double) valObj;
                            this.setOverCoolingConfig(overCoolingConfig);
                        }
                        break;
                    case UNDERCOOLING_CONFIG:
                        if (valObj != null && valObj instanceof Double) {
                            Double underCollingConfig = (Double) valObj;
                            this.setUnderCollingConfig(underCollingConfig);
                        }
                        break;
                    case ADJUSTABLE_TEMP_BAND:
                        if (valObj != null && valObj instanceof Double) {
                            Double adjustableTempBand = (Double) valObj;
                            this.setAdjustableTempBand(adjustableTempBand);
                        }
                        break;
                    case HIGH_HUMIDITY_CONFIG_VALUE:
                        if (valObj != null && valObj instanceof Double) {
                            Double highHumidityConfig = (Double) valObj;
                            this.setHighHumidityConfig(highHumidityConfig);
                        }
                        break;
                    case LOW_HUMIDITY_CONFIG_VALUE:
                        if (valObj != null && valObj instanceof Double) {
                            Double lowHumidityConfig = (Double) valObj;
                            this.setLowHumidityConfig(lowHumidityConfig);
                        }
                        break;
                    case CO2LIMIT:
                        if (valObj != null && valObj instanceof Double) {
                            Double co2Limit = (Double) valObj;
                            this.setCo2Limit(co2Limit);
                        }
                        break;
                    case SUB_OPTIMAL_THERMAL_PROFILE_DEVIATION_LIMIT:
                        if (valObj != null && valObj instanceof Double) {
                            Double subOptThermalProfileDevn = (Double) valObj;
                            this.setSubOptThermalProfileDevn(subOptThermalProfileDevn);
                        }
                        break;
                    case ILLUMINATION_HI_LIMIT_LUX:
                        if (valObj != null && valObj instanceof Double) {
                            Double illumHighLmtLux = (Double) valObj;
                            this.setIllumHighLmtLux(illumHighLmtLux);
                        }
                        break;
                    case ILLUMINATION_LOW_LIMIT_LUX:
                        if (valObj != null && valObj instanceof Double) {
                            Double illumLowLmtLux = (Double) valObj;
                            this.setIllumLowLmtLux(illumLowLmtLux);
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
                }
            }
        }
        if (StringUtil.isNotEmpty(this.getSheetRowId()) && StringUtil.isNotEmpty(this.getLocation())
                && StringUtil.isNotEmpty(this.getSiteId())) {
            boolean updateSitePermitted = SecurityUtil.checkSitePermission(this.getSiteId(), this.getLocation());
            if (!updateSitePermitted) {
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.SCA_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {

        this.validate(odsMasterProps);
        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET));

        OmScaConfig scaConfig = isisJdocontainer.firstMatch(new QueryDefault<OmScaConfig>(OmScaConfig.class,
                "fetch_OmScaConfig_by_pk", "scaUid", this.getAssetNum()));
        if (scaConfig == null) {
            scaConfig = isisJdocontainer.newTransientInstance(OmScaConfig.class);
            scaConfig.setScaUid(this.getAssetNum());
            scaConfig.setOmSite(site);
            scaConfig.setChangeBy(isisJdocontainer.getUser().getName());
            scaConfig.setChangeDt(new Date());
        }
        scaConfig.setScaName(this.getDescription());
        scaConfig.setDescription(this.getDescription());
        scaConfig
                .setAdjustTempBand((this.getAdjustableTempBand() != null ? new BigDecimal(this.getAdjustableTempBand())
                        : null));
        scaConfig.setAreaType(this.getSubType());
        scaConfig.setCoolingProfileOffset((this.getCoolingProfileOffset() != null ? this.getCoolingProfileOffset()
                .intValue() : null));
        scaConfig.setFcHighTempLimit((this.getIllumHighLmtLux() != null ? new BigDecimal(this.getIllumHighLmtLux())
                : null));
        scaConfig
                .setFcLowTempLimit((this.getIllumLowLmtLux() != null ? new BigDecimal(this.getIllumLowLmtLux()) : null));
        scaConfig.setHeatingProfileOffset((this.getHeatingProfileOffset() != null ? this.getHeatingProfileOffset()
                .intValue() : null));
        scaConfig.setHighRhLimit((this.getHighHumidityConfig() != null ? new BigDecimal(this.getHighHumidityConfig())
                : null));
        scaConfig.setHighTempLimit((this.getHighTempConfigValue() != null ? new BigDecimal(this
                .getHighTempConfigValue()) : null));
        scaConfig.setLowRhLimit((this.getLowHumidityConfig() != null ? new BigDecimal(this.getLowHumidityConfig())
                : null));
        scaConfig.setLowTempLimit((this.getLowTempConfigValue() != null ? new BigDecimal(this.getLowTempConfigValue())
                : null));
        scaConfig.setOvercoolingThresholdPercent((this.getOverCoolingConfig() != null ? new BigDecimal(this
                .getOverCoolingConfig()) : null));
        scaConfig.setStatus(this.getStatus());
        scaConfig.setSuboptThermalDeviation((this.getSubOptThermalProfileDevn() != null ? new BigDecimal(this
                .getSubOptThermalProfileDevn()) : null));
        scaConfig.setUndercoolingThresholdPercent((this.getUnderCollingConfig() != null ? new BigDecimal(this
                .getUnderCollingConfig()) : null));

        if (this.getCo2Limit() != null || this.getIllumHighLmtLux() != null || this.getIllumLowLmtLux() != null) {
            boolean scaConfigExtAttrCo2Limit = false;
            boolean scaConfigExtAttrIllHigh = false;
            boolean scaConfigExtAttrIllLow = false;
            Set<OmScaConfigExtAttr> scaConfigExtAttrs = scaConfig.getScaConfigExtAttrs();
            for (OmScaConfigExtAttr scaConfigExtAttr : scaConfigExtAttrs) {
                if (scaConfigExtAttr.getAttributeName().equalsIgnoreCase(ProvisioningConstants.CO2LIMIT)) {
                    scaConfigExtAttr.setNumValue((this.getCo2Limit() != null ? new BigDecimal(this.getCo2Limit())
                            : null));
                    scaConfigExtAttrCo2Limit = true;
                } else if (scaConfigExtAttr.getAttributeName().equalsIgnoreCase(
                        ProvisioningConstants.ILLUMINATION_HIGH_LIMIT_LUX)) {
                    scaConfigExtAttrIllHigh = true;
                    scaConfigExtAttr.setNumValue((this.getIllumHighLmtLux() != null ? new BigDecimal(this
                            .getIllumHighLmtLux()) : null));
                } else if (scaConfigExtAttr.getAttributeName().equalsIgnoreCase(
                        ProvisioningConstants.ILLUMINATION_LOW_LIMIT_LUX)) {
                    scaConfigExtAttrIllLow = true;
                    scaConfigExtAttr.setNumValue((this.getIllumLowLmtLux() != null ? new BigDecimal(this
                            .getIllumLowLmtLux()) : null));
                }
            }
            if (!scaConfigExtAttrCo2Limit && this.getCo2Limit() != null) {
                OmScaConfigExtAttr scaConfigExtAttr = isisJdocontainer.newTransientInstance(OmScaConfigExtAttr.class);
                scaConfigExtAttr.setScaUid(scaConfig);
                scaConfigExtAttr.setAttributeName(ProvisioningConstants.CO2LIMIT);
                scaConfigExtAttr.setNumValue((this.getCo2Limit() != null ? new BigDecimal(this.getCo2Limit()) : null));
                scaConfigExtAttrs.add(scaConfigExtAttr);
            }
            if (!scaConfigExtAttrIllHigh && this.getIllumHighLmtLux() != null) {
                OmScaConfigExtAttr scaConfigExtAttr = isisJdocontainer.newTransientInstance(OmScaConfigExtAttr.class);
                scaConfigExtAttr.setScaUid(scaConfig);
                scaConfigExtAttr.setAttributeName(ProvisioningConstants.ILLUMINATION_HIGH_LIMIT_LUX);
                scaConfigExtAttr.setNumValue((this.getIllumHighLmtLux() != null ? new BigDecimal(this
                        .getIllumHighLmtLux()) : null));
                scaConfigExtAttrs.add(scaConfigExtAttr);
            }
            if (!scaConfigExtAttrIllLow && this.getIllumLowLmtLux() != null) {
                OmScaConfigExtAttr scaConfigExtAttr = isisJdocontainer.newTransientInstance(OmScaConfigExtAttr.class);
                scaConfigExtAttr.setScaUid(scaConfig);
                scaConfigExtAttr.setAttributeName(ProvisioningConstants.ILLUMINATION_LOW_LIMIT_LUX);
                scaConfigExtAttr.setNumValue((this.getIllumLowLmtLux() != null ? new BigDecimal(this
                        .getIllumLowLmtLux()) : null));
                scaConfigExtAttrs.add(scaConfigExtAttr);
            }
        }

        isisJdocontainer.persistIfNotAlready(scaConfig);
        this.processAsset(isisJdocontainer, locationMap, odsMasterProps);

    }

    private void processAsset(DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        OmLocationHierarchy locationHierarchy = lookupLocationHierarchy(isisJdocontainer, locationMap,
                this.getLocation(), this.getSiteId(), odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET));
        if (locationHierarchy == null) {
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET)
                    + "." + ProvisioningConstants.LOCATION, ProvisioningConstants.LOCATION
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE));
            throw exception;
        } else if (locationHierarchy.getOrganisation() == null) {
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET)
                    + "." + ProvisioningConstants.SITEID, ProvisioningConstants.SITEID
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE));
            throw exception;
        }
        MOrganisation organisation = locationHierarchy.getOrganisation();
        OmAsset asset = isisJdocontainer.firstMatch(new QueryDefault<OmAsset>(OmAsset.class, "fetch_OmAsset_by_pk",
                "assetUid", this.getAssetNum(), "organisation", organisation));
        if (asset == null) {
            asset = isisJdocontainer.newTransientInstance(OmAsset.class);
            asset.setAssetUid(this.getAssetNum());
            asset.setOrganisation(organisation);
        }

        asset.setOmLocationHierarchy(locationHierarchy);
        asset.setDescription(this.getDescription());
        asset.setType(this.getType());
        asset.setSubtype(this.getSubType());
        asset.setChangeby(odsMasterProps.getProperty(ProvisioningConstants.UPLOADED_BY));
        asset.setChangedate(new Date());
        asset.setStatus(this.getStatus());
        isisJdocontainer.persistIfNotAlready(asset);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET));
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
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET));
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
        if (this.getDescription() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SCA_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.DESCRIPTION);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.DESCRIPTION);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_DESCRIPTION_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_DESCRIPTION_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
    }

    @Override
    public String toString() {
        return "ExcelSca [assetNum=" + assetNum + ", description=" + description + ", status=" + status + ", type="
                + type + ", subType=" + subType + ", calendarName=" + calendarName + ", shiftName=" + operationPeriod
                + ", highTempConfigValue=" + highTempConfigValue + ", lowTempConfigValue=" + lowTempConfigValue
                + ", heatingProfileOffset=" + heatingProfileOffset + ", coolingProfileOffset=" + coolingProfileOffset
                + ", overCoolingConfig=" + overCoolingConfig + ", underCollingConfig=" + underCollingConfig
                + ", adjustableTempBand=" + adjustableTempBand + ", highHumidityConfig=" + highHumidityConfig
                + ", lowHumidityConfig=" + lowHumidityConfig + ", co2Limit=" + co2Limit + ", subOptThermalProfileDevn="
                + subOptThermalProfileDevn + ", illumHighLmtLux=" + illumHighLmtLux + ", illumLowLmtLux="
                + illumLowLmtLux + ", location=" + location + ", pluspCustomer=" + pluspCustomer + ", siteId=" + siteId
                + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
