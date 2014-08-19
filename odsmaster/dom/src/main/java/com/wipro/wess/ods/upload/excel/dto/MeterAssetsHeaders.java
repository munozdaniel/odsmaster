package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MeterAssetsHeaders {
    ASSETNUM("MeterAsset.ASSETNUM"),
    DESCRIPTION("MeterAsset.DESCRIPTION"),
    TYPE("MeterAsset.TYPE"),
    SUBTYPE("MeterAsset.SUBTYPE"),
    PHYSICALLOCATION("MeterAsset.PHYSICALLOCATION"),
    MANUFACTURER("MeterAsset.MANUFACTURER"),
    MODEL("MeterAsset.MODEL"),
    VENDOR("MeterAsset.VENDOR"),
    INSTALLDATE("MeterAsset.INSTALLDATE"),
    SERIALNUM("MeterAsset.SERIALNUM"),
    ASSETTAG("MeterAsset.ASSETTAG"),
    YEARPURCHASED("MeterAsset.YEARPURCHASED"),
    LCE_FLAG("MeterAsset.LCE_FLAG"),
    METER_TYPE("MeterAsset.METER_TYPE"),
    LOCATION("MeterAsset.LOCATION"),
    PLUSPCUSTOMER("MeterAsset.PLUSPCUSTOMER"),
    SITEID("MeterAsset.SITEID"),
    ESTIMATION_ENABLED("MeterAsset.ESTIMATION_ENABLED");

    String header;

    public String getHeader() {
        return header;
    }

    MeterAssetsHeaders(String header) {
        this.header = header;
    }

    public static MeterAssetsHeaders getMeterAssetsHeaders(String header, Properties odsMasterProps) {
        MeterAssetsHeaders meterAssetsHeader = null;
        if (header != null) {
            header = header.trim();
            for (MeterAssetsHeaders meterAssetsHeadersItr : MeterAssetsHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(meterAssetsHeadersItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    meterAssetsHeader = meterAssetsHeadersItr;
                    break;
                }
            }
        }
        return meterAssetsHeader;
    }

}
