package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum ScaHeaders {

    ASSETNUM("ASSETNUM"),
    DESCRIPTION("DESCRIPTION"),
    STATUS("STATUS"),
    TYPE("TYPE"),
    SUBTYPE("SUBTYPE"),
    CALENDAR("CALENDAR"),
    OPERATION_PERIOD("OPERATION_PERIOD"),
    HIGH_TEMPERATURE_CONFIG_VALUE("HIGH_TEMPERATURE_CONFIG_VALUE"),
    LOW_TEMPERATURE_CONFIG_VALUE("LOW_TEMPERATURE_CONFIG_VALUE"),
    HEATING_PROFILE_OFFSET("HEATING_PROFILE_OFFSET"),
    COOLING_PROFILE_OFFSET("COOLING_PROFILE_OFFSET"),
    OVERCOOLING_CONFIG("OVERCOOLING_CONFIG"),
    UNDERCOOLING_CONFIG("UNDERCOOLING_CONFIG"),
    ADJUSTABLE_TEMP_BAND("ADJUSTABLE_TEMP_BAND"),
    HIGH_HUMIDITY_CONFIG_VALUE("HIGH_HUMIDITY_CONFIG_VALUE"),
    LOW_HUMIDITY_CONFIG_VALUE("LOW_HUMIDITY_CONFIG_VALUE"),
    CO2LIMIT("CO2LIMIT"),
    SUB_OPTIMAL_THERMAL_PROFILE_DEVIATION_LIMIT("SUB_OPTIMAL_THERMAL_PROFILE_DEVIATION_LIMIT"),
    ILLUMINATION_HI_LIMIT_LUX("ILLUMINATION_HI_LIMIT_LUX"),
    ILLUMINATION_LOW_LIMIT_LUX("ILLUMINATION_LOW_LIMIT_LUX"),
    LOCATION("LOCATION"),
    PLUSPCUSTOMER("PLUSPCUSTOMER"),
    SITEID("SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    ScaHeaders(String header) {
        this.header = header;
    }

    public static ScaHeaders getScaHeaders(String header, Properties odsMasterProps) {
        ScaHeaders scaHeader = null;
        if (header != null) {
            header = header.trim();
            for (ScaHeaders scaHeaderItr : ScaHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(scaHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    scaHeader = scaHeaderItr;
                    break;
                }
            }
        }
        return scaHeader;
    }

}
