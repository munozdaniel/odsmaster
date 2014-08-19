package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum ScaToServicesHeaders {
    SCAASSET("ScaToServices.SCAASSET"),
    SERVICEASSET("ScaToServices.SERVICEASSET"),
    SITEID("ScaToServices.SITEID"),
    CUSTOMER("ScaToServices.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    private ScaToServicesHeaders(String header) {
        this.header = header;
    }

    public static ScaToServicesHeaders getScaToServicesHeaders(String header, Properties odsMasterProps) {
        ScaToServicesHeaders scaToServicesHeader = null;
        if (header != null) {
            header = header.trim();
            for (ScaToServicesHeaders scaToServicesHeaderItr : ScaToServicesHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(scaToServicesHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    scaToServicesHeader = scaToServicesHeaderItr;
                    break;
                }
            }
        }
        return scaToServicesHeader;
    }

}
