package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MsaHeaders {

    ASSETNUM("ASSETNUM"),
    DESCRIPTION("DESCRIPTION"),
    TYPE("TYPE"),
    SUBTYPE("SUBTYPE"),
    OVERALLMSAAREA("OVERALLMSAAREA"),
    O_M_CONTACT("O_M_CONTACT"),
    SPIKE_CONSUMPTION_DEVIATION("SPIKE_CONSUMPTION_DEVIATION"),
    AFTER_HOURS_CONFIG("AFTER_HOURS_CONFIG"),
    PARTIAL_HOURS_CONFIG("PARTIAL_HOURS_CONFIG"),
    DEMAND_LIMIT_HOURS_CONFIG("DEMAND_LIMIT_HOURS_CONFIG"),
    AFTER_HOURS_THRESHOLD("AFTER_HOURS_THRESHOLD"),
    PARTIAL_HOURS_THRESHOLD("PARTIAL_HOURS_THRESHOLD"),
    DEMAND_LIMIT_HRS_THRESHOLD("DEMAND_LIMIT_HRS_THRESHOLD"),
    EXP_WEEKLY_OPERATION_HRS("EXP_WEEKLY_OPERATION_HRS"),
    EXP_WEEKLY_PARTIAL_HRS("EXP_WEEKLY_PARTIAL_HRS"),
    LOCATION("LOCATION"),
    PLUSPCUSTOMER("PLUSPCUSTOMER"),
    SITEID("SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    MsaHeaders(String header) {
        this.header = header;
    }

    public static MsaHeaders getMsaHeaders(String header, Properties odsMasterProps) {
        MsaHeaders msaHeader = null;
        if (header != null) {
            header = header.trim();
            for (MsaHeaders msaHeaderItr : MsaHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(msaHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    msaHeader = msaHeaderItr;
                    break;
                }
            }
        }
        return msaHeader;
    }

}
