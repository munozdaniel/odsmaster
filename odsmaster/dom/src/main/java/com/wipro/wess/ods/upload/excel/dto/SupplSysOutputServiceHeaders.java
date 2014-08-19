package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum SupplSysOutputServiceHeaders {

    ASSETNUM("SupplSysOutputService.ASSETNUM"),
    OUTPUTSERVICE("SupplSysOutputService.OUTPUTSERVICE"),
    MONITORINGASSET("SupplSysOutputService.MONITORINGASSET"),
    SITEID("SupplSysOutputService.SITEID"),
    CUSTOMER("SupplSysOutputService.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    SupplSysOutputServiceHeaders(String header) {
        this.header = header;
    }

    public static SupplSysOutputServiceHeaders getSupplSysOutputServiceHeaders(String header, Properties odsMasterProps) {
        SupplSysOutputServiceHeaders supplSysOutputServiceHeaders = null;
        if (header != null) {
            header = header.trim();
            for (SupplSysOutputServiceHeaders supplSysOutputServiceHeadersItr : SupplSysOutputServiceHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(supplSysOutputServiceHeadersItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    supplSysOutputServiceHeaders = supplSysOutputServiceHeadersItr;
                    break;
                }
            }
        }
        return supplSysOutputServiceHeaders;
    }

}
