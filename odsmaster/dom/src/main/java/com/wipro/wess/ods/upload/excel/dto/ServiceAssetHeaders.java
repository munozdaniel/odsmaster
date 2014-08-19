package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;


public enum ServiceAssetHeaders {
    ASSETNUM("ASSETNUM"),
    DESCRIPTION("DESCRIPTION"),
    STATUS("STATUS"),
    TYPE("TYPE"),
    SUBTYPE("SUBTYPE"),
    SERVICESUBTYPE("SERVICESUBTYPE"),
    SERVICEGROUP("SERVICEGROUP"),
    LOCATION("LOCATION"),
    PLUSPCUSTOMER("PLUSPCUSTOMER"),
    SITEID("SITEID"),
    ENERGYCOSTPERUNIT("ENERGYCOSTPERUNIT"),
    SERVICE_EFF_FORMULA("SERVICE_EFF_FORMULA"),
    SERVICE_QA_FORMULA("SERVICE_QA_FORMULA"),
    SVCCONSMINUS("SVCCONSMINUS"),
    SVCCONSPLUS("SVCCONSPLUS"),
    SERVICE_QTY_FORMULA("SERVICE_QTY_FORMULA");
    
    String header;

    
    public String getHeader() {
        return header;
    }
    
    ServiceAssetHeaders(String header){
        this.header = header;
    }
    
    public static ServiceAssetHeaders getServiceAssetHeaders(String header, Properties odsMasterProps){
        ServiceAssetHeaders serviceAssetHeader = null;
        if (header != null) {
            header = header.trim();
            for (ServiceAssetHeaders serviceAssetHeaderItr : ServiceAssetHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(serviceAssetHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    serviceAssetHeader = serviceAssetHeaderItr;
                    break;
                }
            }
        }
        return serviceAssetHeader;
        
    }


}
