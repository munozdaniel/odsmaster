package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum UOMHeaders {
    DEFAULTUNIT("DEFAULTUNIT"),
    FAMILYNAME("FAMILYNAME"),
    CUSTOMER("CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    UOMHeaders(String header) {
        this.header = header;
    }
    
    public static UOMHeaders getUomHeader(String header, Properties odsMasterProps){
        UOMHeaders uomHeader = null;
        if (header != null) {
            header = header.trim();
            for(UOMHeaders uomHeaderItr : UOMHeaders.values()){
                String headerVal = odsMasterProps.getProperty(uomHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    uomHeader = uomHeaderItr;
                    break;
                }
            }
        }
        return uomHeader;
    }

}
