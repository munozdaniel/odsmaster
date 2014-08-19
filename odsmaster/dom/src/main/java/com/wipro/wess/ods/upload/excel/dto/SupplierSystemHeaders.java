package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum SupplierSystemHeaders {

    ASSETNUM("ASSETNUM"),
    DESCRIPTION("DESCRIPTION"),
    TYPE("TYPE"),
    SUBTYPE("SUBTYPE"),
    PHYSICALLOCATION("PHYSICALLOCATION"),
    SYSTEM_REDUNDANCY("SYSTEM_REDUNDANCY"),
    ACTIVE_COMPONENTS("ACTIVE_COMPONENTS"),
    REDUNDANT_COMPONENTS("REDUNDANT_COMPONENTS"),
    SHARED_OUTPUT_SYSTEM("SHARED_OUTPUT_SYSTEM"),
    AFTERHRS_FLAG("AFTERHRS_FLAG"),
    SYSTEM_AVAILABILITY_THRESHOLD("SYSTEM_AVAILABILITY_THRESHOLD"),
    LOSS_THRESOLD("LOSS_THRESOLD"),
    OVER_UTILIZATION_THRESHOLD("OVER_UTILIZATION_THRESHOLD"),
    UNDER_UTILIZATION_THRESHOLD("UNDER_UTILIZATION_THRESHOLD"),
    PHASE_LOAD_IMBALANCE_THRESHOLD("PHASE_LOAD_IMBALANCE_THRESHOLD"),
    LOCATION("LOCATION"),
    PLUSPCUSTOMER("PLUSPCUSTOMER"),
    SITEID("SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    SupplierSystemHeaders(String header) {
        this.header = header;
    }

    public static SupplierSystemHeaders getSupplierSystemHeaders(String header, Properties odsMasterProps) {
        SupplierSystemHeaders supplierSystemHeader = null;
        if (header != null) {
            header = header.trim();
            for (SupplierSystemHeaders supplierSystemHeaderItr : SupplierSystemHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(supplierSystemHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    supplierSystemHeader = supplierSystemHeaderItr;
                    break;
                }
            }
        }
        return supplierSystemHeader;
    }

}
