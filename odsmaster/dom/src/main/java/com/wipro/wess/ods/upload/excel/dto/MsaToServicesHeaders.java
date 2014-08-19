package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MsaToServicesHeaders {

    MSAASSET("MsaToServices.MSAASSET"),
    SERVICEASSET("MsaToServices.SERVICEASSET"),
    MONITORINGASSET("MsaToServices.MONITORINGASSET"),
    SITEID("MsaToServices.SITEID"),
    CUSTOMER("MsaToServices.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    MsaToServicesHeaders(String header) {
        this.header = header;
    }

    public static MsaToServicesHeaders getMsaToServicesHeaders(String header, Properties odsMasterProps) {
        MsaToServicesHeaders msaToServicesHeader = null;
        if (header != null) {
            header = header.trim();
            for (MsaToServicesHeaders msaToServicesHeaderItr : MsaToServicesHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(msaToServicesHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    msaToServicesHeader = msaToServicesHeaderItr;
                    break;
                }
            }
        }
        return msaToServicesHeader;
    }

}
