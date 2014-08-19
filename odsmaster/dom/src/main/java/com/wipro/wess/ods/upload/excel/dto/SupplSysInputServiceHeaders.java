package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum SupplSysInputServiceHeaders {

    ASSETNUM("SupplSysInputService.ASSETNUM"),
    INPUTSERVICE("SupplSysInputService.INPUTSERVICE"),
    MONITORINGASSET("SupplSysInputService.MONITORINGASSET"),
    SITEID("SupplSysInputService.SITEID"),
    CUSTOMER("SupplSysInputService.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    SupplSysInputServiceHeaders(String header) {
        this.header = header;
    }

    public static SupplSysInputServiceHeaders getSupplSysInputServiceHeaders(String header, Properties odsMasterProps) {
        SupplSysInputServiceHeaders supplSysInputServiceHeader = null;
        if (header != null) {
            header = header.trim();
            for (SupplSysInputServiceHeaders supplSysInputServiceHeaderItr : SupplSysInputServiceHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(supplSysInputServiceHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    supplSysInputServiceHeader = supplSysInputServiceHeaderItr;
                    break;
                }
            }
        }
        return supplSysInputServiceHeader;
    }

}
