package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MsaServTypeFormulaHeaders {
    ASSETNUM("MSAServiceTypeFormula.ASSETNUM"),
    SOURCETYPE_CODE("MSAServiceTypeFormula.SOURCETYPE_CODE"),
    SERVICETYPE("MSAServiceTypeFormula.SERVICETYPE"),
    METER_FORMULA("MSAServiceTypeFormula.METER_FORMULA"),
    BUSINESSLOAD("MSAServiceTypeFormula.BUSINESSLOAD"),
    SITEID("MSAServiceTypeFormula.SITEID"),
    ORGID("MSAServiceTypeFormula.ORGID");

    String header;

    public String getHeader() {
        return header;
    }

    MsaServTypeFormulaHeaders(String header) {
        this.header = header;
    }

    public static MsaServTypeFormulaHeaders getMsaServTypeFormulaHeaders(String header, Properties odsMasterProps) {
        MsaServTypeFormulaHeaders msaServTypeFormulaHeader = null;
        if (header != null) {
            header = header.trim();
            for (MsaServTypeFormulaHeaders msaServTypeFormulaHeaderItr : MsaServTypeFormulaHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(msaServTypeFormulaHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    msaServTypeFormulaHeader = msaServTypeFormulaHeaderItr;
                    break;
                }
            }
        }
        return msaServTypeFormulaHeader;
    }

}
