package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.upload.ProvisioningConstants;
import com.wipro.wess.pdm.security.SecurityUtil;
import com.wipro.wess.pdm.security.StringUtil;

public class ExcelSite extends ExcelSheet {

    String location;

    String customerSiteCode;

    Double territory;

    Double district;

    Double zipcode;

    Double area;

    String propertyType;

    Double numOfPeople;

    String climateZone;

    Double ashraeOatSetpoint;

    Double oatOffsetAdjust;

    String oatObjectUid;

    Double economizerThreshold;

    Double utilHoursThreshold;

    String timezone;

    String timeZoneNonDbFmt;

    String operationType;

    String lightingType;

    String customerConcept;

    String classificationCode;

    String siteId;

    String dataAggregatorName;

    String ipaddress;

    Double port;

    String hvacType;

    Double loadImbalThreshold;

    String domain;

    String sitePostalAddress;

    String city;

    String state;

    String country;

    Double espikeDayNormalHrsThr;

    Double espikeDayAfterHrsThr;

    Double espikeDayPartialHrsThr;

    Double espikeDayDemandHrsThr;

    Double espikeNightNormalHrsThr;

    Double espikeNightAfterHrsThr;

    Double espikeNightDemandHrsThr;

    Double espikeNightPartialHrsThr;

    Double noaPermissableRunHrsWeekly;

    Double stateCoolOffPeriod;

    public ExcelSite() {
        super();
    }

    public ExcelSite(String location, String customerSiteCode, Double territory, Double district, Double zipcode,
            Double area, String propertyType, Double numOfPeople, String climateZone, Double ashraeOatSetpoint,
            Double oatOffsetAdjust, String oatObjectUid, Double economizerThreshold, Double utilHoursThreshold,
            String timezone, String operationType, String lightingType, String customerConcept,
            String classificationCode, String siteId, String dataAggregatorName, String ipaddress, Double port,
            String hvacType, Double loadImbalThreshold, String domain, String sitePostalAddress, String city,
            String state, String country, Double espikeDayNormalHrsThr, Double espikeDayAfterHrsThr,
            Double espikeDayPartialHrsThr, Double espikeDayDemandHrsThr, Double espikeNightNormalHrsThr,
            Double espikeNightAfterHrsThr, Double espikeNightDemandHrsThr, Double espikeNightPartialHrsThr,
            Double noaPermissableRunHrsWeekly, Double stateCoolOffPeriod) {
        super();
        this.location = location;
        this.customerSiteCode = customerSiteCode;
        this.territory = territory;
        this.district = district;
        this.zipcode = zipcode;
        this.area = area;
        this.propertyType = propertyType;
        this.numOfPeople = numOfPeople;
        this.climateZone = climateZone;
        this.ashraeOatSetpoint = ashraeOatSetpoint;
        this.oatOffsetAdjust = oatOffsetAdjust;
        this.oatObjectUid = oatObjectUid;
        this.economizerThreshold = economizerThreshold;
        this.utilHoursThreshold = utilHoursThreshold;
        this.timezone = timezone;
        this.operationType = operationType;
        this.lightingType = lightingType;
        this.customerConcept = customerConcept;
        this.classificationCode = classificationCode;
        this.siteId = siteId;
        this.dataAggregatorName = dataAggregatorName;
        this.ipaddress = ipaddress;
        this.port = port;
        this.hvacType = hvacType;
        this.loadImbalThreshold = loadImbalThreshold;
        this.domain = domain;
        this.sitePostalAddress = sitePostalAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.espikeDayNormalHrsThr = espikeDayNormalHrsThr;
        this.espikeDayAfterHrsThr = espikeDayAfterHrsThr;
        this.espikeDayPartialHrsThr = espikeDayPartialHrsThr;
        this.espikeDayDemandHrsThr = espikeDayDemandHrsThr;
        this.espikeNightNormalHrsThr = espikeNightNormalHrsThr;
        this.espikeNightAfterHrsThr = espikeNightAfterHrsThr;
        this.espikeNightDemandHrsThr = espikeNightDemandHrsThr;
        this.espikeNightPartialHrsThr = espikeNightPartialHrsThr;
        this.noaPermissableRunHrsWeekly = noaPermissableRunHrsWeekly;
        this.stateCoolOffPeriod = stateCoolOffPeriod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCustomerSiteCode() {
        return customerSiteCode;
    }

    public void setCustomerSiteCode(String customerSiteCode) {
        this.customerSiteCode = customerSiteCode;
    }

    public Double getTerritory() {
        return territory;
    }

    public void setTerritory(Double territory) {
        this.territory = territory;
    }

    public Double getDistrict() {
        return district;
    }

    public void setDistrict(Double district) {
        this.district = district;
    }

    public Double getZipcode() {
        return zipcode;
    }

    public void setZipcode(Double zipcode) {
        this.zipcode = zipcode;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(Double numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getClimateZone() {
        return climateZone;
    }

    public void setClimateZone(String climateZone) {
        this.climateZone = climateZone;
    }

    public Double getAshraeOatSetpoint() {
        return ashraeOatSetpoint;
    }

    public void setAshraeOatSetpoint(Double ashraeOatSetpoint) {
        this.ashraeOatSetpoint = ashraeOatSetpoint;
    }

    public Double getOatOffsetAdjust() {
        return oatOffsetAdjust;
    }

    public void setOatOffsetAdjust(Double oatOffsetAdjust) {
        this.oatOffsetAdjust = oatOffsetAdjust;
    }

    public String getOatObjectUid() {
        return oatObjectUid;
    }

    public void setOatObjectUid(String oatObjectUid) {
        this.oatObjectUid = oatObjectUid;
    }

    public Double getEconomizerThreshold() {
        return economizerThreshold;
    }

    public void setEconomizerThreshold(Double economizerThreshold) {
        this.economizerThreshold = economizerThreshold;
    }

    public Double getUtilHoursThreshold() {
        return utilHoursThreshold;
    }

    public void setUtilHoursThreshold(Double utilHoursThreshold) {
        this.utilHoursThreshold = utilHoursThreshold;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimeZoneNonDbFmt() {
        return timeZoneNonDbFmt;
    }

    public void setTimeZoneNonDbFmt(String timeZoneNonDbFmt) {
        this.timeZoneNonDbFmt = timeZoneNonDbFmt;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getLightingType() {
        return lightingType;
    }

    public void setLightingType(String lightingType) {
        this.lightingType = lightingType;
    }

    public String getCustomerConcept() {
        return customerConcept;
    }

    public void setCustomerConcept(String customerConcept) {
        this.customerConcept = customerConcept;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getDataAggregatorName() {
        return dataAggregatorName;
    }

    public void setDataAggregatorName(String dataAggregatorName) {
        this.dataAggregatorName = dataAggregatorName;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Double getPort() {
        return port;
    }

    public void setPort(Double port) {
        this.port = port;
    }

    public String getHvacType() {
        return hvacType;
    }

    public void setHvacType(String hvacType) {
        this.hvacType = hvacType;
    }

    public Double getLoadImbalThreshold() {
        return loadImbalThreshold;
    }

    public void setLoadImbalThreshold(Double loadImbalThreshold) {
        this.loadImbalThreshold = loadImbalThreshold;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSitePostalAddress() {
        return sitePostalAddress;
    }

    public void setSitePostalAddress(String sitePostalAddress) {
        this.sitePostalAddress = sitePostalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getEspikeDayNormalHrsThr() {
        return espikeDayNormalHrsThr;
    }

    public void setEspikeDayNormalHrsThr(Double espikeDayNormalHrsThr) {
        this.espikeDayNormalHrsThr = espikeDayNormalHrsThr;
    }

    public Double getEspikeDayAfterHrsThr() {
        return espikeDayAfterHrsThr;
    }

    public void setEspikeDayAfterHrsThr(Double espikeDayAfterHrsThr) {
        this.espikeDayAfterHrsThr = espikeDayAfterHrsThr;
    }

    public Double getEspikeDayPartialHrsThr() {
        return espikeDayPartialHrsThr;
    }

    public void setEspikeDayPartialHrsThr(Double espikeDayPartialHrsThr) {
        this.espikeDayPartialHrsThr = espikeDayPartialHrsThr;
    }

    public Double getEspikeDayDemandHrsThr() {
        return espikeDayDemandHrsThr;
    }

    public void setEspikeDayDemandHrsThr(Double espikeDayDemandHrsThr) {
        this.espikeDayDemandHrsThr = espikeDayDemandHrsThr;
    }

    public Double getEspikeNightNormalHrsThr() {
        return espikeNightNormalHrsThr;
    }

    public void setEspikeNightNormalHrsThr(Double espikeNightNormalHrsThr) {
        this.espikeNightNormalHrsThr = espikeNightNormalHrsThr;
    }

    public Double getEspikeNightAfterHrsThr() {
        return espikeNightAfterHrsThr;
    }

    public void setEspikeNightAfterHrsThr(Double espikeNightAfterHrsThr) {
        this.espikeNightAfterHrsThr = espikeNightAfterHrsThr;
    }

    public Double getEspikeNightDemandHrsThr() {
        return espikeNightDemandHrsThr;
    }

    public void setEspikeNightDemandHrsThr(Double espikeNightDemandHrsThr) {
        this.espikeNightDemandHrsThr = espikeNightDemandHrsThr;
    }

    public Double getEspikeNightPartialHrsThr() {
        return espikeNightPartialHrsThr;
    }

    public void setEspikeNightPartialHrsThr(Double espikeNightPartialHrsThr) {
        this.espikeNightPartialHrsThr = espikeNightPartialHrsThr;
    }

    public Double getNoaPermissableRunHrsWeekly() {
        return noaPermissableRunHrsWeekly;
    }

    public void setNoaPermissableRunHrsWeekly(Double noaPermissableRunHrsWeekly) {
        this.noaPermissableRunHrsWeekly = noaPermissableRunHrsWeekly;
    }

    public Double getStateCoolOffPeriod() {
        return stateCoolOffPeriod;
    }

    public void setStateCoolOffPeriod(Double stateCoolOffPeriod) {
        this.stateCoolOffPeriod = stateCoolOffPeriod;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            SiteDetailsHeaders siteHeader = SiteDetailsHeaders.getSiteDetailsHeader(headerVal, odsMasterProps);
            if (siteHeader != null) {
                switch (siteHeader) {
                    case LOCATION:
                        if (valObj != null && valObj instanceof String) {
                            String location = (String) valObj;
                            this.setLocation(location);
                            this.setSheetRowId(location);
                        } else if (valObj != null && valObj instanceof Double) {
                            String location = ((Double) valObj) + "";
                            this.setSheetRowId(location);
                            this.setLocation(location);
                        }
                        break;
                    case CUSTOMER_SITE_CODE:
                        if (valObj != null && valObj instanceof String) {
                            String customerSiteCode = (String) valObj;
                            this.setCustomerSiteCode(customerSiteCode);
                        }
                        break;
                    case TERRITORY:
                        if (valObj != null && valObj instanceof Double) {
                            Double territory = (Double) valObj;
                            this.setTerritory(territory);
                        }
                        break;
                    case DISTRICT:
                        if (valObj != null && valObj instanceof Double) {
                            Double district = (Double) valObj;
                            this.setDistrict(district);
                        }
                        break;
                    case ZIP_CODE:
                        if (valObj != null && valObj instanceof Double) {
                            Double zipcode = (Double) valObj;
                            this.setZipcode(zipcode);
                        }
                        break;
                    case AREA:
                        if (valObj != null && valObj instanceof Double) {
                            Double area = (Double) valObj;
                            this.setArea(area);
                        }
                        break;
                    case PROPERTY_TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String propertyType = (String) valObj;
                            this.setPropertyType(propertyType);
                        }
                        break;
                    case NUMBER_OF_PEOPLE:
                        if (valObj != null && valObj instanceof Double) {
                            Double numOfPeople = (Double) valObj;
                            this.setNumOfPeople(numOfPeople);
                        }
                        break;
                    case CLIMATE_ZONE:
                        if (valObj != null && valObj instanceof String) {
                            String climateZone = (String) valObj;
                            this.setClimateZone(climateZone);
                        }
                        break;
                    case ASHRAE_OAT_SET_POINT:
                        if (valObj != null && valObj instanceof Double) {
                            Double ashraeOatSetpoint = (Double) valObj;
                            this.setAshraeOatSetpoint(ashraeOatSetpoint);
                        }
                        break;
                    case OAT_OFFSET_ADJ:
                        if (valObj != null && valObj instanceof Double) {
                            Double oatOffsetAdjust = (Double) valObj;
                            this.setOatOffsetAdjust(oatOffsetAdjust);
                        }
                        break;
                    case OAT_OBJECT_UID:
                        if (valObj != null && valObj instanceof String) {
                            String oatObjectUid = (String) valObj;
                            this.setOatObjectUid(oatObjectUid);
                        }
                        break;
                    case ECONOMIZER_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double economizerThreshold = (Double) valObj;
                            this.setEconomizerThreshold(economizerThreshold);
                        }
                        break;
                    case UTILIZATION_HRS_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double utilHoursThreshold = (Double) valObj;
                            this.setUtilHoursThreshold(utilHoursThreshold);
                        }
                        break;
                    case TIMEZONE:
                        if (valObj != null && valObj instanceof String) {
                            String timezone = (String) valObj;
                            this.setTimezone(timezone);
                        }
                        break;
                    case Time_Zone:
                        if (valObj != null && valObj instanceof String) {
                            String timezoneNonDbFmt = (String) valObj;
                            this.setTimeZoneNonDbFmt(timezoneNonDbFmt);
                        }
                        break;
                    case OPERATION_TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String operationType = (String) valObj;
                            this.setOperationType(operationType);
                        }
                        break;
                    case LIGHTING_TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String lightingType = (String) valObj;
                            this.setLightingType(lightingType);
                        }
                        break;
                    case CUSTOMER_CONCEPT:
                        if (valObj != null && valObj instanceof String) {
                            String customerConcept = (String) valObj;
                            this.setCustomerConcept(customerConcept);
                        }
                        break;
                    case CLASSIFICATION_CODE:
                        if (valObj != null && valObj instanceof String) {
                            String classificationCode = (String) valObj;
                            this.setClassificationCode(classificationCode);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
                        }
                        break;
                    case DATA_AGG_NAME:
                        if (valObj != null && valObj instanceof String) {
                            String dataAggregatorName = (String) valObj;
                            this.setDataAggregatorName(dataAggregatorName);
                        }
                        break;
                    case IP_ADDRESS:
                        if (valObj != null && valObj instanceof String) {
                            String ipaddress = (String) valObj;
                            this.setIpaddress(ipaddress);
                        }
                        break;
                    case PORT:
                        if (valObj != null && valObj instanceof Double) {
                            Double port = (Double) valObj;
                            this.setPort(port);
                        }
                        break;
                    case HVAC_TYPE:
                        if (valObj != null && valObj instanceof String) {
                            String hvacType = (String) valObj;
                            this.setHvacType(hvacType);
                        }
                        break;
                    case LOAD_IMBALANCE_THRESHOLD:
                        if (valObj != null && valObj instanceof Double) {
                            Double loadImbalThreshold = (Double) valObj;
                            this.setLoadImbalThreshold(loadImbalThreshold);
                        }
                        break;
                    case DOMAIN:
                        if (valObj != null && valObj instanceof String) {
                            String domain = (String) valObj;
                            this.setDomain(domain);
                        }
                        break;
                    case POSTAL_ADDRESS:
                        if (valObj != null && valObj instanceof String) {
                            String sitePostalAddress = (String) valObj;
                            this.setSitePostalAddress(sitePostalAddress);
                        }
                        break;
                    case CITY:
                        if (valObj != null && valObj instanceof String) {
                            String city = (String) valObj;
                            this.setCity(city);
                        }
                        break;
                    case STATE:
                        if (valObj != null && valObj instanceof String) {
                            String state = (String) valObj;
                            this.setState(state);
                        }
                        break;
                    case COUNTRY:
                        if (valObj != null && valObj instanceof String) {
                            String country = (String) valObj;
                            this.setCountry(country);
                        }
                        break;
                    case ESPIKE_DAYNH_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeDayNormalHrsThr = (Double) valObj;
                            this.setEspikeDayNormalHrsThr(espikeDayNormalHrsThr);
                        }
                        break;
                    case ESPIKE_DAYAH_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeDayAfterHrsThr = (Double) valObj;
                            this.setEspikeDayAfterHrsThr(espikeDayAfterHrsThr);
                        }
                        break;
                    case ESPIKE_DAYPH_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeDayPartialHrsThr = (Double) valObj;
                            this.setEspikeDayPartialHrsThr(espikeDayPartialHrsThr);
                        }
                        break;
                    case ESPIKE_DAYDL_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeDayDemandHrsThr = (Double) valObj;
                            this.setEspikeDayDemandHrsThr(espikeDayDemandHrsThr);
                        }
                        break;
                    case ESPIKE_NIGHTNH_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeNightNormalHrsThr = (Double) valObj;
                            this.setEspikeNightNormalHrsThr(espikeNightNormalHrsThr);
                        }
                        break;
                    case ESPIKE_NIGHTAH_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeNightAfterHrsThr = (Double) valObj;
                            this.setEspikeNightAfterHrsThr(espikeNightAfterHrsThr);
                        }
                        break;
                    case ESPIKE_NIGHTPH_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeNightPartialHrsThr = (Double) valObj;
                            this.setEspikeNightPartialHrsThr(espikeNightPartialHrsThr);
                        }
                        break;
                    case ESPIKE_NIGHTDL_DAYAVG_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double espikeNightDemandHrsThr = (Double) valObj;
                            this.setEspikeNightDemandHrsThr(espikeNightDemandHrsThr);
                        }
                        break;
                    case NOAPERMISSIBLEDAYRUNHOUR_WEEKSUM_UWM1:
                        if (valObj != null && valObj instanceof Double) {
                            Double noaPermissableRunHrsWeekly = (Double) valObj;
                            this.setNoaPermissableRunHrsWeekly(noaPermissableRunHrsWeekly);
                        }
                        break;
                    case STATE_COOLOFF_PERIOD:
                        if (valObj != null && valObj instanceof Double) {
                            Double stateCoolOffPeriod = (Double) valObj;
                            this.setStateCoolOffPeriod(stateCoolOffPeriod);
                        }
                        break;
                }
            }

        }

    }

    @Override
    public String toString() {
        return "ExcelSite [location=" + location + ", customerSiteCode=" + customerSiteCode + ", territory="
                + territory + ", district=" + district + ", zipcode=" + zipcode + ", area=" + area + ", propertyType="
                + propertyType + ", numOfPeople=" + numOfPeople + ", climateZone=" + climateZone
                + ", ashraeOatSetpoint=" + ashraeOatSetpoint + ", oatOffsetAdjust=" + oatOffsetAdjust
                + ", oatObjectUid=" + oatObjectUid + ", economizerThreshold=" + economizerThreshold
                + ", utilHoursThreshold=" + utilHoursThreshold + ", timezone=" + timezone + ", timeZoneNonDbFmt="
                + timeZoneNonDbFmt + ", operationType=" + operationType + ", lightingType=" + lightingType
                + ", customerConcept=" + customerConcept + ", classificationCode=" + classificationCode + ", siteId="
                + siteId + ", dataAggregatorName=" + dataAggregatorName + ", ipaddress=" + ipaddress + ", port=" + port
                + ", hvacType=" + hvacType + ", loadImbalThreshold=" + loadImbalThreshold + ", domain=" + domain
                + ", sitePostalAddress=" + sitePostalAddress + ", city=" + city + ", state=" + state + ", country="
                + country + ", espikeDayNormalHrsThr=" + espikeDayNormalHrsThr + ", espikeDayAfterHrsThr="
                + espikeDayAfterHrsThr + ", espikeDayPartialHrsThr=" + espikeDayPartialHrsThr
                + ", espikeDayDemandHrsThr=" + espikeDayDemandHrsThr + ", espikeNightNormalHrsThr="
                + espikeNightNormalHrsThr + ", espikeNightAfterHrsThr=" + espikeNightAfterHrsThr
                + ", espikeNightDemandHrsThr=" + espikeNightDemandHrsThr + ", espikeNightPartialHrsThr="
                + espikeNightPartialHrsThr + ", noaPermissableRunHrsWeekly=" + noaPermissableRunHrsWeekly
                + ", stateCoolOffPeriod=" + stateCoolOffPeriod + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
