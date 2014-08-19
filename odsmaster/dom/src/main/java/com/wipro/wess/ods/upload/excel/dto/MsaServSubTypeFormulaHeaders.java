package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MsaServSubTypeFormulaHeaders {
    ASSETNUM("MSAServiceSubTypeFormula.ASSETNUM"),
    SOURCETYPE_CODE("MSAServiceSubTypeFormula.SOURCETYPE_CODE"),
    SERVICETYPE("MSAServiceSubTypeFormula.SERVICETYPE"),
    SERVICESUBTYPE("MSAServiceSubTypeFormula.SERVICESUBTYPE"),
    METER_FORMULA("MSAServiceSubTypeFormula.METER_FORMULA"),    
    SITEID("MSAServiceSubTypeFormula.SITEID"),
    ORGID("MSAServiceSubTypeFormula.ORGID");

    String header;

    public String getHeader() {
        return header;
    }

    MsaServSubTypeFormulaHeaders(String header) {
        this.header = header;
    }

    public static MsaServSubTypeFormulaHeaders getMsaServSubTypeFormulaHeaders(String header, Properties odsMasterProps) {
        MsaServSubTypeFormulaHeaders msaServSubTypeFormulaHeader = null;
        if (header != null) {
            header = header.trim();
            for (MsaServSubTypeFormulaHeaders msaServSubTypeFormulaHeaderItr : MsaServSubTypeFormulaHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(msaServSubTypeFormulaHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    msaServSubTypeFormulaHeader = msaServSubTypeFormulaHeaderItr;
                    break;
                }
            }
        }
        return msaServSubTypeFormulaHeader;
    }

}
