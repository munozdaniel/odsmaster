package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum ControlAssetsHeaders {
    ASSETNUM("ControlAsset.ASSETNUM"),
    DESCRIPTION("ControlAsset.DESCRIPTION"),
    TYPE("ControlAsset.TYPE"),
    SUBTYPE("ControlAsset.SUBTYPE"),
    PHYSICALLOCATION("ControlAsset.PHYSICALLOCATION"),
    MANUFACTURER("ControlAsset.MANUFACTURER"),
    MODEL("ControlAsset.MODEL"),
    VENDOR("ControlAsset.VENDOR"),
    INSTALLDATE("ControlAsset.INSTALLDATE"),
    SERIALNUM("ControlAsset.SERIALNUM"),
    YEARPURCHASED("ControlAsset.YEARPURCHASED"),
    IP("ControlAsset.IP"),
    LOCATION("ControlAsset.LOCATION"),
    PLUSPCUSTOMER("ControlAsset.PLUSPCUSTOMER"),
    SITEID("ControlAsset.SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    ControlAssetsHeaders(String header) {
        this.header = header;
    }

    public static ControlAssetsHeaders getControlAssetsHeaders(String header, Properties odsMasterProps) {
        ControlAssetsHeaders controlAssetsHeader = null;
        if (header != null) {
            header = header.trim();
            for (ControlAssetsHeaders controlAssetsHeadersItr : ControlAssetsHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(controlAssetsHeadersItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    controlAssetsHeader = controlAssetsHeadersItr;
                    break;
                }
            }
        }
        return controlAssetsHeader;
    }

}
