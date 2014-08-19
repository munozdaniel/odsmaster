package com.wipro.wess.ods.upload.excel.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

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
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utils.StringUtil;
import com.wipro.wess.pdm.security.SecurityUtil;

public class ExcelServiceAsset extends ExcelSheet {

    private String assetNum;

    private String description;

    private String status;

    private String type;

    private String subType;

    private String serviceSubType;

    private String serviceGroup;

    private String location;

    private String pluspCustomer;

    private String siteId;

    private String energyCostPerUnit;

    private String servEffFormula;

    private String servQualFormula;

    private String svcconsminus;

    private String svcconsplus;

    private String servQuanFormula;

    public ExcelServiceAsset() {
        super();
    }

    public ExcelServiceAsset(String assetNum, String description, String status, String type, String subType,
            String serviceSubType, String serviceGroup, String location, String pluspCustomer, String siteId,
            String energyCostPerUnit, String servEffFormula, String servQualFormula, String svcconsminus,
            String svcconsplus, String servQuanFormula) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.status = status;
        this.type = type;
        this.subType = subType;
        this.serviceSubType = serviceSubType;
        this.serviceGroup = serviceGroup;
        this.location = location;
        this.pluspCustomer = pluspCustomer;
        this.siteId = siteId;
        this.energyCostPerUnit = energyCostPerUnit;
        this.servEffFormula = servEffFormula;
        this.servQualFormula = servQualFormula;
        this.svcconsminus = svcconsminus;
        this.svcconsplus = svcconsplus;
        this.servQuanFormula = servQuanFormula;
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

    public String getServiceSubType() {
        return serviceSubType;
    }

    public void setServiceSubType(String serviceSubType) {
        this.serviceSubType = serviceSubType;
    }

    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
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

    public String getEnergyCostPerUnit() {
        return energyCostPerUnit;
    }

    public void setEnergyCostPerUnit(String energyCostPerUnit) {
        this.energyCostPerUnit = energyCostPerUnit;
    }

    public String getServEffFormula() {
        return servEffFormula;
    }

    public void setServEffFormula(String servEffFormula) {
        this.servEffFormula = servEffFormula;
    }

    public String getServQualFormula() {
        return servQualFormula;
    }

    public void setServQualFormula(String servQualFormula) {
        this.servQualFormula = servQualFormula;
    }

    public String getSvcconsminus() {
        return svcconsminus;
    }

    public void setSvcconsminus(String svcconsminus) {
        this.svcconsminus = svcconsminus;
    }

    public String getSvcconsplus() {
        return svcconsplus;
    }

    public void setSvcconsplus(String svcconsplus) {
        this.svcconsplus = svcconsplus;
    }

    public String getServQuanFormula() {
        return servQuanFormula;
    }

    public void setServQuanFormula(String servQuanFormula) {
        this.servQuanFormula = servQuanFormula;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            ServiceAssetHeaders serviceAssetHeaders = ServiceAssetHeaders.getServiceAssetHeaders(headerVal,
                    odsMasterProps);
            if (serviceAssetHeaders != null) {
                switch (serviceAssetHeaders) {
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
                    case SERVICESUBTYPE:
                        if (valObj != null && valObj instanceof String) {
                            String serviceSubType = (String) valObj;
                            this.setServiceSubType(serviceSubType);
                        }
                        break;
                    case SERVICEGROUP:
                        if (valObj != null && valObj instanceof String) {
                            String serviceGroup = (String) valObj;
                            this.setServiceGroup(serviceGroup);
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
                    case ENERGYCOSTPERUNIT:
                        if (valObj != null && valObj instanceof String) {
                            String energyCostPerUnit = (String) valObj;
                            this.setEnergyCostPerUnit(energyCostPerUnit);
                        }
                        break;
                    case SERVICE_EFF_FORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String servEffFormula = (String) valObj;
                            this.setServEffFormula(servEffFormula);
                        }
                        break;
                    case SERVICE_QA_FORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String servQualFormula = (String) valObj;
                            this.setServQualFormula(servQualFormula);
                        }
                        break;
                    case SVCCONSMINUS:
                        if (valObj != null && valObj instanceof String) {
                            String svcconsminus = (String) valObj;
                            this.setSvcconsminus(svcconsminus);
                        }
                        break;
                    case SVCCONSPLUS:
                        if (valObj != null && valObj instanceof String) {
                            String svcconsplus = (String) valObj;
                            this.setSvcconsplus(svcconsplus);
                        }
                        break;
                    case SERVICE_QTY_FORMULA:
                        if (valObj != null && valObj instanceof String) {
                            String servQuanFormula = (String) valObj;
                            this.setServQuanFormula(servQuanFormula);
                        }
                        break;
                }
            }

        }
        if (StringUtil.isNotEmpty(this.getSheetRowId()) && StringUtil.isNotEmpty(this.getLocation())
                && StringUtil.isNotEmpty(this.getSiteId())) {
            boolean updateSitePermitted = SecurityUtil.checkSitePermission(this.getSiteId(), this.getLocation());
            if (!updateSitePermitted) {
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.SERVICE_ASSET_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(),
                ProvisioningConstants.SERVICE_ASSET_SHEET);
        OmServiceConfig serviceConfig = isisJdocontainer.firstMatch(new QueryDefault<OmServiceConfig>(
                OmServiceConfig.class, "fetch_om_service_config_by_pk", "serviceUid", this.getAssetNum()));
        if (serviceConfig == null) {
            serviceConfig = isisJdocontainer.newTransientInstance(OmServiceConfig.class);
            serviceConfig.setServiceUid(this.getAssetNum());
            serviceConfig.setSite(site);
            serviceConfig.setChangeBy(isisJdocontainer.getUser().getName());
            serviceConfig.setChangeTs(new Date());
        }
        serviceConfig.setDescription(this.getDescription());
        serviceConfig.setEnergyCostPerUnit((this.getEnergyCostPerUnit() != null ? new BigDecimal(this
                .getEnergyCostPerUnit()) : null));
        serviceConfig.setServiceEffFormula(this.getServEffFormula());
        serviceConfig.setServiceQaFormula(this.getServQualFormula());
        serviceConfig.setServiceQtyFormula(this.getServQuanFormula());
        serviceConfig.setServiceType(this.getServiceSubType());
        serviceConfig.setStatus(this.getStatus());
        isisJdocontainer.persistIfNotAlready(serviceConfig);
        this.processAsset(isisJdocontainer, locationMap, odsMasterProps);
    }

    private void processAsset(DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        OmLocationHierarchy locationHierarchy = lookupLocationHierarchy(isisJdocontainer, locationMap,
                this.getLocation(), this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET));
        if (locationHierarchy == null) {
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps
                    .getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET) + "." + ProvisioningConstants.LOCATION,
                    ProvisioningConstants.LOCATION + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE));
            throw exception;
        } else if (locationHierarchy.getOrganisation() == null) {
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps
                    .getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET) + "." + ProvisioningConstants.SITEID,
                    ProvisioningConstants.SITEID + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE));
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
        asset.setServiceGroup(this.getServiceGroup());
        isisJdocontainer.persistIfNotAlready(asset);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET));
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
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SERVICE_ASSET_SHEET));
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
        return "ExcelServiceAsset [assetNum=" + assetNum + ", description=" + description + ", status=" + status
                + ", type=" + type + ", subType=" + subType + ", serviceSubType=" + serviceSubType + ", serviceGroup="
                + serviceGroup + ", location=" + location + ", pluspCustomer=" + pluspCustomer + ", siteId=" + siteId
                + ", energyCostPerUnit=" + energyCostPerUnit + ", servEffFormula=" + servEffFormula
                + ", servQualFormula=" + servQualFormula + ", svcconsminus=" + svcconsminus + ", svcconsplus="
                + svcconsplus + ", servQuanFormula=" + servQuanFormula + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
