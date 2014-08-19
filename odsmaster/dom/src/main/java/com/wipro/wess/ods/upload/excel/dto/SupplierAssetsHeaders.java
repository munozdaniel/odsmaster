package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;


public enum SupplierAssetsHeaders {
    ASSETNUM("ASSETNUM"),
    DESCRIPTION("DESCRIPTION"),
    TYPE("TYPE"),
    SUBTYPE("SUBTYPE"),
    PHYSICALLOCATION("PHYSICALLOCATION"),
    PARENT("PARENT"),
    MANUFACTURER("MANUFACTURER"),
    MODEL("MODEL"),
    VENDOR("VENDOR"),
    INSTALLDATE("INSTALLDATE"),
    SERIALNUM("SERIALNUM"),
    ASSETTAG("ASSETTAG"),
    YEARPURCHASED("YEARPURCHASED"),
    IP("IP"),
    LCE_FLAG("LCE_FLAG"),
    LCE_PARENT("LCE_PARENT"),
    METER_TYPE("METER_TYPE"),
    PARENT_METER("PARENT_METER"),
    RATED_CONSUMPTION("RATED_CONSUMPTION"),
    SPECIFIED_RATING_1("SPECIFIED_RATING_1"),
    SPECIFIED_RATING_3("SPECIFIED_RATING_3"),
    MEASUREUNITID("MEASUREUNITID"),
    SPECIFIED_RATING_2("SPECIFIED_RATING_2"),
    SPECIFIED_RATING_4("SPECIFIED_RATING_4"),
    MEASUREUNITID2("MEASUREUNITID2"),
    LOCATION("LOCATION"),
    PLUSPCUSTOMER("PLUSPCUSTOMER"),
    SITEID("SITEID");

    String header;

    
    public String getHeader() {
        return header;
    }
    
    
    SupplierAssetsHeaders(String header) {
        this.header = header;
    }
    
    public static SupplierAssetsHeaders getSupplierAssetsHeaders(String header, Properties odsMasterProps){
        SupplierAssetsHeaders supplierAssetsHeaders = null;
        if (header != null) {
            header = header.trim();
            for (SupplierAssetsHeaders supplierAssetsHeadersItr : SupplierAssetsHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(supplierAssetsHeadersItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    supplierAssetsHeaders = supplierAssetsHeadersItr;
                    break;
                }
            }
        }
        return supplierAssetsHeaders;
    }

}
