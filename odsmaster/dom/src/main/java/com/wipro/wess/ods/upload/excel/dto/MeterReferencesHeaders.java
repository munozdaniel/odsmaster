package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MeterReferencesHeaders {
    LOCATION("LOCATION"),
    SETYPECODE("SETYPECODE"),
    UMREFFORMULA("UMREFFORMULA"),
    CMREFFORMULA("CMREFFORMULA"),
    OMREFFORMULA("OMREFFORMULA"),
    MASTERREFFORM("MASTERREFFORM"),
    SITEID("SITEID"),
    ORGID("ORGID");

    String header;

    public String getHeader() {
        return header;
    }

    MeterReferencesHeaders(String header) {
        this.header = header;
    }

    public static MeterReferencesHeaders getMeterReferencesHeaders(String header, Properties odsMasterProps) {
        MeterReferencesHeaders meterReferencesHeader = null;
        if (header != null) {
            header = header.trim();
            for (MeterReferencesHeaders meterReferencesHeaderItr : MeterReferencesHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(meterReferencesHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    meterReferencesHeader = meterReferencesHeaderItr;
                    break;
                }
            }
        }
        return meterReferencesHeader;
    }

}
