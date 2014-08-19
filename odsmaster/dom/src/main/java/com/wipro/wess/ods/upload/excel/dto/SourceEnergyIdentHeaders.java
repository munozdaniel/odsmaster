package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum SourceEnergyIdentHeaders {
    GENTECHTYPE("GENTECHTYPE"),
    SETYPECODE("SETYPECODE"),
    CATEGORYCODE("CATEGORYCODE"),
    MAPPING("MAPPING"),
    CUSTOMER("CUSTOMER"),
    SITEID("SITEID");

    String header;

    public String getHeader() {
        return header;
    }

    SourceEnergyIdentHeaders(String header) {
        this.header = header;
    }

    public static SourceEnergyIdentHeaders getSourceEnergyIdentHeaders(String header, Properties odsMasterProps){
        SourceEnergyIdentHeaders sourceEnergyIdentHeader = null;
        if(header != null){
            header = header.trim();
            for(SourceEnergyIdentHeaders sourceEnergyIdentHeaderItr: SourceEnergyIdentHeaders.values()){
                String headerVal = odsMasterProps.getProperty(sourceEnergyIdentHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    sourceEnergyIdentHeader = sourceEnergyIdentHeaderItr;
                    break;
                }
            }
        }
        return sourceEnergyIdentHeader;
    }
}
