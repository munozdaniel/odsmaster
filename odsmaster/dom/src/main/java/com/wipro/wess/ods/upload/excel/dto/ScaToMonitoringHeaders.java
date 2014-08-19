package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum ScaToMonitoringHeaders {
    SCAASSET("ScaToMonitoring.SCAASSET"),
    MONITORINGASSET("ScaToMonitoring.MONITORINGASSET"),
    SITEID("ScaToMonitoring.SITEID"),
    CUSTOMER("ScaToMonitoring.CUSTOMER");

    String header;

    public String getHeader() {
        return header;
    }

    private ScaToMonitoringHeaders(String header) {
        this.header = header;
    }

    public static ScaToMonitoringHeaders getScaToMonitoringHeaders(String header, Properties odsMasterProps) {
        ScaToMonitoringHeaders scaToMonitoringHeader = null;
        if (header != null) {
            header = header.trim();
            for (ScaToMonitoringHeaders scaToMonitoringHeaderItr : ScaToMonitoringHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(scaToMonitoringHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    scaToMonitoringHeader = scaToMonitoringHeaderItr;
                    break;
                }
            }
        }
        return scaToMonitoringHeader;
    }

}
