package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum UtilityMeterHeaders {
    ASSETNUM("ASSETNUM"),
    DESCRIPTION("DESCRIPTION"),
    SUPPLIERCODE("SUPPLIERCODE"),
    MAPPING("MAPPING"),
    UOM("UOM"),
    TYPE("TYPE"),
    SUBTYPE("SUBTYPE"),
    FUNCTYPE("FUNCTYPE"),
    LOCATION("LOCATION"),
    PLUSPCUSTOMER("PLUSPCUSTOMER"),
    SITEID("SITEID"),
    SUPPLIER_UTILITY_METER_ID("SUPPLIER_UTILITY_METER_ID");

    String header;

    public String getHeader() {
        return header;
    }

    UtilityMeterHeaders(String header) {
        this.header = header;
    }
    
    public static UtilityMeterHeaders getUtilityMeterHeaders(String header, Properties odsMasterProps){
        UtilityMeterHeaders utilityMeterHeader = null;
        if (header != null) {
            header = header.trim();
            for(UtilityMeterHeaders utilityMeterHeaderItr : UtilityMeterHeaders.values()){
                String headerVal = odsMasterProps.getProperty(utilityMeterHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    utilityMeterHeader = utilityMeterHeaderItr;
                    break;
                }
            }
        }
        return utilityMeterHeader;
    }

}
