package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;


public enum ORGMeterGroupHeaders {
    SOURCETYPECODE("SOURCETYPECODE"),
    UMDISPLAYNAME("UMDISPLAYNAME"),
    CMDISPLAYNAME("CMDISPLAYNAME"),
    OMDISPLAYNAME("OMDISPLAYNAME"),
    MASTERDISNAME("MASTERDISNAME"),
    CUSTOMER("CUSTOMER"),
    ORGID("ORGID");
    
    String header;
    
    
    public String getHeader() {
        return header;
    }

    ORGMeterGroupHeaders(String header){
        this.header = header;
    }
    
    public static ORGMeterGroupHeaders getOrgMeterGroup(String header, Properties odsMasterProps){
        ORGMeterGroupHeaders orgMeterGroupHeader = null;
        if (header != null) {
            header = header.trim();
            for(ORGMeterGroupHeaders orgMeterGroupItr : ORGMeterGroupHeaders.values()){
                String headerVal = odsMasterProps.getProperty(orgMeterGroupItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    orgMeterGroupHeader = orgMeterGroupItr;
                    break;
                }
            }
        }
        
        return orgMeterGroupHeader;
    }

}
