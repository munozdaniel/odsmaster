package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.ods.utils.StringUtil;
import com.wipro.wess.pdm.security.SecurityUtil;



public class ExcelSubAssets extends ExcelSupplierAssets{

    private String assetNum;

    private String description;

    private String type;

    private String subType;

    private String physicalLocation;

    private String ip;

    private String parent;

    private String manufacturer;

    private String model;

    private String vendor;

    private Date installDate;

    private String serialNumber;

    private String assetTag;

    private Date yearPurchased;

    private String lceFlag;

    private String lceParent;

    private String meterType;
    
    // Not to be filled for BBY
    private String parentMeter;

    private Double ratedConsumption;

    private Double specifiedRating1;

    private Double specifiedRating3;

    private String measureUnitId;

    private Double specifiedRating2;

    private String specifiedRating4;

    private String measureUnitId2;

    private String location;

    private String pluspCustomer;

    private String siteId;

    
    public ExcelSubAssets() {
        super();
    }


    public ExcelSubAssets(String assetNum, String description, String type, String subType, String physicalLocation,
            String ip, String parent, String manufacturer, String model, String vendor, Date installDate,
            String serialNumber, String assetTag, Date yearPurchased, String lceFlag, String lceParent,
            String meterType, String parentMeter, Double ratedConsumption, Double specifiedRating1,
            Double specifiedRating3, String measureUnitId, Double specifiedRating2, String specifiedRating4,
            String measureUnitId2, String location, String pluspCustomer, String siteId) {
        super();
        this.assetNum = assetNum;
        this.description = description;
        this.type = type;
        this.subType = subType;
        this.physicalLocation = physicalLocation;
        this.ip = ip;
        this.parent = parent;
        this.manufacturer = manufacturer;
        this.model = model;
        this.vendor = vendor;
        this.installDate = installDate;
        this.serialNumber = serialNumber;
        this.assetTag = assetTag;
        this.yearPurchased = yearPurchased;
        this.lceFlag = lceFlag;
        this.lceParent = lceParent;
        this.meterType = meterType;
        this.parentMeter = parentMeter;
        this.ratedConsumption = ratedConsumption;
        this.specifiedRating1 = specifiedRating1;
        this.specifiedRating3 = specifiedRating3;
        this.measureUnitId = measureUnitId;
        this.specifiedRating2 = specifiedRating2;
        this.specifiedRating4 = specifiedRating4;
        this.measureUnitId2 = measureUnitId2;
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

    
    public String getIp() {
        return ip;
    }

    
    public void setIp(String ip) {
        this.ip = ip;
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

    
    public String getLceParent() {
        return lceParent;
    }

    
    public void setLceParent(String lceParent) {
        this.lceParent = lceParent;
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

    
    public Double getRatedConsumption() {
        return ratedConsumption;
    }

    
    public void setRatedConsumption(Double ratedConsumption) {
        this.ratedConsumption = ratedConsumption;
    }

    
    public Double getSpecifiedRating1() {
        return specifiedRating1;
    }

    
    public void setSpecifiedRating1(Double specifiedRating1) {
        this.specifiedRating1 = specifiedRating1;
    }

    
    public Double getSpecifiedRating3() {
        return specifiedRating3;
    }

    
    public void setSpecifiedRating3(Double specifiedRating3) {
        this.specifiedRating3 = specifiedRating3;
    }

    
    public String getMeasureUnitId() {
        return measureUnitId;
    }

    
    public void setMeasureUnitId(String measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    
    public Double getSpecifiedRating2() {
        return specifiedRating2;
    }

    
    public void setSpecifiedRating2(Double specifiedRating2) {
        this.specifiedRating2 = specifiedRating2;
    }

    
    public String getSpecifiedRating4() {
        return specifiedRating4;
    }

    
    public void setSpecifiedRating4(String specifiedRating4) {
        this.specifiedRating4 = specifiedRating4;
    }

    
    public String getMeasureUnitId2() {
        return measureUnitId2;
    }

    
    public void setMeasureUnitId2(String measureUnitId2) {
        this.measureUnitId2 = measureUnitId2;
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
            Properties odsMasterProps) throws ConstraintViolatedException{
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            SubAssetsHeaders subAssetsHeaders = SubAssetsHeaders.getSubAssetsHeaders(headerVal, odsMasterProps);
            if(subAssetsHeaders != null){
                switch(subAssetsHeaders){
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
                    case IP:
                        if (valObj != null && valObj instanceof String) {
                            String ip = (String) valObj;
                            this.setIp(ip);
                        }
                        break;
                    case PARENT:
                        if (valObj != null && valObj instanceof String) {
                            String parent = (String) valObj;
                            this.setParent(parent);
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
                    case LCE_PARENT:
                        if (valObj != null && valObj instanceof String) {
                            String lceParent = (String) valObj;
                            this.setLceParent(lceParent);
                        }
                        break;
                    case METER_TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String meterType = (String) valObj;
                            this.setMeterType(meterType);
                        }
                        break;
                    case PARENT_METER:
                        if (valObj != null && valObj instanceof String) {
                            String parentMeter = (String) valObj;
                            this.setParentMeter(parentMeter);
                        }
                        break;
                    case RATED_CONSUMPTION:
                        if (valObj != null && valObj instanceof Double) {
                            Double ratedConsumption = (Double) valObj;
                            this.setRatedConsumption(ratedConsumption);
                        }
                        break;
                    case SPECIFIED_RATING_1:
                        if (valObj != null && valObj instanceof Double) {
                            Double specifiedRating1 = (Double) valObj;
                            this.setSpecifiedRating1(specifiedRating1);
                        }
                        break;
                    case SPECIFIED_RATING_3:
                        if (valObj != null && valObj instanceof Double) {
                            Double specifiedRating3 = (Double) valObj;
                            this.setSpecifiedRating3(specifiedRating3);
                        }
                        break;
                    case MEASUREUNITID:
                        if (valObj != null && valObj instanceof String) {
                            String measureUnitId = (String) valObj;
                            this.setMeasureUnitId(measureUnitId);
                        }
                        break;
                    case SPECIFIED_RATING_2:
                        if (valObj != null && valObj instanceof Double) {
                            Double specifiedRating2 = (Double) valObj;
                            this.setSpecifiedRating2(specifiedRating2);
                        }
                        break;
                    case MEASUREUNITID2:
                        if (valObj != null && valObj instanceof String) {
                            String measureUnitId2 = (String) valObj;
                            this.setMeasureUnitId2(measureUnitId2);
                        }
                        break;
                    case SPECIFIED_RATING_4:
                        if (valObj != null && valObj instanceof String) {
                            String specifiedRating4 = (String) valObj;
                            this.setSpecifiedRating4(specifiedRating4);
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
                this.raiseSecExceptionForSheetUpload(odsMasterProps, ProvisioningConstants.SUB_ASSET_SHEET,
                        ProvisioningConstants.LOCATION, ProvisioningConstants.SITEID);
            }
        }
    }
    


    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        if(this.getParent() != null){
            this.validateParent(odsMasterProps, isisJdocontainer, ProvisioningConstants.SUB_ASSET_SHEET);
        }
        this.processSupplierAsset(locationMap, odsMasterProps, isisJdocontainer, ProvisioningConstants.SUB_ASSET_SHEET);
    }


    @Override
    public String toString() {
        return "ExcelSubAssets [assetNum=" + assetNum + ", description=" + description + ", type=" + type
                + ", subType=" + subType + ", physicalLocation=" + physicalLocation + ", ip=" + ip + ", parent="
                + parent + ", manufacturer=" + manufacturer + ", model=" + model + ", vendor=" + vendor
                + ", installDate=" + installDate + ", serialNumber=" + serialNumber + ", assetTag=" + assetTag
                + ", yearPurchased=" + yearPurchased + ", lceFlag=" + lceFlag + ", lceParent=" + lceParent
                + ", meterType=" + meterType + ", parentMeter=" + parentMeter + ", ratedConsumption="
                + ratedConsumption + ", specifiedRating1=" + specifiedRating1 + ", specifiedRating3="
                + specifiedRating3 + ", measureUnitId=" + measureUnitId + ", specifiedRating2=" + specifiedRating2
                + ", specifiedRating4=" + specifiedRating4 + ", measureUnitId2=" + measureUnitId2 + ", location="
                + location + ", pluspCustomer=" + pluspCustomer + ", siteId=" + siteId + ", getSheetId()="
                + getSheetRowId() + "]";
    }
    
    
}
