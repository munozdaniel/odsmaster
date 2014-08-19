package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MonitorAssetsHeaders {
    ASSETNUM("MonitorAsset.ASSETNUM"),
    DESCRIPTION("MonitorAsset.DESCRIPTION"),
    TYPE("MonitorAsset.TYPE"),
    SUBTYPE("MonitorAsset.SUBTYPE"),
    PHYSICALLOCATION("MonitorAsset.PHYSICALLOCATION"),
    MANUFACTURER("MonitorAsset.MANUFACTURER"),
    MODEL("MonitorAsset.MODEL"),
    VENDOR("MonitorAsset.VENDOR"),
    INSTALLDATE("MonitorAsset.INSTALLDATE"),
    YEARPURCHASED("MonitorAsset.YEARPURCHASED"),
    METER_TYPE("MonitorAsset.METER_TYPE"),
    PARENT_METER("MonitorAsset.PARENT_METER"),
    LCE_FLAG("MonitorAsset.LCE_FLAG"),
    LOCATION("MonitorAsset.LOCATION"),
    PLUSPCUSTOMER("MonitorAsset.PLUSPCUSTOMER"),
    SITEID("MonitorAsset.SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    MonitorAssetsHeaders(String header) {
        this.header = header;
    }

    public static MonitorAssetsHeaders getMonitorAssetsHeaders(String header, Properties odsMasterProps) {
        MonitorAssetsHeaders monitorAssetsHeader = null;
        if (header != null) {
            header = header.trim();
            for (MonitorAssetsHeaders monitorAssetsHeadersItr : MonitorAssetsHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(monitorAssetsHeadersItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    monitorAssetsHeader = monitorAssetsHeadersItr;
                    break;
                }
            }
        }
        return monitorAssetsHeader;
    }

}
