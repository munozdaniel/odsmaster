package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum SupplSysControlAssetHeaders {
    SUPPLIERASSET("SupplSysControlAsset.SUPPLIERASSET"),
    CONTROLASSET("SupplSysControlAsset.CONTROLASSET"),
    SITEID("SupplSysControlAsset.SITEID"),
    CUSTOMER("SupplSysControlAsset.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    private SupplSysControlAssetHeaders(String header) {
        this.header = header;
    }

    public static SupplSysControlAssetHeaders getSupplSysControlAssetHeaders(String header, Properties odsMasterProps) {
        SupplSysControlAssetHeaders supplSysControlAssetHeader = null;
        if (header != null) {
            header = header.trim();
            for (SupplSysControlAssetHeaders supplSysControlAssetHeaderItr : SupplSysControlAssetHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(supplSysControlAssetHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    supplSysControlAssetHeader = supplSysControlAssetHeaderItr;
                    break;
                }
            }
        }
        return supplSysControlAssetHeader;
    }
}
