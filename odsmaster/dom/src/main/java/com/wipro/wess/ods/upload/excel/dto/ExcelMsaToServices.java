package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.msa.OmMsaConfig;
import com.wipro.wess.ods.msa.OmMsaServiceMap;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelMsaToServices extends ExcelSheet {

    private String msaSet;

    private String serviceAsset;

    private String monitoringAsset;

    private String siteId;

    private String customer;

    public ExcelMsaToServices() {
        super();
    }

    public ExcelMsaToServices(String msaSet, String serviceAsset, String monitoringAsset, String siteId, String customer) {
        super();
        this.msaSet = msaSet;
        this.serviceAsset = serviceAsset;
        this.monitoringAsset = monitoringAsset;
        this.siteId = siteId;
        this.customer = customer;
    }

    public String getMsaSet() {
        return msaSet;
    }

    public void setMsaSet(String msaSet) {
        this.msaSet = msaSet;
    }

    public String getServiceAsset() {
        return serviceAsset;
    }

    public void setServiceAsset(String serviceAsset) {
        this.serviceAsset = serviceAsset;
    }

    public String getMonitoringAsset() {
        return monitoringAsset;
    }

    public void setMonitoringAsset(String monitoringAsset) {
        this.monitoringAsset = monitoringAsset;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException{
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            MsaToServicesHeaders msaToServicesHeaders = MsaToServicesHeaders.getMsaToServicesHeaders(headerVal,
                    odsMasterProps);
            if (msaToServicesHeaders != null) {
                switch (msaToServicesHeaders) {
                    case MSAASSET:
                        if (valObj != null && valObj instanceof String) {
                            String msaSet = (String) valObj;
                            this.setSheetRowId(msaSet);
                            this.setMsaSet(msaSet);
                        }
                        break;
                    case SERVICEASSET:
                        if (valObj != null && valObj instanceof String) {
                            String serviceAsset = (String) valObj;
                            this.setServiceAsset(serviceAsset);
                        }
                        break;
                    case MONITORINGASSET:
                        if (valObj != null && valObj instanceof String) {
                            String monitoringAsset = (String) valObj;
                            this.setMonitoringAsset(monitoringAsset);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
                        }
                        break;
                    case CUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String customer = (String) valObj;
                            this.setCustomer(customer);
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, siteId, ProvisioningConstants.MSA_TO_SERVICE_SHEET);
        OmMsaConfig msaConfig = this.validateMsaExistence(odsMasterProps, isisJdocontainer, this.getMsaSet(),
                ProvisioningConstants.MSA_TO_SERVICE_SHEET, ProvisioningConstants.MSAASSET);
        OmServiceConfig serviceConfig = this.validateServiceUidExistence(odsMasterProps, isisJdocontainer,
                this.getServiceAsset(), ProvisioningConstants.MSA_TO_SERVICE_SHEET, ProvisioningConstants.SERVICEASSET);
        OmMsaServiceMap msaServiceMap = isisJdocontainer.firstMatch(new QueryDefault<OmMsaServiceMap>(
                OmMsaServiceMap.class, "fetch_OmMsaServiceMap_by_msa_service_map", "serviceUid", serviceConfig,
                "omMsaConfig", msaConfig));
        if (msaServiceMap == null) {
            msaServiceMap = isisJdocontainer.newTransientInstance(OmMsaServiceMap.class);
            msaServiceMap.setOmMsaConfig(msaConfig);
            msaServiceMap.setServiceUid(serviceConfig);
            msaServiceMap.setOrgId(orgId);
        }
        isisJdocontainer.persistIfNotAlready(msaServiceMap);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getServiceAsset() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.MSA_TO_SERVICE_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SERVICEASSET);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SERVICEASSET);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_SERVICE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_SERVICE_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
    }

    @Override
    public String toString() {
        return "ExcelMsaToServices [msaSet=" + msaSet + ", serviceAsset=" + serviceAsset + ", monitoringAsset="
                + monitoringAsset + ", siteId=" + siteId + ", customer=" + customer + ", getSheetId()=" + getSheetRowId()
                + "]";
    }

}
