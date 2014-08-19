package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.sca.OmScaConfig;
import com.wipro.wess.ods.sca.OmScaServiceMap;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelScaToServices extends ExcelSheet {

    private String scaSet;

    private String serviceAsset;

    private String siteId;

    private String customer;

    public ExcelScaToServices() {
        super();
    }

    public ExcelScaToServices(String scaSet, String serviceAsset, String siteId, String customer) {
        super();
        this.scaSet = scaSet;
        this.serviceAsset = serviceAsset;
        this.siteId = siteId;
        this.customer = customer;
    }

    public String getScaSet() {
        return scaSet;
    }

    public void setScaSet(String scaSet) {
        this.scaSet = scaSet;
    }

    public String getServiceAsset() {
        return serviceAsset;
    }

    public void setServiceAsset(String serviceAsset) {
        this.serviceAsset = serviceAsset;
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
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            ScaToServicesHeaders scaToServicesHeaders = ScaToServicesHeaders.getScaToServicesHeaders(headerVal,
                    odsMasterProps);
            if (scaToServicesHeaders != null) {
                switch (scaToServicesHeaders) {
                    case SCAASSET:
                        if (valObj != null && valObj instanceof String) {
                            String scaSet = (String) valObj;
                            this.setSheetRowId(scaSet);
                            this.setScaSet(scaSet);
                        }
                        break;
                    case SERVICEASSET:
                        if (valObj != null && valObj instanceof String) {
                            String serviceAsset = (String) valObj;
                            this.setServiceAsset(serviceAsset);
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
        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, this.getSiteId(),
                ProvisioningConstants.SCA_TO_SERVICES_SHEET);
        OmScaConfig scaUid = this.validateScaExistence(odsMasterProps, isisJdocontainer, this.getScaSet(),
                ProvisioningConstants.SCA_TO_SERVICES_SHEET);
        OmServiceConfig serviceUid = this
                .validateServiceUidExistence(odsMasterProps, isisJdocontainer, this.getServiceAsset(),
                        ProvisioningConstants.SCA_TO_SERVICES_SHEET, ProvisioningConstants.SERVICEASSET);
        OmScaServiceMap scaServiceMap = isisJdocontainer.firstMatch(new QueryDefault<OmScaServiceMap>(
                OmScaServiceMap.class, "fetch_OmScaServiceMap_by_sca_service_map", "scaUid", scaUid, "serviceUid",
                serviceUid));
        if (scaServiceMap == null) {
            scaServiceMap = isisJdocontainer.newTransientInstance(OmScaServiceMap.class);
            scaServiceMap.setScaUid(scaUid);
            scaServiceMap.setServiceUid(serviceUid);
            scaServiceMap.setChangeBy(isisJdocontainer.getUser().getName());
            scaServiceMap.setChangeDt(new Date());
        }
        scaServiceMap.setOrgId(orgId);
        isisJdocontainer.persistIfNotAlready(scaServiceMap);
    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getServiceAsset() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SCA_TO_SERVICES_SHEET));
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
        return "ExcelScaToServices [scaSet=" + scaSet + ", serviceAsset=" + serviceAsset + ", siteId=" + siteId
                + ", customer=" + customer + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
