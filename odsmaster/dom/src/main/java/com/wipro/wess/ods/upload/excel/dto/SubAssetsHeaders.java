package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;


public enum SubAssetsHeaders {
    ASSETNUM("SubAssets.ASSETNUM"),
    DESCRIPTION("SubAssets.DESCRIPTION"),
    TYPE("SubAssets.TYPE"),
    SUBTYPE("SubAssets.SUBTYPE"),
    PHYSICALLOCATION("SubAssets.PHYSICALLOCATION"),
    IP("SubAssets.IP"),
    PARENT("SubAssets.PARENT"),
    MANUFACTURER("SubAssets.MANUFACTURER"),
    MODEL("SubAssets.MODEL"),
    VENDOR("SubAssets.VENDOR"),
    INSTALLDATE("SubAssets.INSTALLDATE"),
    SERIALNUM("SubAssets.SERIALNUM"),
    ASSETTAG("SubAssets.ASSETTAG"),
    YEARPURCHASED("SubAssets.YEARPURCHASED"),    
    LCE_FLAG("SubAssets.LCE_FLAG"),
    LCE_PARENT("SubAssets.LCE_PARENT"),
    METER_TYPE("SubAssets.METER_TYPE"),
    PARENT_METER("SubAssets.PARENT_METER"),
    RATED_CONSUMPTION("SubAssets.RATED_CONSUMPTION"),
    SPECIFIED_RATING_1("SubAssets.SPECIFIED_RATING_1"),
    SPECIFIED_RATING_3("SubAssets.SPECIFIED_RATING_3"),
    MEASUREUNITID("SubAssets.MEASUREUNITID"),
    SPECIFIED_RATING_2("SubAssets.SPECIFIED_RATING_2"),
    SPECIFIED_RATING_4("SubAssets.SPECIFIED_RATING_4"),
    MEASUREUNITID2("SubAssets.MEASUREUNITID2"),
    LOCATION("SubAssets.LOCATION"),
    PLUSPCUSTOMER("SubAssets.PLUSPCUSTOMER"),
    SITEID("SubAssets.SITEID");

    String header;

    
    public String getHeader() {
        return header;
    }
    
    
    SubAssetsHeaders(String header) {
        this.header = header;
    }
    
    public static SubAssetsHeaders getSubAssetsHeaders(String header, Properties odsMasterProps){
        SubAssetsHeaders subAssetsHeader = null;
        if (header != null) {
            header = header.trim();
            for (SubAssetsHeaders subAssetsHeadersItr : SubAssetsHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(subAssetsHeadersItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    subAssetsHeader = subAssetsHeadersItr;
                    break;
                }
            }
        }
        return subAssetsHeader;
    }

}
