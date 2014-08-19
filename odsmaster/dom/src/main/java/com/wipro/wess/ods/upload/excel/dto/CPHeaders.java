package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum CPHeaders {
    MODENAME("MODENAME"),
    DESCRIPTION("DESCRIPTION"),
    CUSTOMER("CUSTOMER"),
    SITEID("SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    CPHeaders(String header) {
        this.header = header;
    }

    public static CPHeaders getCPHeaders(String header, Properties odsMasterProps) {
        CPHeaders cpHeader = null;
        if (header != null) {
            header = header.trim();
            for (CPHeaders cpHeaderItr : CPHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(cpHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    cpHeader = cpHeaderItr;
                    break;
                }
            }
        }
        return cpHeader;
    }

}
