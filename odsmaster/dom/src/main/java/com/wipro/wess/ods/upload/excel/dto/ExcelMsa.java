package com.wipro.wess.ods.upload.excel.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.asset.OmAssetspec;
import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.msa.OmModeOfOperationConfig;
import com.wipro.wess.ods.msa.OmMsaConfig;
import com.wipro.wess.ods.msa.OmMsaModeopDef;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utils.StringUtil;
import com.wipro.wess.pdm.security.SecurityUtil;

public class ExcelMsa extends ExcelSheet {

    private String assetNum;

    private String description;

    private String type;

    private String subType;

    private Double overallMsaArea;

    private String oandmContact;

    private Double spikeConsumptionDevn;

    private String afterHrsConfig;

    private String partialHrsConfig;

    private String demandLmtHrsConfig;

    private Double afterHrsThreshold;

    private Double partialHrsThreshold;

    private Double demanLmtHrsThreshold;

    private Double expWeeklyOprHrs;

    private Double expWeeklyPartialHrs;

    private String location;

    private String pluspCustomer;

    private String siteId;

    public ExcelMsa() {
        super();
    }

    public ExcelMsa(String assetNum, String description, String type, String subType, Double overallMsaArea,
            String oandmContact, Double spikeConsumptionDevn, String afterHrsConfig, String partialHrsConfig,
            String demandLmtHrsConfig, Double afterHrsThreshold, Double partialHrsThreshold,
            Double demanLmtHrsThreshold, Double expWeeklyOprHrs, Double expWeeklyPartialHrs, String location,
            String pluspCustomer, String siteId) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.type = type;
        this.subType = subType;
        this.overallMsaArea = overallMsaArea;
        this.oandmContact = oandmContact;
        this.spikeConsumptionDevn = spikeConsumptionDevn;
        this.afterHrsConfig = afterHrsConfig;
        this.partialHrsConfig = partialHrsConfig;
        this.demandLmtHrsConfig = demandLmtHrsConfig;
        this.afterHrsThreshold = afterHrsThreshold;
        this.partialHrsThreshold = partialHrsThreshold;
        this.demanLmtHrsThreshold = demanLmtHrsThreshold;
        this.expWeeklyOprHrs = expWeeklyOprHrs;
        this.expWeeklyPartialHrs = expWeeklyPartialHrs;
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

    public Double getOverallMsaArea() {
        return overallMsaArea;
    }

    public void setOverallMsaArea(Double overallMsaArea) {
        this.overallMsaArea = overallMsaArea;
    }

    public String getOandmContact() {
        return oandmContact;
    }

    public void setOandmContact(String oandmContact) {
        this.oandmContact = oandmContact;
    }

    public Double getSpikeConsumptionDevn() {
        return spikeConsumptionDevn;
    }

    public void setSpikeConsumptionDevn(Double spikeConsumptionDevn) {
        this.spikeConsumptionDevn = spikeConsumptionDevn;
    }

    public String getAfterHrsConfig() {
        return afterHrsConfig;
    }

    public void setAfterHrsConfig(String afterHrsConfig) {
        this.afterHrsConfig = afterHrsConfig;
    }

    public String getPartialHrsConfig() {
        return partialHrsConfig;
    }

    public void setPartialHrsConfig(String partialHrsConfig) {
        this.partialHrsConfig = partialHrsConfig;
    }

    public String getDemandLmtHrsConfig() {
        return demandLmtHrsConfig;
    }

    public void setDemandLmtHrsConfig(String demandLmtHrsConfig) {
        this.demandLmtHrsConfig = demandLmtHrsConfig;
    }

    public Double getAfterHrsThreshold() {
        return afterHrsThreshold;
    }

    public void setAfterHrsThreshold(Double afterHrsThreshold) {
        this.afterHrsThreshold = afterHrsThreshold;
    }

    public Double getPartialHrsThreshold() {
        return partialHrsThreshold;
    }

    public void setPartialHrsThreshold(Double partialHrsThreshold) {
        this.partialHrsThreshold = partialHrsThreshold;
    }

    public Double getDemanLmtHrsThreshold() {
        return demanLmtHrsThreshold;
    }

    public void setDemanLmtHrsThreshold(Double demanLmtHrsThreshold) {
        this.demanLmtHrsThreshold = demanLmtHrsThreshold;
    }

    public Double getExpWeeklyOprHrs() {
        return expWeeklyOprHrs;
    }

    public void setExpWeeklyOprHrs(Double expWeeklyOprHrs) {
        this.expWeeklyOprHrs = expWeeklyOprHrs;
    }

    public Double getExpWeeklyPartialHrs() {
        return expWeeklyPartialHrs;
    }

    public void setExpWeeklyPartialHrs(Double expWeeklyPartialHrs) {
        this.expWeeklyPartialHrs = expWeeklyPartialHrs;
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
            MsaHeaders msaHeaders = MsaHeaders.getMsaHeaders(headerVal, odsMasterProps);
            if (msaHeaders != null) {
                switch (msaHeaders) {
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
                    case OVERALLMSAAREA:
                        if (valObj != null && valObj instanceof Double) {
                            Double overallMsaArea = (Double) valObj;
                            this.setOverallMsaArea(overallMsaArea);
                        }
                        break;
                    case O_M_CONTACT:
                        if (valObj != null && valObj instanceof String) {
                            String oandmContact = (String) valObj;
                            this.setOandmContact(oandmContact);
                        }
                        break;
                    case SPIKE_CONSUMPTION_DEVIATION:
                        if (valObj != null && valObj instanceof Double) {
                            Double spikeConsumptionDevn = (Double) valObj;
                            this.setSpikeConsumptionDevn(spikeConsumptionDevn);
                        }
                        break;
                    case AFTER_HOURS_CONFIG:
                        if (valObj != null && valObj instanceof String) {
                            String afterHrsConfig = (String) valObj;
                            this.setAfterHrsConfig(afterHrsConfig);
                        }
                        break;
                    case PARTIAL_HOURS_CONFIG:
                        if (valObj != null && valObj instanceof String) {
                            String partialHrsConfig = (String) valObj;
                            this.setPartialHrsConfig(partialHrsConfig);
                        }
                        break;
                    case DEMAND_LIMIT_HOURS_CONFIG:
                        if (valObj != null && valObj instanceof String) {
                            String demandLmtHrsConfig = (String) valObj;
                            this.setDemandLmtHrsConfig(demandLmtHrsConfig);
                        }
                        break;
                    case AFTER_HOURS_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double afterHrsThreshold = (Double) valObj;
                            this.setAfterHrsThreshold(afterHrsThreshold);
                        }
                        break;
                    case PARTIAL_HOURS_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double partialHrsThreshold = (Double) valObj;
                            this.setPartialHrsThreshold(partialHrsThreshold);
                        }
                        break;
                    case DEMAND_LIMIT_HRS_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double demanLmtHrsThreshold = (Double) valObj;
                            this.setDemanLmtHrsThreshold(demanLmtHrsThreshold);
                        }
                        break;
                    case EXP_WEEKLY_OPERATION_HRS:
                        if (valObj != null && valObj instanceof Double) {
                            Double expWeeklyOprHrs = (Double) valObj;
                            this.setExpWeeklyOprHrs(expWeeklyOprHrs);
                        }
                        break;
                    case EXP_WEEKLY_PARTIAL_HRS:
                        if (valObj != null && valObj instanceof Double) {
                            Double expWeeklyPartialHrs = (Double) valObj;
                            this.setExpWeeklyPartialHrs(expWeeklyPartialHrs);
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
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.MSA_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        MOrganisation organisation = this.lookupOrganisation(isisJdocontainer, locationMap, this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.MSA_SHEET));

        OmMsaConfig msaConfig = isisJdocontainer.firstMatch(new QueryDefault<OmMsaConfig>(OmMsaConfig.class,
                "fetch_OmMsaConfig_by_pk", "msaUid", this.getAssetNum()));
        if (msaConfig == null) {
            msaConfig = isisJdocontainer.newTransientInstance(OmMsaConfig.class);
            msaConfig.setMsaUid(this.getAssetNum());
            msaConfig.setChangeBy(isisJdocontainer.getUser().getName());
            msaConfig.setChangeDt(new Date());
        }
        msaConfig.setAhThresholdPercent(new BigDecimal(this.getAfterHrsThreshold()));
        msaConfig.setAreaType(this.getSubType());
        msaConfig.setContactOp(this.getOandmContact());
        msaConfig.setDescription(this.getDescription());
        msaConfig.setDlThresholdPercent((this.getDemanLmtHrsThreshold() != null ? new BigDecimal(this
                .getDemanLmtHrsThreshold()) : null));
        msaConfig.setExpdWeeklyOpHrs((this.getExpWeeklyOprHrs() != null ? new BigDecimal(this.getExpWeeklyOprHrs())
                : null));
        msaConfig.setExpdWeeklyPsHrs((this.getExpWeeklyPartialHrs() != null ? new BigDecimal(this
                .getExpWeeklyPartialHrs()) : null));
        msaConfig.setMsaName(this.getDescription());
        msaConfig.setOrgId(organisation);
        msaConfig.setOverallArea((this.getOverallMsaArea() != null ? new BigDecimal(this.getOverallMsaArea()) : null));
        msaConfig.setPhThresholdPercent((this.getPartialHrsThreshold() != null ? new BigDecimal(this
                .getPartialHrsThreshold()) : null));
        msaConfig.setStatus(ProvisioningConstants.OPERATING);

        OmAssetspec assetspec = isisJdocontainer.firstMatch(new QueryDefault<OmAssetspec>(OmAssetspec.class,
                "fetch_OmAssetspec_by_pk", "assetUid", this.getAssetNum(), "attributeCode", odsMasterProps
                        .getProperty(ProvisioningConstants.PEOPLE_COUNT)));

        if (assetspec != null) {
            msaConfig.setPeopleCount(assetspec.getAttributeId());
        }
        isisJdocontainer.persistIfNotAlready(msaConfig);
        this.processAsset(isisJdocontainer, locationMap, odsMasterProps, ProvisioningConstants.MSA_SHEET);

        if (StringUtil.isNotEmpty(this.getAfterHrsConfig())) {

            OmMsaModeopDef msaModeopDef = isisJdocontainer.firstMatch(new QueryDefault<OmMsaModeopDef>(
                    OmMsaModeopDef.class, "fetch_OmMsaModeopDef_by_msa_modename", "modeName",
                    ProvisioningConstants.AFTER_HRS_CONFIG_MODE_NAME, "organisation", organisation, "msaConfig",
                    msaConfig));
            if (msaModeopDef == null) {
                msaModeopDef = isisJdocontainer.newTransientInstance(OmMsaModeopDef.class);
                OmModeOfOperationConfig modeOfOperationConfig = isisJdocontainer
                        .firstMatch(new QueryDefault<OmModeOfOperationConfig>(OmModeOfOperationConfig.class,
                                "fetch_OmModeOfOperationConfig_by_pk", "modeName",
                                ProvisioningConstants.AFTER_HRS_CONFIG_MODE_NAME, "organisation", organisation));
                if (modeOfOperationConfig == null) {
                    modeOfOperationConfig = isisJdocontainer.newTransientInstance(OmModeOfOperationConfig.class);
                    modeOfOperationConfig.persist(ProvisioningConstants.AFTER_HRS_CONFIG_MODE_NAME, organisation,
                            ProvisioningConstants.AFTER_HRS_CONFIG_MODE_NAME);
                }
                msaModeopDef.setOmModeOfOperationConfig(modeOfOperationConfig);
                msaModeopDef.setOmMsaConfig(msaConfig);
            }
            msaModeopDef.setModeDefinition(this.getAfterHrsConfig());
            isisJdocontainer.persistIfNotAlready(msaModeopDef);
        }
        if (StringUtil.isNotEmpty(this.getPartialHrsConfig())) {

            OmMsaModeopDef msaModeopDef = isisJdocontainer.firstMatch(new QueryDefault<OmMsaModeopDef>(
                    OmMsaModeopDef.class, "fetch_OmMsaModeopDef_by_msa_modename", "modeName",
                    ProvisioningConstants.PARTIAL_HRS_CONFIG_MODE_NAME, "organisation", organisation, "msaConfig",
                    msaConfig));
            if (msaModeopDef == null) {
                msaModeopDef = isisJdocontainer.newTransientInstance(OmMsaModeopDef.class);
                OmModeOfOperationConfig modeOfOperationConfig = isisJdocontainer
                        .firstMatch(new QueryDefault<OmModeOfOperationConfig>(OmModeOfOperationConfig.class,
                                "fetch_OmModeOfOperationConfig_by_pk", "modeName",
                                ProvisioningConstants.PARTIAL_HRS_CONFIG_MODE_NAME, "organisation", organisation));
                if (modeOfOperationConfig == null) {
                    modeOfOperationConfig = isisJdocontainer.newTransientInstance(OmModeOfOperationConfig.class);
                    modeOfOperationConfig.persist(ProvisioningConstants.PARTIAL_HRS_CONFIG_MODE_NAME, organisation,
                            ProvisioningConstants.PARTIAL_HRS_CONFIG_MODE_NAME);
                }
                msaModeopDef.setOmModeOfOperationConfig(modeOfOperationConfig);
                msaModeopDef.setOmMsaConfig(msaConfig);
            }
            msaModeopDef.setModeDefinition(this.getPartialHrsConfig());
            isisJdocontainer.persistIfNotAlready(msaModeopDef);
        }
        if (StringUtil.isNotEmpty(this.getDemandLmtHrsConfig())) {

            OmMsaModeopDef msaModeopDef = isisJdocontainer.firstMatch(new QueryDefault<OmMsaModeopDef>(
                    OmMsaModeopDef.class, "fetch_OmMsaModeopDef_by_msa_modename", "modeName",
                    ProvisioningConstants.DEMAND_LIMIT_HRS_CONFIG_MODE_NAME, "organisation", organisation, "msaConfig",
                    msaConfig));
            if (msaModeopDef == null) {
                msaModeopDef = isisJdocontainer.newTransientInstance(OmMsaModeopDef.class);
                OmModeOfOperationConfig modeOfOperationConfig = isisJdocontainer
                        .firstMatch(new QueryDefault<OmModeOfOperationConfig>(OmModeOfOperationConfig.class,
                                "fetch_OmModeOfOperationConfig_by_pk", "modeName",
                                ProvisioningConstants.DEMAND_LIMIT_HRS_CONFIG_MODE_NAME, "organisation", organisation));
                if (modeOfOperationConfig == null) {
                    modeOfOperationConfig = isisJdocontainer.newTransientInstance(OmModeOfOperationConfig.class);
                    modeOfOperationConfig.persist(ProvisioningConstants.DEMAND_LIMIT_HRS_CONFIG_MODE_NAME,
                            organisation, ProvisioningConstants.DEMAND_LIMIT_HRS_CONFIG_MODE_NAME);
                }
                msaModeopDef.setOmModeOfOperationConfig(modeOfOperationConfig);
                msaModeopDef.setOmMsaConfig(msaConfig);
            }
            msaModeopDef.setModeDefinition(this.getDemandLmtHrsConfig());
            isisJdocontainer.persistIfNotAlready(msaModeopDef);
        }

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_SHEET));
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
    }

    @Override
    public String toString() {
        return "ExcelMsa [assetNum=" + assetNum + ", description=" + description + ", type=" + type + ", subType="
                + subType + ", overallMsaArea=" + overallMsaArea + ", oandmContact=" + oandmContact
                + ", spikeConsumptionDevn=" + spikeConsumptionDevn + ", afterHrsConfig=" + afterHrsConfig
                + ", partialHrsConfig=" + partialHrsConfig + ", demandLmtHrsConfig=" + demandLmtHrsConfig
                + ", afterHrsThreshold=" + afterHrsThreshold + ", partialHrsThreshold=" + partialHrsThreshold
                + ", demanLmtHrsThreshold=" + demanLmtHrsThreshold + ", expWeeklyOprHrs=" + expWeeklyOprHrs
                + ", expWeeklyPartialHrs=" + expWeeklyPartialHrs + ", location=" + location + ", pluspCustomer="
                + pluspCustomer + ", siteId=" + siteId + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
