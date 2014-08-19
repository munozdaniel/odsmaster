package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum SiteDetailsHeaders {
    LOCATION("LOCATION"),
    CUSTOMER_SITE_CODE("CUSTOMER_SITE_CODE"),
    TERRITORY("TERRITORY"),
    DISTRICT("DISTRICT"),
    ZIP_CODE("ZIP_CODE"),
    AREA("AREA"),
    PROPERTY_TYPE("PROPERTY_TYPE"),
    NUMBER_OF_PEOPLE("NUMBER_OF_PEOPLE"),
    CLIMATE_ZONE("CLIMATE_ZONE"),
    ASHRAE_OAT_SET_POINT("ASHRAE_OAT_SET_POINT"),
    OAT_OFFSET_ADJ("OAT_OFFSET_ADJ"),
    OAT_OBJECT_UID("OAT_OBJECT_UID"),
    ECONOMIZER_THRESHOLD("ECONOMIZER_THRESHOLD"),
    UTILIZATION_HRS_THRESHOLD("UTILIZATION_HRS_THRESHOLD"),
    Time_Zone("Time_Zone"),
    TIMEZONE("TIMEZONE"),
    OPERATION_TYPE("OPERATION_TYPE"),
    LIGHTING_TYPE("LIGHTING_TYPE"),
    CUSTOMER_CONCEPT("CUSTOMER_CONCEPT"),
    CLASSIFICATION_CODE("CLASSIFICATION_CODE"),
    SITEID("SITEID"),
    DATA_AGG_NAME("DATA_AGG_NAME"),
    IP_ADDRESS("IP_ADDRESS"),
    PORT("PORT"),
    HVAC_TYPE("HVAC_TYPE"),
    LOAD_IMBALANCE_THRESHOLD("LOAD_IMBALANCE_THRESHOLD"),
    DOMAIN("DOMAIN"),
    POSTAL_ADDRESS("POSTAL_ADDRESS"),
    CITY("CITY"),
    STATE("STATE"),
    COUNTRY("COUNTRY"),
    ESPIKE_DAYNH_DAYAVG_UWM1("ESPIKE_DAYNH_DAYAVG_UWM1"),
    ESPIKE_DAYAH_DAYAVG_UWM1("ESPIKE_DAYAH_DAYAVG_UWM1"),
    ESPIKE_DAYPH_DAYAVG_UWM1("ESPIKE_DAYPH_DAYAVG_UWM1"),
    ESPIKE_DAYDL_DAYAVG_UWM1("ESPIKE_DAYDL_DAYAVG_UWM1"),
    ESPIKE_NIGHTNH_DAYAVG_UWM1("ESPIKE_NIGHTNH_DAYAVG_UWM1"),
    ESPIKE_NIGHTAH_DAYAVG_UWM1("ESPIKE_NIGHTAH_DAYAVG_UWM1"),
    ESPIKE_NIGHTPH_DAYAVG_UWM1("ESPIKE_NIGHTPH_DAYAVG_UWM1"),
    ESPIKE_NIGHTDL_DAYAVG_UWM1("ESPIKE_NIGHTDL_DAYAVG_UWM1"),
    NOAPERMISSIBLEDAYRUNHOUR_WEEKSUM_UWM1("NOAPERMISSIBLEDAYRUNHOUR_WEEKSUM_UWM1"),
    STATE_COOLOFF_PERIOD("STATE_COOLOFF_PERIOD");

    String header;

    public String getHeader() {
        return header;
    }

    SiteDetailsHeaders(String header) {
        this.header = header;
    }

    public static SiteDetailsHeaders getSiteDetailsHeader(String header, Properties odsMasterProps){
        SiteDetailsHeaders siteDetailsHeader = null;
        if (header != null) {
            header = header.trim();
            for (SiteDetailsHeaders siteHeaderItr : SiteDetailsHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(siteHeaderItr.getHeader());
                if (headerVal.equalsIgnoreCase(header)) {
                    siteDetailsHeader = siteHeaderItr;
                    break;
                }
            }

        }
        return siteDetailsHeader;
    }

}
