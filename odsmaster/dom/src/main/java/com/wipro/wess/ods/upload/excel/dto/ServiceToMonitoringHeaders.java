package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum ServiceToMonitoringHeaders {

    SERVICEASSET("ServiceToMonitoring.SERVICEASSET"),
    MONITORINGASSET("ServiceToMonitoring.MONITORINGASSET"),
    SITEID("ServiceToMonitoring.SITEID"),
    CUSTOMER("ServiceToMonitoring.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    ServiceToMonitoringHeaders(String header) {
        this.header = header;
    }

    public static ServiceToMonitoringHeaders getServiceToMonitoringHeaders(String header, Properties odsMasterProps) {
        ServiceToMonitoringHeaders serviceToMonitoringHeader = null;
        if (header != null) {
            header = header.trim();
            for (ServiceToMonitoringHeaders serviceToMonitoringHeaderItr : ServiceToMonitoringHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(serviceToMonitoringHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    serviceToMonitoringHeader = serviceToMonitoringHeaderItr;
                    break;
                }
            }
        }
        return serviceToMonitoringHeader;
    }
}
