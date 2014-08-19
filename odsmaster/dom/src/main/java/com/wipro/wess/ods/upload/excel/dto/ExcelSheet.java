package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.NotFoundConstraint;
import com.wipro.wess.ods.exceptions.constraints.SecurityCheckFailedConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.masterconfig.MSourcetypeConfig;
import com.wipro.wess.ods.msa.OmMsaConfig;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;
import com.wipro.wess.ods.sca.OmScaConfig;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelSheet {

    private String sheetRowId;

    private String siteId;

    private String location;

    private String description;

    private String type;

    private String subType;

    private String physicalLocation;

    private String assetNum;

    private String parent;

    private String manufacturer;

    private String model;

    private String vendor;

    private Date installDate;

    private String meterType;

    private String parentMeter;

    private String serialNumber;

    private String assetTag;

    private Date yearPurchased;

    public String getSheetRowId() {
        return sheetRowId;
    }

    public void setSheetRowId(String sheetId) {
        this.sheetRowId = sheetId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(String assetNum) {
        this.assetNum = assetNum;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
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

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public String getParentMeter() {
        return parentMeter;
    }

    public void setParentMeter(String parentMeter) {
        this.parentMeter = parentMeter;
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

    public ExcelSheet() {

    }

    public Object getCellValue(Cell cell) {
        Object value = null;
        String strVal = null;
        Date dateVal = null;
        Double doubleVal = null;
        Boolean booleanVal = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strVal = cell.getStringCellValue();
                value = strVal;
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    dateVal = cell.getDateCellValue();
                    value = dateVal;
                } else {
                    doubleVal = cell.getNumericCellValue();
                    value = doubleVal;
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                booleanVal = cell.getBooleanCellValue();
                value = booleanVal;
                break;
            case Cell.CELL_TYPE_FORMULA:
                try {
                    strVal = cell.getStringCellValue();
                    value = strVal;
                } catch (IllegalStateException e) {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        dateVal = cell.getDateCellValue();
                        value = dateVal;
                    } else {
                        doubleVal = cell.getNumericCellValue();
                        value = doubleVal;
                    }
                }
                break;
        }
        return value;
    }

    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException{
        throw new UnsupportedOperationException();
    }

    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        throw new UnsupportedOperationException();
    }

    protected MOrganisation lookupOrganisation(DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, String siteId, String sheetName)
            throws ConstraintViolatedException {
        LocationHierarchyLookup locationHierarchyLookupKey = new LocationHierarchyLookup(null, siteId);
        LocationHierarchyLookup locationHierarchyLookup = locationMap.get(locationHierarchyLookupKey);
        if (locationHierarchyLookup == null) {
            locationHierarchyLookup = locationHierarchyLookupKey;
            locationHierarchyLookup.setOrganisation(isisJdocontainer.firstMatch(new QueryDefault<MOrganisation>(
                    MOrganisation.class, "fetch_orgnaisation_by_id", "orgId", siteId)));
            locationMap.put(locationHierarchyLookup, locationHierarchyLookup);
        } else {
            locationHierarchyLookupKey = null;
        }
        MOrganisation organisation = locationHierarchyLookup.getOrganisation();
        if (organisation == null) {
            Error.PDM_ORGID_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.SITEID
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(sheetName + "." + ProvisioningConstants.SITEID,
                    Error.PDM_ORGID_NOT_FOUND.name(), ProvisioningConstants.SITEID
                            + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, siteId));
            throw exception;
        }
        return organisation;
    }

    protected OmSite lookUpSite(DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, String location, String siteId,
            String sheetName) throws ConstraintViolatedException {
        OmSite site = null;
        LocationHierarchyLookup locationHierarchyLookupKey = new LocationHierarchyLookup(location, siteId);
        LocationHierarchyLookup locationHierarchyLookup = locationMap.get(locationHierarchyLookupKey);
        if (locationHierarchyLookup == null) {
            locationHierarchyLookup = locationHierarchyLookupKey;
            locationHierarchyLookup.setOmSite(isisJdocontainer.firstMatch(new QueryDefault<OmSite>(OmSite.class,
                    "fetch_OmSite_by_site_and_org", "orgId", siteId, "siteId", location)));
            locationMap.put(locationHierarchyLookup, locationHierarchyLookup);
        } else if (locationHierarchyLookup.getOmSite() == null) {
            locationHierarchyLookup.setOmSite(isisJdocontainer.firstMatch(new QueryDefault<OmSite>(OmSite.class,
                    "fetch_OmSite_by_site_and_org", "orgId", siteId, "siteId", location)));
            locationMap.put(locationHierarchyLookup, locationHierarchyLookup);
            locationHierarchyLookupKey = null;
        }
        site = locationHierarchyLookup.getOmSite();
        if (site == null) {
            Error.PDM_LOCATION_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.LOCATION
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(sheetName + "." + ProvisioningConstants.LOCATION,
                    Error.PDM_LOCATION_NOT_FOUND.name(), ProvisioningConstants.LOCATION
                            + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE));
            throw exception;
        } else if (site.getOrgId() == null) {
            Error.PDM_ORGID_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.SITEID
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(sheetName + "." + ProvisioningConstants.SITEID,
                    Error.PDM_ORGID_NOT_FOUND.name(), ProvisioningConstants.SITEID
                            + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, siteId));
            throw exception;
        }
        locationHierarchyLookup.setOrganisation(site.getOrgId());
        return site;
    }

    protected OmLocationHierarchy lookupLocationHierarchy(DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, String location, String siteId,
            String sheetName) throws ConstraintViolatedException {
        OmLocationHierarchy locationHierarchy = null;
        LocationHierarchyLookup locationHierarchyLookupKey = new LocationHierarchyLookup(location, siteId);
        LocationHierarchyLookup locationHierarchyLookup = locationMap.get(locationHierarchyLookupKey);
        if (locationHierarchyLookup == null) {
            locationHierarchyLookup = locationHierarchyLookupKey;
            locationHierarchyLookup.setLocationHierarchy(isisJdocontainer
                    .firstMatch(new QueryDefault<OmLocationHierarchy>(OmLocationHierarchy.class,
                            "fetch_locationhierarchy_by_location_and_org", "orgId", siteId, "locationId", location)));
            if (locationHierarchyLookup.getLocationHierarchy() != null) {
                locationHierarchyLookup.setOmSite(locationHierarchyLookup.getLocationHierarchy().getOmSite());
            }
            locationMap.put(locationHierarchyLookup, locationHierarchyLookup);
        }
        locationHierarchy = locationHierarchyLookup.getLocationHierarchy();
        if (locationHierarchy == null) {
            Error.PDM_LOCATION_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.LOCATION
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(sheetName + "." + ProvisioningConstants.LOCATION,
                    Error.PDM_LOCATION_NOT_FOUND.name(), ProvisioningConstants.LOCATION
                            + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, location));
            throw exception;
        } else if (locationHierarchy.getOrganisation() == null) {
            Error.PDM_ORGID_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.SITEID
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(sheetName + "." + ProvisioningConstants.SITEID,
                    Error.PDM_ORGID_NOT_FOUND.name(), ProvisioningConstants.SITEID
                            + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, siteId));
            throw exception;
        }
        return locationHierarchy;
    }

    protected void processAsset(DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            String sheetName) throws ConstraintViolatedException {
        OmLocationHierarchy locationHierarchy = this.lookupLocationHierarchy(isisJdocontainer, locationMap,
                this.getLocation(), this.getSiteId(), odsMasterProps.getProperty(sheetName));
        MOrganisation organisation = locationHierarchy.getOrganisation();
        OmAsset asset = isisJdocontainer.firstMatch(new QueryDefault<OmAsset>(OmAsset.class, "fetch_OmAsset_by_pk",
                "assetUid", this.getAssetNum(), "organisation", organisation));
        if (asset == null) {
            asset = isisJdocontainer.newTransientInstance(OmAsset.class);
            asset.setAssetUid(this.getAssetNum());
            asset.setOrganisation(organisation);
            asset.setChangeby(isisJdocontainer.getUser().getName());
            asset.setChangedate(new Date());
        }

        asset.setOmLocationHierarchy(locationHierarchy);
        asset.setDescription(this.getDescription());
        asset.setType(this.getType());
        asset.setSubtype(this.getSubType());
        asset.setStatus(ProvisioningConstants.OPERATING);
        asset.setPhysicalLocation(this.getPhysicalLocation());
        if(this.getParent() != null){
            OmAsset parentAsset = isisJdocontainer.firstMatch(new QueryDefault<OmAsset>(OmAsset.class, "fetch_OmAsset_by_pk",
                    "assetUid", this.getParent(), "organisation", organisation));
            asset.setParentAssetUid(parentAsset);
        }
        asset.setManufacturer(this.getManufacturer());
        asset.setModel(this.getModel());
        asset.setVendor(this.getVendor());
        asset.setInstalldate(this.getInstallDate());
        asset.setSerialNum(this.getSerialNumber());
        asset.setYearPurchased(this.getYearPurchased());
        asset.setAssetTag(this.getAssetTag());
        asset.setMeterType(this.getMeterType());
        asset.setParentMeter(this.getParentMeter());
        isisJdocontainer.persistIfNotAlready(asset);

    }

    protected OmMsaConfig validateMsaExistence(Properties odsMasterProps, DomainObjectContainer isisJdocontainer,
            String msaUid, String sheetName, String fieldName) throws ConstraintViolatedException {
        OmMsaConfig msaConfig = isisJdocontainer.firstMatch(new QueryDefault<OmMsaConfig>(OmMsaConfig.class,
                "fetch_OmMsaConfig_by_pk", "msaUid", msaUid));
        if (msaConfig == null) {
            Error.PDM_MSA_NOT_FOUND.format(ErrorMinorCode.PDMError002, fieldName
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(sheetName) + "." + fieldName,
                    fieldName + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, msaUid));
            throw exception;
        }
        return msaConfig;
    }

    protected void validateTypeCodeExistence(Properties odsMasterProps, DomainObjectContainer isisJdocontainer,
            String typeCode, String sheetName) throws ConstraintViolatedException {
        MSourcetypeConfig sourcetypeConfig = isisJdocontainer.firstMatch(new QueryDefault<MSourcetypeConfig>(
                MSourcetypeConfig.class, "fetch_MSourcetypeConfig_by_pk", "sourceTypeCode", typeCode));
        if (sourcetypeConfig == null) {
            Error.PDM_SETTYPECODE_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.SETYPECODE
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(sheetName) + "."
                    + ProvisioningConstants.SETYPECODE, Error.PDM_SETTYPECODE_NOT_FOUND.name(),
                    ProvisioningConstants.SETYPECODE + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, typeCode));
            throw exception;
        }

    }

    protected void validateServiceTypeExistence(Properties odsMasterProps, DomainObjectContainer isisJdocontainer,
            String serviceType, String sheetName) throws ConstraintViolatedException {
        OmServiceConfig serviceConfig = isisJdocontainer.firstMatch(new QueryDefault<OmServiceConfig>(
                OmServiceConfig.class, "fetch_om_service_config_by_service_type", "serviceType", serviceType));
        if (serviceConfig == null) {
            Error.PDM_SERVICETYPE_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.SERVICETYPE
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(sheetName) + "."
                    + ProvisioningConstants.SERVICETYPE, Error.PDM_SERVICETYPE_NOT_FOUND.name(),
                    ProvisioningConstants.SERVICETYPE + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE,
                    serviceType));
            throw exception;
        }

    }

    protected OmServiceConfig validateServiceUidExistence(Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer, String serviceUid, String sheetName, String fieldName)
            throws ConstraintViolatedException {
        OmServiceConfig serviceConfig = isisJdocontainer.firstMatch(new QueryDefault<OmServiceConfig>(
                OmServiceConfig.class, "fetch_om_service_config_by_pk", "serviceUid", serviceUid));
        if (serviceConfig == null) {
            Error.PDM_SERVICE_NOT_FOUND.format(ErrorMinorCode.PDMError002, fieldName
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(sheetName) + "." + fieldName,
                    Error.PDM_SERVICE_NOT_FOUND.name(), fieldName
                            + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, serviceUid));
            throw exception;
        }
        return serviceConfig;

    }

    protected OmScaConfig validateScaExistence(Properties odsMasterProps, DomainObjectContainer isisJdocontainer,
            String scaUid, String sheetName) throws ConstraintViolatedException {
        OmScaConfig scaConfig = isisJdocontainer.firstMatch(new QueryDefault<OmScaConfig>(OmScaConfig.class,
                "fetch_OmScaConfig_by_pk", "scaUid", scaUid));
        if (scaConfig == null) {
            Error.PDM_SCAASSET_NOT_FOUND.format(ErrorMinorCode.PDMError002, ProvisioningConstants.SCAASSET
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(sheetName) + "."
                    + ProvisioningConstants.SCAASSET, Error.PDM_SCAASSET_NOT_FOUND.name(),
                    ProvisioningConstants.SCAASSET + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE, scaUid));
            throw exception;
        }
        return scaConfig;
    }

    protected OmAsset validateAssetExistence(Properties odsMasterProps, DomainObjectContainer isisJdocontainer,
            String assetUid, MOrganisation orgId, String sheetName, String fieldName)
            throws ConstraintViolatedException {
        OmAsset asset = isisJdocontainer.firstMatch(new QueryDefault<OmAsset>(OmAsset.class, "fetch_OmAsset_by_pk",
                "assetUid", assetUid, "organisation", orgId));
        if (asset == null) {
            Error.PDM_ASSET_NOT_FOUND.format(ErrorMinorCode.PDMError002, fieldName
                    + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            exception.addConstraint(new NotFoundConstraint(odsMasterProps.getProperty(sheetName) + "." + fieldName,
                    Error.PDM_ASSET_NOT_FOUND.name(), fieldName + ProvisioningConstants.RECORD_NOT_FOUND_ERROR_MESSAGE,
                    assetUid));
            throw exception;
        }
        return asset;
    }

    protected void raiseSecExceptionForSheetUpload(Properties odsMasterProps, String sheetName, String locFieldName,
            String orgFieldName) throws ConstraintViolatedException {
        StringBuffer fieldName = new StringBuffer();
        fieldName.append(odsMasterProps.getProperty(sheetName));
        fieldName.append(ProvisioningConstants.DOT_CHAR);
        fieldName.append(locFieldName);
        fieldName.append(ProvisioningConstants.DOT_CHAR);
        fieldName.append(orgFieldName);
        ConstraintViolatedException exception = new ConstraintViolatedException();
        Error.PDM_SITE_PERMISSION_DENIED.format(ErrorMinorCode.PDMError005, ProvisioningConstants.PERMISSION_DENIED_ERROR_MESSAGE);
        exception.addConstraint(new SecurityCheckFailedConstraint(fieldName.toString(),
                Error.PDM_SITE_PERMISSION_DENIED.name(), ProvisioningConstants.PERMISSION_DENIED_ERROR_MESSAGE, this.getSheetRowId()));
        throw exception;
    }

}
