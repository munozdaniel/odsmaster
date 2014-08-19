package com.wipro.wess.ods.upload.excel.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.asset.OmAssetExtendedAttr;
import com.wipro.wess.ods.asset.OmSupplierAssetConfig;
import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utils.StringUtil;
import com.wipro.wess.pdm.security.SecurityUtil;

public class ExcelSupplierSystem extends ExcelSheet {

    private String assetNum;

    private String description;

    private String type;

    private String subType;

    private String physicalLocation;

    private String systemRedundancy;

    private Double activeComponents;

    private Double redundantComponents;

    private String sharedOutputSystem;

    private String afterHrsFlag;

    private Double sysAvailThreshold;

    private Double lossThreshold;

    private Double overUtilThreshold;

    private Double underUtilThreshold;

    private Double phaseLoadImbalThreshold;

    private String location;

    private String pluspCustomer;

    private String siteId;

    private String parent;

    private String manufacturer;

    private String model;

    private String vendor;

    private Date installDate;

    public ExcelSupplierSystem() {
        super();
    }

    public ExcelSupplierSystem(String assetNum, String description, String type, String subType,
            String physicalLocation, String systemRedundancy, Double activeComponents, Double redundantComponents,
            String sharedOutputSystem, String afterHrsFlag, Double sysAvailThreshold, Double lossThreshold,
            Double overUtilThreshold, Double underUtilThreshold, Double phaseLoadImbalThreshold, String location,
            String pluspCustomer, String siteId) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.type = type;
        this.subType = subType;
        this.physicalLocation = physicalLocation;
        this.systemRedundancy = systemRedundancy;
        this.activeComponents = activeComponents;
        this.redundantComponents = redundantComponents;
        this.sharedOutputSystem = sharedOutputSystem;
        this.afterHrsFlag = afterHrsFlag;
        this.sysAvailThreshold = sysAvailThreshold;
        this.lossThreshold = lossThreshold;
        this.overUtilThreshold = overUtilThreshold;
        this.underUtilThreshold = underUtilThreshold;
        this.phaseLoadImbalThreshold = phaseLoadImbalThreshold;
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

    public String getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    public String getSystemRedundancy() {
        return systemRedundancy;
    }

    public void setSystemRedundancy(String systemRedundancy) {
        this.systemRedundancy = systemRedundancy;
    }

    public Double getActiveComponents() {
        return activeComponents;
    }

    public void setActiveComponents(Double activeComponents) {
        this.activeComponents = activeComponents;
    }

    public Double getRedundantComponents() {
        return redundantComponents;
    }

    public void setRedundantComponents(Double redundantComponents) {
        this.redundantComponents = redundantComponents;
    }

    public String getSharedOutputSystem() {
        return sharedOutputSystem;
    }

    public void setSharedOutputSystem(String sharedOutputSystem) {
        this.sharedOutputSystem = sharedOutputSystem;
    }

    public String getAfterHrsFlag() {
        return afterHrsFlag;
    }

    public void setAfterHrsFlag(String afterHrsFlag) {
        this.afterHrsFlag = afterHrsFlag;
    }

    public Double getSysAvailThreshold() {
        return sysAvailThreshold;
    }

    public void setSysAvailThreshold(Double sysAvailThreshold) {
        this.sysAvailThreshold = sysAvailThreshold;
    }

    public Double getLossThreshold() {
        return lossThreshold;
    }

    public void setLossThreshold(Double lossThreshold) {
        this.lossThreshold = lossThreshold;
    }

    public Double getOverUtilThreshold() {
        return overUtilThreshold;
    }

    public void setOverUtilThreshold(Double overUtilThreshold) {
        this.overUtilThreshold = overUtilThreshold;
    }

    public Double getUnderUtilThreshold() {
        return underUtilThreshold;
    }

    public void setUnderUtilThreshold(Double underUtilThreshold) {
        this.underUtilThreshold = underUtilThreshold;
    }

    public Double getPhaseLoadImbalThreshold() {
        return phaseLoadImbalThreshold;
    }

    public void setPhaseLoadImbalThreshold(Double phaseLoadImbalThreshold) {
        this.phaseLoadImbalThreshold = phaseLoadImbalThreshold;
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

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException{
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            SupplierSystemHeaders supplierSystemHeaders = SupplierSystemHeaders.getSupplierSystemHeaders(headerVal,
                    odsMasterProps);
            if (supplierSystemHeaders != null) {
                switch (supplierSystemHeaders) {
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
                    case SYSTEM_REDUNDANCY:
                        if (valObj != null && valObj instanceof String) {
                            String systemRedundancy = (String) valObj;
                            this.setSystemRedundancy(systemRedundancy);
                        }
                        break;
                    case ACTIVE_COMPONENTS:
                        if (valObj != null && valObj instanceof Double) {
                            Double activeComponents = (Double) valObj;
                            this.setActiveComponents(activeComponents);
                        }
                        break;
                    case REDUNDANT_COMPONENTS:
                        if (valObj != null && valObj instanceof Double) {
                            Double redundantComponents = (Double) valObj;
                            this.setRedundantComponents(redundantComponents);
                        }
                        break;
                    case SHARED_OUTPUT_SYSTEM:
                        if (valObj != null && valObj instanceof String) {
                            String sharedOutputSystem = (String) valObj;
                            this.setSharedOutputSystem(sharedOutputSystem);
                        }
                        break;
                    case AFTERHRS_FLAG:
                        if (valObj != null && valObj instanceof String) {
                            String afterHrsFlag = (String) valObj;
                            this.setAfterHrsFlag(afterHrsFlag);
                        }
                        break;
                    case SYSTEM_AVAILABILITY_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double sysAvailThreshold = (Double) valObj;
                            this.setSysAvailThreshold(sysAvailThreshold);
                        }
                        break;
                    case LOSS_THRESOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double lossThreshold = (Double) valObj;
                            this.setLossThreshold(lossThreshold);
                        }
                        break;
                    case OVER_UTILIZATION_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double overUtilThreshold = (Double) valObj;
                            this.setOverUtilThreshold(overUtilThreshold);
                        }
                        break;
                    case UNDER_UTILIZATION_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double underUtilThreshold = (Double) valObj;
                            this.setUnderUtilThreshold(underUtilThreshold);
                        }
                        break;
                    case PHASE_LOAD_IMBALANCE_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double phaseLoadImbalThreshold = (Double) valObj;
                            this.setPhaseLoadImbalThreshold(phaseLoadImbalThreshold);
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
        if(StringUtil.isNotEmpty(this.getSheetRowId()) && StringUtil.isNotEmpty(this.getLocation()) && StringUtil.isNotEmpty(this.getSiteId())){
            boolean updateSitePermitted  = SecurityUtil.checkSitePermission(this.getSiteId(), this.getLocation());
            if (!updateSitePermitted) {
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.SUPPL_SYS_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.processSupplierAsset(locationMap, odsMasterProps, isisJdocontainer, ProvisioningConstants.SUPPL_SYS_SHEET);
    }

    protected void processSupplierAsset(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap,
            Properties odsMasterProps, DomainObjectContainer isisJdocontainer, String sheetName)
            throws ConstraintViolatedException {
        this.validate(odsMasterProps, sheetName);
        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(),
                odsMasterProps.getProperty(sheetName));
        OmSupplierAssetConfig supplierAssetConfig = isisJdocontainer
                .firstMatch(new QueryDefault<OmSupplierAssetConfig>(OmSupplierAssetConfig.class,
                        "fetch_OmSupplierAssetConfig_by_pk", "supAssetUid", this.getAssetNum()));
        if (supplierAssetConfig == null) {
            supplierAssetConfig = isisJdocontainer.newTransientInstance(OmSupplierAssetConfig.class);
            supplierAssetConfig.setSupAssetUid(this.getAssetNum());
            supplierAssetConfig.setOmSite(site);
            //supplierAssetConfig.setMOrganisation(site.getOrgId());
        }
        supplierAssetConfig.setAfterHrsFlag(this.getAfterHrsFlag());
        supplierAssetConfig.setSupAssetDesc(this.getDescription());
        supplierAssetConfig.setSupAssetType(this.getSubType());
        supplierAssetConfig.setParentSupAssetUid(this.getParent());
        isisJdocontainer.persistIfNotAlready(supplierAssetConfig);
        this.processAsset(isisJdocontainer, locationMap, odsMasterProps, sheetName);
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
        isisJdocontainer.persistIfNotAlready(asset);
        this.processAssetExtendedAttr(asset, isisJdocontainer, locationMap, odsMasterProps);

    }

    protected void processAssetExtendedAttr(OmAsset asset, DomainObjectContainer isisJdocontainer,
            Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps)
            throws ConstraintViolatedException {
        OmSite site = this.lookUpSite(isisJdocontainer, locationMap, this.getLocation(), this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.SUPPL_SYS_SHEET));        
        if (this.getActiveComponents() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.ACTIVE_COMPNENTS, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.ACTIVE_COMPNENTS,
                    new BigDecimal(this.getActiveComponents()));
        }
        if (this.getRedundantComponents() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.REDUNDANT_COMPNENTS, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.REDUNDANT_COMPNENTS,
                    new BigDecimal(this.getRedundantComponents()));
        }
        if (this.getSysAvailThreshold() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.SYS_AVAIL_THRESHOLD, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.SYS_AVAIL_THRESHOLD,
                    new BigDecimal(this.getSysAvailThreshold()));
        }
        if (this.getLossThreshold() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.LOSS_THRESHOLD, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.LOSS_THRESHOLD,
                    new BigDecimal(this.getLossThreshold()));
        }
        if (this.getOverUtilThreshold() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.OVER_UTIL_THRESHOLD, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.OVER_UTIL_THRESHOLD,
                    new BigDecimal(this.getOverUtilThreshold()));
        }
        if (this.getUnderUtilThreshold() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.UNDER_UTIL_THRESHOLD, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.UNDER_UTIL_THRESHOLD,
                    new BigDecimal(this.getUnderUtilThreshold()));
        }
        if (this.getPhaseLoadImbalThreshold() != null) {
            OmAssetExtendedAttr assetExtendedAttr = this.queryAssetExtendedAttr(site,
                    ProvisioningConstants.PLI_THRESHOLD, isisJdocontainer);
            assetExtendedAttr.process(asset, site, ProvisioningConstants.PLI_THRESHOLD,
                    new BigDecimal(this.getPhaseLoadImbalThreshold()));
        }

        /*
         * boolean activeComponents = false; boolean redundantComponents = false; boolean sysAvailThreshold = false;
         * boolean lossThreshold = false; boolean overUtilThreshold = false; boolean underUtilThreshold = false; boolean
         * phaseLoadImbalThreshold = false; if (this.getActiveComponents() != null || this.getRedundantComponents() !=
         * null || this.getSysAvailThreshold() != null || this.getLossThreshold() != null || this.getOverUtilThreshold()
         * != null || this.getUnderUtilThreshold() != null || this.getPhaseLoadImbalThreshold() != null) {
         * Set<OmAssetExtendedAttr> omAssetExtendedAttrs = asset.getOmAssetExtendedAttrs(); for (OmAssetExtendedAttr
         * assetExtendedAttr : omAssetExtendedAttrs) { if
         * (assetExtendedAttr.getParamName().equalsIgnoreCase(ProvisioningConstants.ACTIVE_COMPNENTS)) {
         * activeComponents = true; assetExtendedAttr.setNumValue((this.getActiveComponents() != null ? new
         * BigDecimal(this .getActiveComponents()) : null)); } else if
         * (assetExtendedAttr.getParamName().equalsIgnoreCase(ProvisioningConstants.REDUNDANT_COMPNENTS)) {
         * redundantComponents = true; assetExtendedAttr.setNumValue((this.getRedundantComponents() != null ? new
         * BigDecimal(this .getRedundantComponents()) : null)); } else if
         * (assetExtendedAttr.getParamName().equalsIgnoreCase(ProvisioningConstants.SYS_AVAIL_THRESHOLD)) {
         * sysAvailThreshold = true; assetExtendedAttr.setNumValue((this.getSysAvailThreshold() != null ? new
         * BigDecimal(this .getSysAvailThreshold()) : null)); } else if
         * (assetExtendedAttr.getParamName().equalsIgnoreCase(ProvisioningConstants.LOSS_THRESHOLD)) { lossThreshold =
         * true; assetExtendedAttr.setNumValue((this.getLossThreshold() != null ? new BigDecimal(this
         * .getLossThreshold()) : null)); } else if
         * (assetExtendedAttr.getParamName().equalsIgnoreCase(ProvisioningConstants.OVER_UTIL_THRESHOLD)) {
         * overUtilThreshold = true; assetExtendedAttr.setNumValue((this.getOverUtilThreshold() != null ? new
         * BigDecimal(this .getOverUtilThreshold()) : null)); } else if (assetExtendedAttr.getParamName()
         * .equalsIgnoreCase(ProvisioningConstants.UNDER_UTIL_THRESHOLD)) { underUtilThreshold = true;
         * assetExtendedAttr.setNumValue((this.getUnderUtilThreshold() != null ? new BigDecimal(this
         * .getUnderUtilThreshold()) : null)); } else if
         * (assetExtendedAttr.getParamName().equalsIgnoreCase(ProvisioningConstants.PLI_THRESHOLD)) {
         * phaseLoadImbalThreshold = true; assetExtendedAttr.setNumValue((this.getPhaseLoadImbalThreshold() != null ?
         * new BigDecimal(this .getPhaseLoadImbalThreshold()) : null)); } } if(!activeComponents &&
         * this.getActiveComponents() != null){ OmAssetExtendedAttr assetExtendedAttr =
         * isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class); assetExtendedAttr.process(asset, site,
         * ProvisioningConstants.ACTIVE_COMPNENTS, new BigDecimal(this.getActiveComponents()));
         * omAssetExtendedAttrs.add(assetExtendedAttr); } if(!redundantComponents && this.getRedundantComponents() !=
         * null){ OmAssetExtendedAttr assetExtendedAttr =
         * isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class); assetExtendedAttr.process(asset, site,
         * ProvisioningConstants.REDUNDANT_COMPNENTS, new BigDecimal(this.getRedundantComponents()));
         * omAssetExtendedAttrs.add(assetExtendedAttr); } if(!sysAvailThreshold && this.getSysAvailThreshold() != null){
         * OmAssetExtendedAttr assetExtendedAttr = isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class);
         * assetExtendedAttr.process(asset, site, ProvisioningConstants.SYS_AVAIL_THRESHOLD, new
         * BigDecimal(this.getSysAvailThreshold())); omAssetExtendedAttrs.add(assetExtendedAttr); } if(!lossThreshold &&
         * this.getLossThreshold() != null){ OmAssetExtendedAttr assetExtendedAttr =
         * isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class); assetExtendedAttr.process(asset, site,
         * ProvisioningConstants.LOSS_THRESHOLD, new BigDecimal(this.getLossThreshold()));
         * omAssetExtendedAttrs.add(assetExtendedAttr); } if(!overUtilThreshold && this.getOverUtilThreshold() != null){
         * OmAssetExtendedAttr assetExtendedAttr = isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class);
         * assetExtendedAttr.process(asset, site, ProvisioningConstants.OVER_UTIL_THRESHOLD, new
         * BigDecimal(this.getOverUtilThreshold())); omAssetExtendedAttrs.add(assetExtendedAttr); }
         * if(!underUtilThreshold && this.getUnderUtilThreshold() != null){ OmAssetExtendedAttr assetExtendedAttr =
         * isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class); assetExtendedAttr.process(asset, site,
         * ProvisioningConstants.UNDER_UTIL_THRESHOLD, new BigDecimal(this.getUnderUtilThreshold()));
         * omAssetExtendedAttrs.add(assetExtendedAttr); } if(!phaseLoadImbalThreshold &&
         * this.getPhaseLoadImbalThreshold() != null){ OmAssetExtendedAttr assetExtendedAttr =
         * isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class); assetExtendedAttr.process(asset, site,
         * ProvisioningConstants.PLI_THRESHOLD, new BigDecimal(this.getPhaseLoadImbalThreshold()));
         * omAssetExtendedAttrs.add(assetExtendedAttr); } }
         */

    }

    protected OmAssetExtendedAttr queryAssetExtendedAttr(OmSite site, String paramName,
            DomainObjectContainer isisJdocontainer) {
        OmAssetExtendedAttr assetExtendedAttr = isisJdocontainer.firstMatch(new QueryDefault<OmAssetExtendedAttr>(
                OmAssetExtendedAttr.class, "fetch_OmAssetExtendedAttr_by_pk", "assetId", this.getAssetNum(), "site",
                site, "paramName", paramName));
        if (assetExtendedAttr == null) {
            assetExtendedAttr = isisJdocontainer.newTransientInstance(OmAssetExtendedAttr.class);
        }
        return assetExtendedAttr;
    }

    private void validate(Properties odsMasterProps, String sheetName) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(sheetName));
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
            fieldName.append(odsMasterProps.getProperty(sheetName));
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
        return "ExcelSupplierSystem [assetNum=" + assetNum + ", description=" + description + ", type=" + type
                + ", subType=" + subType + ", physicalLocation=" + physicalLocation + ", systemRedundancy="
                + systemRedundancy + ", activeComponents=" + activeComponents + ", redundantComponents="
                + redundantComponents + ", sharedOutputSystem=" + sharedOutputSystem + ", afterHrsFlag=" + afterHrsFlag
                + ", sysAvailThreshold=" + sysAvailThreshold + ", lossThreshold=" + lossThreshold
                + ", overUtilThreshold=" + overUtilThreshold + ", underUtilThreshold=" + underUtilThreshold
                + ", phaseLoadImbalThreshold=" + phaseLoadImbalThreshold + ", location=" + location
                + ", pluspCustomer=" + pluspCustomer + ", siteId=" + siteId + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
