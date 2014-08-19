package com.wipro.wess.ods.upload.excel.dto;

import java.util.Properties;

public enum MsaConsFormulaHeaders {
    ASSETNUM("MSAConsumptionFormula.ASSETNUM"),
    SOURCETYPE_CODE("MSAConsumptionFormula.SOURCETYPE_CODE"),
    METER_FORMULA("MSAConsumptionFormula.METER_FORMULA"),
    SITEID("MSAConsumptionFormula.SITEID"),
    ORGID("MSAConsumptionFormula.ORGID");

    String header;

    public String getHeader() {
        return header;
    }

    MsaConsFormulaHeaders(String header) {
        this.header = header;
    }

    public static MsaConsFormulaHeaders getMsaConsFormulaHeaders(String header, Properties odsMasterProps) {
        MsaConsFormulaHeaders msaConsFormulaHeader = null;
        if (header != null) {
            header = header.trim();
            for (MsaConsFormulaHeaders msaConsFormulaHeaderItr : MsaConsFormulaHeaders.values()) {
                String headerVal = odsMasterProps.getProperty(msaConsFormulaHeaderItr.getHeader());
                if (headerVal != null && headerVal.equalsIgnoreCase(header)) {
                    msaConsFormulaHeader = msaConsFormulaHeaderItr;
                    break;
                }
            }
        }
        return msaConsFormulaHeader;
    }

}
