package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MsaToScaHeaders {

    MSAASSET("MsaToSca.MSAASSET"),
    SCAASSET("MsaToSca.SCAASSET"),
    SITEID("MsaToSca.SITEID"),
    CUSTOMER("MsaToSca.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    MsaToScaHeaders(String header) {
        this.header = header;
    }

    public static MsaToScaHeaders getMsaToScaHeaders(String header, Properties odsMasterProps) {
        MsaToScaHeaders msaToScaHeader = null;
        if (header != null) {
            header = header.trim();
            for (MsaToScaHeaders msaToScaHeaderItr : MsaToScaHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(msaToScaHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    msaToScaHeader = msaToScaHeaderItr;
                    break;
                }
            }
        }
        return msaToScaHeader;
    }

}
