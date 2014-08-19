package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum UtilitySupplierHeaders {
    SUPPLIERNAME("SUPPLIERNAME"),
    DESCRIPTION("DESCRIPTION"),
    COMPANY("COMPANY"),
    STATUS("STATUS"),
    CUSTOMER("CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    UtilitySupplierHeaders(String header) {
        this.header = header;
    }

    public static UtilitySupplierHeaders getUtilitySupplierHeaders(String header, Properties odsMasterProps) {
        UtilitySupplierHeaders supplierHeader = null;
        if (header != null) {
            header = header.trim();
            for (UtilitySupplierHeaders supplierHeaderItr : UtilitySupplierHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(supplierHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    supplierHeader = supplierHeaderItr;
                    break;
                }
            }
        }
        return supplierHeader;
    }

}
