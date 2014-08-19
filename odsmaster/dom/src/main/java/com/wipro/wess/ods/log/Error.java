package com.wipro.wess.ods.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Error logs
public enum Error implements LoggerInterface {

    /**
     * @meaning Technical Exception
     */
    PDM_TECHNICAL_ERROR,

    /**
     * @meaning Technical Exception
     */
    PDM_NODATA_OR_WRONG_FORMAT_ERROR,
    
    /**
     * @meaning ORG_ID(SITEID) not found
     */
    PDM_ORGID_NOT_FOUND,

    /**
     * @meaning LOCATION not found
     */
    PDM_LOCATION_NOT_FOUND,

    /**
     * @meaning PARENT_ASSET not found
     */
    PDM_PARENT_ASSET_NOT_FOUND,

    /**
     * @meaning MSA not found
     */
    PDM_MSA_NOT_FOUND,

    /**
     * @meaning MSA is mandatory
     */
    PDM_MSA_MANDATORY,

    /**
     * @meaning ORG_ID(SITEID) is mandatory
     */
    PDM_ORGID_MANDATORY,

    /**
     * @meaning CUSTOMER is mandatory
     */
    PDM_CUSTOMER_MANDATORY,

    /**
     * @meaning COMPANY is mandatory
     */
    PDM_COMPANY_MANDATORY,
    /**
     * @meaning STATUS is mandatory
     */
    PDM_STATUS_MANDATORY,

    /**
     * @meaning SUPPLIERCODE is mandatory
     */
    PDM_SUPPLIERCODE_MANDATORY,
    /**
     * @meaning INPUTSERVICE is mandatory
     */
    PDM_INPUTSERVICE_MANDATORY,

    /**
     * @meaning OUTPUTSERVICE is mandatory
     */
    PDM_OUTPUTSERVICE_MANDATORY,

    /**
     * @meaning MONITORINGASSET is mandatory
     */
    PDM_MONITORINGASSET_MANDATORY,

    /**
     * @meaning LOCATION is mandatory
     */
    PDM_LOCATION_MANDATORY,

    /**
     * @meaning DESCRIPTION is mandatory
     */
    PDM_DESCRIPTION_MANDATORY,

    /**
     * @meaning SETTYPECODE is mandatory
     */
    PDM_SETTYPECODE_MANDATORY,

    /**
     * @meaning SETTYPECODE is mandatory
     */
    PDM_CATEGORYTYPECODE_MANDATORY,

    /**
     * @meaning SETTYPECODE is mandatory
     */
    PDM_MAPPING_MANDATORY,

    /**
     * @meaning SETTYPECODE is not found
     */
    PDM_SETTYPECODE_NOT_FOUND,

    /**
     * @meaning METERFORMULA is mandatory
     */
    PDM_METERFORMULA_MANDATORY,

    /**
     * @meaning SERVICETYPE is mandatory
     */
    PDM_SERVICETYPE_MANDATORY,

    /**
     * @meaning SERVICETYPE is not found
     */
    PDM_SERVICETYPE_NOT_FOUND,

    /**
     * @meaning SERVICESUBTYPE is mandatory
     */
    PDM_SERVICESUBTYPE_MANDATORY,

    /**
     * @meaning BUSINESSLOAD is mandatory
     */
    PDM_BUSINESSLOAD_MANDATORY,

    /**
     * @meaning SERVICE is not found
     */
    PDM_SERVICE_NOT_FOUND,

    /**
     * @meaning SERVICE is mandatory
     */
    PDM_SERVICE_MANDATORY,

    /**
     * @meaning SCAASSET is not found
     */
    PDM_SCAASSET_NOT_FOUND,

    /**
     * @meaning SCAASSET is mandatory
     */
    PDM_SCAASSET_MANDATORY,

    /**
     * @meaning ASSET is not found
     */
    PDM_ASSET_NOT_FOUND,
    
    /**
     * @meaning Permission denied to upload site
     */
    PDM_SITE_PERMISSION_DENIED,

    ;

    static Logger logger = LoggerFactory.getLogger(Error.class);

    /**
     * @param args
     * @return String
     */
    public String format(Object... args) {
        if (Error.isErrorEnabled()) {
            final String message = LoggerHelper.format(this, args);
            return message;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see net.atos.wlp.commoncomponent.logaudit.log.A#log(java.lang.String)
     */
    @Override
    public void log(String message) {
        Error.logger.error(message);
    }

    /*
     * (non-Javadoc)
     * @see net.atos.wlp.commoncomponent.logaudit.log.A#log(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void log(String message, Throwable e) {
        Error.logger.error(message, e);
    }

    /**
    *
    */
    public static boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }
}
